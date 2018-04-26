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
        $(function(){
            var flbh1="${flbh1}";
            console.log(flbh1)
            $.getJSON("js/json/tm_class_1_" + flbh1 + ".js", function (data) {
                $("#sku_class_2_select").empty();
                $(data).each(function (i, json) {

                    $("#sku_class_2_select").append("<option value=" + json.id + ">" + json.ppmch + "</option>");
                });
            });
        });
        function get_spu_list(pp_id){
            var flbh2 = "${flbh2}";
            $("#spu_list").empty();
            $.ajax({
                type: "POST",
                url: "get_spu_list.do",
                data: {ppid:pp_id,flbh2:flbh2},
                success: function(data){
                    console.log(data)
                    $.each(data,function(idx,obj){
                        console.log(obj);
                        console.log(idx);
                        $("#spu_list").append("<option value="+obj.id+">"+obj.shpMch+"</option>");
                    });
                }
            });


           /* $.post("get_spu_list.html",{ppid:pp_id,flbh2:flbh2},function(data){
                $("#spu_list").empty();q
                console.log(data);
                var json=data;
                $.each(json,function(idx,obj){
                    console.log(idx+obj);
                    /!*$("#spu_list").append("<option value="+json.id+">"+json.shpMch+"</option>");*!/
                });
            });*/

        }

        function show_val(attr_id,checked){

            if(checked){
                $("#val_"+attr_id).show();
            }else{
                $("#val_"+attr_id).hide();
            }

        }
        function shaow_val(attr_id) {

            $("#val_"+attr_id).toggle();
        }


    </script>
    <title>硅谷商城</title>
</head>
<body>
   <form action="inserSku.do" method="post">
       <input type="hidden" value="${flbh1}" name="flbh1"/>
       <input type="hidden" value="${flbh2}" name="flbh2"/>
       品牌:<select id="sku_class_2_select" onchange="get_spu_list(this.value)"></select>
       商品:<select  id="spu_list" name="id"></select>
       <hr>
       分类属性:<br>
        <c:forEach items="${mallAttrVOS}" var="attr" varStatus="status">
            <input value="${attr.id}" name="listattrvalue[${status.index}].shxmId"  type="checkbox" onclick="shaow_val(${attr.id})">${attr.shxmMch}
        </c:forEach>
       <c:forEach items="${mallAttrVOS}" var="attr" varStatus="status">
           <div id="val_${attr.id}" style="display: none">
               <c:forEach items="${attr.listvalue}" var="val">
                     <input  value="${val.id}" name="listattrvalue[${status.index}].shxzhId"  type="radio"/>${val.shxzh}${val.shxzhMch}
               </c:forEach>
           </div>
       </c:forEach><br>
       商品库存名称:<input type="text" name="skuMch"><br>
       商品库存数量:<input type="text" name="kc"><br>
       商品库存价格:<input type="text" name="jg"><br>
       商品库存地址:<input type="text" name="kcdz"><br>
       <input type="submit" value="提交">
   </form>
</body>
</html>