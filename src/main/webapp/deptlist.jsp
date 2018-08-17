<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="entity.*,java.util.*,java.text.*,dao.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<style type="text/css">
#div {
	width: 801;
	height: 540px;
	background-image: url(images/center2.jpg);
}

.word_white {
	color: white;
	font-size: 9pt;
}

a {float：right;
	font-size: 9pt;
	text-decoration: none;
	color: #000000;
	noline: expression(this.onfocus = this.blur);
}

.tr {
	font-size: 12pt;
}

#table-bottom {
	border: rgba(130, 102, 68, 0.72);
}

</style>
</head>
<body>
	<div align="center">
		<%@ include file="header.jsp"%>
		<form action="">
			<table width="801" height="48" border="0" cellpadding="0"
				cellspacing="0" background="images/center1.jpg">
				<tr>
					<td valign="top">
						<table width="494">
							<tr>
								<td width="45" height="25">&nbsp;</td>
								<td width="437" valign="bottom"><font color="#66583D"><b>部门管理&nbsp;</b></font>&gt;
									<font color="#FF0000"> 部门查询</font></td>
							</tr>
						</table> <br>
						<div id="div" align="center">
							<table width="650" border="1" cellpadding="1" cellspacing="1"
								id="table">
								<tr align="center" bgcolor="66583D"">
									<td width="46" height="20"><span class="word_white">序号</span></td>
									<td width="109"><span class="word_white">部门名称</span></td>
									<td width="138"><span class="word_white">创建时间</span></td>
									<td width="138"><span class="word_white">部门人数</span></td>
									<td width="203"><span class="word_white">备注</span></td>
									<td width="88"><span class="word_white">操作</span></td>
								</tr>
							</table>
							<table width="650" border="1" cellpadding="0" cellspacing="0"
								id="table-bottom">
								<%
									deptDAO dao=new deptDAO();
									int page1=Integer.parseInt(session.getAttribute("currentPage").toString());
									List<Dept> depts=dao.findDeptLimit(page1);
									if(depts!=null){
										for(int i=0;i<depts.size();i++){
											Dept d=depts.get(i);
								%>
								<tr align="center" class="tr">
									<td width="50"><%=d.getId() %></td>
									<td width="105"><%=d.getDt_name() %></td>
									<td width="134"><%=d.getDt_createTime() %></td>
									<td width="138"><%=d.getCount() %></td>
									<td width="199"><%=d.getDt_bz() %></td>
									<td width="89">
										<a href="del.do?id=<%=d.getId()%>" 
										onclick="return confirm('确定删除<%=d.getDt_name() %>吗?');">删除</a>&nbsp;
									</td>
								</tr>
								<%
							}
								}
						%>
							</table>
							<table width="650px">
								<tr align="right" style="font-size: 9pt;">
									<td height='24' align='right'><span><a href="last.do">上一页</a>
									</span><span>当前第${currentPage}页</span> <span><a href="next.do">下一页</a></span></td>
								</tr>
							</table>
							<table width="650px">
								<tr align="right">
									<td><a href="deptadd.jsp">添加部门</a></td>
								</tr>
							</table>
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