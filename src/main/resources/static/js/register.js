function registerjs(){

    const myForm = document.getElementById("re-form");

    //创建一个FormData对象，并添加数据
    const formData = new FormData(myForm);

    const username = formData.get("username");
    const password = formData.get("password");
    const email = formData.get("email");
    const confirm_password = formData.get("confirm-password");

    if (password !== confirm_password) {
        alert("两次输入的密码不一致！");
        return false;
    }

    //发送fetch请求
    fetch('/index/register',{method:'POST',
        headers: {
            'Content-Type': 'application/json', // 设置请求头，告诉服务器发送的是 JSON 数据
        },
        body:JSON.stringify({"username":username,"password":password,"email":email})}
    ).then(response =>{
        if (!response.ok){
            throw new Error('NetWork response was not ok ');
        }
        return response.text(); // return response.text();
    }).then(data =>{
        //处理后端返回的数据
        console.log("返回值"+data);
        // alert("成功!!!");
        if (data === "100"){
            alert("注册成功！！！");
            window.location.href="loginPage.html";
        }else if (data === "200"){
            alert("用户不存在!!!");
        }else if(data === "300"){
            alert("密码错误");
        }else if(data === "400"){
            alert("用户异常，联系管理员处理");
        }else if(data === "500"){
            alert("用户已存在");
        }
    }).catch(error=>{
        console.error('There has been a problem with your fetch operation:',error);
    });


}