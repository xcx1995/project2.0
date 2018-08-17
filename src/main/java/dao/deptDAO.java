package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

import entity.Dept;
import util.DBUtils;

public class deptDAO {
	Connection conn;
	
//	sadghasGDjasD
//	asDasdasD
	PreparedStatement ps;
	ResultSet rs;
	private int count=0;
	private int pageSize=10;
	public void save(Dept dept) throws SQLException {

		try {
			conn=DBUtils.getConn();
			String sql="insert into tb_department values(null,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, dept.getDt_name());
			ps.setString(2, dept.getDt_createTime());
			ps.setString(3, dept.getDt_bz());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally {
			DBUtils.close(null, ps, conn);
		}
	}
	public Dept find(String dt_name) {
		Dept dept=null;
		try {
			conn=DBUtils.getConn();
			String sql="select * from tb_department where dt_name=? ";
			ps=conn.prepareStatement(sql);
			ps.setString(1, dt_name);
			rs=ps.executeQuery();
			if(rs.next()) {
				dept=new Dept();
				dept.setId(rs.getInt("id"));
				dept.setDt_name(dt_name);
				dept.setDt_createTime(rs.getString("dt_createTime"));
				dept.setDt_bz(rs.getString("dt_bz"));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			DBUtils.close(rs, ps, conn);
		}
		return dept;
	}
	
	public void delete(int id) throws SQLException {
		try {
			conn=DBUtils.getConn();
			String sql="delete from tb_department where id=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1,id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally {
			DBUtils.close(null, ps, conn);
		}

	}
	public List<Dept> findAll() throws SQLException{
		List<Dept> depts=new ArrayList<Dept>();
		
		try {
			conn=DBUtils.getConn();
			String sql="select d.id,d.dt_name,d.dt_createTime,count(*) count,d.dt_bz from tb_department d left join tb_employee e on d.dt_name=e.em_departmentName where d.dt_name is not null group by d.dt_name";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				int id=rs.getInt("id");
				String dt_name=rs.getString("dt_name");
				String dt_createTime=rs.getString("dt_createTime");
				count=rs.getInt("count");
				String dt_bz=rs.getString("dt_bz");
				Dept dept=new Dept();
				dept.setId(id);
				dept.setDt_name(dt_name);
				dept.setDt_createTime(dt_createTime);
				dept.setCount(count);
				dept.setDt_bz(dt_bz);
				
				depts.add(dept);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally {
			DBUtils.close(rs, ps, conn);
		}
		return depts;
	}
	public List<Dept> findDeptLimit(int a) throws SQLException {
		List<Dept> depts = new ArrayList<Dept>();
		System.out.println("findDeptLimit");
		ResultSet rs = null;
		PreparedStatement ps = null;
		Connection conn = null;
		try {
			//创建连接对象
			conn = DBUtils.getConn();
			//创建sql执行对象
			String sql = "select d.id,d.dt_name,d.dt_createTime,count(e.em_departmentName) count,"
					+ "d.dt_bz from tb_department d left join tb_employee e on d.dt_name=e.em_departmentName "
					+ "where d.dt_name is not null group by d.dt_name order by id limit ?,?";
			ps = conn.prepareStatement(sql);
			if(a<1) {a=1;}
			ps.setInt(1, (a-1)*pageSize);
			ps.setInt(2, pageSize);
			rs = ps.executeQuery();
			while(rs.next()) {
				int id=rs.getInt("id");
				String dt_name=rs.getString("dt_name");
				String dt_createTime=rs.getString("dt_createTime");
				count=rs.getInt("count");
				String dt_bz=rs.getString("dt_bz");
				Dept dept=new Dept();
				dept.setId(id);
				dept.setDt_name(dt_name);
				dept.setDt_createTime(dt_createTime);
				dept.setCount(count);
				dept.setDt_bz(dt_bz);
				depts.add(dept);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			DBUtils.close(rs, ps, conn);
		}
		System.out.println("depts"+depts);
		return depts;
	}
	public int rows() {
		int rows=0;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			conn=DBUtils.getConn();
			String sql="select * from tb_department where id is not null";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				
				rows++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
//		asadjasdgjasdgjasDkasdlkas.d
//		sadhaskjda
		return rows;
	}

}
