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

    <form action="/buyer/info" method="post" style="padding-top: 5%">

        <span style="font-size: 20px"><label for="buyerMoney">充值</label></span>
        <span class="layui-input-inline">
            <input type="number" name="buyerMoney" id="buyerMoney" required  lay-verify="required" placeholder="充值金额" autocomplete="off" class="layui-input">
            <input type="hidden" name="buyerId" value="${user.getBuyerId()}">
        </span>

        <span class="layui-form-item">
            <button class="layui-btn" lay-submit lay-filter="formDemo">立即充值</button>
        </span>
    </form>
</div>
</body>
<#include "../common/end.ftl">
</html>