<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="EF" tagdir="/WEB-INF/tags/EF" %>

<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<EF:EFPage>
    <EF:EFRegion id="inqu" title="查询" >
        <EF:EFInput ename="inqu_status-0-studentName" cname="姓名"/>
        <EF:EFInput ename="inqu_status-0-studentTime" cname="时间"/>
        <EF:EFInput ename="inqu_status-0-email" cname="邮箱校验"
                    data-rules="email" validateGroupName="group1,group2" placeholder="请填写邮箱"/>

    </EF:EFRegion>
    <EF:EFRegion id="result" title="结果" >
          <EF:EFGrid blockId="result"  autoDraw="no" filterable="true" >
               <EF:EFColumn ename="studentId" cname="学生编号"/>
               <EF:EFColumn ename="studentName" cname="学生姓名"/>
              <EF:EFComboColumn ename="studentTime" cname="创建时间"
                                columnTemplate="#=textField#" itemTemplate="#=textField#"
              textField="textField" valueField="valueField">
                  <EF:EFOption label="全部" value="all"/>
                  <EF:EFOption label="1999" value="1999"/>
                  <EF:EFOption label="2000" value="2000"/>
          </EF:EFComboColumn>
          </EF:EFGrid>
    </EF:EFRegion>

    <EF:EFWindow id="test"  lazyload="true">
        <EF:EFRegion id="window" title="新增" >
            <div class="row">
                <EF:EFInput ename="result-0-studentId" cname="编号" />
                <EF:EFInput ename="result-0-studentName" cname="姓名" />
                <EF:EFInput ename="result-0-studentTime" cname="时间" />
                <div class="col-md-8"></div>
                <div class="col-md-4" style="text-align: right" id="aaa"></div>
            </div>
        </EF:EFRegion>
    </EF:EFWindow>

</EF:EFPage>


