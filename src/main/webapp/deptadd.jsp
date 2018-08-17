<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.text.*,java.util.*,dao.*,entity.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css" />
<style type="text/css">
#div{
	width: 801;
	height: 422px;
	background-image: url(images/center2.jpg);"
}
.d2{
	width: 263px;
	height: 30px;
	
}
.d1{
	width: 83px;
	font-size: 9pt;
	font-weight: bold;
   color: #ffffff;
	text-align: center;
	background-color:66583D;
}
#in{
	border: 0px solid #B38E61;
	color: #333333;
	font-family: "宋体";
   font-size: 12pt;
}
</style>
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<%@ include file="header.jsp"%>
		<form action="add.do" method="post">
			<table width="801" height="48" border="0" cellpadding="0"
			cellspacing="0" background="images/center1.jpg">
			<tr>
				<td valign="top">
					<table width="494">
						<tr>
							<td width="45" height="25">&nbsp;</td>
							<td width="437" valign="bottom"><font color="#66583D"><b>部门管理&nbsp;</b></font>&gt;
								<font color="#FF0000"> 部门添加</font></td>
						</tr>
					</table>
					<br>
					<div align="center" id="div">
						<table border="1" cellpadding="1" cellspacing="1"
							style="width: 355;">
							<tr height="30">
								<td class="d1">部门名称:</td>
								<td class="d2"><input type="text" name="dt_name">
									<%
										String msg=(String)request.getAttribute("msg");
									%>
									<span style="font-size:20px;color:red;">
										<%=msg == null ? "" :msg %>
									</span>
								</td>
							</tr>
							<tr height="30">
								<td class="d1">创建时间:</td>
								<td class="d2">
									<input id="in" type="text" name="dt_createTime" 
									value="<%
									Date date1=new Date();
									SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
									out.println(sdf1.format(date1));
									
									%>">
								</td>
							</tr>
							<tr height="30">
								<td class="d1">备注信息:</td>
								<td class="d2"><input type="text" name="dt_bz" value="??"></td>
							</tr>
						</table>
						<br>
						<input type="submit" value="保存" > &nbsp;&nbsp; 
						<input type="reset" value="重置"> &nbsp;&nbsp; 
						<input type="button" name="button" value="返回" onclick="javascript:history.go(-1);">
					</div>
				</td>
			</tr>
			<tr>
				<td><img src="images/down.jpg"></td>
			</tr>
		</table>
		</form>
	</div>
</body>
</html>