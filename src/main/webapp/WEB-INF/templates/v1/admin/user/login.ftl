<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <title>登录页面_TT Bride</title>
    <link rel="stylesheet" href="/static/css/ttbride_login.css">
</head>
<body>
<div id="main">
    <form action="/v1/admin/login" class="form">
        <div class="form-head">
            <h2>登录</h2>
            <p>还没有账号？<a href="register.html">立即注册</a></p>
        </div>
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
            <button type="submit" class="ui-button ui-button--primary">登录</button>
        </div>
    </form>
</div>
</body>
</html>