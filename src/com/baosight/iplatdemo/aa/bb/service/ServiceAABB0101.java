package com.baosight.iplatdemo.aa.bb.service;


import com.baosight.iplat4j.core.ei.*;
import com.baosight.iplat4j.core.exception.PlatException;

import com.baosight.iplat4j.core.log.xeye.PlatEye;
import com.baosight.iplat4j.core.log.xeye.entity.XEyeEntity;
import com.baosight.iplat4j.core.service.impl.ServiceBase;
import com.baosight.iplat4j.core.util.DateUtils;
import com.baosight.iplat4j.core.util.StringUtils;
import com.baosight.iplatdemo.common.aa.domain.Taabb01;
import com.baosight.xservices.em.email.EmailSendCenter;
import com.baosight.xservices.em.email.bean.EmailBean;
import com.baosight.xservices.xs.util.UserSession;
import org.springframework.security.core.userdetails.User;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServiceAABB0101 extends ServiceBase {

    private String treeP = "";
    public String getTreeP() {
        return treeP;
    }

    public EiInfo setTreeP(EiInfo inInfo) {
        this.treeP = inInfo.getString("label");
        EiInfo eiInfo =new EiInfo();
        eiInfo.setStatus(0);
        return eiInfo;
    }


    /**
     * 初始化功能（初始化做查询处理）
     *
     * @param inInfo
     * @return
     */
    @Override
    public EiInfo initLoad(EiInfo inInfo) {
        return super.initLoad(inInfo, new Taabb01());
    }


    @Override
    public EiInfo query(EiInfo inInfo) {
        EiInfo outInfo = super.query(inInfo, "taabb01.query", new
                Taabb01());
        return outInfo; }

    /**
     * 新增功能
     *
     * @param inInfo
     * @return
    //     */
    @Override
    public EiInfo insert(EiInfo inInfo) {
        EiInfo outInfo = super.insert(inInfo, "taabb01.insert");
        return outInfo;
    }

    /**
     * 修改功能
     *
     * @param inInfo
     * @return
     */
    @Override
    public EiInfo update(EiInfo inInfo) {
        EiInfo outInfo = super.update(inInfo, "taabb01.update");
        return outInfo; }

}
