
// 获取文件输入和上传按钮的DOM元素引用
document.addEventListener('DOMContentLoaded', function() {
    var fileInput = document.getElementById('fileInput');
    var uploadButton = document.getElementById('uploadButton');

    uploadButton.addEventListener('click', function () {
        fileInput.click();
    });

    fileInput.addEventListener('change', function (event) {
        const files = event.target.files;
        console.log(files);
        if (files.length > 0) {
            const formats = new FormData();
            // 将选中的文件添加到表单数据中
            // for (let i = 0; i < files.length; i++) {
            //     formData.append('files[]', files[i]);
            // }
            formats.append("file", fileInput.files[0]);

            // 使用Fetch API发送POST请求到服务器
            fetch('/index/upload', {
                method: 'POST',
                body: formats,
            }).then(res => {
                console.log("成功！！！");
            }).catch(err => {
                console.log("失败了！！！", err);
            })
        }
    });
});