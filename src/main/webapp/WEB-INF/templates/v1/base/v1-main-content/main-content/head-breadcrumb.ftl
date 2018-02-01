<div class="layui-row">
    <span class="layui-breadcrumb">
      <a href="/">首页</a>
      <a href="${breadTitle["breadUrl"]!}"><cite><@s.messageText code='${breadTitle["breadTitle"]!""}' text='${breadTitle["breadTitle"]!""}' /></cite></a>
    </span>
</div>
<hr>
<div class="layui-row">
    <div class="layui-btn-group">
        <button class="layui-btn layui-btn-small" onclick='${addButton["buttonUrl"]!""}'>
            <i class="layui-icon">&#xe654;</i><@s.messageText code='${addButton["buttonName"]!""}' text='${addButton["buttonName"]!""}' />
        </button>
        <button class="layui-btn layui-btn-small" onclick="search.show('${managerUrl}');">
            <i class="layui-icon">&#xe615;</i><@s.messageText code="search" text='search'/>
        </button>
        <button class="layui-btn layui-btn-small" onclick="javascript:;">
            <i class="layui-icon">&#xe735;</i><@s.messageText code="reset" text='reset'/>
        </button>
    </div>

</div>