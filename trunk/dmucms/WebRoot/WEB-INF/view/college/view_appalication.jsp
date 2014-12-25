<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

	<title>大连海事创新创业申请书</title>
	<meta content="text/html; charset=utf-8" http-equiv="content-type"/>
	<link rel="stylesheet" type="text/css" href="../css/h1.css">
	
</head>
<body>

  <div>
    
    <div align="center"> 
<h1><strong><a name="h1" id="h1"></a>大连海事大学</strong></h1>
<h2>大学生创新训练项目申请书</h2>
</div>


<div id="contect" align="center">
      <p style="font-size:xx-large"><a name="h2" id="h2"></a>一、基本情况</p>
      <table width="800" height="30" border="1px"  cellpadding="0" cellspacing="0" style="border-bottom:0px;">
        <tr>
          <td width="140">项目名称</td>
          <td colspan="7"> <c:out value="${project.projectName}" ></c:out> </td>
        </tr>
     </table>
     <table width="800" height="30" border="1px"  cellpadding="0" cellspacing="0" style="border-top:0px; border-bottom:0px;" >
        <tr>
          <td width="140">所属学科</td>
          <td width="265"><c:out value="${project.projectSubject}" ></c:out></td>
          <td width="80">项目等级</td>
          <td>校级创新项目</td>
        </tr>
     </table>
     <table width="800" height="30" border="1px"  cellpadding="0" cellspacing="0" style="border-top:0px; border-bottom:0px;" >
        <tr>
          <td width="140">申请金额</td>
          <td width="100">1000元</td>
        </tr>
     </table>
     <table width="800" height="30" border="1px"  cellpadding="0" cellspacing="0" style="border-top:0px; border-bottom:0px;" >
        <tr>
          <td width="140">负责人姓名</td>
          <td width="100"><c:out value="${student.studentName}" ></c:out></td>
          <td width="80">性别</td>
          <td width="80"><c:out value="${student.studentSex}" ></c:out></td>
          <td width="80">民族</td>
          <td width="80"><c:out value="${student.studentNation}" ></c:out></td>
          <td width="80">出生年月</td>
          <td><c:out value="${student.studentBirthDay}" ></c:out></td>
        </tr>
       
     </table>
     <table width="800" height="30" border="1px"  cellpadding="0" cellspacing="0" style="border-top:0px; border-bottom:0px;" >
         <tr>
          <td width="140">学号</td>
          <td width="100"><%=request.getRemoteUser()%></td>
          <td width="80">联系方式</td>
          <td><c:out value="${student.studentPhone}" ></c:out></td>
          <td>学院：<c:out value="${student.studentCollega}" ></c:out></td>
          <td>专业：<c:out value="${student.studentMajor}" ></c:out></td>
         </tr> 
        
     </table>
     <table width="800" height="30" border="1px"  cellpadding="0" cellspacing="0" style="border-top:0px; border-bottom:0px;" >
      <tr>
        <td width="150">电子邮箱</td>
          <td width="650"><c:out value="${student.studentEmail}" ></c:out></td>
        </tr>
     </table>
     <table width="800" border="1px"  cellpadding="0" cellspacing="0" style="border-top:0px; border-bottom:0px;" >
	    <tr>
          <td width="140">负责人曾经参与科研的情况</td>
          <td><c:out value="${student.studentResearch}" ></c:out></td>
        </tr>
     </table>
     <table width="800" border="1px"  cellpadding="0" cellspacing="0" style="border-top:0px; border-bottom:0px;" >
        <tr>
          <td width="140">项目来源</td>
          <td style="text-align:left"><c:out value="${project.projectFrom}" ></c:out></td>
        </tr>
     </table>
     <table width="800" border="1px"  cellpadding="0" cellspacing="0" style="border-top:0px; border-bottom:0px;" >
    	<tr>
          <td width="140">项目来源名称</td>
          <td style="text-align:left"><c:out value="${project.projectFromName}" ></c:out></td>
        </tr>
     </table>
    <table width="800" border="1px"  cellpadding="0" cellspacing="0" style="border-top:0px; border-bottom:0px;" >
        <tr height="30">
          <td width="140" rowspan="4">指导教师</td>
          <td width="100">姓名</td>
          <td width="210"><c:out value="${project.projectTeacherName}" /></td>
          <td width="100">教工号</td>
          <td><c:out value="${project.projectTeacherId}" /></td>
        </tr>
    </table>
    <table width="800" border="1px"  cellpadding="0" cellspacing="0" style="border-top:0px; border-bottom:0px;" >
        <tr height="30">
          <td width="140" rowspan="4">指导教师对本项目的支持情况</td>
          
          <td width="660"><c:out value="${project.teacherComment}" /></td>
          
        </tr>
    </table>
    
   <!-- 企业导师 -->
    <c:if test="${businessTeacher != null}">
    <table width="800" border="1px"  cellpadding="0" cellspacing="0" style="border-top:0px; border-bottom:0px;" >
        <tr height="30">
          <td width="140" rowspan="2">企业导师</td>
          <td width="100">姓名</td>
          <td width="210">${businessTeacher.businessTeacherName}</td>
          <td width="100">手机</td>
          <td>${businessTeacher.businessTeacherPhone}</td>
        </tr>
        <tr height="30">
          <td width="100">单位</td>
          <td width="210">${businessTeacher.businessTeacherCompany}</td>
          <td width="100">职务/职称</td>
          <td>${businessTeacher.businessTeacherTitle}</td>
        </tr>
         <!-- 企业导师结束 -->  
    
    </table>
    
   </c:if>
     
    <table width="800" border="1px"  cellpadding="0" cellspacing="0" style="border-top:0px;" >
        <tr height="30">
          <td width="140" rowspan="5">项目组主要成员</td>
          <td width="130">姓名</td>
          <td width="130">学号</td>
          <td width="130">专业班级</td>
          <td width="130">所在学院</td>
          <td>项目中的分工</td>
        </tr>
       <c:forEach items="${memberList}" var="member" varStatus="index">
        <tr   height="30">
          <td><c:out value="${member.memberName}" /></td>
          <td><c:out value="${member.memberId}" /></td>
          <td><c:out value="${member.memberCalss}" /></td>
          <td><c:out value="${member.memberCollega}" /></td>
          <td><c:out value="${member.memberWork}" /></td>
        </tr>
       </c:forEach>
      </table> 
