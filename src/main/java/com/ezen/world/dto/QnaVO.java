package com.ezen.world.dto;

import java.sql.Timestamp;

public class QnaVO {
	private Integer lqseq; 
	private String title;
	private String content;
	private String reply;
	private String rep;
	private String id;
	private Timestamp indate;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getLqseq() {
		return lqseq;
	}
	public void setLqseq(Integer lqseq) {
		this.lqseq = lqseq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public String getRep() {
		return rep;
	}
	public void setRep(String rep) {
		this.rep = rep;
	}
	public Timestamp getIndate() {
		return indate;
	}
	public void setIndate(Timestamp indate) {
		this.indate = indate;
	}
	
	
	
	
}
