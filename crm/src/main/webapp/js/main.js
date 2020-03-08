function openTab(text, url, iconCls){
    if($("#tabs").tabs("exists",text)){
        $("#tabs").tabs("select",text);
    }else{
        var content="<iframe frameborder=0 scrolling='auto' style='width:100%;height:100%' src='" + url + "'></iframe>";
        $("#tabs").tabs("add",{
            title:text,
            iconCls:iconCls,
            closable:true,
            content:content
        });
    }
}
<<<<<<< HEAD
//打开窗口
function openPasswordModifyDialog() {
    $('#dlg').dialog("open")
}
//关闭窗口
function closePasswordModifyDialog() {
    $('#dlg').dialog("close")
}
//提交
function modifyPassword() {
    $('#fm').form('submit', {
        url: ctx + '/user/updateUserPwd',
        onSubmit: function(){
            return $(this).form('validate');	// 返回false终止表单提交
        },
        success: function (data) {
            data = JSON.parse(data);
            // console.log(data);
            if(data.code==200){
                $.messager.alert('来自Crm',data.msg,'info',function () {
                    // 清空cookie
                    $.removeCookie("userIdStr");
                    // 跳转到登陆页
                    window.location.href=ctx + '/index';
                });
            }else{
                $.messager.alert('来自Crm',data.msg,'error');
            }
        }
    });
}
//安全退出
function logout() {
    // 清空cookie
    $.removeCookie("userIdStr");
    // 跳转到登陆页
    window.location.href=ctx + '/index';
}

=======
>>>>>>> f6ce3391221933bbaf5f13abf6f88ca4a4e5b78d

