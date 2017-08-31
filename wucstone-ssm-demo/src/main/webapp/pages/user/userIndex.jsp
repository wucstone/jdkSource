<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>用户管理首页</title>
	<%@ include  file="../commonHead.jsp"%>
</head>
<body>
	<div class="easyui-panel" style="width:100%;padding:10px 20px">
		<div style="margin-bottom:10px">
			<label style="margin-left:20px">姓名:<input id="userName" class="easyui-textbox" style="width:100%;height:32px"></label>
			<label style="margin-left:40px">年龄:<input id="userAge" class="easyui-textbox" style="width:100%;height:32px"></label>
		</div>
		<div style="margin-bottom:20px">
			<label style="margin-left:20px">地址:<input id="userAddr" class="easyui-textbox" style="width:100%;height:32px"></label>
			<label style="margin-left:40px">
				<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" style="width:80px">查询</a>
			</label>
		</div>
	</div>
	<table id="dg"></table>

</body>

<script>
$(function(){
	$('#dg').datagrid({
	    url:'<%=basePath%>/user/getUserList.mvc',
	    method:'post',
	    pagination:true,
	    rownumbers:true,
	    singleSelect:true,
	    pageSize:10,
	    pageList:[10,20,30,40,50],
	    title:"用户列表",
	    dataType:"json",
	    queryParams :{
	    	userName:$("#userName").val(),
	    	userAge:$("#userAge").val(),
	    	userAddr:$("#userAddr").val()
	    },
	    columns:[[
	        {field:'userName',title:'姓名',width:100},
	        {field:'userAge',title:'年龄',width:100},
	        {field:'userAddr',title:'地址',width:100}
	    ]]
	});
	
});
</script>
</html>