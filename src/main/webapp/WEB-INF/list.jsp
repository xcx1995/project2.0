<%@ page pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@ page import="java.util.*,java.text.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>措滹人力资源管理系统--培训管理</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<script language="JavaScript">
function deleteForm(date){
if(confirm("确定要删除此培训信息吗？")){
window.location.href="train.do?method=deleteTrain&id="+date;
}
}
</script>


<body>
	<table width="100%" height="100%" border="0" cellpadding="0"
		cellspacing="0">
		<tr>
			<td align="center">



				<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>无标题文档</title>

</head>
<script language="JavaScript" src="js/validate.js"></script>
<script language="JavaScript" type="text/JavaScript">
</script>

<map name="Map">
	<area shape="rect" coords="187,28,256,79"
		href="">
	<area shape="rect" coords="278,27,347,86"
		href="">
	<area shape="rect" coords="367,24,435,101"
		href="">
	<area shape="rect" coords="461,29,525,92"
		href="list.do">
	<area shape="rect" coords="551,24,623,103" href="">
	<area shape="rect" coords="642,28,704,103"
		href="">

	<area shape="rect" coords="708,20,793,134"
		href="">

</map>




<body
	onLoad="MM_preloadImages('images/top-11.gif','images/top-22.gif','images/top-33.gif')">
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
							color="#666633">系统时间：</font></td>
						<td width="10">&nbsp;</td>
					</tr>
				</table>
			</td>
			<td width="88"><a href="manager_update.jsp"
				onClick="javascript:;"
				onMouseOver="MM_swapImage('Image1','','images/top-11.gif',1)"
				onMouseOut="MM_swapImgRestore()"><img src="images/top-1.gif"
					name="Image1" width="85" height="34" border="0" id="Image1"></a></td>
			<td width="88"><a href="mainPage.jsp" onClick="javascript:;"
				onMouseOver="MM_swapImage('Image2','','images/top-22.gif',1)"
				onMouseOut="MM_swapImgRestore()"><img src="images/top-2.gif"
					name="Image2" width="85" height="34" border="0" id="Image2"></a></td>
			<td width="93"><a href="javascript:quit()"
				onClick="javascript:;"
				onMouseOver="MM_swapImage('Image3','','images/top-33.gif',1)"
				onMouseOut="MM_swapImgRestore()"><img src="images/top-3.gif"
					name="Image3" width="85" height="34" border="0" id="Image3"></a></td>
		</tr>
	</table>



</body>
				</html>


				<table width="801" height="48" border="0" cellpadding="0"
					cellspacing="0" background="images/center1.jpg">
					<tr>
						<td valign="top">
							<table width="494">
								<tr>
									<td width="45" height="25">&nbsp;</td>
									<td width="437" valign="bottom"><font color="#66583D"><b>培训管理&nbsp;</b></font>&gt;
										<font color="#FF0000"> 培训查询</font></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
				<table width="801" height="436" border="0" cellpadding="0"
					cellspacing="0" background="images/center2.jpg">
					<tr>
						<td height="436" valign="top" align="center">

							<table width="650" border="1" cellpadding="1" cellspacing="1"
								bordercolor="#FFFFFF" bgcolor="66583D">
								<tr align="center">
									<th width="44" height="20"><span class="word_white">编号</span></th>
									<th width="44" height="20"><span class="word_white">培训人</span></th>
									<th width="103"><span class="word_white">培训主题</span></th>
									<th width="131"><span class="word_white">培训时间</span></th>
									<th width="111"><span class="word_white">培训地点</span></th>
									<th width="184"><span class="word_white">操作</span></th>
								</tr>

								<c:forEach items="${users}" var="u" varStatus="s">
									<tr align="center" bgcolor="#FFFFFF">
										<td height="20">${s.index+1}</td>
										<td>${u.tn_man }</td>
										<td>${u.tn_title }</td>
										<td>${u.tn_time }</td>
										<td>${u.tn_address }</td>
										<td><a href="detail.do?id=${u.id}">查看详细信息</a>&nbsp;&nbsp; <a
											href="del.do?id=${s.index+1}" onclick="return confirm('确定删除${u.tn_man}吗？');">删除</a></td>
									</tr>
								</c:forEach>
							</table>
							<table width="650">
								<tr>
									<td>
										<div align="right">
											<table width='370' border='0' cellspacing='0' cellpadding='0'>
												<tr>
													<td height='24' align='right'>
													<span><a href="left.do">上一页</a>
													</span><span>当前第${trainPage}页</span>
													<span><a href="right.do">下一页</a></span></td>
												</tr>
											</table>
										</div>
									</td>
								</tr>
							</table>



							<table width="650">
								<tr align="right">
									<td><a href="add.jsp">添加培训信息</a></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
				<table width="100" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td><img src="images/down.jpg" width="801" height="72"></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>
