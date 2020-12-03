<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>管理员登录</title>
    <link rel="stylesheet" href="../../static/css/layui.css">
</head>
<body>
<div style="font-size: 16px;padding: 15px">
    <a href="/">返回首页</a>
</div>
<div style="margin-top: 20%;margin-left: 38%">
    <form class="layui-form" action="/seller/login" method="post">
        <div class="layui-form-item">
            <label class="layui-form-label" for="adminName">用户名</label>
            <div class="layui-input-inline">
                <input type="text" name="adminName" id="adminName" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label" for="adminPassword">密码</label>
            <div class="layui-input-inline">
                <input type="password" name="adminPassword" id="adminPassword" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</div>


<script>
    //Demo
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