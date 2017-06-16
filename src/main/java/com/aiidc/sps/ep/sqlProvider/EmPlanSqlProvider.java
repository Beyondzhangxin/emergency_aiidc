package com.aiidc.sps.ep.sqlProvider;

import com.aiidc.sps.ep.parameter.EmPlanParameter;

public class EmPlanSqlProvider {
	
	public String getEmPlanListSql(EmPlanParameter emPlan){
		int page = emPlan.getPage();
		int rows = emPlan.getRows();
		int begin = (page-1)*rows +1;
		int end = page*rows;
		String whereStr = buildWhereStr(emPlan);
		String sqlStr="select * from("
				+ " select rownum rn,emplan.* from("
				+ " select pl.plan_id,pl.plan_name,pl.reporting_time,ty.plan_type_name,us.usage_name,inf.name"
				+ " from(((em_response_plan pl left join em_response_plan_type ty on pl.plan_type = ty.plan_type_id)"
				+ " left join em_response_plan_usage_type us on us.usage_id =pl.usage_scope )"
				+ " left join em_enterprise_info inf on inf.id = pl.company_id)"
				+ " where 1=1 "+whereStr
				+ " order by pl.plan_id)emplan)"
				+ " where rn between "+begin+" and "+end;
		return sqlStr;
	}
	
	public String getEmPlanCountSql(EmPlanParameter emPlan){
		String whereStr = buildWhereStr(emPlan);
		String sqlStr="select count(*)"
				+ " from((("
				+ " em_response_plan pl left join em_response_plan_type ty on pl.plan_type = ty.plan_type_id)"
				+ " left join em_response_plan_usage_type us on us.usage_id =pl.usage_scope )"
				+ " left join em_enterprise_info inf on inf.id = pl.company_id)"
				+ " where 1=1 " +whereStr;
		return sqlStr;
	}
	
	public String buildWhereStr(EmPlanParameter emPlan){
		StringBuffer strBuf= new StringBuffer("");
		//应急预案名称
		if(emPlan.getPlanName() !=null  && emPlan.getPlanName().length()>0){
			strBuf.append(" and pl.plan_name like '%"+emPlan.getPlanName()+"%'");
		}
		//应急预案类别
		if(emPlan.getPlanType() !=null && emPlan.getPlanType().length()>0){
			strBuf.append("  and pl.plan_type ="+emPlan.getPlanType());
		}
		//应急预案适用领域
		if(emPlan.getUsageScope() !=null && emPlan.getUsageScope().length()>0){
			strBuf.append(" and pl.usage_scope ="+emPlan.getUsageScope());
		}
		//单位名称
		if(emPlan.getCompanyName() !=null && emPlan.getCompanyName().length()>0){
			strBuf.append(" and  inf.name like '%"+emPlan.getCompanyName()+"%'");
		}
		return strBuf.toString();
	}
	
	
	
}
