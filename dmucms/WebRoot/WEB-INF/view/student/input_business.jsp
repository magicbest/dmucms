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
	<script type="text/javascript">
$(function () {
	var show_count = 4;   //要显示的条数
	var count = 1;    //递增的开始值，这里是你的ID
	$("#btn_addtr").click(function () {

		var length = $("#dynamicTable tbody tr").length;
		//alert(length);
		if (length < show_count)    //点击时候，如果当前的数字小于递增结束的条件
		{
			$("#tab11 tbody tr").clone().appendTo("#dynamicTable tbody");   //在表格后面添加一行
			changeIndex();//更新行号
		}
		if (length >= show_count) {
		alert("最多只能有四名队员（不包含队长）");
	    } 
	});


});
function changeIndex() {
	var i = 1;
	$("#dynamicTable tbody tr").each(function () { //循环tab tbody下的tr
		$(this).find("input[name='NO']").val(i++);//更新行号
	});
}

function deltr(opp) {
	var length = $("#dynamicTable tbody tr").length;
	//alert(length);

		$(opp).parent().parent().remove();//移除当前行
		changeIndex();
	
}
</script>
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
				<a href="${pageContext.request.contextPath}" title="Go to Home" class="tip-bottom"><i class="icon-home"></i>主页</a>
				<a href="#">项目管理</a>
				<a href="#" class="current">项目申请</a>
			</div>
			<div class="container-fluid">
				<div class="row-fluid">
					<div class="span12">
						<div class="widget-box">
							<div class="widget-title">
								<span class="icon">
									<i class="icon-pencil"></i>
								</span>
								<h5>填写项目申请书</h5>
							</div>
							<div class="widget-content nopadding">
								<form id="form-wizard" class="form-horizontal" method="post" action="${pageContext.request.contextPath}/businessApplication" />
									
									<div id="form-wizard-1" class="step">
									    <div class="control-group">
											<label class="control-label">项目名称</label>
											<div class="controls">
												<input id="projectName" type="text" name="projectName" maxlength="100"/>
												<input  type="hidden" name="projectType" value="CY"  />
											</div>
										</div>
										 <div class="control-group">
										<label class="control-label">项目简介（100字以内）</label>
										   <div class="controls">
											<textarea maxlength="100" name="projectSpecial"  style="height:70px;" id="required"></textarea>
										   </div>
									    </div>	
										<div class="control-group">
										<center><h3>立项依据</h3></center>
										   <div >
											<textarea id="editor1"  name="projectContent" >（一）研究目的<br/>（二）研究内容<br/>（三）国、内外研究现状和发展动态<br/>（四）创新点与项目特色<br/>（五）技术路线、拟解决的问题及预期成果<br/>（六）项目研究进度安排<br/>（七）已有基础
						<br>&nbsp;&nbsp;&nbsp;1．与本项目有关的研究积累和已取得的成绩<br/>&nbsp;&nbsp;&nbsp;2．已具备的条件，尚缺少的条件及解决方法</textarea>
						                     <ckf:setupCKEditor  basePath="/dmucms/ckfinder/"  editor="editor1"/>
					                         <ckeditor:replace  replace="editor1" basePath="/dmucms/ckeditor/" />
										   </div>
									    </div>	
                                       										
									</div>
									
									<div id="form-wizard-2" class="step">
										<div class="control-group">
											<label class="control-label">项目负责人及学号</label>
											<div class="controls">
												  <input  type="text" name="studentId"  value="<%=request.getRemoteUser()%>"  readonly="readonly" /> 
											</div>
										</div>
										<div class="control-group">
											<label class="control-label">负责人邮箱</label>
											<div class="controls">
												<input id="email" name="studentEmail"  type="text" name="email2" />
											</div>
										</div>
										<div class="control-group">
											<label class="control-label">负责人电话</label>
											<div class="controls">
											<input type="text" name="studentPhone" id="number" />
										    </div>
										</div>
										<div class="control-group">
										<label class="control-label">负责人参与科研情况<br/>(300字以内）</label>
										   <div class="controls">
											<textarea  name="studentResearch"  maxlength="300" style="height:100px;"></textarea>
										   </div>
									    </div>
										<div class="control-group">
											   <label class="control-label">指导教师教工号（重要）</label>
											   <div class="controls">
											    <input type="text" name="projectTeacherId" id="number" />
										    </div>
										</div>
										
										<div class="control-group">
										<hr/>
										<label class="control-label">企业导师<br/>
										（没有可以不填）
										</label>
										<div class="controls">
										 <table>
											<tr height="30">
											  <td width="100">姓名</td>
											  <td width="210"><input type="text" name="businessTeacherName" size="29" /></td>
											  <td width="100">手机</td>
											  <td><input type="text" name="businessTeacherPhone" size="30"  id="number_only"/></td>
											</tr>
											<tr height="30">
											  <td width="100">单位</td>
											  <td width="210"><input type="text" name="businessTeacherCompany" size="29" /></td>
											  <td width="100">职务/职称</td>
											  <td><input type="text" name="businessTeacherTitle" size="30" /></td>
											</tr>
										</table>
										</div>
										</div>
										
										
									</div>
									<div id="form-wizard-3" class="step">
										<div class="control-group">
											<center><label>项目成员（不包括队长，最多四人）</label></center>
										</div>	
										<div style="width:720px;margin:20px auto;">

											<table id="tab11" style="display: none">
												<tbody>
													<tr>
														<td height="30" align="center" width="80">
															<input type="text" name="NO" size="2" value="1" /></td>
														<td align="center" width="150">
															<input type="text" id="number" name="projectMemberId" /></td>
														<td align="center" width="350">
															<input type="text" name="projectMemberWork" maxlength="100" /></td>
														<td>
															<input type="button" id="Button1" onClick="deltr(this)" value="删除一名" class="btn btn-danger"/>
														</td>
													</tr>
												</tbody>
											</table>
											
											<table id="dynamicTable" width="700" border="0" cellspacing="0" cellpadding="0">
												<thead>
													<tr>
														<td height="30" align="center" bgcolor="#D1EEEE" width="80">ID</td>
														<td align="center" bgcolor="#D1EEEE" width="150">学号</td>
														<td align="center" bgcolor="#D1EEEE" width="350">项目中的分工</td>
														<td><input type="button" id="btn_addtr" value="增加一名" class="btn btn-success"/></td>
													</tr>
												</thead>
												<tbody>
													
												</tbody>
											</table>

										</div>										
									</div>
									<div id="form-wizard-4" class="step">
										
										<div class="control-group">
										<label class="control-label">所属学科门类</label>
										<div class="controls">
											<select name="projectSubject">
												<option value="未填写">请选择学科门类
												<option value="0101哲学"/>0101哲学
												<option value="0201理论经济学"/>0201理论经济学		  
												<option value="0202经济学"/>0202经济学			  
												<option value="0301法学"/>0301法学
												<option value="0302政治学"/>0302政治学
												<option value="0303社会学"/>0303社会学			  
												<option value="0304民族学"/>0304民族学
												<option value="0401教育学"/>0401教育学
												<option value="0402心理学"/>0402心理学
												<option value="0403体育学"/>0403体育学			  
												<option value="0501中国语言文学"/>0501中国语言文学			  
												<option value="0502外国语言文学"/>0502外国语言文学
												<option value="0503新闻传播学"/>0503新闻传播学
												<option value="0504艺术学"/>0504艺术学			  
												<option value="0601历史学"/>0601历史学
												<option value="0701数学"/>0701数学
												<option value="0702物理学"/>0702物理学
												<option value="0703化学"/>0703化学			  
												<option value="0704天文学"/>0704天文学			 
												<option value="0705地理学"/>0705地理学
												<option value="0706大气科学"/>0706大气科学
												<option value="0707海洋科学"/>0707海洋科学			  
												<option value="0708地球物理学"/>0708地球物理学
												<option value="0709地质学"/>0709地质学
												<option value="0710生物学"/>0710生物学
												<option value="0711系统科学"/>0711系统科学		  
												<option value="0712科学技术史"/>0712科学技术史		  
												<option value="0801力学"/>0801力学
												<option value="0802机械工程"/>0802机械工程		  
												<option value="0803光学工程"/>0803光学工程			  
												<option value="0804仪器科学与技术"/>0804仪器科学与技术
												<option value="0805材料科学与工程"/>0805材料科学与工程
												<option value="0806冶金工程"/>0806冶金工程			  
												<option value="0807动力工程及工程热物理"/>0807动力工程及工程热物理
												<option value="0808电气工程"/>0808电气工程
												<option value="0809电子科学与技术"/>0809电子科学与技术
												<option value="0810信息与通信工程"/>0810信息与通信工程
												<option value="0811控制科学与工程"/>0811控制科学与工程			  
												<option value="0812计算机科学与技术"/>0812计算机科学与技术
												<option value="0813建筑学"/>0813建筑学
												<option value="0814土木工程"/>0814土木工程			  
												<option value="0815水利工程"/>0815水利工程
												<option value="0816测绘科学与技术"/>0816测绘科学与技术
												<option value="0817化学工程与技术"/>0817化学工程与技术
												<option value="0818地质资源与地质工程"/>0818地质资源与地质工程	  
												<option value="0819矿业工程"/>0819矿业工程			 
												<option value="0820石油与天然气工程"/>0820石油与天然气工程
												<option value="0821纺织科学与工程"/>0821纺织科学与工程
												<option value="0822轻工技术与工程"/>0822轻工技术与工程			  
												<option value="0823交通运输工程"/>0823交通运输工程
												<option value="0824船舶与海洋工程"/>0824船舶与海洋工程
												<option value="0825航空宇航科学与技术"/>0825航空宇航科学与技术
												<option value="0826兵器科学与技术"/>0826兵器科学与技术		  
												<option value="0827核科学与技术"/>0827核科学与技术
												<option value="0828农业工程"/>0828农业工程		  
												<option value="0829林业工程"/>0829林业工程
												<option value="0830环境科学与工程"/>0830环境科学与工程
												<option value="0831生物医学工程"/>0831生物医学工程
												<option value="0832食品科学与工程"/>0832食品科学与工程
												<option value="0901作物学"/>0901作物学
												<option value="0902园艺学"/>0902园艺学
												<option value="0903农业资源利用"/>0903农业资源利用			  
												<option value="0904植物保护"/>0904植物保护
												<option value="0905畜牧学"/>0905畜牧学			  
												<option value="0906兽医学"/>0906兽医学
												<option value="0907林学"/>0907林学
												<option value="0908水产"/>0908水产		  
												<option value="1001基础医学"/>1001基础医学
												<option value="1002临床医学"/>1002临床医学
												<option value="1003口腔医学"/>1003口腔医学			  
												<option value="1004公共卫生与预防医学"/>1004公共卫生与预防医学
												<option value="1005中医学"/>1005中医学		  
												<option value="1006中西医结合"/>1006中西医结合
												<option value="1007药学"/>1007药学
												<option value="1008中药学"/>1008中药学
												<option value="1101军事思想及军事历史"/>1101军事思想及军事历史
												<option value="1102战略学"/>1102战略学
												<option value="1103战役学"/>1103战役学			  
												<option value="1104战术学"/>1104战术学
												<option value="1105军队指挥学"/>1105军队指挥学			  
												<option value="1106军制学"/>1106军制学
												<option value="1107军队政治工作学"/>1107军队政治工作学		 
												<option value="1108军事后勤学与军事装备学"/>1108军事后勤学与军事装备学
												<option value="1201管理科学与工程"/>1201管理科学与工程
												<option value="1202工商管理"/>1202工商管理
												<option value="1203农林经济管理"/>1203农林经济管理		  
												<option value="1204公共管理"/>1204公共管理
												<option value="1205图书馆、情报与档案管理"/>1205图书馆、情报与档案管理
											</select>
										</div>
									</div>
									<div class="control-group">
										<label class="control-label">项目来源</label>
										<div class="controls">
											<label><input checked="true" type="radio" name="projectFrom" value="学生自主选题，来源于自己对课题的长期积累与兴趣" />学生自主选题，来源于自己对课题的长期积累与兴趣</label>
											<label><input  type="radio" name="projectFrom" value="来源于教师科研项目选题"/>来源于教师科研项目选题</label>
											<label><input  type="radio" name="projectFrom" value="学生承担社会、企业委托项目选题"/>学生承担社会、企业委托项目选题</label>
										</div>
									</div>
									<div class="control-group">
										<label class="control-label">项目来源名称</label>
										<div class="controls">
											<label><input type="radio" name="projectFromName" value="863项目" /> 863项目</label>
											<label><input type="radio" name="projectFromName" value="973项目" /> 973项目</label>
											<label><input type="radio" name="projectFromName" value="国家自然科学基金项目"/>国家自然科学基金项目</label>
											<label><input type="radio" name="projectFromName" value="省级自然科学基金项目"/>省级自然科学基金项目</label>
											<label><input type="radio" name="projectFromName" value="教师横向科研项目"/>教师横向科研项目</label>
											<label><input type="radio" name="projectFromName" value="企业委托项目"/>企业委托项目</label>
											<label><input type="radio" name="projectFromName" value="社会委托项目"/>社会委托项目</label>
											<label><input checked="true" type="radio" name="projectFromName" value="其他项目"/>其他项目</label>
										</div>
									</div>
										
									</div>
									
									<div id="form-wizard-5" class="step">
                                        <center><h3>经费预算</h3></center><br/>
										<center><h4>没有相关费用请填0</h4></center>
										<div>&nbsp;</div>
										<table class="table table-bordered table-condensed table-border-n">
											<tr>
												<td>开支项目</td>
												<td>预算经费（元）</td>
												<td>主要用途</td>
											</tr>
											<tr>
												<td>1.设备费</td>
												<td><input type="text" name="equipmentCost" size="11" id="number"/></td>
												<td><input type="text" name="equipmentUse" size="45" maxlength="100"/></td>
											</tr>
											<tr>
												<td>2.材料费</td>
												<td><input type="text" name="materialCost" size="11" id="number"/></td>
												<td><input type="text" name="materialUse" size="45" maxlength="100"/></td>      
											</tr>
											<tr>
												<td>3.测试/化验/加工费</td>
												<td><input type="text" name="testCost" size="11" id="number"/></td>
												<td><input type="text" name="testUse" size="45" maxlength="100"/></td>        
											</tr>
											<tr>
												<td>4.差旅费</td>
												<td><input type="text" name="trafficCost" size="11" id="number"/></td>
												<td><input type="text" name="trafficUse" size="45" maxlength="100"/></td>     
											</tr>
											<tr>
												<td>5.出版/文献/信息传播/知识产权事务费</td>
												<td><input type="text" name="publishCost" size="11" id="number"/></td>
												<td><input type="text" name="publishUse" size="45" maxlength="100"/></td>       
											</tr>
											<tr>
												<td>6.劳务费</td>
												<td><input type="text" name="labourCost" size="11" id="number"/></td>
												<td><input type="text" name="labourUse" size="45" maxlength="100"/></td>       
											</tr>
											<tr>
												<td>7.专家咨询费</td>
												<td><input type="text" name="expertCost" size="11" id="number"/></td>
												<td><input type="text" name="expertUse" size="45" maxlength="100"/></td>     
											</tr>
										</table>
										<div>&nbsp;</div>										
									</div>
									
									<div class="form-actions">
											<input id="back" class="btn btn-primary" type="reset" value="Back" />
											<input id="next" class="btn btn-primary" type="submit" value="Next" />
											<div id="status"></div>
									</div>
									<div id="submitted"></div>
								</form>
							</div>
						</div>
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
