<div class="layui-form layui-border-box layui-table-view">
    <div class="layui-table-body layui-table-main">
        <table cellspacing="0" cellpadding="0" border="0" class="layui-table">
            <colgroup>
                <#list widthTitle as width>
                    <col width="${width!''}">
                </#list>
            </colgroup>
            <thead>
                <tr>
                <#list headerTitle as head>
                    <th>
                        <div class="layui-table-cell"><@s.messageText code="${head['title']}" text="${head['title']}"/></div>
                    </th>
                </#list>
                </tr>
            </thead>
            <tbody>
                <#list colletion as row>
                <tr>
                    <#list headerTitle as head>
                        <#assign name = head.name/>
                        <#if name != "action">
                            <td><div class="layui-table-cell">${row[name]!''}</div></td>
                        <#else>
                            <td>
                                <div class="layui-btn-group layui-table-cell">
                                    <button class="layui-btn layui-btn-small"><i class="layui-icon">&#xe642;</i>编辑</button>
                                    <button class="layui-btn layui-btn-danger layui-btn-small"><i class="layui-icon">&#xe640;</i>删除</button>
                                </div>
                            </td>
                        </#if>
                    </#list>
                </tr>
                </#list>
            </tbody>
        </table>
    </div>
    <div class="layui-table-tool">
        <div class="layui-inline layui-table-page" id="layui-table-page1">
            <div class="layui-box layui-laypage layui-laypage-default" id="layui-laypage-1">
                <a href="javascript:;" class="layui-laypage-prev layui-disabled" data-page="0"><i class="layui-icon">&#xe603;</i></a>
                <span class="layui-laypage-curr">
                    <em class="layui-laypage-em"></em>
                    <em>1</em>
                </span>
                <a href="javascript:;" data-page="2">2</a>
                <a href="javascript:;" data-page="3">3</a>
                <a href="javascript:;" class="layui-laypage-next" data-page="2">
                    <i class="layui-icon">&#xe602;</i>
                </a>
                <span class="layui-laypage-count">共 1000 条</span>
                <span class="layui-laypage-limits">
                    <select id="pageSize" lay-ignore="">
                        <option value="10">10 条/页</option>
                        <option value="20">20 条/页</option>
                        <option value="30">30 条/页</option>
                        <option value="40">40 条/页</option>
                        <option value="50">50 条/页</option>
                        <option value="60">60 条/页</option>
                        <option value="70">70 条/页</option>
                        <option value="80">80 条/页</option>
                        <option value="90">90 条/页</option>
                    </select>
                </span>
                <span class="layui-laypage-skip">
                    到第<input id="pageNumber" type="text" min="1" value="1" class="layui-input">页
                    <button type="button" class="layui-laypage-btn" onclick="page.build('/v1/user/userManager')">确定</button>
                </span>
            </div>
        </div>
    </div>
</div>