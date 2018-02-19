/**
 * 管理页面搜索功能
 * Created by ttm on 2017/12/2.
 */
var search = {
    show : function(url) {
        //1.获取页面对应的数据
        //2.组装数据
        //3.请求后台
        // var postData = {};
        // var searchEntity = $('#model-search');
        // searchEntity.each(function () {
        //     //获取input
        //     var formByInput = $(this).find('.layui-filter');
        //     formByInput.each(function() {
        //         var nodeName = this.nodeName;
        //         if ('INPUT' === nodeName) {
        //             var name = this.name;
        //             var value = $(this).val();
        //             if (!(value == "" || value.trim() == "")) {
        //                 postData[name] = value;
        //             }
        //         } else if ('SELECT' === nodeName) {
        //             var name = this.name;
        //             var selectOption = $(this).find('option:selected');
        //             var value = selectOption.val();
        //             if (!(value == "" || value.trim() == "")) {
        //                 postData[name] = value;
        //             }
        //         }
        //     });
        //
        // });
        // console.info('show : ' + JSON.stringify(postData));
        var postData = search.showParams();
        var paging = page.pageParams(null);
        postData['pageNumber'] = paging['pageNumber'];
        postData['pageSize'] = paging['pageSize'];
        console.info('show : ' + JSON.stringify(postData));
        var index = dialog.load();
        $.ajax({
            type: 'post',
            url: url,
            data: postData,
            success: function( response ) {
                dialog.close(index);
                //TODO
                $('#headBody').html(response);
                //更新表单元素
                var form = layui.form;
                form.render();
                dateTime.init();
            },
            error: function() {
                dialog.close(index);
                dialog.error('ERROR : search fail')
            }
        });
    },
    /**
     * 获取查询数据
     * @param url
     * @returns {{}}
     */
    showParams : function () {
        var postData = {};
        var searchEntity = $('#model-search');
        searchEntity.each(function () {
            //获取input
            var formByInput = $(this).find('.layui-filter');
            formByInput.each(function() {
                var nodeName = this.nodeName;
                if ('INPUT' === nodeName) {
                    var name = this.name;
                    var value = $(this).val();
                    if (!(value == "" || value.trim() == "")) {
                        postData[name] = value;
                    }
                } else if ('SELECT' === nodeName) {
                    var name = this.name;
                    var selectOption = $(this).find('option:selected');
                    var value = selectOption.val();
                    if (!(value == "" || value.trim() == "")) {
                        postData[name] = value;
                    }
                }
            });

        });
        console.info('show : ' + JSON.stringify(postData));
        return postData;
    }
}
