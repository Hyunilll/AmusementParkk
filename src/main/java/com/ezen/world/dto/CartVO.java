package com.ezen.world.dto;

import java.sql.Timestamp;

public class CartVO {

	private Integer lcseq;
	private String id;  
	private Integer ptseq;  
	private Integer aquantity;
	private Integer cquantity;
	private Integer aprice;
	private Integer cprice;
	private Timestamp indate;
	private Timestamp visitdate;
	
	
	
	public Integer getLcseq() {
		return lcseq;
	}
	public void setLcseq(Integer lcseq) {
		this.lcseq = lcseq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getPtseq() {
		return ptseq;
	}
	public void setPtseq(Integer ptseq) {
		this.ptseq = ptseq;
	}
	public Integer getAquantity() {
		return aquantity;
	}
	public void setAquantity(Integer aquantity) {
		this.aquantity = aquantity;
	}
	public Integer getCquantity() {
		return cquantity;
	}
	public void setCquantity(Integer cquantity) {
		this.cquantity = cquantity;
	}
	public Integer getAprice() {
		return aprice;
	}
	public void setAprice(Integer aprice) {
		this.aprice = aprice;
	}
	public Integer getCprice() {
		return cprice;
	}
	public void setCprice(Integer cprice) {
		this.cprice = cprice;
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
