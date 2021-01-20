<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="EF" tagdir="/WEB-INF/tags/EF" %>

<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<EF:EFPage>
<EF:EFRegion id="region1" title="内置规则校验">
    <div class="row">
        <h5 class="push-30-l text-danger">EFSelect 和 EFDatePicker 只支持必填校验</h5>
        <EF:EFInput ename="inqu_status-0-required" cname="非空校验"
                    required="true" placeholder="请填写字符"/>
        <EF:EFSelect cname="大洲" template="#=valueField#-#=textField#" valueTemplate="#=valueField#-#=textField#"
                     ename="inqu_status-0-continent" required="true" resultId="result"
                     optionLabel="请选择" serviceName="EEDM5010" methodName="initLoad"
                     textField="continent_name" valueField="continent_code">
            <EF:EFOption label="所有" value="all"/>
        </EF:EFSelect>

        <EF:EFDatePicker format="yyyy/MM/dd" required="true" cname="单个的日期" ename="inqu_status-0-start">
        </EF:EFDatePicker>
    </div>

    <div class="row">
        <EF:EFInput ename="inqu_status-0-length" cname="输入长度校验"
                    minLength="3" maxLength="8" placeholder="请输入长度为3-8的字符串"/>
        <EF:EFInput ename="inqu_status-0-email" cname="邮箱校验"
                    data-rules="email"  placeholder="请填写邮箱"/>
        <EF:EFInput ename="inqu_status-0-url" cname="URL校验"
                    data-rules="http_url" placeholder="请填写URL"/>
    </div>
    <div class="row">
        <EF:EFInput ename="inqu_status-0-mobile_phone" cname="手机号校验"
                    data-rules="mobile_phone" placeholder="请输入手机号"/>
        <EF:EFInput ename="inqu_status-0-number" cname="数字校验"
                    data-rules="positive_integer" placeholder="请输入正整数"/>
        <EF:EFInput ename="inqu_status-0-ip" cname="IP地址校验"
                    data-rules="ip_address" placeholder="请输入IP地址"/>
    </div>
</EF:EFRegion>

    <EF:EFRegion id="region2" title="正则表达式校验">
        <div class="row">
            <EF:EFInput ename="result-0-num5_101" cname="正则校验"
                        data-regex="/^([5-9]|100|[1-9]\d)$/" data-errorprompt="请输入5-100之间的数字"
                        placeholder="请输入5-100数字"/>
            <EF:EFInput colWidth="6" ratio="6:6" ename="result-0-password" cname="密码校检
                (字母,数字,_组成6-10位字符)" required="true" type="password"
                        data-regex="/^[0-9a-zA-Z]{6,10}$/" data-errorPrompt="密码格式不符合要求"
                        placeholder="字母,数字,_组成6-10位字符"/>
        </div>
        <div class="row">
            <EF:EFInput ename="result-0-num37" cname="多重正则校验"
                        data-errorPrompt='长度大于3的数字' data-regex='/^[0-9]{3,}$/'
                        data-errorPrompt0='长度小于10的数字' data-regex0='/^[0-9]{0,10}$/'
                        data-errorPrompt1='只允许出现3到9的数字' data-regex1='/^[3-9]{0,}$/'
                        data-errorPrompt2='只允许出现0到7的数字' data-regex2='/^[0-7]{0,}$/'
                        placeholder="长度在3-10只包含3-7的数字"/>

            <EF:EFInput colWidth="6" ratio="6:6" ename="result-0-chinese" cname="中文校检"
                        data-regex="/^[\u4e00-\u9fa5]+$/" data-errorPrompt="请输入中文"
                        placeholder="请输入中文"/>
        </div>
    </EF:EFRegion>
</EF:EFPage>

