function getFileList(){

    fetch("/index/getFilelist",{method:"GET"})
        .then(response => response.json())
        .then(data => {
            // console.log(data);
            const tbody = document.getElementById("file-list");
            tbody.innerHTML = ''; //清空现有内容
            data.forEach(element => {console.log(element)})
            data.forEach(files => {
                const row = document.createElement('tr');
                row.innerHTML = `  
                            <td>${files.file_name}</td>
                            <td>${files.filePath}</td>  
                            <td>${files.fileSize}</td>  
                            <td><button id="handle-button" type="button">解密</button></td>  
                        `;
                tbody.appendChild(row);
            })
        })
        .catch(error => console.log(error));
}