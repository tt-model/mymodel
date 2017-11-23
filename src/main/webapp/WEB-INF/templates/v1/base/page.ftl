<div class="layui-table-tool">
    <div class="layui-inline layui-table-page" id="layui-table-page1">
        <div class="layui-box layui-laypage layui-laypage-default" id="layui-laypage-1">
            <span class="layui-laypage-skip">
                到第
                <input id="jump-value-input" type="text" min="1" value="" class="layui-input">页
                <button id="jump-button" type="button" class="layui-laypage-btn">确定</button>
            </span>
            <span class="layui-laypage-count">共 1 条</span>
            <span class="layui-laypage-limits">
                <select id="jump-value-pagesize-select" lay-ignore="">
                    <option selected="selected" value="{$ps}">1 条/页</option>
                </select>
            </span>
        </div>
    </div>
</div>