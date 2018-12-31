$(document).ready(function(){
    $("#login").click(function() {
        var account = {
            custName : $("#name").val(),
            custPassword : $("#password").val()
        };
        var requestJSON = JSON.stringify(account);
        $.ajax({
            type : "POST",
            url : "http://localhost:8080/customers/login",
            headers : {
                "Content-Type" : "application/json"
            },
            data : requestJSON,
            success : function(msg) {
                if (msg == "success")
                    window.location.href="http://localhost:8080/index";
                if (msg == "error")
                    window.location.href="http://localhost:8080/login";
            },
            error : function(msg) {
                alert("Error");
            }
        });
    });
});