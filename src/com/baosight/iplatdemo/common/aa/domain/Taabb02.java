package com.baosight.iplatdemo.common.aa.domain; /**
 * Generate time : 2017-12-21 11:29:32
 * Version : 6.0.731.201712180701
 */

import com.baosight.iplat4j.core.ei.EiColumn;
import com.baosight.iplat4j.core.data.DaoEPBase;
import java.util.HashMap;
import java.util.Map;
import com.baosight.iplat4j.core.util.StringUtils;

/**
 * Tdmcm02
 *
 */
public class Taabb02 extends DaoEPBase {

    private String ename = " ";     /* 英文名称*/
    private String cname = "";      /* 中文名称*/
    private String parentEname = "";        /* 父节点名称*/
    private String type = "";       /* 类别*/
    private String leaf = "1";      /* 是否有叶子节点*/
    private String sort = "";       /* 排序字段*/
    private String icon = "";       /* 图片地址*/
    /**
     * initialize the metadata
     */
    public void initMetaData() {
        EiColumn eiColumn;

        eiColumn = new EiColumn("ename");
        eiColumn.setPrimaryKey(true);
        eiColumn.setFieldLength(255);
        eiColumn.setDescName("英文名称");
        eiMetadata.addMeta(eiColumn);

        eiColumn = new EiColumn("cname");
        eiColumn.setFieldLength(255);
        eiColumn.setDescName("中文名称");
        eiMetadata.addMeta(eiColumn);

        eiColumn = new EiColumn("parentEname");
        eiColumn.setFieldLength(255);
        eiColumn.setDescName("父节点名称");
        eiMetadata.addMeta(eiColumn);

        eiColumn = new EiColumn("type");
        eiColumn.setFieldLength(255);
        eiColumn.setDescName("类别");
        eiMetadata.addMeta(eiColumn);

        eiColumn = new EiColumn("leaf");
        eiColumn.setFieldLength(10);
        eiColumn.setDescName("是否有叶子节点");
        eiMetadata.addMeta(eiColumn);

        eiColumn = new EiColumn("sort");
        eiColumn.setFieldLength(255);
        eiColumn.setDescName("排序字段");
        eiMetadata.addMeta(eiColumn);

        eiColumn = new EiColumn("icon");
        eiColumn.setFieldLength(255);
        eiColumn.setDescName("图片地址");
        eiMetadata.addMeta(eiColumn);


    }
    /**
     * the constructor
     */
    public Taabb02() {
        initMetaData();
    }

    /**
     * get the ename - 英文名称
     * @return the ename
     */
    public String getEname() {
        return this.ename;
    }

    /**
     * set the ename - 英文名称
     */
    public void setEname(String ename) {
        this.ename = ename;
    }
    /**
     * get the cname - 中文名称
     * @return the cname
     */
    public String getCname() {
        return this.cname;
    }

    /**
     * set the cname - 中文名称
     */
    public void setCname(String cname) {
        this.cname = cname;
    }
    /**
     * get the parentEname - 父节点名称
     * @return the parentEname
     */
    public String getParentEname() {
        return this.parentEname;
    }

    /**
     * set the parentEname - 父节点名称
     */
    public void setParentEname(String p_ename) {
        this.parentEname = parentEname;
    }
    /**
     * get the type - 类别
     * @return the type
     */
    public String getType() {
        return this.type;
    }

    /**
     * set the type - 类别
     */
    public void setType(String type) {
        this.type = type;
    }
    /**
     * get the leaf - 是否有叶子节点
     * @return the leaf
     */
    public String getLeaf() {
        return this.leaf;
    }

    /**
     * set the leaf - 是否有叶子节点
     */
    public void setLeaf(String leaf) {
        this.leaf = leaf;
    }
    /**
     * get the sort - 排序字段
     * @return the sort
     */
    public String getSort() {
        return this.sort;
    }

    /**
     * set the sort - 排序字段
     */
    public void setSort(String sort) {
        this.sort = sort;
    }
    /**
     * get the icon - 图片地址
     * @return the icon
     */
    public String getIcon() {
        return this.icon;
    }

    /**
     * set the icon - 图片地址
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }
    /**
     * get the value from Map
     */
    public void fromMap(Map map) {

        setEname(StringUtils.defaultIfEmpty(StringUtils.toString(map.get("ename")), ename));
        setCname(StringUtils.defaultIfEmpty(StringUtils.toString(map.get("cname")), cname));
        setParentEname(StringUtils.defaultIfEmpty(StringUtils.toString(map.get("p_ename")), parentEname));
        setType(StringUtils.defaultIfEmpty(StringUtils.toString(map.get("type")), type));
        setLeaf(StringUtils.defaultIfEmpty(StringUtils.toString(map.get("leaf")), leaf));
        setSort(StringUtils.defaultIfEmpty(StringUtils.toString(map.get("sort")), sort));
        setIcon(StringUtils.defaultIfEmpty(StringUtils.toString(map.get("icon")), icon));
    }

    /**
     * set the value to Map
     */
    public Map toMap() {

        Map map = new HashMap();
        map.put("ename",StringUtils.toString(ename, eiMetadata.getMeta("ename")));
        map.put("cname",StringUtils.toString(cname, eiMetadata.getMeta("cname")));
        map.put("parentEname",StringUtils.toString(parentEname, eiMetadata.getMeta("parentEname")));
        map.put("type",StringUtils.toString(type, eiMetadata.getMeta("type")));
        map.put("leaf",StringUtils.toString(leaf, eiMetadata.getMeta("leaf")));
        map.put("sort",StringUtils.toString(sort, eiMetadata.getMeta("sort")));
        map.put("icon",StringUtils.toString(icon, eiMetadata.getMeta("icon")));

        return map;

    }
}
