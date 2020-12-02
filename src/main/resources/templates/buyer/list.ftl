<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="../../static/css/layui.css">
</head>
<body>
<div class="layui-fluid">
    <div class="layui-row">
        <table class="layui-table" lay-even lay-skin="nob">
            <thead>
            <tr>
                <th>商品名字</th>
                <th>图片</th>
                <th>描述</th>
                <th>单价</th>
                <th>库存</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <#list productList as product>
            <tr>
                <td>${product.productName}</td>
                <td><img width="100px" height="100px" src="${product.productIcon}" alt="${product.productName}"></td>
                <td>${product.productDescription}</td>
                <td>${product.productPrice}</td>
                <td>${product.productStock}</td>
                <td><a href="/buyer/order?productId=${product.productId}&buyerId=${buyerId}" style="color: #01AAED">下单</a></td>
            </tr>
            </#list>
            </tbody>
        </table>
    </div>
</div>
</body>
<#include "../common/end.ftl">
</html>