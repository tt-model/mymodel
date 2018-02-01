/**
 * 分页模块 前段业务js
 * Created by ttm on 2016/12/21.
 */
var page = {
    build : function(url) {
        page.build(url, null);
    },
    build : function(url, pageNumber) {
        //获取当前页
        if (pageNumber == null || pageNumber == "") {
            pageNumber = $('#pageNumber').val();
        }
        //获取每页显示行数
        var pageSize = $('#pageSize :checked').val();
        var paging = {};
        paging['pageNumber'] = pageNumber;
        paging['pageSize'] = pageSize;
        var index = dialog.load();
        $.ajax({
            type: 'post',
            url: url,
            data: paging,
            success: function( response ) {
                dialog.close(index);
                $("#headBody").html(response);
                //初始化一次数据
                layui.use('element', function(){
                    //更新表单元素
                    var form = layui.form;
                    form.render();
                    var laydate = layui.laydate;
                    var laydateForm = $('input[id$="-form"]');
                    if (laydateForm.length > 0) {
                        laydateForm.each(function() {
                            //执行一个laydate实例
                            var dateFormId = '#' + this.id;
                            laydate.render({
                                elem: dateFormId,
                                type: 'datetime'
                            });
                        });
                    }
                    var laydateTo = $('input[id$="-to"]');
                    if (laydateTo.length > 0) {
                        laydateTo.each(function() {
                            var dateToId = '#' + this.id;
                            laydate.render({
                                elem: dateToId,
                                type: 'datetime'
                            });
                        });
                    }
                });
            },
            error: function() {
                dialog.close(index);
                dialog.error('[DATA ERROR] page request fail!')
            }
        });
    }
}