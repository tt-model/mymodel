<div class="layui-form layui-form-item">
    <#assign userId="" />
    <#assign userName="" />
    <#assign password="" />
    <#assign email="" />
    <#assign mobile="" />
    <#assign deptId="" />
    <#if user??>
        <#assign userId=user.userId!'' />
        <#assign userName=user.userName!"" />
        <#assign password=user.password!'' />
        <#assign email=user.email!'' />
        <#assign mobile=user.mobile!'' />
        <#assign deptId=user.deptId!'' />
    </#if>
    <div class="layui-form-item">
        <label class="layui-form-label">用户名</label>
        <div class="layui-input-inline">
            <input type="text" name="userName" value="${userName}" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
        </div>
        <div class="layui-form-mid layui-word-aux"></div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">密码</label>
        <div class="layui-input-inline">
            <input type="password" name="password" value="${password}" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
        </div>
        <div class="layui-form-mid layui-word-aux"></div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">邮箱</label>
        <div class="layui-input-inline">
            <input type="text" name="email" value="${email}" required lay-verify="required" placeholder="请输入邮箱" autocomplete="off" class="layui-input">
        </div>
        <div class="layui-form-mid layui-word-aux"></div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">手机</label>
        <div class="layui-input-inline">
            <input type="text" name="mobile" value="${mobile}" required lay-verify="required" placeholder="请输入手机" autocomplete="off" class="layui-input">
        </div>
        <div class="layui-form-mid layui-word-aux"></div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">部门</label>
        <div class="layui-input-inline">
            <#assign searchOptionValue=deptOption />
            <@s.formSingleSelect id="dept" name="deptId" options=searchOptionValue selectId="${deptId}" attributes="" />
        </div>
        <div class="layui-form-mid layui-word-aux"></div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <input type="hidden" name="userId" value="${userId}" />
            <button class="layui-btn" lay-filter="formDemo" onclick="myajax.ajaxSave('/v1/user/userSave');">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</div>