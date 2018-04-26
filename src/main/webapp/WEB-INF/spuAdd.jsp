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
	$(function () {
		
    })

    function click_image(index){
//		console.log(index);
        $("#file_"+index).click();

    }

    function replace_image(index) {

        // 获得图片对象
        var blob_image = $("#file_"+index)[0].files[0];

        var url = window.URL.createObjectURL(blob_image);

        $("#image_"+index).attr("src",url);

        var length = $(":file").length;

        if((index+1)==length){
            // 用户选择的是最后一张图片
            add_image(index);
        }
    }

    function add_image(index){
        var a = '<div id ="d_'+(index+1)+'" style="float:left;margin-left:10px;border:1px #86ffdf solid;">';
		var l='<input type="radio" name="identity" onclick="chonseone('+(index+1)+')">';
        var b = '<input id="file_'+(index+1)+'" type="file" name="files" style="display:none;" onChange="replace_image('+(index+1)+')"/>'
        var c = '<img id="image_'+(index+1)+'" onclick="click_image('+(index+1)+')" style="cursor:pointer;" src="image/upload_hover.png" width="100px" height="100px"/>'
        var d = '</div>';
        $("#d_"+index).after(a+l+b+c+d);
    }
    function chonseone(index) {
        alert("设置该图片为主题")

		$("#indx_m").val(index);

        console.log(index);

    }


</script>
<title>硅谷商城</title>
</head>
<body>
	spu信息添加${spu.flbh1}|${spu.flbh2}|${spu.ppId}
	<hr>
	<form action="spu_add.do" enctype="multipart/form-data" method="post">
		商品名称：<input type="text" name="shpMch" /><br>
		商品描述：<textarea rows="10" cols="50" name="shpMsh"></textarea><br>
		商品颜色:<select name="color"><br>
		<option selected="selected">黑色</option>
		<option selected="selected">红的</option>
		<option selected="selected">蓝色</option>
	</select><br>
		商品版本:<select name="version">
		<option selected="selected">金属</option>
		<option >APEC功能塑料</option>
		<option >纤维</option>
	</select>
		商品图片：<br>
		<input type="hidden" name="flbh1" value="${spu.flbh1}" /><br>
		<input type="hidden" name="flbh2" value="${spu.flbh2}" /><br>
		<input type="hidden" name="ppId" value="${spu.ppId}" /><br>
		<input id="indx_m" type="hidden" name="index" value="" /><br>

		<div id ="d_0" style="float:left;margin-left:10px;border:1px #86ffdf solid;">
			<input type="radio" name="identity" onclick="chonseone(0)">
			<input id="file_0" type="file" name="files" onchange="replace_image(0)" style="width: 100px"/><br>
			<img id="image_0" src="image/upload_hover.png" onclick="click_image(0)" style="cursor: pointer" width="100px" height="100px">
		</div>
		<input type="submit" value="提交"/>
	</form>
</body>
</html>