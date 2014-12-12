<%@page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor" %>
<%@ taglib uri = "http://ckfinder.com" prefix="ckf" %>
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
	     <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	     <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	     <script src="${pageContext.request.contextPath}/js/bootstrap-paginator.min.js"></script>
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
				<a href="${pageContext.request.contextPath}" title="Go to Home" class="tip-bottom"><i class="icon-home"></i>主页</a>
				
			</div>
			
	    <input id="totalPage" type="hidden" th:value="${page.totalPageCount}"> </input>     
        <input id="pageNow" type="hidden" th:value="${page.pageNow}"> </input>   
          
    	<div align="right" style="margin-right:20px"   id="prolist" > </div>  
			
			
			<script type='text/javascript'>  
        var total=$("#totalPage").val();
        var pageNow=$("#pageNow").val();    
        var fromDate = $("#datepicker").val(); 
        var toDate = $("#datepicker2").val(); 
        var options = {
        	
            currentPage:pageNow ,
            totalPages: total,
            numberOfPages:10,
            itemTexts: function (type, page, current) {
                switch (type) {
                case "first":
                    return "First";
                case "prev":
                    return "&lt;";
                case "next":
                    return "&gt;";
                case "last":
                    return "Last";
                case "page":
                    return ""+page;
                }
            },
            pageUrl: function(type, page, current){            
            		return "/queryWorkNumInHref?roundPram="+fromDate+"@"+toDate+"@"+ page ;
            }
      
        }  
        
    	   $('#prolist').bootstrapPaginator(options);
           $('#prolist2').bootstrapPaginator(options);
   		</script>
			
			
			<div class="container-fluid">
				<div class="row-fluid">
					<div class="span12">
					       <div class="widget-box">
							<div class="widget-title">
								<span class="icon">
									<i class="icon-th"></i>
								</span>
								<h5>项目列表</h5>
							</div>
							<div class="widget-content nopadding">
								<table class="table table-bordered table-striped">
									<thead>
										<tr>
										    <th>序号</th>
											<th>项目名称</th>
											<th>项目负责人</th>
											<th>负责人电话</th>
											<th>项目等级</th>
											<th>项目经费</th>
											<th>项目状态</th>
											<th>指导教师</th>
											<th>项目详情</th>
											<th>操作</th>
										</tr>
									</thead>
									<tbody>
									   <c:forEach items="${projectList}" var="project" varStatus="index">
										<tr>
										    <td >${index.count}</td>
											<td  ><c:out value="${project.projectName}" /></td>
											<td><c:out value="${project.projectMannagerName}" /></td>
											<td><c:out value="${project.projectMannagerPhone}" /></td>
											<td>
											  <c:if test="${project.projectRank == null}">校级</c:if> 
											  <c:if test="${project.projectRank != null}">${project.projectRank}</c:if>
											 </td>
											<td>
											  <c:if test="${project.projectCost == null}">1000</c:if> 
											  <c:if test="${project.projectCost != null}">${project.projectCost}</c:if>
											 </td>
											<td> 
											  <c:if test="${project.projectStatus == 0}">未提交</c:if> 
											  <c:if test="${project.projectStatus == 1}">已提交</c:if> 
											  <c:if test="${project.projectStatus == 2}">导师通过</c:if> 
										   </td>
											<td>
											   <form method="post"  target="_blank"  action="${pageContext.request.contextPath}/teacher/<%=request.getRemoteUser() %>/view/${project.projectMannagerId}">
											        <input type="hidden"  name="projectMannagerId" value="${project.projectMannagerId}">
											        <input type="hidden"  name="projectId" value="${project.projectId}">
											        <input type="submit"  class="btn btn-info btn-mini" value="查看" >
											   </form>
											</td>
											<td>
											    <c:if test="${project.projectStatus != 0}">
											       <a href="#passAlert${index.count}" data-toggle="modal" class="btn btn-success btn-mini">操作</a>
											    </c:if> 
											</td>
										</tr>
									  </c:forEach>
									</tbody>
								</table>							
							</div>
						</div>					
					</div>
				</div>
				
			  <c:forEach items="${projectList}" var="project" varStatus="index">
				<div id="passAlert${index.count}" class="modal hide">
					<div class="modal-header">
						<button data-dismiss="modal" class="close" type="button"></button>
						<h3>确认通过</h3>
					</div>
				  <form action="${pageContext.request.contextPath}/teacher/<%=request.getRemoteUser() %>/review/${project.projectId}" method="post">
					<div class="modal-body">
					       <p><strong>请选择是否通过该项目</strong></p>
					       <div class="control-group"> 
							   <div class="controls"> 
							    <label class="radio inline"> <input type="radio" value="2" checked="checked" name="projectResult" /> 通过该项目</label> 
							    <label class="radio inline"> <input type="radio" value="0" name="projectResult" /> 退回该项目 </label> 
							   </div> 
							</div>
						<p><strong>请输入对该项目的评语.</strong></p>
						<input type="hidden"  name="projectId" value="${project.projectId}" >
						<textarea rows="3" name="teacherComment"  style="width:500px;"></textarea>
					</div>
					<div class="modal-footer">
					    <input class="btn btn-primary"  type="submit" value="确认" >
						<a data-dismiss="modal" class="btn" href="#">取消</a>
					</div>
				</form>
              </div>
            </c:forEach>
                                
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

