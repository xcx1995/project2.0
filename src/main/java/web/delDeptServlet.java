package web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.deptDAO;


public class delDeptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id=Integer.parseInt(request.getParameter("id"));
		try {
			deptDAO dao=new deptDAO();
			dao.delete(id);
			//重定向
			response.sendRedirect("list");
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("error", "系统繁忙，稍后重试");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

}
