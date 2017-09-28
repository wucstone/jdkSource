<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>wucstone-ssm-demo首页</title>
	<link rel="stylesheet" type="text/css" href="pages/resource/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="pages/resource/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="pages/resource/demo/demo.css">
	<script type="text/javascript" src="pages/resource/jquery.min.js"></script>
	<script type="text/javascript" src="pages/resource/jquery.easyui.min.js"></script>
</head>
<body class="easyui-layout">
	<div data-options="region:'north',border:false" style="height:60px;background:#B3DFDA;padding:10px">欢迎</div>
	<div data-options="region:'west',split:true,title:'我的菜单'" style="width:150px;padding:10px;">
	
		<div class="easyui-accordion" data-options="fit:true,border:false">
			<div title="用户管理" style="padding:10px;" data-options="selected:true">
				<a url="<%=path %>/user/userIndex.mvc onclick="addPanel(this)">用户管理</a>
			</div>
			<div title="菜单管理"  style="padding:10px;">
				content2
			</div>
			<div title="权限管理" style="padding:10px">
				content3
			</div>
		</div>
	
	</div>
<!-- 	<div data-options="region:'east',split:true,collapsed:true,title:'East'" style="width:100px;padding:10px;">east region</div> -->
	<div data-options="region:'south',border:false" style="height:50px;background:#A9FACD;padding:10px;">south region</div>
	<div data-options="region:'center'" >
			<div id="tt" class="easyui-tabs" data-options="tools:'#tab-tools'" ></div>
	</div>
</body>

<script>
	function addPanel(node){
		$('#tt').tabs('add',{
			title  : node.innerHTML ,
			content: '<div style="height:500px;"><iframe scrolling="yes" frameborder="0"  src="'+$(node).attr("url")+'" style="width:100%;height:100%;"></iframe></div>',
			closable:true
		});
	}
</script>
</html>