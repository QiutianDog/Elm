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
                <th>订单编号</th>
                <th>商品名称</th>
                <th>商品图片</th>
                <th>商品单价</th>
                <th>点单数量</th>
                <th>支付状态</th>
                <th>订单状态</th>
                <th>创建时间</th>
                <th>更新时间</th>
                <th colspan="2">操作</th>
            </tr>
            </thead>
            <tbody>
            <#list fromList as list>
            <tr>
                <td>${list.getOrderId()}</td>
                <td>${list.productName}</td>
                <td><img width="100px" height="100px" src="${list.productIcon}" alt="${list.productName}"></td>
                <td>${list.productPrice}</td>
                <td>${list.productQuantity}</td>
                <td>${list.getPayStatus()}</td>
                <td>${list.getOrderStatus()}</td>
                <td>${list.getCreateTime()}</td>
                <td>${list.getUpdateTime()}</td>
                <td><a href="/buyer/pay?orderId=${list.getOrderId()}" style="color: #01AAED">支付</a></td>
                <td><a href="/buyer/cancel?orderId=${list.getOrderId()}" style="color: #01AAED">取消</a></td>
            </tr>
            </#list>
            </tbody>
        </table>
    </div>
</div>
</body>
<#include "../common/end.ftl">
</html>