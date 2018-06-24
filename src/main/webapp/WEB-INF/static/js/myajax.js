/**
 * 异步请求
 * @type {{}}
 */
var myajax = {
    ajax : function (url, data) {
        $.ajax({
            url: url,
            type: "POST",
            data: data,
            success: function(response) {
                console.log("show response: " + response)
                if (null != response) {
                    var responseEntity = JSON.parse(response);
                    if (responseEntity.code == 200) {
                        return dialog.success( responseEntity.msg, '/v1/user/userManager' );
                    } else {
                        return dialog.error( responseEntity.msg );
                    }
                } else {
                    return dialog.error( 'Fetch response is null!' );
                }
            },
            error: function() {
                console.log("show error");
            }
        });
    },
    ajaxSave: function (url) {
        var params = {};
        var userId = $('input[name="userId"]').eq(0).val();
        var userName = $('input[name="userName"]').eq(0).val();
        var userPassword = $('input[name="password"]').eq(0).val();
        var userEmail = $('input[name="email"]').eq(0).val();
        var userMobile = $('input[name="mobile"]').eq(0).val();
        var selectOption = $('select[name="deptId"]').eq(0).find('option:selected');
        var value = selectOption.val();
        if (null != userId && userId != "") {
            params['userId'] = userId;
        }
        params['userName'] = userName;
        params['password'] = userPassword;
        params['email'] = userEmail;
        params['mobile'] = userMobile;
        params['deptId'] = value;
        console.log("show user: " + JSON.stringify(params));
        myajax.ajax(url, params);
    },
    ajaxDelete: function (url, id) {
        layer.confirm( 'Are you sure?', {icon : 3, title : 'delete id:' + id } ,function( index ) {
            myajax.ajax(url, null);
            layer.close( index );
        });
    }
}