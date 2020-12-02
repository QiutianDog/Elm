<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="../../static/css/layui.css">
</head>
<body>
<form class="layui-form" action="/buyer/order?productId=${product.productId}" method="post">
    <table class="layui-table" lay-even lay-skin="nob">
        <thead>
        <tr>
            <th>商品名字</th>
            <th>图片</th>
            <th>描述</th>
            <th>单价</th>
            <th>下单数量</th>
        </tr>
        </thead>
        <tbody>

        <tr>
            <td>${product.productName}</td>
            <td><img width="100px" height="100px" src="${product.productIcon}" alt="${product.productName}"></td>
            <td>${product.productDescription}</td>
            <td>${product.productPrice}</td>
            <td>
                <div class="layui-form-item">
                    <div class="layui-input-inline">
                        <input type="number" name="productQuantity" required  lay-verify="required" autocomplete="off" class="layui-input" value="1">
                        <input type="hidden" name="productId" value="${product.getProductId()}">
                        <input type="hidden" name="buyerId" value="${buyerId}">
                    </div>
                </div>
            </td>
        </tr>

        </tbody>
    </table>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>

</form>

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