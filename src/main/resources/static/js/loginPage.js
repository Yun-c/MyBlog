function loginjs(){
    //获取变量
    const myForm = document.getElementById("loginForm");

    //创建一个FormData对象，并添加数据
    const formData = new FormData(myForm);

    const username = formData.get("username");
    const password = formData.get("password");
    console.log("运行了！！！")
    console.log(username);
    console.log(password);

    //发送post请求到后端controller
    fetch('/index/login',{
        method:'POST',
        headers: {
            'Content-Type': 'application/json', // 设置请求头，告诉服务器发送的是 JSON 数据
        },
        body:JSON.stringify({"username":username,"password":password})
    }).then(response =>{
        if (!response.ok){
            throw new Error('NetWork response was not ok ');
        }
        return response.text(); // return response.text();
    }).then(data =>{
        //处理后端返回的数据
        console.log("返回值"+data);
        // alert("成功!!!");
        if (data === "100"){
            alert("登录成功！！！");
        }else if (data === "200"){
            alert("用户不存在!!!");
        }else if(data === "300"){
            alert("密码错误");
        }else if(data === "400"){
            alert("用户异常，联系管理员处理");
        }
    }).catch(error=>{
        console.error('There has been a problem with your fetch operation:',error);
    });

}

