package entity;

public class SalesMan {
	private int sID;
	private String sPassWord;
	private String sName;
	
	public SalesMan() {
		// TODO Auto-generated constructor stub
	}
	public SalesMan(String name,String pass) {
		this.sName=name;
		this.sPassWord=pass;
	}
	public SalesMan(int id,String name,String pass) {
		this.sID=id;
		this.sName=name;
		this.sPassWord=pass;
	}
	
	public int getsID() {
		return sID;
	}
	public void setsID(int sID) {
		this.sID = sID;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getsPassWord() {
		return sPassWord;
	}
	public void setsPassWord(String sPassWord) {
		this.sPassWord = sPassWord;
	}
}
