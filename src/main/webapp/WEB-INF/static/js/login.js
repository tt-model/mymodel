/**
 * 登录模块 前段业务js
 * Created by ttm on 2016/12/21.
 */
var login = {
    post : function () {
        //获取页面用户名和密码
        var userNameInput = $('input[name="userName"]');
        var passwordInput = $('input[name="password"]');
        var userName = userNameInput.val();
        var password = passwordInput.val();
        var params = {};
        if (login.empty(userName)) {
            return dialog.error('用户名不能为空!')
        }
        if (login.empty(password)) {
            return dialog.error('密码不能为空!');
        }
        params['name'] = userName;
        params['password'] = password;
        //console.info('data show : ' + JSON.stringify(params));
        $.ajax({
            type: 'post',
            url: '/v1/admin/login',
            data: params,
            dataType: 'json',
            success: function ( response ) {
                if (response.code == 0) {
                    return dialog.error( response.msg );
                }
                if (response.code == 200) {
                    return dialog.success( response.msg, '/v1/admin/index' );
                }
            },
            error: function () {
                dialog.error('请求失败')
            }
        });
    },
    /**
     * 判断数据是否为空
     * @param text
     */
    empty : function(text) {
        return text == null || text.trim() == "";
    }
}