</div>
<div class="hu44">&nbsp;</div>
<div class="hu44">&nbsp;</div>
<div class="hu44">&nbsp;</div>
<div  align="center">
<p style="font-size:xx-large"><a name="h3" id="h3"></a>二、立项依据</p>
<table width="800" border="1px"  cellpadding="0" cellspacing="0">
<tr><td>
  ${project.projectContent}</td>
  </tr>
</table>
</div>

<div id="contect" align="center">


<table width="800" border="1px"  cellpadding="0" cellspacing="0" style="border-top:0px; border-bottom:0px;" >
	    <tr>
          <td align="center">项目简介（100字以内）</td>
		</tr>
		<tr>
          <td  style="height:70px"><c:out value="${project.projectSpecial}" ></c:out></td>
        </tr>
   </table>


<p style="font-size:xx-large"><a name="h4" id="h4"></a>三、经费预算</p>
        <table width="800" border="1" cellpadding="0" cellspacing="0" style="border:solid">
          <tr style="font-size:20px" height="35">
            <td width="200" rowspan="1">开支项目</td>
            <td width="100" rowspan="1">预算经费</td>
            <td width="300" rowspan="1">主要用途</td>
          </tr>

  <tr height="30">
            <td>1.设备费</td>
            <td><c:out value="${cost.equipmentCost}" ></c:out></td>
            <td><c:out value="${cost.equipmentUse}" ></c:out></td>
          </tr>
          <tr height="30">
            <td>2.材料费</td>
            <td><c:out value="${cost.materialCost}" ></c:out></td>
            <td><c:out value="${cost.materialUse}" ></c:out></td>      
            </tr>
          <tr height="30">
            <td>3.测试/化验/加工费</td>
            <td><c:out value="${cost.testCost}" ></c:out></td>
            <td><c:out value="${cost.testUse}" ></c:out></td>        
            </tr>
          <tr height="30">
            <td>4.差旅费</td>
            <td><c:out value="${cost.trafficCost}"></c:out></td>
            <td><c:out value="${cost.trafficUse}" ></c:out></td>     
             </tr>
          <tr height="30">
            <td>5.出版/文献/信息传播/知识产权事务费</td>
            <td><c:out value="${cost.publishCost}" ></c:out></td>
            <td><c:out value="${cost.publishUse}" ></c:out></td>       
            </tr>
          <tr height="30">
            <td>6.劳务费</td>
            <td><c:out value="${cost.labourCost}" ></c:out></td>
            <td><c:out value="${cost.labourUse}" ></c:out></td>       
            </tr>
          <tr height="30">
            <td>7.专家咨询费</td>
            <td><c:out value="${cost.expertCost}" ></c:out></td>
            <td><c:out value="${cost.expertUse}" ></c:out></td>     
              </tr>

        </table>
        
  </div>
  
  </div>
  
             
</body>
</html>