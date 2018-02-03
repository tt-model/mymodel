/**
 * 时间工具
 * @type {{}}
 */
var dateTime = {
    /**
     * 初始化
     */
    init : function () {
        var laydate = layui.laydate;
        var laydateForm = $('input[id$="-form"]');
        if (laydateForm.length > 0) {
            laydateForm.each(function() {
                //执行一个laydate实例
                var dateFormId = '#' + this.id;
                laydate.render({
                    elem: document.getElementById(this.id),
                    type: 'datetime'
                });
            });
        }
        var laydateTo = $('input[id$="-to"]');
        if (laydateTo.length > 0) {
            laydateTo.each(function() {
                var dateToId = '#' + this.id;
                laydate.render({
                    elem: document.getElementById(this.id),
                    type: 'datetime'
                });
            });
        }
    }
}