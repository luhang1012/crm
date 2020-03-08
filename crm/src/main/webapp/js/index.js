function login() {
    var userName = $('#userName').val();
    var userPwd = $('#userPwd').val();

    if(isEmpty(userName)){
        $('#msg').html("用户名不能为空")
        return
    }
    if(isEmpty(userPwd)){
        $('#msg').html("密码不能为空")
        return
    }

    $.ajax({
        url:ctx+"/user/login",
        type:'post',
        data:{
            userName:userName,
            userPwd:userPwd
        },
        success:function (data) {
            if(data.code==200){
                //添加cookie
                $.cookie("userIdStr",data.obj.userIdStr)
                //跳到主页
                window.location.href=ctx+"/main"
            }else{
                $('#msg').html(data.msg)
            }
        }
    })

}