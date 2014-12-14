<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-theme.min.css" />
    <script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/bootstrap/js/jquery-2.1.1.min.js"></script>
    <title>编辑邮件</title>
    
  </head>
  
  <body>
   <div  align="center" style="width: 800px" >
     <form class="form-horizontal" action="${pageContext.request.contextPath}/center/sendMail" method="post" role="form">
     
   <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <div class="checkbox">
        <label>
          <input type="checkbox" name="sendAll" value="1" > 发送全部
        </label>
      </div>
    </div>
  </div>
     
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">邮箱</label>
    <div class="col-sm-10">
      <input type="text" class="form-control"  name="EmailAddressee"  placeholder="Email">
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">主题</label>
    <div class="col-sm-10">
      <input type="text" class="form-control"  name="EmailSubject"  placeholder="EmailSubject">
    </div>
  </div>
  
  <label class="control-label">邮件内容</label>
   <div class="controls">
	<textarea   name="EmailContent"  style="height:250px;width: 600px;" ></textarea>
   </div>
   </div>	

  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">发送</button>
    </div>
  </div>
</form>
     </div>
  </body>
</html>
