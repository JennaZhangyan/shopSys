package entity;

public class Goods {
	private int gID;
	private String gName;
	private double gPrice;
	private int gNum; 
	
	public Goods() {
		// TODO Auto-generated constructor stub
	}
	public Goods(int gid,String name,Double price,int num) {
		// TODO Auto-generated constructor stub
		this.gID=gid;
		this.gName=name;
		this.gPrice=price;
		this.gNum=num;
	}
	
	public Goods(String name, double price, int num) {
		// TODO Auto-generated constructor stub
		this.gName=name;
		this.gPrice=price;
		this.gNum=num;
	}
	
	public Goods(int gid, String nextLine) {
		// TODO Auto-generated constructor stub
		this.gID=gid;
		this.gName=nextLine;
	}
	
	public Goods(int gid, int nextInt) {
		// TODO Auto-generated constructor stub
		this.gID=gid;
		this.gNum=nextInt;
	}
	
	public Goods(int gid, double nextDouble) {
		// TODO Auto-generated constructor stub
		this.gID=gid;
		this.gPrice=nextDouble;
	}

	
	
	
	
	
	public int getgID() {
		return gID;
	}
	public void setgID(int gID) {
		this.gID = gID;
	}
	public String getgName() {
		return gName;
	}
	public void setgName(String gName) {
		this.gName = gName;
	}
	public double getgPrice() {
		return gPrice;
	}
	public void setgPrice(int gPrice) {
		this.gPrice = gPrice;
	}
	public int getgNum() {
		return gNum;
	}
	public void setgNum(int gNum) {
		this.gNum = gNum;
	}
	
}
