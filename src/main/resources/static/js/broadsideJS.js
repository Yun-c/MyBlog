
    //侧边栏打开时的width
    var leftbarWidth = "50%";

    function openBroadside() {

    //关闭侧边栏
    if (leftbar.style.width === leftbarWidth) {//如果侧边栏的宽度=我们设置的侧边栏的宽度leftbarWidth
        leftbar.style.width = "0";//设置侧边栏width=0
        leftbar.innerHTML = '<img src="/static/starPictures/111719.jpg" alt="点击打开教程">'//切换按钮中的图片
        leftbar.style.left = "0";//移动按钮
    } else {//打开侧边栏
        leftbar.style.width = leftbarWidth;//设置侧边栏width=leftbarWidth
        leftbar.innerHTML = '<img src="/static/starPictures/918362.jpg" alt="点击关闭">'//切换按钮中的图片
        leftbar.style.left = leftbarWidth;//移动按钮
    }
}
