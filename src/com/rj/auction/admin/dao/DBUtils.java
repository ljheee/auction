package com.rj.auction.admin.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.mysql.jdbc.PreparedStatement;
import com.rj.auction.product.vo.Product;

public class DBUtils {
	
	static Connection con;
	static ResultSet rs;
	static PreparedStatement ps;
	
	static String dbURL = "jdbc:mysql://localhost:3306/auction";     
	
	static{
		 try {
			Class.forName("com.mysql.jdbc.Driver");//加载驱动
			con = DriverManager.getConnection(dbURL,"root","root");//建立连接，返回一个Connection con对象
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static List<Product> getIndexList(){
		List<Product> list = new ArrayList<Product>();
		try {
			System.out.println("con="+con);
			ps = (PreparedStatement) con.prepareStatement("select * from product");
			rs = ps.executeQuery();
			
			Product product = null;
			while(rs.next()){
				product = new Product();
				product.setPid(rs.getInt("pid"));
				product.setTitle(rs.getString("title"));
				product.setDescribes(rs.getString("describes"));
				product.setBeginTime(toTimestamp(rs.getString("beginTime")));
				product.setStopTime(toTimestamp(rs.getString("stopTime")));
				product.setPrice(rs.getDouble("price"));
				product.setImage(rs.getString("image"));
				list.add(product);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		
		return list;
	}



	private static Timestamp toTimestamp(String string) throws ParseException {
		Timestamp ts = null;
		if(string!=null){
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date d = df.parse(string);
			String time = df.format(d);
			ts = Timestamp.valueOf(time);
		}
		
		return ts;
	}
	
	

}
