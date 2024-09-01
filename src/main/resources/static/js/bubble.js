window.onload = function() {
    var oc = document.querySelector("canvas");
    if (oc.getContext) {
        var ctx = oc.getContext("2d");
        var arr = [];
        setInterval(function () {
            console.log(arr);
            // 在绘画之前，对数组arr内部的参数值进行改变，以达到运动的效果
            ctx.clearRect(0, 0, oc.width, oc.height);
            for (var i = 0; i < arr.length; i++) {
                arr[i].degree++;
                arr[i].x = arr[i].startX + Math.sin(arr[i].degree * Math.PI / 180) * arr[i].step * 2;
                arr[i].y = arr[i].startY - (arr[i].degree * Math.PI / 180) * arr[i].step * 5;
                console.log(arr[i].y);
                if (arr[i].y <= arr[i].r) {
                    arr.splice(i, 1);
                }
                arr[i].alp -= 0.001;
            }
            //对已经更改好的数组对应的圆进行绘画。
            for (var i = 0; i < arr.length; i++) {
                ctx.save();
                ctx.fillStyle = "rgba(" + arr[i].red + "," + arr[i].green + "," + arr[i].blue + "," + arr[i].alp + ")";
                ctx.beginPath();
                ctx.arc(arr[i].x, arr[i].y, arr[i].r, 0, 2 * Math.PI);
                ctx.fill();
                ctx.restore();
            }
        }, 1000 / 60);
        // 在arr中注入随机圆信息
        setInterval(function () {
            var x = Math.round(Math.random() * oc.width);
            var r = Math.round(Math.random()) * 10 + 5;
            var y = oc.height - r;
            var red = Math.round(Math.random() * 255);
            var green = Math.round(Math.random() * 255);
            var blue = Math.round(Math.random() * 255);
            var alp = 1;
            var degree = 0;
            var startX = x;
            var startY = y;
            var step = 10;
            arr.push({
                x: x,
                y: y,
                r: r,
                red: red,
                green: green,
                blue: blue,
                alp: alp,
                degree: degree,
                startX: startX,
                startY: startY,
                step: step
            });
        }, 200)
    }
}

