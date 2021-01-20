<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="EF" tagdir="/WEB-INF/tags/EF" %>

<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<EF:EFPage title="使用EFPage模版的KendoUI示例">
    <EF:EFRegion id="inqu" title="查询条件" type="query" efRegionShowClear="true" efRegionSave="true">
        <div class="row">
            <div class="col-xs-4">
                <div class="form-group">
                    <label class="col-md-4 control-label">
                        产品代号:
                    </label>
                    <div class="col-md-8">
                        <input name="inqu_status-0-product_id" data-query="gt" class="k-textbox input-time query-need" placeholder="产品代号">
                    </div>
                </div>
            </div>
            <div class="col-xs-4">
                <div class="form-group">
                    <label class="col-md-4 control-label">
                        公司名称:
                    </label>
                    <div class="col-md-8">
                        <input name="inqu_status-0-company_name" data-query="gt" class="k-textbox input-time query-need" placeholder="公司名称">
                    </div>
                </div>
            </div>
            <div class="col-xs-4"></div>
        </div>
    </EF:EFRegion>
    <EF:EFRegion id="result" title="记录集">
        <EF:EFGrid blockId="result"></EF:EFGrid>
    </EF:EFRegion>
</EF:EFPage>