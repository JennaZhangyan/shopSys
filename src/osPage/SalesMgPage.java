package osPage;

import java.util.ArrayList;

import deal.SalesMg;
import entity.GSales;
import entity.Goods;

public class SalesMgPage {

	public void querySales() {
		// TODO Auto-generated method stub
		System.out.println("执行列出当日销售情况:"
				+ "\n今日售出商品:");
		SalesMg sales=new SalesMg();
		ArrayList<GSales> gsList=sales.showAll();
		
		if (gsList==null||gsList.size()<=0) {
			System.out.println("\n无销售记录");
		}
		else {
			System.out.println("\n商品名称\t商品价格\t商品数量\t销量\t备注");
			for (GSales gSales : gsList) {
				if (gSales.getgNum()<10) {
					System.out.println(gSales.getgName()+"\t"+gSales.getgPrice()+"\t"
							+gSales.getgNum()+"\t"+gSales.getsNum()+"\t*该商品已不足10件");
				}
				else {
					System.out.println(gSales.getgName()+"\t"+gSales.getgPrice()+"\t"+gSales.getgNum());
				}
			}
			System.out.println("\n\n");
		}
		
	}

	public void salesman() {
		// TODO Auto-generated method stub
		
	}

}
