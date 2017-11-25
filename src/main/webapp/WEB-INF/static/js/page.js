/**
 * 分页模块 前段业务js
 * Created by ttm on 2016/12/21.
 */
var page = {
    build : function(url) {
        //获取当前页
        var pageNumber = $('#pageNumber').val();
        //获取每页显示行数
        var pageSize = $('#pageSize :checked').val();
        var paging = {};
        paging['pageNumber'] = pageNumber;
        paging['pageSize'] = pageSize;
        $.ajax({
            type: 'post',
            url: url,
            data: 'paging=' + paging,
            dataType: 'json',
            success: function( response ) {
                //TODO 成功结果还没有进行编写
            },
            error: function() {
                dialog.error('[DATA ERROR] page request fail!')
            }
        });
    }
}