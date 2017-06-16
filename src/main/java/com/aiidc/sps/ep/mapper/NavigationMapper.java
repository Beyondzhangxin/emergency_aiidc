package com.aiidc.sps.ep.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.aiidc.sps.ep.entity.Navigation;

@org.apache.ibatis.annotations.Mapper
public interface NavigationMapper{
		
	@Select( "select * from navigation where pid is null and sys_id=1 order by orderby")
	@Results({@Result(property="iconCls",column="icon_cls"),@Result(property="funcid",column="func_id")})
	public List<Navigation> getRootNavigationList();
	
	@Select( "select * from navigation where pid=#{pid} and sys_id=1 order by orderby")
	@Results({@Result(property="iconCls",column="icon_cls"),@Result(property="funcid",column="func_id")})
	public List<Navigation> getNavigationListByParent(int pid);
}
