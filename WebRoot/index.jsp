<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.rj.auction.admin.dao.DBUtils, java.util.List,com.rj.auction.product.vo.Product" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<style media="screen">
* {
	margin: 0;
	padding: 0;
}
header {
	height: 75px;
	padding: 1em 0;
	text-align: center;
	background-color: #4a4;
	color: #fff;
	font-size: 300%;
}
header span {
	font-size: 50%;
	margin-left: 1em;
	color: #eee;
}
footer {
	height: 15px;
	position: fixed;
	bottom: 0;
	left: 0;
	padding: 2em 0;
	text-align: center;
	background-color: #4a4;
	color: #fff;
	width: 100%;
	clear: both;
}
.content {
	width: 85%;
	overflow: auto;
	float: right;
	min-height: 300px;
}
.nav {
	float: left;
	background-color: #eee;
	width: 15%;
	position: absolute;
	height: 130%;
	overflow: auto;
}
ul {
	list-style-type: none;
	margin-top: 1em;
}
li a {
	display: block;
	color: #000;
	padding: 8px 0 8px 16px;
	text-decoration: none;
}
li a:hover {
	background-color: #4a4;
	color: white;
}
form {
	margin: 2em 4em;
}
form div {
	margin-bottom: 1em;
}
label {
	display: inline-block;
	width: 6em;
	text-align: right;
	margin-right: 2em;
}
input, select {
	font-size: 150%;
}
input[type=submit] {
	padding: 0 4em;
	margin-left: 6em;
}
#index_table{
border:1px solid black
}
#index_table td{
padding: 14px
}
</style>
<title>二手图书拍卖</title>
</head>

<body>
	<header>
		二手图书拍卖系统<span>首页</span>
	</header>
	<div class="nav">
		<ul>
			<li><a href="AdminLogin.jsp">管理员登录</a></li>
			<li><a href="UserLogin.jsp">用户登录</a></li>
			<li><a href="aboutus.html">关于</a></li>
		</ul>
	</div>
	
	<% 
		List<Product> index_list = DBUtils.getIndexList();
		pageContext.setAttribute("index_list", index_list);
	%>
	
	
	
	
	<div class="content">
	<p>最新资讯</p>
	
	<table id="index_table" border="1">
			<tr>
				<th>名称</th>
				<th>描述</th>
				<th>开始时间</th>
				<th>结束时间</th>
				<th>起拍价</th>
			</tr>
			
			<% for(Product pp : index_list){ %>
			<tr>
				<td><%=pp.getTitle() %></td>
				<td><%=pp.getDescribes().substring(0, pp.getDescribes().length()/2) %></td>
				<td><%=pp.getBeginTime() %></td>
				<td><%=pp.getStopTime() %></td>
				<td><%=pp.getPrice() %></td>
			</tr>
			
			<%} %>
		</table>
		
	<footer>Copyright (c) 2017  二手图书拍卖  All Rights Reserved.</footer>
</body>
</html>