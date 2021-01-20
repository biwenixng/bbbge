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

public class ServiceAABB01 extends ServiceBase {

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

    /**
     * 删除功能
     *
     * @param inInfo
     * @return
     */
    @Override
    public EiInfo delete(EiInfo inInfo) {
        EiInfo outInfo = super.delete(inInfo, "taabb01.delete");
        return outInfo; }

    public EiInfo queryMachineInfoByPoid(EiInfo inInfo) {
        EiInfo outInfo = super.query(inInfo, "taabb01.query", new
                Taabb01());
        System.out.print(outInfo+"-----------");
        return outInfo;
    }
    public void sendMail(){
        //创建邮件实体对象
        EmailBean emailBean = new EmailBean();
        //增加收件人
        emailBean.addTo("1350500764@qq.com.com");

        //设置邮件标题
        emailBean.setSubject("Email Example Title");
        //设置邮件内容
        emailBean.setMsg("Email message body");
        //设置附件,多个附件按;分割
        String attachFiles = "d:/attachFiles/attachFile1.txt;d:/attachFiles/attachFile2.txt;";
        if (StringUtils.isNotEmpty(attachFiles)) {
            String[] attachFile = attachFiles.split(";");
            for (int i = 0; i < attachFile.length; i++) {
                //检查文件是否存在
                File file = new File(attachFile[i]);
                if (!file.exists()) {
                    throw new PlatException("该文件不存在: " + attachFile[i]);
                }
                emailBean.addAttachFile(attachFile[i]);
            }
        }
        //邮件发送成功会返回emailMsgID
        String emailMsgID = EmailSendCenter.getInstance().sendEmail(emailBean);
        if (!StringUtils.isNotEmpty(emailMsgID)) {
            throw new PlatException("邮件发送失败!");
        }
    }

    public EiInfo getnum(EiInfo inInfo){
        EiBlock block = inInfo.addBlock("formTypeDesc");
        //EiInfo对新增一个EiBlock块
        EiBlockMeta metadata = new EiBlockMeta();
        //产生一个EiBlockMeta元数据对象
        EiColumn eiColumn = new EiColumn("form_type");
        //产生一个EiColumn对象
        eiColumn.setDescName("类型");
        //设置EiColumn对象的中文名称
        metadata.addMeta(eiColumn);
        //EiBlockMeta对象新增一个EiColumn对象
        eiColumn = new EiColumn("form_type_desc");
        eiColumn.setDescName("页面类型描述");
        metadata.addMeta(eiColumn);
        //同上
        block.setBlockMeta(metadata);
        block.setBlockMeta(metadata);
        //EiBlock对象设置EiBlockMeta对象
        Map row = new HashMap();
        row.put("form_type", "1");
        row.put("form_type_desc", "直接载入");
        block.addRow(row);
        //EiBlock对象新增一行数据
        row = new HashMap();
        row.put("form_type", "0");
        row.put("form_type_desc", "平台载入");
        block.addRow(row);
        //同上
        return inInfo;
    }
}
