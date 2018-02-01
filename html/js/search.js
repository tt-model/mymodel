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
					postData[name] = value;
				}
            });

        });
        console.info('show : ' + JSON.stringify(postData));
       
    }
}
