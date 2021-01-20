package com.baosight.iplatdemo.aa.bb.service;

import com.baosight.iplat4j.core.ei.EiInfo;
import com.baosight.iplat4j.core.service.impl.ServiceEPBase;

public class ServiceEWTT00 extends ServiceEPBase {
    public EiInfo invokeService(EiInfo inInfo){
        String id=(String)inInfo.get("id");//输入输出参数，从流程中传入变量

        String name="zhangsan";
        int age=25;
        String statusCode="9999";
        //返回给流程的变量的参数
        EiInfo outInfo=new EiInfo();
        outInfo.set("id",id);//输入输出参数
        outInfo.set("name",name);//输出参数
        outInfo.set("age",age);//输出参数
        outInfo.set("statusCode",statusCode);//输出参数
        return outInfo;

    }

}
