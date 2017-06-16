package com.aiidc.sps.ep.entity;

import java.io.Serializable;

public class AuthzFunction implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -9042365069865161640L;
	private String roleid;
	private String funcid;
	private int    authz;
	public String getRoleid() {
		return roleid;
	}
	public String getFuncid() {
		return funcid;
	}
	public int getAuthz() {
		return authz;
	}
	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}
	public void setFuncid(String funcid) {
		this.funcid = funcid;
	}
	public void setAuthz(int authz) {
		this.authz = authz;
	}
}
