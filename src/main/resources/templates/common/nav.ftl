<div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
<#--        左侧导航部分-->
        <ul class="layui-nav layui-nav-tree" lay-shrink="all" lay-filter="test">
            <li class="layui-nav-item"><a href="#">卖家管理系统</a></li>
            <li class="layui-nav-item layui-nav-itemed">
                <a href="javascript:;">商品</a>
                <dl class="layui-nav-child">
                    <dd><a href="/seller/product/list">列表</a></dd>
                    <dd><a href="/seller/product/index">新增</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item layui-nav-itemed">
                <a href="javascript:;">商品类目</a>
                <dl class="layui-nav-child">
                    <dd><a href="/seller/category/list">列表</a></dd>
                    <dd><a href="/seller/category/index">新增</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="#">登出</a></li>
        </ul>
    </div>
</div>