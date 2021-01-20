<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="EF" tagdir="/WEB-INF/tags/EF"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<EF:EFPage title="树与grid联动示例">
    <div class="row">
        <div class="col-md-3">
            <EF:EFRegion id="tree" title="多次加载树 JS 配置首节点" fitHeight="true"  >
                <EF:EFTree id="tree01" textField="text" valueField="label"
                           hasChildren="leaf"  serviceName="AABB02" methodName="queryTreeNode">
                </EF:EFTree>
            </EF:EFRegion>
        </div>
        <div class="col-md-9">
            <EF:EFRegion title="查询区" id="inqu">
                <div class="row">
                    <EF:EFInput cname="目录代码" ename="inqu_status-0-ename" />
                </div>
                <EF:EFInput ename="inqu_status-0-parentEname" type="hidden"/>
            </EF:EFRegion>
            <EF:EFRegion title="数据集" id="result" fitHeight="true"   >
                <EF:EFGrid blockId="result" autoDraw="false" serviceName="AABB02" needAuth="false">
                    <EF:EFColumn ename="ename" cname="英文名称"/>
                    <EF:EFColumn ename="cname" cname="中文名称"/>
                    <EF:EFColumn ename="parentEname" cname="父节点名称"/>
                    <EF:EFColumn ename="leaf" cname="类型" />
                </EF:EFGrid>
            </EF:EFRegion>
        </div>
    </div>
</EF:EFPage>