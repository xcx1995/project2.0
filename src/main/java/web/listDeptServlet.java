package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.deptDAO;
import entity.Dept;


public class listDeptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("html/text;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		try {
			deptDAO dao=new deptDAO();
			List<Dept> depts=dao.findAll();
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
