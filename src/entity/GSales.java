package entity;

import java.sql.Timestamp;

public class GSales {
	private int gsID;
	private int gID;
	private int sID;
	private int sNum;
	private Timestamp sDate;
	
	private String gName;
	private String gPrice;
	private int gNum;
	
	public GSales() {
		// TODO Auto-generated constructor stub
	}
	public GSales(int num,Timestamp date) {
		this.sNum=num;
		this.sDate=date;
	}
	public GSales(int gid, int sid, int gnum, Timestamp sdate) {
		// TODO Auto-generated constructor stub
		this.gID=gid;
		this.sID=sid;
		this.sNum=gnum;
		this.sDate=sdate;
	}
//	public GSales(int gid, int sid, int gnum,Goods good) {
//		// TODO Auto-generated constructor stub
//		this.gID=gid;
//		this.sID=sid;
//		this.sNum=gnum;
//		this.good=good;
//	}
	
	public GSales(String gname2, double gprice2, int gnum2, int snum2) {
		// TODO Auto-generated constructor stub
	}
	public int getGsID() {
		return gsID;
	}
	public void setGsID(int gsID) {
		this.gsID = gsID;
	}
	public int getgID() {
		return gID;
	}
	public void setgID(int gID) {
		this.gID = gID;
	}
	public int getsID() {
		return sID;
	}
	public void setsID(int sID) {
		this.sID = sID;
	}
	public int getsNum() {
		return sNum;
	}
	public void setsNum(int sNum) {
		this.sNum = sNum;
	}
	public Timestamp getsDate() {
		return sDate;
	}
	public void setsDate(Timestamp sDate) {
		this.sDate = sDate;
	}
	public String getgName() {
		return gName;
	}
	public String getgPrice() {
		return gPrice;
	}
	public int getgNum() {
		return gNum;
	}
	
}
