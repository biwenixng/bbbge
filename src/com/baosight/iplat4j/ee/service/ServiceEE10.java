/**
 *
 */
package com.baosight.iplat4j.ee.service;

import com.baosight.iplat4j.core.data.ibatis.dao.Dao;
import com.baosight.iplat4j.core.ei.*;
import com.baosight.iplat4j.core.service.impl.ServiceEPBase;
import com.baosight.iplat4j.ee.domain.TEE10;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wuyicang
 */
public class ServiceEE10 extends ServiceEPBase {
    private List countries;

    public ServiceEE10() {
        initCountries();
    }

    public EiInfo initLoad(EiInfo inInfo) {
        return query(inInfo);
    }

    public EiInfo query(EiInfo inInfo) {
        EiInfo outInfo = super.query(inInfo, "EE10.query", new TEE10());

        generateOtherBlocks(outInfo);
        outInfo.getBlock(EiConstant.resultBlock);
        return outInfo;
    }

    public EiInfo delete(EiInfo inInfo) {
        EiInfo outInfo = super.delete(inInfo, "EE10.delete");
        EiInfo out = query(inInfo);
        out.setMsg(outInfo.getMsg());
        out.setDetailMsg(outInfo.getDetailMsg());
        return out;
    }

    public EiInfo update(EiInfo inInfo) {
        StringBuffer buffer = new StringBuffer();
        StringBuffer detail = new StringBuffer();

        Dao tt = this.getDao();
        for (int i = 0; i < inInfo.getBlock("result").getRowCount(); i++) {
            try {
                tt.update("EE10.update", inInfo.getBlock("result").getRow(i));
                buffer.append("更新产品代号:" + inInfo.getBlock("result").getCell(i, "product_id") + "的记录成功\n");
            } catch (Exception ex) {
                buffer.append("更新产品代号:" + inInfo.getBlock("result").getCell(i, "product_id") + "的记录失败\n");
                inInfo.setStatus(-1);
                detail.append(ex.getCause().toString());
            }
        }
        inInfo.setMsg(buffer.toString());
        inInfo.setDetailMsg(detail.toString());
        EiInfo out = query(inInfo);
        out.setMsg(inInfo.getMsg());
        out.setDetailMsg(inInfo.getDetailMsg());
        return out;
    }

    public String getSubStr(String src) {
        if (src == null || src.equals(""))
            return src;

        System.out.println("SUB TEST, SRC:" + src);
        System.out.println("SUB TEST, SRC LENGTH:" + src.length());

        String dest = "";

        try {
            byte[] bb = src.getBytes("GBK");
            System.out.println("SUB TEST, SRC BYTE LENGTH:" + bb.length);

            byte[] bb2 = new byte[bb.length - 1];
            System.out.println("SUB TEST, SRC BYTE LENGTH-1:" + bb2.length);

            for (int i = 0; i < bb.length - 1; i++) {
                bb2[i] = bb[i];
            }

            dest = new String(bb2, "GBK");

            System.out.println("SUB TEST, DEST:" + dest);
            System.out.println("SUB TEST, DEST LENGTH:" + dest.length());
        } catch (UnsupportedEncodingException e) {
        }

        return dest;
    }

    public EiInfo insert(EiInfo inInfo) {
        StringBuffer buffer = new StringBuffer();
        StringBuffer detail = new StringBuffer();
        Dao tt = this.getDao();
        for (int i = 0; i < inInfo.getBlock("result").getRowCount(); i++) {
            try {
                inInfo.setCell("result", i, "validate_2", getSubStr(inInfo
                        .getCellStr("result", i, "validate_2")));
                tt.insert("EE10.insert", inInfo.getBlock("result").getRow(i));
                buffer.append("新增第" + i + "条记录成功\n");
            } catch (Exception ex) {
                buffer.append("新增第" + i + "条记录失败\n");
                inInfo.setStatus(-1);
                detail.append(ex.getCause().toString());
            }
        }
        inInfo.setMsg(buffer.toString());
        inInfo.setDetailMsg(detail.toString());
        return inInfo;
    }

    public int getAllRecordCount(StringBuffer buffer, Map param) {
        Dao tt = this.getDao();
        try {
            List aa = tt.query("EE10.count", param);
            int count = ((Integer) aa.get(0)).intValue();
            return count;
        } catch (Exception ex) {
            buffer.append(ex.getMessage()).append("\n");
            return -1;
        }
    }

