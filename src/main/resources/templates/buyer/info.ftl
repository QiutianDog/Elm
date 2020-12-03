<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="../../static/css/layui.css">
</head>
<body>
<div class="layui-container">

    <div class="layui-row" style="padding-top: 5%">
        <div style="font-size: 20px">用户名: &nbsp; ${user.getBuyerName()}</div>
    </div>
    <div class="layui-row" style="padding-top: 5%">
        <div style="font-size: 20px">手机号: &nbsp; ${user.getBuyerPhoneNumber()}</div>
    </div>
    <div class="layui-row" style="padding-top: 5%">
        <div style="font-size: 20px">微信号: &nbsp; ${user.getWechatId()}</div>
    </div>
    <div class="layui-row" style="padding-top: 5%">
        <div style="font-size: 20px">地址: &nbsp; ${user.getBuyerAddress()}</div>
    </div>
    <div class="layui-row" style="padding-top: 5%">
        <span style="font-size: 20px">余额: &nbsp; </span>
        <span style="font-size: 30px;color: #f54141">${user.getBuyerMoney()}</span>
    </div>
</div>
</body>
<#include "../common/end.ftl">
</html>