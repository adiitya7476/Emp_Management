package com.emp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.emp.bean.Emp;

public class SqlQueries {

	public static int insertData(Emp ob)
	{
		Connection con = DB_Connections.connect();
		String sql = "insert into emp2 (id,name,city,salary,mobile) values (?,?,?,?,?)";
		int status =0;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, ob.getId());
			ps.setString(2, ob.getName());
			ps.setString(3, ob.getCity());
			ps.setInt(4, ob.getSal());
			ps.setString(5, ob.getMobile());
			
			status = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
	public static List<Emp> dataFetch()
	{
		Connection con = DB_Connections.connect();
		String sql = "select * from emp2";
		List<Emp> al = new ArrayList<Emp>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Emp ob = new Emp();
				
				ob.setId(rs.getInt(1));
				ob.setName(rs.getString(2));
				ob.setCity(rs.getString(3));
				ob.setSal(rs.getInt(4));
				ob.setMobile(rs.getString(5));
				
				al.add(ob);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return al;
	}
	public static int deleteId(int id)
	{
		Connection con = DB_Connections.connect();
		String sql = "delete from emp2 where id =?";
		int status =0;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			status = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
	public static Emp getIdData(int id)
	{
		Connection con = DB_Connections.connect();
		String sql = "select * from emp2 where id = ?";
		Emp ob = new Emp();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				ob.setId(rs.getInt(1));
				ob.setName(rs.getString(2));
				ob.setCity(rs.getString(3));
				ob.setSal(rs.getInt(4));
				ob.setMobile(rs.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ob;
	}
	public static int updateData(Emp ob)
	{
		Connection con = DB_Connections.connect();
		String sql = "update emp2 set name = ?,city=?,salary=?,mobile =? where id = ?";
		int status =0;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, ob.getName());
			ps.setString(2, ob.getCity());
			ps.setInt(3, ob.getSal());
			ps.setString(4, ob.getMobile());
			ps.setInt(5, ob.getId());
			
			status = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
	public static List<Emp> searchName(String name)
	{
		Connection con = DB_Connections.connect();
		String sql = "select * from emp2 where name like '"+name+"%'";
		List<Emp> al = new ArrayList<Emp>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
//			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Emp ob = new Emp();
				
				ob.setId(rs.getInt(1));
				ob.setName(rs.getString(2));
				ob.setCity(rs.getString(3));
				ob.setSal(rs.getInt(4));
				ob.setMobile(rs.getString(5));
				
				al.add(ob);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return al;
	}
}

