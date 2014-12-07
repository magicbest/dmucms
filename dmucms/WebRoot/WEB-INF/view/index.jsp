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
		<link rel="stylesheet" href="css/bootstrap.min.css" />
		<link rel="stylesheet" href="css/bootstrap-responsive.min.css" />
		<link rel="stylesheet" href="css/unicorn.main.css" />
		<link rel="stylesheet" href="css/unicorn.grey.css" class="skin-color" />	
		<script type="text/javascript" src="ckeditor/ckeditor.js"></script>
         <script type="text/javascript" src="ckfinder/ckfinder.js"></script>
	     <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	     <script src="js/jquery.min.js"></script>
	     <script>       
		    function myBrowser(){  
		    var userAgent = navigator.userAgent; //取得浏览器的userAgent字符串  
		    var isOpera = userAgent.indexOf("Opera") > -1; //判断是否Opera浏览器  
		    var isChrome = userAgent.indexOf("Chrome") > -1; //判断是否Chrome浏览器  
		    var isIE = userAgent.indexOf("compatible") > -1 && userAgent.indexOf("MSIE") > -1 && !isOpera ; //判断是否IE浏览器  
		    var isFF = userAgent.indexOf("Firefox") > -1 ; //判断是否Firefox浏览器  
		    var isSafari = userAgent.indexOf("Safari") > -1 ; //判断是否Safari浏览器  
		      
		      
		    if(isIE){  
		    var IE5 = IE55 = IE6 = IE7 = IE8 = false;  
		    var reIE = new RegExp("MSIE (\\d+\\.\\d+);");  
		    reIE.test(userAgent);  
		    var fIEVersion = parseFloat(RegExp["$1"]);  
		      
		    IE55 = fIEVersion == 5.5 ;  
		    IE6 = fIEVersion == 6.0 ;  
		    IE7 = fIEVersion == 7.0 ;  
		    IE8 = fIEVersion == 8.0 ;  
		    IE9 = fIEVersion == 9.0 ;   
			IE10 = fIEVersion == 10.0 ;
			IE11 = fIEVersion == 11.0 ;
			IE12 = fIEVersion == 12.0 ;
		    if(IE55){ return "IE55"; }  
		    if(IE6){ return "IE6"; }  
		    if(IE7){ return "IE7"; }  
		    if(IE8){ return "IE8"; }  
			if(IE9){ return "IE9"; }
			if(IE10){ return "IE10"; }
			if(IE11){ return "IE11"; }
			if(IE12){ return "IE12"; }
		    }//isIE end  
		      
		    if(isFF){ return "FF"; }  
		    if(isOpera){ return "Opera"; }  
		    if(isChrome){return"Chrome";}  
		    }//myBrowser() end  
		      
		    //以下是调用上面的函数  
		      
		    if(myBrowser()=="Chrome"||myBrowser()=="FF"||myBrowser()=="IE8"||myBrowser()=="IE9"||myBrowser()=="IE10"||myBrowser()=="IE11"||myBrowser()=="IE12"){ }  
			else{
			window.location.href="errors/browser.html";
			}
		   // if(myBrowser()=="Opera"){window.location.href="http://www.baidu.com";}  
		   // if(myBrowser()=="Safari"){window.location.href="http://www.baidu.com";}  
    </script>  
	</head>
	<body>
		
		
		<div id="header">
			<h1><a href="#">大创客户端</a></h1>		
		</div>
		<%@ include file="student/sidebar.html"%>
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
				<a href="${pageContext.request.contextPath}" title="Go to Home" class="tip-bottom"><i class="icon-home"></i>主页</a>
				
			</div>
			<div class="container-fluid">
				<div class="row-fluid">
					<div class="span12">
					         
						    <center>
						    <a href="http://202.118.83.44:8080/grade" class="btn btn-primary" target="_blank">查看2013年国家级优秀项目</a>
						    <a href="http://202.118" class="btn btn-primary" target="_blank">操作说明下载</a>
						    </center>
						     <hr/>
						    <center>
						    <a href="http://my.dlmu.edu.cn/oa/downloadattachment/45148/附件1关于实施大学生创新创业训练计划项目的有关要求.docx" class="btn btn-info" >关于实施大学生创新创业训练计划项目的有关要求.docx</a>
						    <a href="http://my.dlmu.edu.cn/oa/downloadattachment/45149/附件2立项评审标准.doc" class="btn btn-info">立项评审标准.doc</a>
						     <a href="http://my.dlmu.edu.cn/oa/downloadattachment/45150/附件3一级学科名称及代码.doc" class="btn btn-info" >一级学科名称及代码.doc</a>
						    </center>
						   
						    <hr/>
							<center>
							
							<a href="${pageContext.request.contextPath}/innovationApplication" class="btn btn-success">填写创新申请书</a>
                            <a href="${pageContext.request.contextPath}/businessApplication" class="btn btn-success">填写创业申请书</a>
                            <a href="${pageContext.request.contextPath}/viewApplication" class="btn btn-success">查看申请书</a>
                            <a href="${pageContext.request.contextPath}/appalication/<%=request.getRemoteUser()%>/edit"  class="btn btn-success">修改申请书</a>
                            <a href="${pageContext.request.contextPath}/appalication/<%=request.getRemoteUser()%>/edit"  class="btn btn-success">删除申请书</a>
                             <a href="${pageContext.request.contextPath}/appalication/<%=request.getRemoteUser()%>/edit"  class="btn btn-success">提交给老师</a>
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
		
		
            
            
            <script src="js/jquery.ui.custom.js"></script>
            <script src="js/bootstrap.min.js"></script>
            <script src="js/jquery.validate.js"></script>
            <script src="js/jquery.wizard.js"></script>
            <script src="js/unicorn.js"></script>
            <script src="js/unicorn.wizard.js"></script>
	</body>
</html>
