<!DOCTYPE html>
<html lang="en">
<#include "../../common/header.ftl">
<body>
<#include "../../common/nav.ftl">
<div class="layui-body">
    <!-- 内容主体区域 -->
    <div style="padding: 15px;">

        <div class="layui-fluid">
            <div class="layui-row">
                <table class="layui-table" lay-even lay-skin="nob">
                    <thead>
                    <tr>
                        <th>订单编号</th>
                        <th>买家姓名</th>
                        <th>买家手机号</th>
                        <th>买家地址</th>
                        <th>买家微信</th>
                        <th>总金额</th>
                        <th>订单状态</th>
                        <th>支付状态</th>
                        <th>创建时间</th>
                        <th>更新时间</th>
                        <th colspan="2">操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list masterList as master>
                        <tr>
                            <td>${master.getOrderId()}</td>
                            <td>${master.getBuyerName()}</td>
                            <td>${master.getBuyerPhone()}</td>
                            <td>${master.getBuyerAddress()}</td>
                            <td>${master.getBuyerOpenid()}</td>
                            <td>${master.getOrderAmount()}</td>

                            <#if master.getOrderStatus() == 0>
                                <td style="color: green">新订单</td>
                            <#elseif master.getOrderStatus() == 1>
                                <td style="color: gray">完结</td>
                            <#elseif master.getOrderStatus() == 2>
                                <td style="color: red">已取消</td>
                            </#if>

                            <#if master.getPayStatus() == 0>
                                <td style="color: red">等待支付</td>
                            <#elseif master.getPayStatus() == 1>
                                <td style="color: green">支付成功</td>
                            </#if>

                            <td>${master.getCreateTime()}</td>
                            <td>${master.getUpdateTime()}</td>
                            <td><a href="/seller/master/done?orderId=${master.getOrderId()}" style="color: #01AAED">完结</a></td>
                            <td><a href="/seller/master/del?orderId=${master.getOrderId()}" style="color: #01AAED">删除</a></td>
                        </tr>
                    </#list>
                    </tbody>
                </table>
            </div>
        </div>

    </div>
</div>
</body>
<#include "../../common/end.ftl">
</html>