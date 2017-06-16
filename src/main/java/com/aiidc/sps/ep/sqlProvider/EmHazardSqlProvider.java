package com.aiidc.sps.ep.sqlProvider;
import com.aiidc.sps.ep.parameter.EmHazardChenicalQueryEntity;

public class EmHazardSqlProvider {

	public String findEmHazardChenicalListSql(EmHazardChenicalQueryEntity queryEntity){
		int page = queryEntity.getPage();
		int rows =queryEntity.getRows();
		int begin = (page-1)*rows+1;
		int end =page*rows;
		String whereStr = getWhereStr(queryEntity);
		String sqlStr="select * from("
				+ " select rownum rn, haz.* from em_park_hazard_chemical haz "
				+ " where 1=1 "+whereStr+")"
				+ " where rn between "+begin+" and "+end;
		return sqlStr;
	}
	
	public String getEmHazardChenicalCount(EmHazardChenicalQueryEntity queryEntity){
		String whereStr = getWhereStr(queryEntity);
		String sqlStr ="select count(*) from em_park_hazard_chemical haz where 1=1 "+whereStr;
		return sqlStr;
	}
	

	public String getWhereStr(EmHazardChenicalQueryEntity queryEntity){
		StringBuffer strBuf = new StringBuffer("");
		if(queryEntity.getChineseName() !=null && queryEntity.getChineseName().length()>0){
			strBuf.append("and haz.chinese_name like '%"+queryEntity.getChineseName()+"%'");
		}
		if(queryEntity.getEnglishName() !=null && queryEntity.getEnglishName().length()>0){
			strBuf.append("and haz.english_name like '%"+queryEntity.getEnglishName()+"%'");
		}
		if(queryEntity.getCasCode() !=null && queryEntity.getCasCode().length()>0){
			strBuf.append("and haz.cas_code="+queryEntity.getCasCode());
		}
		return strBuf.toString();
	}
}
