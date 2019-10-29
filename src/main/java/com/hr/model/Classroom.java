package com.hr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "classroom")
public class Classroom {
	
	@Id
	@Column (name = "classId")
	private String cid;
	@Column (name = "className")
	private String cname;
	@Column (name = "classLocation")
	private String clink;
	@Column (name = "classDescription")
	private String cdesc;
	
	
	public Classroom() {
		super();
	}


	public Classroom(String cid, String cname, String clink, String cdesc) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.clink = clink;
		this.cdesc = cdesc;
	}


	public String getCid() {
		return cid;
	}


	public void setCid(String cid) {
		this.cid = cid;
	}


	public String getCname() {
      
		return cname;
	}


	public void setCname(String cname) {
		this.cname = cname;
	}


	public String getClink() {
		return clink;
	}


	public void setClink(String clink) {
		this.clink = clink;
	}


	public String getCdesc() {
		return cdesc;
	}


	public void setCdesc(String cdesc) {
		this.cdesc = cdesc;
	}
	
	
	
	
}