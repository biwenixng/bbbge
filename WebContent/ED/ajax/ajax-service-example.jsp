<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="EF" tagdir="/WEB-INF/tags/EF" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html>

<%
    String ctx = request.getContextPath();
    System.out.println(ctx);
%>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta http-equiv="Pragma" content="no-cache"> 
    <meta http-equiv="Cache-Control" content="no-cache"> 
    <meta http-equiv="Expires" content="0"> 
    <title>测试界面测试</title>

    <script type="text/javascript" src="<%=ctx%>/lib/jquery/jquery-1.8.0.min.js"></script>
    <script type="text/javascript" src="<%=ctx%>/EI/json_util.js"></script>
    <script type="text/javascript" src="<%=ctx%>/EI/EIInfo.js"></script>
    <script type="text/javascript" src="<%=ctx%>/EF/iplat-ui-2.0.js"></script>
    <script type="text/javascript" src="<%=ctx%>/ED/ajax/ajax-example.js"></script>

    <script type="text/javascript">
        var ctx = "<%=ctx%>";
    </script>
  
</head>

<!--
<body onbeforeunload="javascript:return '将关闭打开的所有子窗口！'">
 -->
<body>
<div class="ui-layout-center">
    <p>简单的ajax测试</p>
    <p>代码示例</p>
    <code>
        var eiInfo = "{}";
        var reqParams = {eiinfo: jsonEi, efSecurityToken: efSecurityToken};
        $.ajax(
        {
            type: "POST",
            async: false,
            url: ctx+"/service/EDFA00/query" ,
            data: reqParams,
            dataType: "json",
            success: function (msg) {
            var ajaxEi = Json2EiInfo.prototype.parseJsonObject( msg );
            alert(ajaxEi.getMsg());
        },
            error: function (xmlR, status, e) {
            alert("AJAX请求异常，执行失败！");
        }
        });
    </code>
    <input type="button" id="test" name="test" value="测试ajax发送"  onclick="testService();" />
    <code id="return">
    </code>
</div>



</body>
</html>
