package com.ezen.world.dto;

import java.sql.Timestamp;

public class Cart2VO {

	private Integer cseq;
	private String id;  
	private Integer kind;  
	private Integer p1;
	private Integer p2;
	private String tatname1;
	private String tatname2;
	private String tatname3;
	private Timestamp indate;	
	private Timestamp visitdate;
	
	public Integer getCseq() {
		return cseq;
	}
	public void setCseq(Integer cseq) {
		this.cseq = cseq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getKind() {
		return kind;
	}
	public void setKind(Integer kind) {
		this.kind = kind;
	}
	public Integer getP1() {
		return p1;
	}
	public void setP1(Integer p1) {
		this.p1 = p1;
	}
	public Integer getP2() {
		return p2;
	}
	public void setP2(Integer p2) {
		this.p2 = p2;
	}
	public String getTatname1() {
		return tatname1;
	}
	public void setTatname1(String tatname1) {
		this.tatname1 = tatname1;
	}
	public String getTatname2() {
		return tatname2;
	}
	public void setTatname2(String tatname2) {
		this.tatname2 = tatname2;
	}
	public String getTatname3() {
		return tatname3;
	}
	public void setTatname3(String tatname3) {
		this.tatname3 = tatname3;
	}
	public Timestamp getIndate() {
		return indate;
	}
	public void setIndate(Timestamp indate) {
		this.indate = indate;
	}
	public Timestamp getVisitdate() {
		return visitdate;
	}
	public void setVisitdate(Timestamp visitdate) {
		this.visitdate = visitdate;
	}
	
}
