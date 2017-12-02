<!DOCTYPE html>
<html>
<head>
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
                <input type="text" name="name" />
            </td>
            <td>
                <select>
                    <option value="0">关闭</option>
                    <option value="1">开启</option>
                </select>
            </td>
            <td>
                从<input type="text" name="date[from]" />
                到<input type="text" name="date[to]" />
            </td>
            <td>
                <input type="button" value="搜索" />
            </td>
        </tr>
    </table>
</body>
</html>