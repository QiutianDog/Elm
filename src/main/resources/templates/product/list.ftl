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
                            <th>商品编号</th>
                            <th>商品名字</th>
                            <th>图片</th>
                            <th>描述</th>
                            <th>单价</th>
                            <th>库存</th>
                            <th>状态</th>
                            <th>类目编号</th>
                            <th>创建时间</th>
                            <th>更新时间</th>
                            <th colspan="2">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list productList.getContent() as product>
                            <tr>
                                <td>${product.productId}</td>
                                <td>${product.productName}</td>
                                <td><img width="100px" height="100px" src="${product.productIcon}" alt="方便面"></td>
                                <td>${product.productDescription}</td>
                                <td>${product.productPrice}</td>
                                <td>${product.productStock}</td>
                                <td>${product.productStatus}</td>
                                <td>${product.categoryType}</td>
                                <td>${product.createTime}</td>
                                <td>${product.updateTime}</td>
                                <td><a href="/seller/product/del?productId=${product.productId}" style="color: #01AAED">删除</a></td>
                                <td><a href="/seller/product/index?productId=${product.productId}" style="color: #01AAED">修改</a></td>
                            </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>
                <div class="layui-row">
                    <div id="page" align="right"></div>
                </div>
            </div>

        </div>
    </div>
</body>
<#include "../common/end.ftl">
<script>
    layui.use('laypage', function(){
        var laypage = layui.laypage;
        laypage.render({
            elem: 'page'
            , count: ${productList.getTotalPages()}
            , limit: ${pageSize}
            , jump: function(obj, first){
                //首次不执行
                if(!first){
                    //do something
                }
            }
            , layout: ['prev', 'page', 'next', 'count', 'limit', 'skip']
        });
    });
</script>
</html>

