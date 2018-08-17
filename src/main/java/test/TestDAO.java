package test;

import java.sql.SQLException;
import java.util.List;

import dao.deptDAO;
import entity.Dept;


public class TestDAO {

	public static void main(String[] args) throws SQLException {
		deptDAO dao=new deptDAO();
		int currentPage = 0;
		List<Dept> depts=dao.findDeptLimit(1);
		System.out.println(depts);
		
	}

}
