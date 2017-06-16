package com.aiidc.sps.ep.services;

import com.aiidc.base.security.WebSecurity;
import com.aiidc.base.util.BeanUtils;
import com.aiidc.sps.ep.entity.Navigation;
import com.aiidc.sps.ep.mapper.NavigationMapper;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;




@Service
public class LogonService {

	
	
	
	@Autowired
	private NavigationMapper mapper;
	@Autowired
	private WebSecurity webSecurity;
	
	public List<Navigation> getNavigation()
	{
		
		
		List<Navigation> list = mapper.getRootNavigationList();
		getNavigationChildren(mapper, list);
		return list;
	}


	private void getNavigationChildren(NavigationMapper mapper, List<Navigation> list)
	{
		for(Navigation nav: list){
			List<Navigation> children = mapper.getNavigationListByParent(nav.getId());
			nav.setChildren(children);
			getNavigationChildren(mapper,children);
		}
	}
	
	
	public JSONArray getNavigationForJson(Authentication auth)
	throws Exception
	{
		List<Navigation> menus = getNavigation();
		rebuildMenuTree(auth, menus);
		JSONArray jarr = new JSONArray();
		for(Navigation menu : menus)
		{
			jarr.put(BeanUtils.describeToJson(menu));
		}
		return jarr;
	}
	
	public JSONArray getNavigationForJson()
	throws Exception
	{
		List<Navigation> menus = getNavigation();
		
		JSONArray jarr = new JSONArray();
		for(Navigation menu : menus)
		{
			jarr.put(BeanUtils.describeToJson(menu));
		}
		return jarr;
	}
	
	private void rebuildMenuTree(Authentication auth, List<Navigation> menus) 
	{
		
		for(Navigation menu : menus)
		{
			if(menu.getFuncid()==null||menu.getFuncid().equals(""))
			{
				List<Navigation> children = menu.getChildren();
				if(children==null||children.size()==0){
					menus.remove(menu);
					rebuildMenuTree(auth, menus);
					return;
				}else{
					rebuildMenuTree(auth, children);
					if(children.size()==0){
						menus.remove(menu);
						rebuildMenuTree(auth, menus);
						return;
					}
				}
			}else{
				if(!webSecurity.checkAccess(auth, menu.getFuncid()))
				{
					menus.remove(menu);
					rebuildMenuTree(auth, menus);
					return;
				}
			}
		}
	}
}
