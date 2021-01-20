<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="EF" tagdir="/WEB-INF/tags/EF" %>

<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<EF:EFPage title="跳转4C演示">
    <EF:EFRegion id="inqu" title="跳转4C演示" >
        <div class="row">
            <EF:EFInput ename="inqu_status-0-formEname" cname="画面名"/>

                    <%-- 自定义的按钮 --%>
            <div>
                <EF:EFButton ename="F1" cname="跳转" ></EF:EFButton>
            </div>
        </div>
    </EF:EFRegion>
</EF:EFPage>