package com.aiidc.sps.ep.sqlProvider;

import com.aiidc.sps.ep.parameter.EmMaterialParameter;

public class EmMaterialSqlProvider {

	public String getEmMaterialListSizeSql(EmMaterialParameter emMaterialParamete){
		String wherestr = getSqlStrForgetEmMaterialList(emMaterialParamete);
		String sqlStr="select count(*)"
				+ " from (((em_resource_material m "
				+ " left join em_resource_material_classify mc on m.material_classify_id =mc.classify_id )"
				+ " left join em_resource_material_type mt on mt.type_id =m.material_type_id)"
				+ " left join em_enterprise_info cont on cont.id = m.company_id)"
				+ " where 1=1 "+wherestr;
		return sqlStr;
	}
	
	public String getEmMaterialListSql(EmMaterialParameter emMaterialParamete){
		int page =emMaterialParamete.getPage();
		int rows=emMaterialParamete.getRows();
		int begin = (page-1)*rows+1;
		int end= page*rows;
		String wherestr = getSqlStrForgetEmMaterialList(emMaterialParamete);
		String sqlStr="select * from("
				+ "select rownum rn,rnm.*from("
				+ "select m.material_id,m.material_name,mc.classify_name,mt.type_name,m.num,m.expiry_date,m.change_time,cont.name,m.create_time,m.company_id "
				+ "from (((em_resource_material m left join em_resource_material_classify mc on m.material_classify_id =mc.classify_id ) "
				+ "left join em_resource_material_type mt on mt.type_id =m.material_type_id)"
				+ "left join em_enterprise_info cont on cont.id = m.company_id)"
				+ "where 1=1 "+wherestr+" order by expiry_date)rnm)"
				+ "where rn between "+begin+" and "+end;
		return sqlStr;
	}
	
	public String getSqlStrForgetEmMaterialList(EmMaterialParameter emMaterialParamete){
		StringBuffer strBuf= new StringBuffer("");
		//物资装备名称
		if(emMaterialParamete.getMaterialName() != null && emMaterialParamete.getMaterialName().length()>0){
			strBuf.append(" and m.material_name like '%"+emMaterialParamete.getMaterialName()+"%' ");
		}
		//所属地区
		if(emMaterialParamete.getAreaId() !=null && emMaterialParamete.getAreaId().length()>0){
			strBuf.append(" and m.area_id like '%"+emMaterialParamete.getAreaId()+"%' ");
		}
		//物资装备分类
		if(emMaterialParamete.getMaterialClassifyId() !=null && emMaterialParamete.getMaterialClassifyId().length()>0 ){
			strBuf.append(" and  mc.classify_id='"+emMaterialParamete.getMaterialClassifyId()+"' ");
		}
		//物资装备类别
		if(emMaterialParamete.getMaterialTypeId() != null && emMaterialParamete.getMaterialTypeId().length()>0){
			strBuf.append(" and mt.type_id ='"+emMaterialParamete.getMaterialTypeId() +"' ");
		}
		//有效期
		if(emMaterialParamete.getIsExpire() !=null && emMaterialParamete.getIsExpire().length()>0){
			if(emMaterialParamete.getIsExpire().equals("2")){
				//未过期
				strBuf.append(" and sysdate<m.expiry_date");
			}else if(emMaterialParamete.getIsExpire().equals("3")){
				//已过期
				strBuf.append(" and sysdate>m.expiry_date");
			}
		}
		//单位名称
		if(emMaterialParamete.getCompanyName() !=null && emMaterialParamete.getCompanyName().length()>0){
			strBuf.append(" and cont.name like '%"+emMaterialParamete.getCompanyName()+"%' ");
		}
		return strBuf.toString();
	}
}



