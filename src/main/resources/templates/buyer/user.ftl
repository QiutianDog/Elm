<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户菜单</title>
    <link rel="stylesheet" href="/static/css/layui.css">
</head>
<body>
    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <#--        左侧导航部分-->
            <ul class="layui-nav layui-nav-tree" lay-shrink="all" lay-filter="test">
                <li class="layui-nav-item"><a href="#">欢迎您 &nbsp; ${buyer.getBuyerName()}</a></li>
                <li class="layui-nav-item"><a target="iframeMain" href="/buyer/info?buyerId=${buyer.getBuyerId()}">个人中心</a></li>
                <li class="layui-nav-item layui-nav-itemed">
                    <a href="javascript:;">点餐</a>
                    <dl class="layui-nav-child">
                        <dd><a href="/buyer/list?buyerId=${buyer.getBuyerId()}" target="iframeMain">商品列表</a></dd>
                        <dd><a href="/buyer/detail" target="iframeMain">我的订单</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item"><a href="/buyer/login">登出</a></li>
            </ul>
        </div>
    </div>
    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 0px;">
            <div class="layui-row">
                <iframe src="/buyer/info?buyerId=${buyer.getBuyerId()}" frameborder="0" height="1080px" width="100%" class="layui-layedit-iframe" scrolling="auto" name="iframeMain">

                </iframe>
            </div>
        </div>
    </div>
</body>
<#include "../common/end.ftl">
</body>
</html>