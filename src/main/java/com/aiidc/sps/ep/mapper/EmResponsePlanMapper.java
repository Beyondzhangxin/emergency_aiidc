package com.aiidc.sps.ep.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.aiidc.sps.ep.entity.EmResponsePlan;
import com.aiidc.sps.ep.entity.EmResponsePlanType;
import com.aiidc.sps.ep.entity.EmResponsePlanUsageType;
import com.aiidc.sps.ep.parameter.EmPlanListParameter;
import com.aiidc.sps.ep.parameter.EmPlanParameter;
import com.aiidc.sps.ep.sqlProvider.EmPlanSqlProvider;

@Mapper
public interface EmResponsePlanMapper {
	
	/**
	 * 获取应急预案类别列表
	 * @return
	 */
	@Select("select * from em_response_plan_type")
	@Results({@Result(property="planTypeId",column="plan_type_id"),
		@Result(property="planTypeName",column="plan_type_name")})
	public List<EmResponsePlanType> getEmResponsePlanTypeList();
	
	
	/**
	 * 获取应急预案使用领域列表
	 * @return
	 */
	@Select("select * from em_response_plan_usage_type")
	@Results({@Result(property="usageId",column="usage_id"),
		@Result(property="usageName",column="usage_name")})
	public List<EmResponsePlanUsageType> getEmPlanUsageTypeList();
	
	/**
	 * 获取应急预案列表
	 * @return
	 */
	@SelectProvider(type=EmPlanSqlProvider.class,method="getEmPlanListSql")
	@Results({
		@Result(property="planId",column="plan_id"),
		@Result(property="planName",column="plan_name"),
		@Result(property="planTypeName",column="plan_type_name"),
		@Result(property="usageName",column="usage_name"),
		@Result(property="reportingTime",column="reporting_time"),
		@Result(property="companyName",column="name")
	})
	public List<EmPlanListParameter> getEmPlanList(EmPlanParameter emPlan);
	
	/**
	 * 获取应急预案：满足条件的记录数
	 * @param map
	 * @return
	 */
	@SelectProvider(type=EmPlanSqlProvider.class,method="getEmPlanCountSql")
	public Integer getEmPlanCount(EmPlanParameter emPlan);
	
	/**
	 * 查询应急预案详情信息
	 * @param planId
	 * @return
	 */
	@Select("select company_id,plan_id,plan_name,plan_type,usage_scope,plan_content,reporting_time"
			+ " from em_response_plan where plan_id=#{planId}")
	@Results({
		@Result(property="companyId",column="company_id"),
		@Result(property="planId",column="plan_id"),
		@Result(property="planName",column="plan_name"),
		@Result(property="planType",column="plan_type"),
		@Result(property="usageScope",column="usage_scope"),
		@Result(property="planContent",column="plan_content"),
		@Result(property="reportingTime",column="reporting_time")
	})
	public EmResponsePlan findEmPlanByPlanId(int planId);
	
	
	
}
