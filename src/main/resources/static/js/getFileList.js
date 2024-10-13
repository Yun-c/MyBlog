function getFileList(){

    fetch("/index/getFilelist",{method:"GET"})
        .then(response => response.json())
        .then(data => {
            const tbody = document.getElementById("file-list");
            tbody.innerHTML = ''; //清空现有内容
            data.forEach(file => {
                const row = document.createElement('tr');
                row.innerHTML = `  
                            <td>${file.fileNmme}</td>  
                            <td>${file.filePath}</td>  
                            <td>${file.fileSize}</td>  
                        `;
                tbody.appendChild(row);
            })
        })
        .catch(error => console.log(error));
}