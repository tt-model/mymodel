<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <title>登录页面_TT Bride</title>
    <link rel="stylesheet" href="/static/css/login.css" />
    <link rel="stylesheet" href="/static/plugin/layui/css/modules/layer/default/layer.css" />
</head>
<body>
    <div id="main">
        <form action="/v1/admin/login" method="post" class="form">
            <div class="form-body">
                <p class="err-msg"></p>
                <div class="ui-input">
                    <input name="userName" class="abc" type="text" placeholder="账号">
                </div>
                <div class="ui-input">
                    <input name="password" type="password" placeholder="密码">
                </div>
                <p class="forget-password">
                    <a href="forget.html">忘记密码？</a>
                </p>
                <button onclick="login.post();" type="button" class="ui-button ui-button-primary">登录</button>
            </div>
        </form>
    </div>
    <script type="text/javascript" src="/static/plugin/jquery-2.1.4.min.js"></script>
    <script type="text/javascript" src="/static/plugin/layui/layui.all.js"></script>
    <script type="text/javascript" src="/static/plugin/layui/lay/modules/layer.js"></script>
    <script type="text/javascript" src="/static/js/dialog.js"></script>
    <script type="text/javascript" src="/static/js/login.js"></script>
</body>
</html>