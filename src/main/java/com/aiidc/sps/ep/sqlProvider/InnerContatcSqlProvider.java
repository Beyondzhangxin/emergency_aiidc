package com.aiidc.sps.ep.sqlProvider;

import com.aiidc.sps.ep.parameter.InnerContatcQueryEntity;

public class InnerContatcSqlProvider {

	public String getInnerContatcListSql(InnerContatcQueryEntity innerContatcQueryEntity){
		int page = innerContatcQueryEntity.getPage();
		int rows = innerContatcQueryEntity.getRows();
		int begin = (page-1)*rows+1;
		int end =page*rows;
		String whereStr =getWhereStr(innerContatcQueryEntity);
		String sqlStr="select * from ("
				+ "select rownum rn,t.* from em_park_contacts t"
				+ " where 1=1 "+whereStr
				+ "order by id )"
				+ " where rn between "+begin+" and "+end;
		return sqlStr;
	}
	
	public String getInnerContaticCountSql(InnerContatcQueryEntity innerContatcQueryEntity){
		String whereStr =getWhereStr(innerContatcQueryEntity);
		String sqlStr="select count(*) from em_park_contacts t where 1=1 order by change_time" +whereStr;
		return sqlStr;
	}
	
	public String getWhereStr(InnerContatcQueryEntity innerContatcQueryEntity){
		StringBuffer strBuf = new StringBuffer("");
		if(innerContatcQueryEntity.getContacts() != null && innerContatcQueryEntity.getContacts().length()>0){
			strBuf.append("and t.contacts like '%"+innerContatcQueryEntity.getContacts()+"%'");
		}
		if(innerContatcQueryEntity.getCompanyName() != null && innerContatcQueryEntity.getCompanyName().length()>0 ){
			strBuf.append("and t.company_name like '%"+innerContatcQueryEntity.getCompanyName()+"%'");
		}
		if(innerContatcQueryEntity.getMobilePhone() != null  && innerContatcQueryEntity.getMobilePhone().length()>0){
			strBuf.append("and t.mobile_phone like '%"+innerContatcQueryEntity.getMobilePhone()+"%'");
		}
		if(innerContatcQueryEntity.getEmail() != null && innerContatcQueryEntity.getEmail().length()>0 ){
			strBuf.append("and t.email like '%"+innerContatcQueryEntity.getEmail()+"%'");
		}
		return strBuf.toString();
	}
	
}
