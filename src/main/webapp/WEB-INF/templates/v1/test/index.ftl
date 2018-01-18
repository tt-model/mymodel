<!DOCTYPE html>
<html>
<head>
    <script src="/static/plugin/jquery-2.1.4.min.js" type="text/javascript"></script>
    <script src="/static/js/dialog.js" type="text/javascript"></script>
    <script src="/static/js/search.js?time()" type="text/javascript"></script>
</head>
<body class="layui-layout-body">
    <table>
        <tr>
            <td>名称</td>
            <td>状态</td>
            <td>时间</td>
            <td>操作</td>
        </tr>
        <tr id="search-from">
            <td>
                <input data-search="true" type="text" name="name" />
            </td>
            <td>
                <select name="status" data-search="true">
                    <option value="0">关闭</option>
                    <option value="1">开启</option>
                </select>
            </td>
            <td>
                从<input name="date[from]" data-search="true" type="text" />
                到<input name="date[to]" data-search="true" type="text" />
            </td>
            <td>
                <input type="button" value="搜索" onclick="search.show()" />
            </td>
        </tr>
    </table>
</body>
</html>