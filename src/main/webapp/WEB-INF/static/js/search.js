/**
 * 管理页面搜索功能
 * Created by ttm on 2017/12/2.
 */
var search = {
    show : function(url) {
        //1.获取页面对应的数据
        //2.组装数据
        //3.请求后台
        var postData = {};
        var searchEntity = $('*[data-search="true"]');
        searchEntity.each(function (index) {
            var formEntity = $(this);
            //根据类型获取
            var nodeName = this.nodeName;
            if (nodeName == "INPUT") {
                var name = this.name;
                var value = $(this).val();
                if (!(value == "" || value.trim() == "")) {
                    postData[name] = value;
                }
            }
            //select
            if (nodeName == 'SELECT') {
                var name = this.name;
                var value = $(this).val();
                if (!(value == "" || value.trim() == "")) {
                    postData[name] = value;
                }
            }
        });
        console.info('show : ' + JSON.stringify(postData));
        $.ajax({
            type: 'post',
            url: url,
            data: postData,
            success: function( response ) {
                //TODO
            },
            error: function() {
                dialog.error('ERROR : search fail')
            }
        });
    }
}
