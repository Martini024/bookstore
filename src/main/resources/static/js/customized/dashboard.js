window.onload(function requestData(){
    $.ajax({
        url: "http://localhost:8080/customers/1",
        type: "post",
        dataType: "json",
        success: function(data){
            /*这个方法里是ajax发送请求成功之后执行的代码*/
            showData(data);//我们仅做数据展示
        },
        error: function(msg){
            alert("ajax连接异常："+msg);
        }
    });
});

function showData(data) {
    var str = "";//定义用于拼接的字符串
    for (var i = 0; i < data.length; i++) {
        //拼接表格的行和列
        str = "<tr><td>" + data[i].addressList.addrName + "</td>" +
            "<td>" + data[i].addressList.addrPhone + "</td>" +
            "<td>" + data[i].addressList.addrAddress + "</td>" +
            "<td>" + data[i].addressList.addrZipcode + "</td></tr>";
        //追加到table中
        $("#addressTable").append(str);
    }
}