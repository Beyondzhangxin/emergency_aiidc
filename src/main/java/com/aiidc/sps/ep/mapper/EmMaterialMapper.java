package com.aiidc.sps.ep.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.aiidc.sps.ep.entity.EmMaterial;
import com.aiidc.sps.ep.entity.EmMaterialClassify;
import com.aiidc.sps.ep.entity.EmMaterialSource;
import com.aiidc.sps.ep.entity.EmMaterialType;
import com.aiidc.sps.ep.entity.EmMaterialUtilEntity;
import com.aiidc.sps.ep.entity.EmEnterpriseInfo;
import com.aiidc.sps.ep.parameter.EmMaterialParameter;
import com.aiidc.sps.ep.sqlProvider.EmMaterialSqlProvider;

@org.apache.ibatis.annotations.Mapper
public interface EmMaterialMapper{
	
	/**
	 * 获取满足条件的总记录数
	 * @return
	 */
	@SelectProvider(type=EmMaterialSqlProvider.class,method="getEmMaterialListSizeSql")
	public Integer getEmMaterialListSize(EmMaterialParameter emMaterialParameter);
	

	/**
	 * 获取满足条件的数据集合
	 * @param map
	 * @return
	 */
	@SelectProvider(type=EmMaterialSqlProvider.class,method="getEmMaterialListSql")
	@Results({@Result(property="materialId",column="material_id"),
		@Result(property="typeName",column="type_name"),
		@Result(property="classifyName",column="classify_name"),
		@Result(property="materialName",column="material_name"),
		@Result(property="num",column="num"),
		@Result(property="expiryDate",column="expiry_date"),
		@Result(property="companyName",column="name"),
		@Result(property="createTime",column="create_time"),
		@Result(property="companyId",column="company_id"),
		@Result(property="changeTime",column="change_time")})
	public List<EmMaterialUtilEntity> getEmMaterialList(EmMaterialParameter emMaterialParamete);
	
	
	/**
	 * 获取物资装备分类
	 * @return
	 */
	@Select("select * from em_resource_material_classify")
	@Results({
		@Result(property="classifyId",column="classify_id"),
		@Result(property="classifyName",column="classify_name")})
	public List<EmMaterialClassify> getEmMaterialClassify();
	
	/**
	 * 获取物资装备类别
	 * @return
	 */
	@Select("select * from em_resource_material_type")
	@Results({
		@Result(property="typeId",column="type_id"),
		@Result(property="typeName",column="type_name")})
	public List<EmMaterialType> getEmMaterialTyp();
	
	/**
	 * 获取物资装备来源
	 * @return
	 */
	@Select("select * from em_resource_material_source")
	@Results({
		@Result(property="sourceId",column="source_id"),
		@Result(property="sourceName",column="source_name")})
	public List<EmMaterialSource> getEmMaterialSource();
	
	/**
	 * 根据id查询应急
	 * @param materialId
	 * @return
	 */
	@Select("select * from em_resource_material where material_id =#{materialId}")
	@Results({@Result(property="companyId",column="company_id"),
		@Result(property="materialId",column="material_id"),
		@Result(property="materialName",column="material_name"),
		@Result(property="teamId",column="team_id"),
		@Result(property="areaId",column="area_id"),
		@Result(property="materialClassifyId",column="material_classify_id"),
		@Result(property="materialTypeId",column="material_type_id"),
		@Result(property="materialSourceId",column="material_source_id"),
		@Result(property="currentStatus",column="current_status"),
		@Result(property="storagePlace",column="storage_place"),
		@Result(property="purchaseDate",column="purchase_date"),
		@Result(property="productDate",column="product_date"),
		@Result(property="expiryDate",column="expiry_date"),
		@Result(property="usefulLife",column="useful_life"),
		@Result(property="createTime",column="create_time"),
		@Result(property="changeTime",column="change_time")})
	public List<EmMaterial> findEmMaterialById(String materialId);
	
	
	@Select("select * from em_enterprise_info where id=#{enterPriseId}")
	public List<EmEnterpriseInfo> findEnterpriseById(String enterPriseId);

}



