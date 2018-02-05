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
                //更新表单元素
                var form = layui.form;
                form.render();
                dateTime.init();
            },
            error: function() {
                dialog.close(index);
                dialog.error('[DATA ERROR] page request fail!')
            }
        });
    }
}