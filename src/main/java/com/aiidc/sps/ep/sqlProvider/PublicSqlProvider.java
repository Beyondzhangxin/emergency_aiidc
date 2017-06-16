package com.aiidc.sps.ep.sqlProvider;

import java.util.Map;

public class PublicSqlProvider {
	/**
	 * 为查询指定身份下的市区县,返回SqlStr
	 * @param map
	 * @return
	 */
	public String findAreaSql(Map<String,Object> map){
		StringBuffer strBuf= new StringBuffer("select * from area where");
		String provId =(String) map.get("provId");
		String cityId =(String) map.get("cityId");
		String countyId =(String) map.get("countyId");
		//查询指定省份的：所有市
		if("00".equals(countyId) && cityId ==null && provId !=null){
			strBuf.append(" prov_id="+provId+" and county_id=00 order by area_id");
			return strBuf.toString();
		}
		//查询指定市的：所有区县
		if(provId !=null && cityId !=null && countyId ==null){
			strBuf.append( " prov_id="+provId+" and city_id="+cityId +" order by area_id");
			return strBuf.toString();
		}
		//查询指定的区县
		if(provId !=null && cityId !=null && countyId !=null){
			strBuf.append(" prov_id="+provId+" and city_id="+cityId+" and county_id="+countyId +" order by area_id");
		}
		return strBuf.toString();
	}
}
