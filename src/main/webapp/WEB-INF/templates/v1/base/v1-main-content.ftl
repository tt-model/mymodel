<#if method?? && method="GET">
    <#include "head.ftl"/>
        <body class="layui-layout-body">
            <div class="layui-layout layui-layout-admin">
                <#include "topNav.ftl"/>
                    <#include "leftNav.ftl"/>
                    <#include "v1-main-content/main-content.ftl"/>
                    <#include "footer.ftl"/>
            </div>
        </body>
    </html>
    <#else>
    <#include "v1-main-content/main-content/head-body.ftl"/>
</#if>

