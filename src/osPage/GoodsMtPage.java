package osPage;

import java.sql.SQLException;
import java.util.Scanner;

import deal.*;
import entity.Goods;

public class GoodsMtPage {
	public void addGoods() {
		// TODO Auto-generated method stub
		GoodsMt gMt = new GoodsMt();
		boolean go = false;
		System.out.println("执行添加商品操作：");
		do {
			go = false;
			Scanner sc = new Scanner(System.in);
			System.out.println("添加商品名称：");
			String na = sc.nextLine();
			System.out.println("添加商品价格：");
			double p = sc.nextDouble();
			System.out.println("添加商品数量：");
			int nu = sc.nextInt();
			Goods good = new Goods(na, p, nu);
			boolean flag = gMt.add(good);
			if (flag == true) {
				System.out.println("\n\t!您已成功添加商品到数据库!");
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
		System.out.println("执行更改商品操作：");
		do {
			go = false;
			Scanner sc = new Scanner(System.in);
			System.out.println("输入更改商品名称：");
			String na = sc.nextLine();
			boolean flag = gMt.query(na);
			int gid = 0;
			if (flag) {
				System.out.println("商品名称\t商品价格\t商品数量");
				try {
					gid = gMt.rs.getInt(0);
					while (gMt.rs.next()) {
						System.out.println(gMt.rs.getString(1) + "\t" + gMt.rs.getInt(2) + "\t" + gMt.rs.getInt(3));
					}
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			} else {
				System.out.println("无此商品");
			}

			System.out.println("选择您要更改的内容：\n" + "1.更改商品名称\n" + "2.更改商品价格\n" + "3.更改商品数量\n");
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
				System.out.println("商品更新成功");
			}
			System.out.println("是否继续(y/n)");
			go = sc.next() == "y" ? true : false;
		} while (go);
	}

	public void deletGoods() {
		// TODO Auto-generated method stub

	}

	public void showAll() {
		// TODO Auto-generated method stub

	}

	public void queryGoods() {
		// TODO Auto-generated method stub

	}

}
