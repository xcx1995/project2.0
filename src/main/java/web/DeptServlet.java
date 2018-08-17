package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.tribes.util.Logs;

import dao.deptDAO;
import entity.Dept;

/**
 * Servlet implementation class DeptServlet
 */
public class DeptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int currentPage=1;
	private int pageSize=10;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri=request.getRequestURI();
		String path=uri.substring(uri.lastIndexOf("/"),uri.lastIndexOf("."));
		System.out.println("path:"+path);
		if("/list".equals(path)) {
			processList(request,response);
		}else if("/add".equals(path)) {
			processAdd(request,response);
		}else if("/del".equals(path)) {
			processDel(request,response);
		}
		else if("/next".equals(path)) {
			processNext(request,response);
		}
		else if("/last".equals(path)) {
			processLast(request,response);
		}
	}

	private void processLast(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =request.getSession();
		session.setAttribute("currentPage", currentPage);		 		
		int page=Integer.parseInt(session.getAttribute("currentPage").toString());
		System.out.println(page);
		try {			
			deptDAO dao=new deptDAO();			
			if(page<=1) {
				page=1;
				session.setAttribute("currentPage", page);
				List<Dept> depts=dao.findDeptLimit(page);
				request.setAttribute("depts", depts);
				request.getRequestDispatcher("deptlist.jsp").forward(request, response);
			}else{
				page--;
				session.setAttribute("currentPage", page);
				List<Dept> depts=dao.findDeptLimit(page);
				request.setAttribute("depts", depts);
				request.getRequestDispatcher("deptlist.jsp").forward(request, response);

			}
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error","系统繁忙稍后重试");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
		
	}

	private void processNext(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session =request.getSession();
			session.setAttribute("currentPage", currentPage);
			int page=Integer.parseInt(session.getAttribute("currentPage").toString());
			deptDAO dao=new deptDAO();
			int rows=dao.rows();
			System.out.println(rows);
			int maxPage=rows%pageSize==0?(rows/pageSize):(rows/pageSize+1);
			if(page>=maxPage) {
				page=maxPage;
				List<Dept> depts=dao.findDeptLimit(page);
				request.setAttribute("depts", depts);
				request.getRequestDispatcher("deptlist.jsp").forward(request, response);
			}else{
				page++;
				session.setAttribute("currentPage", page);
				System.out.println(page);
				List<Dept> depts=dao.findDeptLimit(page);
				request.setAttribute("depts", depts);
				request.getRequestDispatcher("deptlist.jsp").forward(request, response);
			}
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
			request.setAttribute("error","系统繁忙稍后重试");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
		
	}

	private void processDel(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		int id=Integer.parseInt(request.getParameter("id"));
		try {
			deptDAO dao=new deptDAO();
			dao.delete(id);
			//重定向
			response.sendRedirect("list.do");
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("error", "系统繁忙，稍后重试");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

	private void processAdd(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		String dt_name=request.getParameter("dt_name");
		String dt_createTime=request.getParameter("dt_createTime");
		String dt_bz=request.getParameter("dt_bz");
		System.out.println(dt_name+","+dt_createTime+","+dt_bz);
		PrintWriter out=response.getWriter();
		response.setContentType("text/html;charser=utf-8");
		
		try {
			deptDAO dao=new deptDAO();
			Dept dept=dao.find(dt_name);
			if(dept!=null) {
				out.println("用户存在");
			}else {
				dept=new Dept();
				dept.setDt_name(dt_name);
				dept.setDt_createTime(dt_createTime);
				dept.setDt_bz(dt_bz);
				dao.save(dept);
			}
			response.sendRedirect("list.do");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private void processList(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("html/text;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		try {
			HttpSession session=request.getSession();
			session.setAttribute("currentPage", currentPage);
			deptDAO dao=new deptDAO();
			List<Dept> depts=dao.findDeptLimit(currentPage);
			System.out.println(depts);
			request.setAttribute("depts", depts);
			request.getRequestDispatcher("deptlist.jsp").forward(request, response);
			
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("error", "系统繁忙，稍后重试");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}
       
   
}