    public EiInfo getCountry(EiInfo inInfo) {
        EiInfo outInfo = new EiInfo();

        int offset = 0;
        int limit = 10;
        boolean showCount = false;

        try {
            EiBlock eiBlock = inInfo.getBlock("country");
            if (eiBlock != null) {
                offset = eiBlock.getInt("offset");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        try {
            EiBlock eiBlock = inInfo.getBlock("country");
            if (eiBlock != null) {
                limit = eiBlock.getInt("limit");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        try {
            EiBlock eiBlock = inInfo.getBlock("country");
            if (eiBlock != null) {
                showCount = Boolean.valueOf(eiBlock.getString("showCount")).booleanValue();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        generateCountryBlock(outInfo, offset, limit, showCount);

        outInfo.setMsg("");

        return outInfo;
    }

    public void generateOtherBlocks(EiInfo info) {
        generateCountryBlock(info, 0, 10, false);
        generateCityBlock(info);
    }

    public void initCountries() {
        countries = new ArrayList();
        Map row = new HashMap();
        row.put("country_ename", "China");
        row.put("country_cname", "中国");
        row.put("continenet", "亚洲");
        countries.add(row);

        row = new HashMap();
        row.put("country_ename", "Japan");
        row.put("country_cname", "日本");
        row.put("continenet", "亚洲");
        countries.add(row);

        row = new HashMap();
        row.put("country_ename", "Korea");
        row.put("country_cname", "韩国");
        row.put("continenet", "亚洲");
        countries.add(row);

        row = new HashMap();
        row.put("country_ename", "Sweden");
        row.put("country_cname", "瑞典");
        row.put("continenet", "欧洲");
        countries.add(row);

        row = new HashMap();
        row.put("country_ename", "Germany");
        row.put("country_cname", "德国");
        row.put("continenet", "欧洲");
        countries.add(row);

        row = new HashMap();
        row.put("country_ename", "France");
        row.put("country_cname", "法国");
        row.put("continenet", "欧洲");
        countries.add(row);

        row = new HashMap();
        row.put("country_ename", "England");
        row.put("country_cname", "英格兰");
        row.put("continenet", "欧洲");
        countries.add(row);

        row = new HashMap();
        row.put("country_ename", "USA");
        row.put("country_cname", "美国");
        row.put("continenet", "北美洲");
        countries.add(row);

        row = new HashMap();
        row.put("country_ename", "Canada");
        row.put("country_cname", "加拿大");
        row.put("continenet", "北美洲");
        countries.add(row);

        row = new HashMap();
        row.put("country_ename", "Argentina");
        row.put("country_cname", "阿根廷");
        row.put("continenet", "南美洲");
        countries.add(row);

        row = new HashMap();
        row.put("country_ename", "Brazil");
        row.put("country_cname", "巴西");
        row.put("continenet", "南美洲");
        countries.add(row);

        row = new HashMap();
        row.put("country_ename", "Chile");
        row.put("country_cname", "智利");
        row.put("continenet", "南美洲");
        countries.add(row);
    }

    public void generateCountryBlock(EiInfo info, int offset, int limit, boolean showCount) {
        EiBlock block = info.addBlock("country");
        EiBlockMeta metadata = new EiBlockMeta();

        EiColumn eiColumn = new EiColumn("country_ename");
        eiColumn.setDescName("国家英文名称");
        metadata.addMeta(eiColumn);

        eiColumn = new EiColumn("country_cname");
        eiColumn.setDescName("国家中文名称");
        metadata.addMeta(eiColumn);

        eiColumn = new EiColumn("continenet");
        eiColumn.setDescName("所在洲");
        metadata.addMeta(eiColumn);

        int from_index = (offset >= countries.size()) ? countries.size() : offset;
        int to_index = (from_index + limit >= countries.size()) ? countries.size() : from_index
                + limit;
        List list = countries.subList(from_index, to_index);

        block.setBlockMeta(metadata);
        block.setRows(list);
        block.set("offset", new Integer(offset));
        block.set("limit", new Integer(limit));
        if (showCount) {
            block.set("count", new Integer(countries.size()));
        }
    }

    public void generateCityBlock(EiInfo info) {
        String blockid = "city";
        info.addBlock(blockid);
        EiBlock block = info.getBlock(blockid);
        EiBlockMeta metadata = new EiBlockMeta();

        EiColumn eiColumn = new EiColumn("city_name");
        eiColumn.setDescName("城市名");
        metadata.addMeta(eiColumn);

        eiColumn = new EiColumn("country_name");
        eiColumn.setDescName("国家名称");
        metadata.addMeta(eiColumn);

        block.setBlockMeta(metadata);

        Map row = new HashMap();
        row.put("city_name", "Shanhai");
        row.put("country_name", "中国");
        block.addRow(row);

        row = new HashMap();
        row.put("city_name", "Tokyo");
        row.put("country_name", "日本");
        block.addRow(row);

        row = new HashMap();
        row.put("city_name", "Roma");
        row.put("country_name", "意大利");
        block.addRow(row);

        row = new HashMap();
        row.put("city_name", "Barcelona");
        row.put("country_name", "西班牙");
        block.addRow(row);

        row = new HashMap();
        row.put("city_name", "Paris");
        row.put("country_name", "法国");
        block.addRow(row);

        new HashMap();
        row.put("city_name", "Lyon");
        row.put("country_name", "法国");
        block.addRow(row);
    }
}
