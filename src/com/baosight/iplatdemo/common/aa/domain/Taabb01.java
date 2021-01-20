/**
* Generate time : 2020-12-08 14:15:51
* Version : 6.0.731.201809200158
*/
package com.baosight.iplatdemo.common.aa.domain;

import com.baosight.iplat4j.core.ei.EiColumn;
import com.baosight.iplat4j.core.data.DaoEPBase;
import java.util.HashMap;
import java.util.Map;
import com.baosight.iplat4j.core.util.StringUtils;

/**
* Taabb01
* 
*/
public class Taabb01 extends DaoEPBase {

    private static final long serialVersionUID = 1L;

    private String studentId = " ";		
    private String studentName = " ";		
    private String studentTime = " ";		

    /**
     * initialize the metadata
     */
    public void initMetaData() {
        EiColumn eiColumn;

        eiColumn = new EiColumn("studentId");
        eiColumn.setPrimaryKey(true);
        eiColumn.setDescName(" ");
        eiMetadata.addMeta(eiColumn);

        eiColumn = new EiColumn("studentName");
        eiColumn.setDescName(" ");
        eiMetadata.addMeta(eiColumn);

        eiColumn = new EiColumn("studentTime");
        eiColumn.setDescName(" ");
        eiMetadata.addMeta(eiColumn);


    }

    /**
     * the constructor
     */
    public Taabb01() {
        initMetaData();
    }

    /**
     * get the studentId 
     * @return the studentId
     */
    public String getStudentId() {
        return this.studentId;
    }

    /**
     * set the studentId 
     */
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    /**
     * get the studentName 
     * @return the studentName
     */
    public String getStudentName() {
        return this.studentName;
    }

    /**
     * set the studentName 
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    /**
     * get the studentTime 
     * @return the studentTime
     */
    public String getStudentTime() {
        return this.studentTime;
    }

    /**
     * set the studentTime 
     */
    public void setStudentTime(String studentTime) {
        this.studentTime = studentTime;
    }

    /**
     * get the value from Map
     */
    public void fromMap(Map map) {

        setStudentId(StringUtils.defaultIfEmpty(StringUtils.toString(map.get("studentId")), studentId));
        setStudentName(StringUtils.defaultIfEmpty(StringUtils.toString(map.get("studentName")), studentName));
        setStudentTime(StringUtils.defaultIfEmpty(StringUtils.toString(map.get("studentTime")), studentTime));
    }

    /**
     * set the value to Map
     */
    public Map toMap() {
        Map map = new HashMap();
        map.put("studentId",StringUtils.toString(studentId, eiMetadata.getMeta("studentId")));
        map.put("studentName",StringUtils.toString(studentName, eiMetadata.getMeta("studentName")));
        map.put("studentTime",StringUtils.toString(studentTime, eiMetadata.getMeta("studentTime")));
        return map;
    }
}