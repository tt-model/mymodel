<div class="layui-footer">
    <!-- 底部固定区域 -->
    © Bride.com - 底部固定区域
</div>
<script type="text/javascript" src="/static/plugin/layui/layui.all.js"></script>
<script type="text/javascript" src="/static/plugin/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="/static/js/page.js"></script>
<script type="text/javascript" src="/static/js/dialog.js"></script>
<script type="text/javascript" src="/static/js/search.js"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function(){
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
</script>