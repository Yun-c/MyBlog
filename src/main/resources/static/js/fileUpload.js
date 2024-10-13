function fileUpload(){

    const fileInput = document.getElementById("uploadFile");
    const formats = new FormData();
    if (fileInput.files && fileInput.files.length > 0) {
        console.log("运行了是生生世世");
    }


    formats.append("file", fileInput.files[0]);

    fetch('/index/upload',{
        method: 'POST',
        body: formats,
    }).then(res=>{
        console.log("成功！！！");
    }).catch(err=>{
        console.log("失败了！！！",err);
    })


}