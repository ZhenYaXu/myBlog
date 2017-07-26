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

			<tr>
				<th colspan="3" bgcolor="00ff00"><b>Cron Trigger 1</b></th>
			</tr>
			<tr>
				<td nowrap>Trigger 名称：</td>
				<td><input type="text" id="triggerName" name="triggerName" size="20"></td>
				<td>（必填）</td>
			</tr>
			<tr>
				<td nowrap>Cron表达式：</td>
				<td><input type="text" id="cronExpression" name="cronExpression" size="20">
				</td>
				<td>（必填，Cron表达式(如"0/10 * * ? * *
					*"，每10秒中执行调试一次)，对使用者要求比较，要会写Cron表达式，实际项目中不适用）</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" onclick="save()" value="添加Trigger"></td>
				<td colspan="2"><input type="submit" onclick="showList()" value="返回"></td>
			</tr>
		</table>

	</form>
	<script>
		function validateAdd() {
			if ($.trim($('#triggerName').val()) == '') {
				alert('name不能为空！');
				$('#triggerName').focus();
				return false;
			}

			if ($.trim($('#cronExpression').val()) == '') {
				alert('cron表达式不能为空！');
				$('#cronExpression').focus();
				return false;
			}
			
			return true;
		}
		
		function save() {
			if (validateAdd()) {
				showWaitMsg();
				$.ajax({
					type : "POST",
					async : false,
					dataType : "JSON",
					cache : false,
					url : "${basePath}trigger/save",
					data : $("#addForm").serialize(), //对表单进行序列化
					success : function(data) {
						hideWaitMsg();
						if (data.flag) {
							alert("添加成功 !")
						} else {
							alert(data.msg);
						}
					} //end-callback
				}); //end-ajax
			}
		}
		
		function showList(){
			var url = "${basePath}trigger/showList";
			window.location.href = url;
		}
	
		function showWaitMsg(msg) {
			if (msg) {
	
			} else {
				msg = '正在处理，请稍候...';
			}
			var panelContainer = $("body");
			$("<div id='msg-background' class='datagrid-mask' style=\"display:block;z-index:10006;\"></div>").appendTo(panelContainer);
			var msgDiv = $("<div id='msg-board' class='datagrid-mask-msg' style=\"display:block;z-index:10007;left:50%\"></div>").html(msg).appendTo(
				panelContainer);
			msgDiv.css("marginLeft", -msgDiv.outerWidth() / 2);
		}
		function hideWaitMsg() {
			$('.datagrid-mask').remove();
			$('.datagrid-mask-msg').remove();
		}
	</script>
</body>
</html>




