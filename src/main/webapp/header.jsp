<%@page import="java.text.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<map name="Map">
	<area shape="rect" coords="187,28,256,79" href="list.do">
	<area shape="rect" coords="278,27,347,86" href="#">
	<area shape="rect" coords="367,24,435,101" href="#">
	<area shape="rect" coords="461,29,525,92" href="#">
	<area shape="rect" coords="551,24,623,103" href="#">
	<area shape="rect" coords="642,28,704,103" href="#">
	<area shape="rect" coords="708,20,793,134" href="#">

</map>

<body>
	<table width="100" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td><img src="images/top1.jpg" width="801" height="60"
				border="0" usemap="#Map"></td>
		</tr>
	</table>
	<table width="100" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td><img src="images/top2.jpg" width="801" height="107"></td>
		</tr>
	</table>
	<table width="801" height="34" border="0" cellpadding="0"
		cellspacing="0" background="images/top3.jpg">
		<tr>
			<td width="532" align="right" valign="top">
				<table width="224" border="0" align="right" cellpadding="0"
					cellspacing="0">
					<tr>
						<td width="206" height="30" valign="bottom" align="right"><font
							color="#666633"> 系统时间： <%
							Date date = new Date();
							SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						%> <%=sdf.format(date)%>
						</font></td>
						<td width="10">&nbsp;</td>
					</tr>
				</table>
			</td>
			<td width="88">
				<a href="manager_update.jsp" onClick="javascript:;" onMouseOver="MM_swapImage('Image1','','images/top-11.gif',1)" onMouseOut="MM_swapImgRestore()">
					<img src="images/top-1.gif" name="Image1" width="85" height="34" border="0" id="Image1">
				</a>
			</td>
			<td width="88">
					
				<a href="mainPage.jsp" onClick="javascript:;" onMouseOver="MM_swapImage('Image2','','images/top-22.gif',1)" onMouseOut="MM_swapImgRestore()">
					<img src="images/top-2.gif" name="Image2" width="85" height="34" border="0" id="Image2">
				</a>
			</td>
			<td width="93">
				<a href="javascript:quit()" onClick="javascript:;" onMouseOver="MM_swapImage('Image3','','images/top-33.gif',1)" onMouseOut="MM_swapImgRestore()">
					<img src="images/top-3.gif" name="Image3" width="85" height="34" border="0" id="Image3">
				</a>
			</td>
		</tr>
	</table>
	
	
</body>
</html>