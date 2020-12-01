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
                <form class="layui-form" action="/seller/category/save" method="post" style="padding-top: 50px">

                    <div class="layui-form-item">
                        <label class="layui-form-label" for="categoryName">类目名称</label>
                        <div class="layui-input-inline">
                            <#if category??>
                                <input type="text" name="categoryName" required lay-verify="required"
                                       placeholder="请输入类目名称" autocomplete="off" class="layui-input"
                                       value="${category.categoryName}">
                            <#else >
                                <input type="text" name="categoryName" required lay-verify="required"
                                       placeholder="请输入类目名称" autocomplete="off" class="layui-input">
                            </#if>
                        </div>
                        <div class="layui-form-mid layui-word-aux">必填</div>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label" for="categoryType">类目类型</label>
                        <div class="layui-input-inline">
                            <#if category??>
                                <input type="number" name="categoryType" required lay-verify="required"
                                       placeholder="请输入类目类型" autocomplete="off" class="layui-input"
                                       value="${category.categoryType}">
                            <#else >
                                <input type="number" name="categoryType" required lay-verify="required"
                                       placeholder="请输入类目类型" autocomplete="off" class="layui-input">
                            </#if>
                        </div>
                        <div class="layui-form-mid layui-word-aux">必填</div>
                    </div>

                    <div class="layui-form-item">
                        <div class="layui-input-block">
                            <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
                            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                        </div>
                    </div>

                </form>
            </div>

        </div>

    </div>
</div>
</body>

<#include "../common/end.ftl">
</html>