package com.baosight.iplatdemo.aa.bb.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baosight.iplatdemo.common.aa.domain.Taabb02;
import com.baosight.iplat4j.core.ei.EiBlock;
import com.baosight.iplat4j.core.ei.EiConstant;
import com.baosight.iplat4j.core.ei.EiInfo;
import com.baosight.iplat4j.core.service.impl.ServiceBase;

public class ServiceAABB02 extends ServiceBase {
    @Override
    public EiInfo initLoad(EiInfo inInfo) {
        EiBlock block = new EiBlock(EiConstant.resultBlock);
        block.addBlockMeta(new Taabb02().eiMetadata);
        EiInfo outInfo = new EiInfo();
        outInfo.addBlock(block);
        outInfo.setMsg("欢迎来到树表联动示例");
        return outInfo;
    }

    public EiInfo query(EiInfo inInfo) {
        EiInfo outInfo = super.query(inInfo, "taabb02.query", new Taabb02());
        return outInfo;
    }

    public EiInfo delete(EiInfo inInfo) {
        return super.delete(inInfo, "taabb02.delete");
    }

    public EiInfo update(EiInfo inInfo) {
        return super.update(inInfo, "taabb02.update");
    }

    public EiInfo insert(EiInfo inInfo) {

        return insert(inInfo, "taabb02.insert");
    }

    //树查询服务
    public EiInfo queryTreeNode(EiInfo inInfo) {
        //1 获取参数
        String pEname = inInfo.getCellStr(EiConstant.queryBlock, 0, "node");
        Map queryMap = new HashMap();
        queryMap.put("parentEname", pEname);
        //2 查询节点
        List rows = dao.query("AABB02.queryTree", queryMap);
        //3 增加节点block块
        EiInfo outInfo = new EiInfo();
        EiBlock outBlock = outInfo.addBlock(pEname);
        outBlock.addRows(rows);
        return outInfo;
    }

}