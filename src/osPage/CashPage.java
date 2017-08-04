package osPage;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import deal.Cash;
import deal.GoodsMt;
import entity.GSales;
import entity.Goods;
import entity.SalesMan;

public class CashPage {

	public void cashing(Cash cash,int sid) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
//		Cash cash=new Cash();
		GoodsMt gMt=new GoodsMt();
		boolean flag=false;
		double sum=0;
		do {
			System.out.println("\t购物结算\n"
					+ "输入商品关键字");
			String s=scanner.nextLine();
			ArrayList<Goods> goodsList=gMt.query(s);
			if (goodsList==null||goodsList.size()<=0) {
				System.out.println("\n无商品");
			}
			else {
				System.out.println("\n商品名称\t商品价格\t商品数量\t备注");
				for (Goods goods : goodsList) {
					if (goods.getgNum()<10) {
						System.out.println(goods.getgName()+"\t"+goods.getgPrice()+"\t"+goods.getgNum()+"\t*该商品已不足10件");
					}
					else {
						System.out.println(goods.getgName()+"\t"+goods.getgPrice()+"\t"+goods.getgNum());
					}
					
				}
				System.out.println("\n\n");
			}
			System.out.println("请选择商品:");
			String gname=scanner.nextLine();
			System.out.println("请输入购买数量:");
			int gnum=scanner.nextInt();

			for (Goods goods : goodsList) {
				if (gname==goods.getgName()) {
					if (gnum<goods.getgNum()) {
						sum+=gnum*goods.getgPrice();
						System.out.println("\n商品名称\t商品价格\t购买数量\t总价");
						System.out.println(goods.getgName()+"\t"+goods.getgPrice()+"\t"+gnum+"\t"+sum);
						int gid=goods.getgID();
						
						Timestamp sdate=new Timestamp(new Date().getTime());
						GSales gsale=new GSales(gid,sid,gnum,sdate);
						if (cash.addGSales(gsale)) {
							System.out.println("\n销售情况已更新！");
						}
					}
					else {
						System.out.println("\n库存不足，请调整购买数量！");
					}
				}
			}

			
			
			System.out.println("\n是否继续(y/n)");
			flag=scanner.nextLine()=="y"?true:false;
		} while (flag);
		System.out.println("总计:"+sum);
		System.out.println("实际交费金额:");
		double sumCash=scanner.nextDouble();
		System.out.println("找零:"+(sumCash-sum)
				+"\n谢谢光临！");
	}

}
