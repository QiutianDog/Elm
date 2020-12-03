<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>买家注册</title>
    <link rel="stylesheet" href="/static/css/layui.css">
</head>
<body>
<div style="font-size: 16px;padding: 15px">
    <a href="/buyer/">上一步</a>
</div>
<div class="layui-row" style="padding-left: 35%;padding-top: 10%">
    <form class="layui-form" action="/buyer/register" method="post">

        <div class="layui-form-item">
            <label class="layui-form-label" for="buyer-name">用户名</label>
            <div class="layui-input-inline">
                <input type="text" name="buyer-name" id="buyer-name" required  lay-verify="required" placeholder="请输入用户名" autocomplete="off" class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux">必填</div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label" for="buyer_password">密码框</label>
            <div class="layui-input-inline">
                <input type="password" name="buyer-password" id="buyer_password" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux">必填</div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label" for="buyer-phone">手机号</label>
            <div class="layui-input-inline">
                <input type="text" name="buyer-phone" maxlength="11" id="buyer-phone" required lay-verify="required" placeholder="请输入手机号" autocomplete="off" class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux">必填</div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label" for="wechat">微信号</label>
            <div class="layui-input-inline">
                <input type="text" name="wechat" id="wechat" required  lay-verify="required" placeholder="请输入微信号" autocomplete="off" class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux">必填</div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label" for="buyerAddress">地址</label>
            <div class="layui-input-inline">
                <input type="text" name="buyerAddress" id="buyerAddress" required  lay-verify="required" placeholder="请输入微信号" autocomplete="off" class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux">必填</div>
        </div>

        <input type="hidden" name="buyer-money" value="100">

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</div>



<script>
    layui.use('form', function(){
        var form = layui.form;

        //监听提交
        form.on('submit(formDemo)', function(data){
            layer.msg(JSON.stringify(data.field));
            return false;
        });
    });
</script>
</body>
<#include "../common/end.ftl">
</html>