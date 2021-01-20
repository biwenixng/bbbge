testService = function () {
    var eiInfo = new EiInfo();
    eiInfo.set("test", 0, "test1", "11");
    eiInfo.set("test", 0, "test2", "12");
    eiInfo.set("test", 1, "test1", "22");
    eiInfo.set("test", 1, "test2", "22");
    var jsonEi = EiInfo2Json.prototype.EiInfo2JsonString(eiInfo);
    var efSecurityToken = $('#efSecurityToken').val();
    var reqParams = {eiinfo: jsonEi, efSecurityToken: efSecurityToken};
    //var funcId = document.getElementById("funcId").value;
    $.ajax(
        {
            type: "POST",
            async: false,
            url: ctx+"/service/EDFA00/query" ,
            //data:     "service=" + sService + "&method=" + sMethod + "&eiinfo=" + jsonEi,
            data: reqParams,
            dataType: "json",
            success: function (msg) {
                var ajaxEi = Json2EiInfo.prototype.parseJsonObject( msg );
                alert(ajaxEi.getMsg());


            },
            error: function (xmlR, status, e) {
                alert("AJAX请求异常，登录失败！");
            }
        });

}