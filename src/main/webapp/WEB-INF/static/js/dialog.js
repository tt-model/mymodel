/**
 * 弹出层封装
 * Created by ttm on 2017/11/3.
 */
var dialog = {
    // 错误弹出层
    error: function ( message ) {
        layer.open({
            content : message,
            icon : 2,
            title : '错误提示'
        });
    },

    // 成功弹出层
    success : function ( message, url ) {
        layer.open({
            content : message,
            icon : 1,
            yes : function () {
                location.href = url;
            }
        });
    },

    /**
     * 提示弹出层
     * @param message     提示内容
     * @param title       提示标题
     * @param id          id获取
     * @param requestUrl  请求url
     */
    confirm : function( message, title, url ) {
        layer.confirm( message, {icon : 3, title : title } ,function( index ) {
            location.href = url;
            //go to
            layer.close( index );
        })
    }
}

