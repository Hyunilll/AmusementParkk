package com.ezen.world.dto;

import java.sql.Timestamp;

public class PassticketVO {
	private Integer ptseq;
	private Integer aprice;
	private Integer cprice;
	private Integer tprice;
	private Timestamp visitdate;
	private Integer aquantity;
	private Integer tquantity;
	private Integer cquantity;
	private Timestamp indate;
	
	
	public Integer getPtseq() {
		return ptseq;
	}
	public void setPtseq(Integer ptseq) {
		this.ptseq = ptseq;
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
	public Integer getTprice() {
		return tprice;
	}
	public void setTprice(Integer tprice) {
		this.tprice = tprice;
	}
	public Timestamp getVisitdate() {
		return visitdate;
	}
	public void setVisitdate(Timestamp visitdate) {
		this.visitdate = visitdate;
	}
	public Integer getAquantity() {
		return aquantity;
	}
	public void setAquantity(Integer aquantity) {
		this.aquantity = aquantity;
	}
	public Integer getTquantity() {
		return tquantity;
	}
	public void setTquantity(Integer tquantity) {
		this.tquantity = tquantity;
	}
	public Integer getCquantity() {
		return cquantity;
	}
	public void setCquantity(Integer cquantity) {
		this.cquantity = cquantity;
	}
	public Timestamp getIndate() {
		return indate;
	}
	public void setIndate(Timestamp indate) {
		this.indate = indate;
	}
	
	
}
