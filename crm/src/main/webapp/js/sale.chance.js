function formatState(val) {
    if(val==0){
        return "未分配";
    }
    if(val==1){
        return "已分配";
    }
}

function formatDevResult(val) {
    if(val==0){
        return "未开发";
    }
    if(val==1){
        return "已开发中";
    }
    if(val==2){
        return "开发成功";
    }
    if(val==3){
        return "开发失败";
    }
}
function querySaleChancesByParams() {
    $('#dg').datagrid("load",{
        customerName: $('#customerName').val(),
        state: $('#state').combobox("getValue"),
        devResult: $('#devResult').combobox("getValue"),
        createDate: $('#time').datebox("getValue")
    })
}
$(function () {
    $('#dg').datagrid({
        rowStyler: function(index,row){
            var devResult = row.devResult;
            if (devResult == 0) {
                return "background-color:#5bc0de;"; // 蓝色
            } else if (devResult == 1) {
                return "background-color:#f0ad4e;"; // 黄色
            } else if (devResult == 2) {
                return "background-color:#5cb85c;"; // 绿色
            } else if (devResult == 3) {
                return "background-color:#d9534f;"; // 红色
            }
        }
    });
});
//添加打开弹窗
function openAddSaleChacneDialog() {
    $('#dlg').dialog('open')
}
//取消关闭弹框
function closeDlg() {
    $('#dlg').dialog('close')
}
function saveOrUpdateSaleChance() {
    $('#fm').form('submit', {
        url: ctx + '/saleChance/saveOrUpdateSaleChance',
        onSubmit: function(){
            return $(this).form('validate');	// 返回false终止表单提交
        },
        success: function (data) {
            data = JSON.parse(data);
            console.log(data);
            if(data.code==200){
                $.messager.alert('来自Crm',data.msg,'info',function () {
                    // 关闭弹窗
                    $('#dlg').dialog('close')
                    // 刷新数据
                    $('#dg').datagrid("load")
                });
            }else{
                $.messager.alert('来自Crm',data.msg,'error');
            }
        }
    });
}
function openModifySaleChanceDialog() {
    var rows = $('#dg').datagrid("getSelections");// 获取选中的所有行
    if(rows.length<1){
        $.messager.alert('来自Crm','请选择一条记录进行更新','info');
        return;
    }
    if(rows.length>1){
        $.messager.alert('来自Crm','只能选择一条记录进行更新','info');
        return;
    }
    // 回显数据
    $('#fm').form('load',rows[0]);

    $('#dlg').dialog('open');
}