<%--
  Created by IntelliJ IDEA.
  User: a
  Date: 2017/11/21
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加商品</title>

</head>
<body>
<form action="addGood" method="post" >
    商品名字：<input name="good_name"/>
    商品价格：<input name="good_price"/>
    折扣价格：<input name="fav_price"/>
    折扣开始时间：<input name="fav_start"/>
    折扣结束时间：<input name="fav_end"/>
    商品剩余数量：<input name="good_surnum"/>
    商品状态：<input name="state"/>

    <button type="submit"/>
</form>
</body>
</html>
