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
					<th nowrap>下次执行时间</th>
					<th nowrap>上次执行时间</th>
					<th nowrap>优先级</th>
					<th nowrap>Trigger 状态</th>
					<th nowrap>Trigger 类型</th>
					<th nowrap>开始时间</th>
					<th nowrap>结束时间</th>
					<th nowrap>动作命令</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="trigger" items="${triggerList}">
					<tr>
						<td nowrap>${trigger.triggerName}</td>
						<td nowrap>${trigger.triggerGroup}</td>
						<td nowrap>${trigger.nextFireTime}</td>
						<td nowrap>${trigger.prevFireTime}</td>
						<td nowrap>${trigger.priority}</td>
						<td nowrap>${trigger.triggerState}</td>
						<td nowrap>${trigger.triggerType}</td>
						<td nowrap>${trigger.startTime}</td>
						<td nowrap>${trigger.endTime}</td>
						<td nowrap><input type="button" id="pause" value="暂停"
							onclick="doCmd('pause','${trigger.triggerName}','${trigger.triggerGroup}','${trigger.triggerState}')">
							<input type="button" id="resume" value="恢复"
							onclick="doCmd('resume','${trigger.triggerName}','${trigger.triggerGroup}','${trigger.triggerState}')">
							<input type="button" id="remove" value="删除"
							onclick="doCmd('remove','${trigger.triggerName}','${trigger.triggerGroup}','${trigger.triggerState}')">
						</td>
					</tr>
				</c:forEach>
					<tr>
						<td><button value="showSave" onclick="saveTrigger()">新增trigger</button></td>
					</tr>
			</tbody>
		</table>
	</form>
	
	<script>
			function doCmd(type,triggerName,group,triggerState){
			
			if(type == 'pause' && triggerState=='PAUSED'){
				alert("该Trigger己经暂停！");
				return;
			}
			
		    if(type == 'resume' && triggerState != 'PAUSED'){
				alert("该Trigger正在运行中！");
				return;
			}
			
			//客户端两次编码，服务端再解码，否测中文乱码 
/* 			triggerName = encodeURIComponent(encodeURIComponent(triggerName));
			group = encodeURIComponent(encodeURIComponent(group)); */
			
            $.ajax({
                url: "${basePath}trigger/doTriggerByType",
                type: "POST",
                data: {type:type,triggerName:triggerName,group:group,},
                dataType: "json",
                error: function(){
                   alert("执行失败！");		
                },
                success: function(data){
					if (data.flag) {
						alert("执行成功！");
						window.location.reload();
					}else{
						alert(data.msg);	
					}		   
                }
            });
		}
		
	
		function saveTrigger() {
			window.location.href = "${basePath}trigger/showSave";
		}
	
	</script>
</body>
</html>




