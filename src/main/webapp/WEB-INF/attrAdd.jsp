<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@page isELIgnored="false"  %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <base href="<%=basePath %>">
    <script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript">
        function b(){}
    </script>
    <title>硅谷商城</title>
</head>
<body>
添加商品属性
<hr>
<form action="attr_add.do" method="post">
    <input type="text" value="${flbh2}" name="flbh2"/>
    <table border="1" width="800px">
        <tr><td>属性名：<input type="text" name="list_attr[0].shxmMch"/></td><td></td><td>添加属性值</td></tr>
        <tr><td>属性值：<input type="text" name="list_attr[0].listvalue[0].shxzh"/></td><td>单位：<input type="text" name="list_attr[0].listvalue[0].shxzhMch"/></td><td>删除</td></tr>
        <tr><td>属性值：<input type="text" name="list_attr[0].listvalue[1].shxzh"/></td><td>单位：<input type="text" name="list_attr[0].listvalue[1].shxzhMch"/></td><td>删除</td></tr>
    </table>

    <table border="1" width="800px">
        <tr><td>属性名：<input type="text"  name="list_attr[1].shxmMch"/></td><td></td><td>添加属性值</td></tr>
        <tr><td>属性值：<input type="text"  name="list_attr[1].listvalue[0].shxzh"/></td><td>单位：<input type="text" name="list_attr[1].listvalue[0].shxzhMch"/></td><td>删除</td></tr>
        <tr><td>属性值：<input type="text"  name="list_attr[1].listvalue[1].shxzh"/></td><td>单位：<input type="text" name="list_attr[1].listvalue[1].shxzhMch"/></td><td>删除</td></tr>
    </table>
    添加：<input type="submit" value="提交"/>
</form>
</body>
</html>