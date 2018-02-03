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
                <th class="layui-col-bottom">
                    <div class="layui-table-cell">
                        <b><@s.messageText code="${head['title']}" text="${head['title']}"/></b>
                    </div>
                </th>
            </#list>
            </tr>
            <#-- 搜索 -->
            <tr id="model-search">
            <#list search as searchRow>
                <#--搜索字段名称-->
                <#assign searchName=searchRow.name/>
                <#--搜索字段类型-->
                <#assign searchType=searchRow.type/>
                <#assign searchFilter="layui-filter"/>
                <th class="layui-col-top">
                    <#--- 文本 --->
                    <#if searchType=='text'>
                        <div class="layui-row layui-date-row">
                            <input type="text" name="${searchName}" class="layui-input ${searchFilter}">
                        </div>
                    </#if>
                    <#if searchType='select'>
                        <div class="layui-row layui-date-row">
                            <#assign searchOptionValue=searchRow["option"] />
                            <@s.formSingleSelect searchName searchName searchOptionValue 0 'lay-search class="${searchFilter}"' />
                        </div>
                    </#if>
                    <#if searchType='datetime'>
                        <div class="layui-row layui-date-row">
                            <div class="layui-col-md2"><label class="layui-date-label">从</label></div>
                            <div class="layui-col-md10">
                                <input id="${searchName}-form" type="text" name="${searchName}[form]" class="layui-input ${searchFilter}">
                            </div>
                        </div>
                        <div class="layui-row layui-date-row">
                            <div class="layui-col-md2"><label class="layui-date-label">到</label></div>
                            <div class="layui-col-md10">
                                <input id="${searchName}-to" type="text" name="${searchName}[to]" class="layui-input ${searchFilter}">
                            </div>
                        </div>
                    </#if>
                </th>
            </#list>
            </tr>
        </thead>
        <tbody>
            <#list collection as row>
            <tr>
                <#list headerTitle as head>
                    <#assign name = head.name/>
                    <#if name != "action">
                        <#assign rowNum=''/>
                        <#list search as searchRow>
                            <#assign searchTypeValue=searchRow.type />
                            <#if head_index==searchRow_index>
                                <#assign rowNum=row[name] />
                                <#if searchTypeValue=="select">
                                    <#assign searchOptionValue=searchRow.option />
                                    <#if searchOptionValue[rowNum?string]??>
                                        <#assign rowNum=searchOptionValue[rowNum?string]/>
                                    </#if>
                                </#if>
                                <#break />
                            </#if>
                        </#list>
                        <td>
                            <div class="layui-table-cell">
                                ${rowNum}
                            </div>
                        </td>
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
            <#assign pageNumber = paging.pageNumber!'' />
            <#if paging.upRow?string("true", "false") == "true">
                <a href="javascript:page.build('${managerUrl!''}', ${paging.upNumber!''});;" class="layui-laypage-prev" data-page="${paging.upNumber!''}">
                    <i class="layui-icon">&#xe603;</i>
                </a>
            <#else>
                <a href="javascript:;" class="layui-laypage-prev layui-disabled" data-page="${paging.upNumber!''}">
                    <i class="layui-icon">&#xe603;</i>
                </a>
            </#if>
            <#list paging.linkPages as linkPage>
                <#if linkPage==pageNumber>
                    <span class="layui-laypage-curr">
                        <em class="layui-laypage-em"></em>
                        <em>${linkPage}</em>
                    </span>
                <#else>
                    <a href="javascript:page.build('${managerUrl!''}', ${linkPage!''});" data-page="${linkPage!''}">${linkPage!''}</a>
                </#if>
            </#list>
            <#if paging.downRow?string("true", "false") == "true">
                <a href="javascript:page.build('${managerUrl!''}', ${paging.downNumber!''});" class="layui-laypage-next" data-page="${paging.downNumber!''}">
                    <i class="layui-icon">&#xe602;</i>
                </a>
            <#else>
                <a href="javascript:;" class="layui-laypage-next layui-disabled" data-page="${paging.upNumber!''}">
                    <i class="layui-icon">&#xe602;</i>
                </a>
            </#if>
            <span class="layui-laypage-count">共 ${paging.totalRows!''} 条</span>
            <span class="layui-laypage-limits">
                <select id="pageSize" lay-ignore="">
                    <#list [10, 20, 30, 40, 50, 60, 80, 100] as pageSize>
                        <#assign pageSizeChecked=''/>
                        <#if pageSize==paging.pageSize!'0'>
                            <#assign pageSizeChecked='selected="selected"'/>
                        </#if>
                        <option value="${pageSize}" ${pageSizeChecked}>${pageSize} 条/页</option>
                    </#list>
                </select>
            </span>
            <span class="layui-laypage-skip">
                到第<input id="pageNumber" type="text" min="1" value="${pageNumber}" class="layui-input">页
                <button type="button" class="layui-laypage-btn" onclick="page.build('${managerUrl!""}');">确定</button>
            </span>
        </div>
    </div>
</div>
