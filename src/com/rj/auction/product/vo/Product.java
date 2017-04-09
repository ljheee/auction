package com.rj.auction.product.vo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.rj.auction.user.vo.User;


/**
 * 商品实体类
 * @author Administrator
 *
 */
public class Product {
	private Integer pid;
	private String title;
	private String describes;
	private Timestamp beginTime;
	private Timestamp stopTime;
	private Double price;
	private String image;
	
	public volatile double curPrice;
	
	//产品中所属的多个竞拍记录
	private Set<Record> records = new HashSet<Record>();
	
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescribes() {
		return describes;
	}
	public void setDescribes(String describes) {
		this.describes = describes;
	}
	
	

	public Timestamp getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(Timestamp beginTime) {
		this.beginTime = beginTime;
	}
	public Timestamp getStopTime() {
		return stopTime;
	}
	public void setStopTime(Timestamp stopTime) {
		this.stopTime = stopTime;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Set<Record> getRecords() {
		return records;
	}
	public void setRecords(Set<Record> records) {
		this.records = records;
	}
	
	static class TradeRobot {

		private static TradeRobot robot = new TradeRobot();
		
		private List<User> list = new ArrayList<User>();
		public volatile String curUser;
		static long lastTime;
		static long start;
		
		
		private TradeRobot(){
		}
		
		public static TradeRobot getInstance(){
			return robot;
		}
		
		public boolean addUser(User u){
			return list.add(u);
		}
		
		public boolean removeUser(User u){
			return list.remove(u);
		}
		
		
		public static void setTime(){
			lastTime = start;
			start = System.currentTimeMillis();
		}
		
		public static void toOver(){
			
		}
		
		
		
	}
}
