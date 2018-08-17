package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.deptDAO;
import entity.Dept;

public class addDeptServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
			response.sendRedirect("list");
		} catch (SQLException e) {
			e.printStackTrace();
		}


	}

}
