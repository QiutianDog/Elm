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
                <form class="layui-form" action="/seller/product/save" method="post" style="padding-top: 50px">

                    <#-- 隐藏输入框-->
                    <#if product??>
                        <input type="text" name="productId" style="display:none" value="${product.productId}">
                    <#else >
                        <input type="text" name="productId" style="display:none" >
                    </#if>

                    <div class="layui-form-item">
                        <label class="layui-form-label" for="productName">商品名称</label>
                        <div class="layui-input-inline">
                            <#if product??>
                                <input type="text" name="productName" required lay-verify="required"
                                       placeholder="请输入商品名称" autocomplete="off" class="layui-input"
                                       value="${product.productName}">
                            <#else >
                                <input type="text" name="productName" required lay-verify="required"
                                       placeholder="请输入商品名称" autocomplete="off" class="layui-input">
                            </#if>
                        </div>
                        <div class="layui-form-mid layui-word-aux">必填</div>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label" for="productPrice">商品单价</label>
                        <div class="layui-input-inline">
                            <#if product??>
                                <input type="number" step="0.01" name="productPrice" required lay-verify="required" placeholder="￥"
                                       autocomplete="off" class="layui-input" value="${product.productPrice}">
                            <#else >
                                <input type="number" step="0.01" name="productPrice" required lay-verify="required" placeholder="￥"
                                       autocomplete="off" class="layui-input">
                            </#if>
                        </div>
                        <div class="layui-form-mid layui-word-aux">必填</div>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label" for="productStock">商品库存</label>
                        <div class="layui-input-inline">
                            <#if product??>
                                <input type="number" name="productStock" required lay-verify="required"
                                       placeholder="库存数量" autocomplete="off" class="layui-input"
                                       value="${product.productStock}">
                            <#else >
                                <input type="number" name="productStock" required lay-verify="required"
                                       placeholder="库存数量" autocomplete="off" class="layui-input">
                            </#if>
                        </div>
                        <div class="layui-form-mid layui-word-aux">必填</div>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label" for="categoryType">商品类目</label>
                        <div class="layui-input-inline">
                            <select name="categoryType" lay-verify="required">
                                <#if product??>
                                    <option value="${product.categoryType}">${category.categoryName}</option>
                                <#else >
                                    <option value=""></option>
                                </#if>

                                <#list categoryList as category>
                                    <option value="${category.categoryType}">${category.categoryName}</option>
                                </#list>
                            </select>
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label" for="productStatus">状态</label>
                        <div class="layui-input-block">
                            <#if product??>
                                <#if product.productStatus == 0>
                                    <input type="checkbox" checked="" name="productStatus" lay-skin="switch"
                                           lay-filter="switchTest" lay-text="上架|下架">
                                <#else >
                                    <input type="checkbox" name="productStatus" lay-skin="switch"
                                           lay-filter="switchTest" lay-text="上架|下架">
                                </#if>
                            <#else >
                                <input type="checkbox" checked="" name="productStatus" lay-skin="switch"
                                       lay-filter="switchTest" lay-text="上架|下架">
                            </#if>
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label" for="img">商品图片</label>
                        <button type="button" class="layui-btn" name="img" id="update-img">
                            <i class="layui-icon">&#xe67c;</i>上传图片
                        </button>
                        <!-- 隐藏输入框 -->
                        <#if product??>
                            <input type="text" style="display:none" name="productIcon" id="hide-img-path"
                                   value="${product.productIcon}">
                        <#else >
                            <input type="text" style="display:none" name="productIcon" id="hide-img-path">
                        </#if>
                        <div class="layui-upload-list" style="padding-left: 110px">
                            <#if product??>
                                <img class="layui-upload-img" id="pre-img" style="width: 100px;height: 100px"
                                     src="${product.productIcon}" alt="${product.productName}">
                            <#else >
                                <img class="layui-upload-img" id="pre-img" style="width: 100px;height: 100px">
                            </#if>
                        </div>
                    </div>


                    <div class="layui-form-item layui-form-text">
                        <label class="layui-form-label" for="productDescription">商品描述</label>
                        <div class="layui-input-block" style="width: 20%">
                            <#if product??>
                                <textarea name="productDescription" placeholder="请输入内容" class="layui-textarea"
                                          id="Description">${product.productDescription}</textarea>
                            <#else >
                                <textarea name="productDescription" placeholder="请输入内容" class="layui-textarea"
                                          id="Description"></textarea>
                            </#if>
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

        </div>

    </div>
</div>
</body>

<#include "../../common/end.ftl">
<script>
    layui.use('upload', function () {
        var $ = layui.jquery;
        var upload = layui.upload;

        //普通图片上传
        var uploadInst = upload.render({
            elem: '#update-img'
            , url: '/seller/product/upload'
            , method: 'POST'
            , accept: 'images'
            , before: function (obj) {
                //预读本地文件示例，不支持ie8
                obj.preview(function (index, file, result) {
                    $('#pre-img').attr('src', result); //图片链接（base64）
                });
            }
            , done: function (res) {
                //如果上传失败
                if (res.code > 0) {
                    return layer.msg('上传失败');
                }
                //上传成功
                layer.msg('上传成功')
                $('#hide-img-path').val(res.src);

            }
            , error: function () {
                //演示失败状态，并实现重传
                var demoText = $('#demoText');
                demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
                demoText.find('.demo-reload').on('click', function () {
                    uploadInst.upload();
                });
            }
        });
    });
</script>
</html>