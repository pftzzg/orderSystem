<!DOCTYPE html>
<title>商品列表</title>
<head>
    <meta content="text/html;charset=UTF-8" />
    <title></title>
</head>
<body style="align-content: center">
 <table>
     <tr><td>商品名称</td><td>商品SKU</td><td>IMA</td><td>购买</td></tr>
<#if (list?? && list?size>0)>
    <#list list as goods>
    <tr><td>${goods.goodsName}</td><td>${goods.sku}</td><td><img src="${goods.img}" width="30px"  height="30px"></td><td><a href="/goods/buy?id=${goods.id}" target="_self">购买</a> </td></tr>

 </#list>
</#if>
 </table>

</body>
</html>