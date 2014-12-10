<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
			String basePath = request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>教师注册</title>

<script>
	function jud() {
		var b = document.getElementById('job');
		var d = document.getElementById('jobname');
		var t = document.getElementById('xue');
		var bb = b.selectedIndex;
		var dd = d.selectedIndex;
		var tt = t.selectedIndex;
		if ((b.options[bb].value == "德育教师" || d.options[dd].value == "讲师"
				|| d.options[dd].value == "实验师" || d.options[dd].value == "工程师" || d.options[dd].value == "助理研究员")
				&& (t.options[tt].value != "博士")) {
			alert("根据《大学生创新创业训练计划项目管理办法》的有关规定，指导教师一般应为具有高级职称（正高、副高）或博士学位的教学科研人员，如有特殊指导需要请致电教务处大学生创新教育与实践中心，电话：3603，感谢关注。");
			return false;
		}
		return true;

	}
</script>
</head>

<body>
	<center>
		<h2>某某某老师您好，您是第一次登陆，请完善您的个人信息，以便学生申报</h2>
	</center>
	<table align="center"
		style="border-collapse:collapse; margin-top:150px;" border=1
		bordercolor="#6699cc" cellPadding=4 width="600px;">
		<form onsubmit="return CheckForm();" action="${pageContext.request.contextPath}/teacher/<%=request.getRemoteUser() %>/saveBasicInfo"  name="teacherInfoForm" method="post">
			<tr>
				<td><table style="border-collapse:collapse;" border=1
						bordercolor="#6699cc" cellPadding=4 width="600px;">

						<tr>
							<td width="120px" align="center">手机</td>
							<td bgcolor="#eff1f3"><input size="30" name="teacherPhone"></td>
						</tr>
						<tr>
							<td width="120px" align="center">职务</td>
							<td bgcolor="#eff1f3"><select id="job"
								name="teacherPosition">
									<option value="专任教师">专任教师</option>
									<option value="实验教师">实验教师</option>
									<option value="德育教师">德育教师</option>
									<option value="研究人员">研究人员</option>
							</select></td>
						</tr>
						<tr>
							<td width="120px" align="center">职称</td>
							<td bgcolor="#eff1f3"><select id="jobname" name="teacherTitle">
									<option value="教授">教授</option>
									<option value="副教授">副教授</option>
									<option value="讲师">讲师</option>
									<option value="教授级实验员">教授级实验员</option>
									<option value="高级实验员">高级实验员</option>
									<option value="实验师">实验师</option>
									<option value="成绩优异的高级工程师">成绩优异的高级工程师</option>
									<option value="高级工程师">高级工程师</option>
									<option value="工程师">工程师</option>
									<option value="研究员">研究员</option>
									<option value="副研究员">副研究员</option>
									<option value="助理研究员">助理研究员</option>
							</select></td>
						</tr>
						<tr>
							<td width="120px" align="center">学位</td>
							<td bgcolor="#eff1f3"><select id="xue" name="teacherDegree">
									<option value="学士" >学士</option>
									<option value="硕士" >硕士</option>
									<option value="博士" >博士</option>
									<option value="其他" >其他</option>
							</select></td>
						</tr>

						<tr>
							<td width="120px" align="center">承担科研课题情况</td>
							<td bgcolor="#eff1f3"><textarea name="teacherResearch"
									style="overflow:hidden; border:0; resize:none; width:99%; height:100px"></textarea></td>
						</tr>
					</table></td>
			</tr>
			<tr style="width:600px;">
				<td align="center"><input name="teacher" value="提交"
					type="submit"></td>
			</tr>
		</form>
	</table>
	<script language="javascript">
		function CheckForm() {

			if (document.teacherInfoForm.teacherPhone.value.length == 0) {
				alert("请填写手机号.");
				document.teacherInfoForm.teacherPhone.focus();
				return false;
			}

			if (document.teacherInfoForm.teacherPosition.value.length == 0) {
				alert("请填写职务.");
				document.teacherInfoForm.teacherPosition.focus();
				return false;
			}
			if (document.teacherInfoForm.teacherTitle.value.length == 0) {
				alert("请填写职称.");
				document.teacherInfoForm.teacherTitle.focus();
				return false;
			}
			if (document.teacherInfoForm.teacherDegree.value.length == 0) {
				alert("请填写学位.");
				document.teacherInfoForm.teacherDegree.focus();
				return false;
			}

			var b = document.getElementById('job');
			var d = document.getElementById('jobname');
			var t = document.getElementById('xue');
			var bb = b.selectedIndex;
			var dd = d.selectedIndex;
			var tt = t.selectedIndex;
			if ((b.options[bb].value == "德育教师" || d.options[dd].value == "讲师"
					|| d.options[dd].value == "实验师"
					|| d.options[dd].value == "工程师" || d.options[dd].value == "助理研究员")
					&& (t.options[tt].value != "博士")) {
				alert("根据《大学生创新创业训练计划项目管理办法》的有关规定，指导教师一般应为具有高级职称（正高、副高）或博士学位的教学科研人员，如有特殊指导需要请致电教务处大学生创新教育与实践中心，电话：3603，感谢关注。");
				return false;
			}

			return true;

		}
	</script>
</body>
</html>
