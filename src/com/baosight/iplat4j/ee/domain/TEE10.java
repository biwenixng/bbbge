
/**
 * @author wuyicang
 */
package com.baosight.iplat4j.ee.domain;

import com.baosight.iplat4j.core.data.DaoEPBase;
import com.baosight.iplat4j.core.ei.EiColumn;

public class TEE10 extends DaoEPBase {
    public TEE10() {
        initMetaData();
    }

    public void initMetaData() {
        EiColumn eiColumn = new EiColumn("product_id");
        eiColumn.setDescName("产品代号");
        eiColumn.setMaxLength(20);
//		eiColumn.setNotNull( true );
        eiColumn.setNullable(false);
        eiColumn.setPrimaryKey(true);
        eiMetadata.addMeta(eiColumn);

        eiColumn = new EiColumn("company_name");
        eiColumn.setDescName("公司名称");
        eiColumn.setMaxLength(20);
//		eiColumn.setNotNull( false );
        eiColumn.setNullable(true);
        eiMetadata.addMeta(eiColumn);

        eiColumn = new EiColumn("made_country");
        eiColumn.setDescName("产地");
        eiColumn.setMaxLength(20);
//		eiColumn.setNotNull( false );
        eiColumn.setNullable(true);
        eiMetadata.addMeta(eiColumn);

        eiColumn = new EiColumn("sale_date");
        eiColumn.setDescName("上市日期");
        eiColumn.setMaxLength(20);
//		eiColumn.setNotNull( false );
        eiColumn.setNullable(true);
        eiMetadata.addMeta(eiColumn);

        eiColumn = new EiColumn("price");
        eiColumn.setDescName("价格");
        eiColumn.setType("N");
        eiColumn.setNullable(true);
        eiMetadata.addMeta(eiColumn);

        eiColumn = new EiColumn("company_page");
        eiColumn.setDescName("公司首页");
        eiColumn.setMaxLength(255);
        eiColumn.setWidth(150);
//		eiColumn.setNotNull( false );
        eiColumn.setNullable(true);
        eiMetadata.addMeta(eiColumn);

        eiColumn = new EiColumn("search");
        eiColumn.setDescName("Google查询");
        eiColumn.setMaxLength(20);
//		eiColumn.setNotNull( false );
        eiColumn.setNullable(true);
        eiMetadata.addMeta(eiColumn);

        eiColumn = new EiColumn("validate_0");
        eiColumn.setDescName("验证字段0");
        eiMetadata.addMeta(eiColumn);

        eiColumn = new EiColumn("validate_1");
        eiColumn.setDescName("验证字段1");
        eiMetadata.addMeta(eiColumn);

        eiColumn = new EiColumn("validate_2");
        eiColumn.setDescName("验证字段2");
        eiMetadata.addMeta(eiColumn);

        eiColumn = new EiColumn("validate_3");
        eiColumn.setDescName("验证字段3");
        eiMetadata.addMeta(eiColumn);

        eiColumn = new EiColumn("validate_4");
        eiColumn.setDescName("验证字段4");
        eiMetadata.addMeta(eiColumn);

        eiColumn = new EiColumn("validate_5");
        eiColumn.setDescName("验证字段5");
        eiMetadata.addMeta(eiColumn);

        eiColumn = new EiColumn("validate_6");
        eiColumn.setDescName("验证字段6");
        eiMetadata.addMeta(eiColumn);

        eiColumn = new EiColumn("validate_7");
        eiColumn.setDescName("验证字段7");
        eiMetadata.addMeta(eiColumn);

        eiColumn = new EiColumn("validate_8");
        eiColumn.setDescName("验证字段8");
        eiMetadata.addMeta(eiColumn);

        eiColumn = new EiColumn("validate_9");
        eiColumn.setDescName("验证字段9");
        eiMetadata.addMeta(eiColumn);
    }
}
