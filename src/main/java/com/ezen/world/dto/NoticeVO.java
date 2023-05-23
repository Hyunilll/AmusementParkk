package com.ezen.world.dto;

import java.sql.Timestamp;

public class NoticeVO {
	private Integer nseq; 
	private String title; 
	private String  ncontent;
	private String id;
	private Timestamp indate;
	
	
	public Integer getNseq() {
		return nseq;
	}
	public void setNseq(Integer nseq) {
		this.nseq = nseq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getNcontent() {
		return ncontent;
	}
	public void setNcontent(String ncontent) {
		this.ncontent = ncontent;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Timestamp getIndate() {
		return indate;
	}
	public void setIndate(Timestamp indate) {
		this.indate = indate;
	}
		
	
	
}
