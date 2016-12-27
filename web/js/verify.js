var xmlhttp;
function  create() {
    if (window.XMLHttpRequest) {
        xmlhttp = new XMLHttpRequest();
        if (xmlhttp.overrideMimeType)
            xmlhttp.overrideMimeType("text/xml")
    } else if (window.ActiveXObject) {
        var activexName = ["MSXML2.XMLHTTP", "Microsoft.XMLHTTP"];
        for (var i = 0; i < activexName.length; i++) {
            try {
                xmlhttp = new ActiveXObject(activexName[i]);
                break;
            } catch (e) {
            }
        }
    }
    // 确认XMLHttpRequest对象创建成功
    if(!xmlhttp){
        console.info("XMLHttpRequest对象创建失败！");
        return;
    }else{
        console.info(xmlhttp.readyState);
    }
}

function callback() {//回调函数
    if (xmlhttp.readyState == 4) {//判断对象的状态是交互完成
        if (xmlhttp.status == 200) { //判断http的交互是否成功
            var responseText = xmlhttp.responseText;//获取服务器端返回的纯文本数据
            var divNode = document.getElementById("result");
            divNode.innerHTML = responseText;//将数据显示在页面上
        } else {
            alert("出错了");
        }
    }
}

function verifyPost() {
    create();
    var userName = document.getElementById("userName").value;
    xmlhttp.onreadystatechange = callback;
    xmlhttp.open("POST", "verifyServer", true); //POST方式请求的代码
    //POST方式需要自己设置http的请求头
    xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xmlhttp.send("name=" + encodeURI(encodeURI(userName)));    //POST方式发送数据
}
function verifyGet(){
    create();
    var userName = document.getElementById("userName").value;
    xmlhttp.onreadystatechange = callback;
    xmlhttp.open("GET","verifyServer?name="+userName,true);
    xmlhttp.send(null);
}