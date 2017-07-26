<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />


<%
	String path = request.getContextPath();
	String rootPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ "/";
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	request.setAttribute("basePath", basePath);
	request.setAttribute("rootPath", rootPath);
	pageContext.setAttribute("newLineChar", "\n");
%>
<script src="<%=basePath%>scripts/jquery-1.9.1.min.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<style type="text/css">
.datagrid-mask {
	background: #ccc;
}

.datagrid-mask-msg {
	border-color: #95B8E7;
}

.datagrid-mask-msg {
	background: #ffffff url('../images/loading.gif') no-repeat scroll 5px
		center;
}

.datagrid-mask {
	position: absolute;
	left: 0;
	top: 0;
	width: 100%;
	height: 100%;
	opacity: 0.3;
	filter: alpha(opacity = 30);
	display: none;
}

.datagrid-mask-msg {
	position: absolute;
	top: 50%;
	margin-top: -20px;
	padding: 12px 5px 10px 30px;
	width: auto;
	height: 16px;
	border-width: 2px;
	border-style: solid;
	display: none;
}

.list_table {
	border: 1px solid #CCCCCC;
	border-collapse: collapse;
	color: #333333;
	margin: 0 0 0;
	width: 100%;
}

.list_table tbody td {
	border-top: 1px solid #CCCCCC;
	text-align: left;
}

.list_table th {
	line-height: 1.2em;
	vertical-align: top;
}

.list_table td {
	line-height: 2em;
	font-size: 12px;
	vertical-align: central;
	align: left;
}

.list_table td input {
	width: 90%;
}

.list_table tbody tr:hover th, .list_table tbody tr:hover td {
	background: #EEF0F2;
}

.list_table thead tr {
	background: none repeat scroll 0 0 #09f;
	color: #fff;
	font-weight: bold;
	border-bottom: 1px solid #CCCCCC;
	border-right: 1px solid #CCCCCC;
}
</style>
</head>

<title>task</title>
<body class="bgray">
	<form id="addForm" method="post">

		<table class="list_table">
			<thead>
				<tr>
					<th nowrap>Trigger 名称</th>
					<th nowrap>Trigger 分组</th>
					<th nowrap>时间表达式</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="cronTrigger" items="${cronTriggerList}">
					<tr>
						<td nowrap>${cronTrigger.triggerName}</td>
						<td nowrap>${cronTrigger.triggerGroup}</td>
						<td nowrap>${cronTrigger.cronExpression}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</form>
	
	<script>
			
	</script>
</body>
</html>




