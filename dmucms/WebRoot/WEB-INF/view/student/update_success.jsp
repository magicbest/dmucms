<%@page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor" %>
<%@ taglib uri = "http://ckfinder.com" prefix="ckf" %>
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor" %>
<%@page import="java.util.*"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
	<head>
		<title>大连海事大学大创管理系统</title>
		<meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-responsive.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/unicorn.main.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/unicorn.grey.css" class="skin-color" />	
		<script type="text/javascript" src="${pageContext.request.contextPath}/ckeditor/ckeditor.js"></script>
         <script type="text/javascript" src="${pageContext.request.contextPath}/ckfinder/ckfinder.js"></script>
	     <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	     <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	
	</head>
	<body>
		
		
		<div id="header">
			<h1><a href="#">大创客户端</a></h1>		
		</div>
		<!--搜索按钮
		<div id="search">
			<input type="text" placeholder="Search here..." /><button type="submit" class="tip-right" title="Search"><i class="icon-search icon-white"></i></button>
		</div>
		-->
		<!--右上按钮
		<div id="user-nav" class="navbar navbar-inverse">
            <ul class="nav btn-group">
                <li class="btn btn-inverse"><a title="" href="#"><i class="icon icon-user"></i> <span class="text">Profile</span></a></li>
                <li class="btn btn-inverse dropdown" id="menu-messages"><a href="#" data-toggle="dropdown" data-target="#menu-messages" class="dropdown-toggle"><i class="icon icon-envelope"></i> <span class="text">Messages</span> <span class="label label-important">5</span> <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a class="sAdd" title="" href="#">new message</a></li>
                        <li><a class="sInbox" title="" href="#">inbox</a></li>
                        <li><a class="sOutbox" title="" href="#">outbox</a></li>
                        <li><a class="sTrash" title="" href="#">trash</a></li>
                    </ul>
                </li>
                <li class="btn btn-inverse"><a title="" href="#"><i class="icon icon-cog"></i> <span class="text">Settings</span></a></li>
                <li class="btn btn-inverse"><a title="" href="login.html"><i class="icon icon-share-alt"></i> <span class="text">Logout</span></a></li>
            </ul>
        </div>
		-->
            
		<%@ include file="sidebar.html"%>
		
		<div id="style-switcher">
			<i class="icon-arrow-left icon-white"></i>
			<span>Style:</span>
			<a href="#grey" style="background-color: #555555;border-color: #aaaaaa;"></a>
			<a href="#blue" style="background-color: #2D2F57;"></a>
			<a href="#red" style="background-color: #673232;"></a>
		</div>
		
		<div id="content">
			<div id="content-header">
				<h1>项目申请书</h1>
				<div class="btn-group">
					
				</div>
			</div>
			<div id="breadcrumb">
				<a href="#" title="Go to Home" class="tip-bottom"><i class="icon-home"></i>主页</a>
				
			</div>
			<div class="container-fluid">
				<div class="row-fluid">
					<div class="span12">
						    <center><h3>保存成功！</h3></center>
						   
							<center>
							
							
                            <a href="${pageContext.request.contextPath}/viewApplication" class="btn btn-success">查看申请书</a>
						    </center>
					</div>
				</div>
				
				<div class="row-fluid">
					<div id="footer" class="span12">
						2014 &copy;  <a target="blank" href="https://safewind.dlmu.edu.cn">safewind</a>
					</div>
				</div>
			</div>
		</div>
		
		
            
            
            <script src="${pageContext.request.contextPath}/js/jquery.ui.custom.js"></script>
            <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
            <script src="${pageContext.request.contextPath}/js/jquery.validate.js"></script>
            <script src="${pageContext.request.contextPath}/js/jquery.wizard.js"></script>
            <script src="${pageContext.request.contextPath}/js/unicorn.js"></script>
            <script src="${pageContext.request.contextPath}/js/unicorn.wizard.js"></script>
	</body>
</html>
