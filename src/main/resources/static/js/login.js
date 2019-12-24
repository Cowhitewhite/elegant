function checkForm(){
    var username = document.getElementById("userName").value;
    var password = document.getElementById("password").value;
    //是否记住登录密码  默认记住登录密码true
    var isCheck = document.getElementsByClassName("isRememberPass")[0].checked;
    var isRememberPass;
    if(isCheck){
        isRememberPass = true;
    }else{
        isRememberPass = false;
    }

    var userError = document.getElementById("user_error");
    var passError = document.getElementById("pass_error");

    if (username == "" || username == null || username == undefined) {
        userError.style.cssText='display:block;';
        passError.style.cssText='display:none;';
        return false;
    } else if (password == "" || password == null || password == undefined) {
        passError.style.cssText='display:block;';
        userError.style.cssText='display:none;';
        return false;
    }else{
        passError.style.cssText='display:none;';
        userError.style.cssText='display:none;';

        $.ajax({
            url: "/elegant/login",
            dataType: "json",
            data: {userName:username, password:password, rememberMe:isRememberPass},
            type: "POST",
            success: function (data) {
                if (data.flag == true) {
                    // dialog($,'success','登陆成功！');
                    window.location.href = "/elegant/index";
                } else {
                    // dialog($,'error',data.msg);
                    alert(data.msg);
                }
            },
            error: function () {
                dialog($,'error','登陆失败！');
            }
        });
    }
}

function changeImage() {
    $("#captchaImage").attr({"src":"/elegant/getCode?w="+Math.random()})
}