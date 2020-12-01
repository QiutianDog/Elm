<!DOCTYPE html>
<html lang="en">
<#include "../common/header.ftl">

<body>
<#include "../common/nav.ftl">
<div class="layui-body">
    <!-- 内容主体区域 -->
    <div style="padding: 15px;">

        <div class="layui-fluid">
            <div class="layui-row">
                <table class="layui-table" lay-even lay-skin="nob">
                    <thead>
                    <tr>
                        <th>类目编号</th>
                        <th>类目名称</th>
                        <th>类名类型</th>
                        <th>创建时间</th>
                        <th>更新时间</th>
                        <th colspan="2">操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list categoryList as category>
                        <tr>
                            <td>${category.categoryId}</td>
                            <td>${category.categoryName}</td>
                            <td>${category.categoryType}</td>
                            <td>${category.createTime}</td>
                            <td>${category.updateTime}</td>
                            <td><a href="/seller/category/del?categoryId=${category.categoryId}" style="color: #01AAED">删除</a></td>
                            <td><a href="/seller/category/index?categoryId=${category.categoryId}" style="color: #01AAED">修改</a></td>
                        </tr>
                    </#list>
                    </tbody>
                </table>
            </div>
        </div>

    </div>
</div>
</body>


<#include "../common/end.ftl">
</html>