package osPage;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import deal.*;
import entity.Goods;

public class GoodsMtPage {
	public void addGoods() {
		// TODO Auto-generated method stub
		GoodsMt gMt = new GoodsMt();
		boolean go = false;
		System.out.println("执行添加商品操作\n");
		do {
			go = false;
			Scanner sc = new Scanner(System.in);
			System.out.println("添加商品名称：");
			String na = sc.nextLine();
			System.out.println("添加商品价格：");
			double p=0;
			do {
				p = sc.nextDouble();
				if (p<0) {
					System.out.println("输入错误");
				}
			} while (p<0);
			
			System.out.println("添加商品数量：");
			int nu = 0;
			do {
				nu = sc.nextInt();
				if (nu<0) {
					System.out.println("输入错误");
				}
			} while (nu<0);
			Goods good = new Goods(na, p, nu);
			boolean flag = gMt.add(good);
			if (flag == true) {
				System.out.println("\n!您已成功添加商品到数据库!");
			} else {
				System.out.println("添加商品失败");
			}

			System.out.println("是否继续(y/n)");
			go = sc.next() == "y" ? true : false;
		} while (go == true);
	}

	public void updateGoods() {
		// TODO Auto-generated method stub
		GoodsMt gMt = new GoodsMt();
		boolean go = false;
		System.out.println("执行更改商品操作\n");
		do {
			go = false;
			Scanner sc = new Scanner(System.in);
			System.out.println("输入更改商品名称：");
			String na = sc.nextLine();
			ArrayList<Goods> goodsList = gMt.query(na);
			if (goodsList==null||goodsList.size()<=0) {
				System.out.println("无此商品");
			}
			else {
				System.out.println("\n商品名称\t商品价格\t商品数量");
				for (Goods goods : goodsList) {
					System.out.println(goods.getgName()+"\t"+goods.getgPrice()+"\t"+goods.getgNum());
				}
			}
			int gid=goodsList.get(0).getgID();
//			int gid = 0;
//			if (flag) {
//				System.out.println("商品名称\t商品价格\t商品数量");
//				try {
//					gid = gMt.rs.getInt(0);
//					while (gMt.rs.next()) {
//						System.out.println(gMt.rs.getString(1) + "\t" + gMt.rs.getInt(2) + "\t" + gMt.rs.getInt(3));
//					}
//				} catch (Exception e) {
//					// TODO: handle exception
//					e.printStackTrace();
//				}
//			} else {
//				System.out.println("无此商品");
//			}

			System.out.println("\n选择您要更改的内容：\n" + "1.更改商品名称\n" + "2.更改商品价格\n" + "3.更改商品数量\n");
			int chose = sc.nextInt();
			boolean flag2=false;
			switch (chose) {
			case 1:
				System.out.println("请输入已更改商品名称");
				Goods goodsname = new Goods(gid, sc.nextLine());
				flag2=gMt.update(1, goodsname);
				break;
			case 2:
				System.out.println("请输入已更改商品价格");
				Goods goodsprice = new Goods(gid, sc.nextDouble());
				flag2=gMt.update(2, goodsprice);
				break;
			case 3:
				System.out.println("请输入已更改商品数量");
				Goods goodsnum = new Goods(gid, sc.nextInt());
				flag2=gMt.update(3, goodsnum);
				break;
			default:
				System.out.println("请输入正确的选择！");
				break;
			}
			if (flag2) {
				System.out.println("\n商品更新成功");
			}
			System.out.println("是否继续(y/n)");
			go = sc.next() == "y" ? true : false;
		} while (go);
	}

	public void deletGoods() {
		// TODO Auto-generated method stub
		System.out.println("执行删除商品操作\n");
		GoodsMt gMt = new GoodsMt();
		boolean go = false;
		do {
			System.out.println("\n输入删除的商品名称：");
			Scanner sc = new Scanner(System.in);
			String na = sc.nextLine();
			ArrayList<Goods> goodsList = gMt.query(na);
			if (goodsList==null||goodsList.size()<=0) {
				System.out.println("\n无此商品");
			}
			else {
				System.out.println("\n商品名称\t商品价格\t商品数量");
				for (Goods goods : goodsList) {
					System.out.println(goods.getgName()+"\t"+goods.getgPrice()+"\t"+goods.getgNum());
				}
			}
			int gid=goodsList.get(0).getgID();
//			boolean flag = gMt.query(na);
//			int gid = 0;
//			if (flag) {
//				System.out.println("商品名称\t商品价格\t商品数量");
//				try {
//					gid = gMt.rs.getInt(0);
//					while (gMt.rs.next()) {
//						System.out.println(gMt.rs.getString(1) + "\t" + gMt.rs.getInt(2) + "\t" + gMt.rs.getInt(3));
//					}
//				} catch (Exception e) {
//					// TODO: handle exception
//					e.printStackTrace();
//				}
//			} else {
//				System.out.println("无此商品");
//			}
			
			System.out.println("\n是否确定要删除(y/n)?:");
			boolean flag1=sc.next()=="y"?true:false;
			if (flag1) {
				Goods goodsdelet=new Goods(gid,na);
				boolean r=gMt.delet(goodsdelet);
				if (r) {
					System.out.println("商品删除成功");
				}
			}
			System.out.println("是否继续(y/n)");
			go = sc.next() == "y" ? true : false;
			
		} while (go);

	}

	public void showAll() {
		// TODO Auto-generated method stub
		System.out.println("显示所有商品\n");
		GoodsMt gMt = new GoodsMt();

		ArrayList<Goods> goodsList = gMt.queryAll();
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
//		int gid=goodsList.get(0).getgID();
//		if (flag) {
//			System.out.println("商品名称\t商品价格\t商品数量\t备注");
//			try {
//				while(gMt.rs.next()) {
//					if (gMt.rs.getInt(3)<10) {
//						System.out.println(gMt.rs.getString(1) + "\t" + gMt.rs.getInt(2) + "\t" + gMt.rs.getInt(3)+"\t*该商品已不足1件");
//					}
//					else {
//						System.out.println(gMt.rs.getString(1) + "\t" + gMt.rs.getInt(2) + "\t" + gMt.rs.getInt(3));
//					}
//					
//				}
//			} catch (Exception e) {
//				// TODO: handle exception
//				e.printStackTrace();
//			}	
//		}
	}

	public void queryGoods() {
		// TODO Auto-generated method stub
		System.out.println("执行查询商品操作\n");
		GoodsMt gMt = new GoodsMt();
		System.out.println("1.按商品数量升序查询\n"
				+ "2.按商品价格升序查询\n"
				+ "3.输入关键字查询商品\n"
				+ "请选择，输入数字或按0返回上一级菜单");
		ArrayList<Goods> goodsList=null;
		Scanner sc = new Scanner(System.in);
		int chose=sc.nextInt();
		switch (chose) {
		case 1:
			goodsList=gMt.query(1);
			break;
		case 2:
			goodsList=gMt.query(2);
			break;
		default:
			break;
		}
		if (goodsList==null||goodsList.size()<=0) {
			System.out.println("\n无此商品");
		}
		else {
			System.out.println("\n商品名称\t商品价格\t商品数量");
			for (Goods goods : goodsList) {
				System.out.println(goods.getgName()+"\t"+goods.getgPrice()+"\t"+goods.getgNum());
			}
		}
		System.out.println("\n\n");
	}

}
