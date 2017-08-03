package osPage;

import deal.*;
import sqlFile.*;
import java.io.IOException;
import java.util.Scanner;

public class MainPage {
	static Scanner scanner=new Scanner(System.in);
	
	public static void main(String[] args) throws IOException {
		
		
		do {
			System.out.println("******************************");
			System.out.println("\t1.商品维护");
			System.out.println("\t2.前台收银");
			System.out.println("\t3.商品管理");
			System.out.println("******************************");
			System.out.println("请选择，输入数字或按0退出");
			int c=scanner.nextInt();
			switch (c) {
			case 0:
				return;
			case 1:
				goodsMaintain();
				break;
			case 2:
				cashing();
				break;
			case 3:
				goodsManage();
				break;
			default:
				System.err.println("!输入有误!");
				System.out.println("重新选择或者按0退出.");
				break;
			}
		} while (true);
	}

	private static void goodsMaintain() {
		// TODO Auto-generated method stub
		do {
			System.out.println("执行显示商品维护菜单\n"
					+ "商超购物管理系统>>商品维护");
			System.out.println("********************************");
			System.out.println("\t1.添加商品\n"
					+ "\t2.更改商品\n"
					+ "\t3.删除商品\n"
					+ "\t4.显示所有商品\n"
					+ "\t5.添加商品");
			System.out.println("********************************");
			System.out.println("请选择，输入数字或按0返回上一级菜单");
			int chose=scanner.nextInt();
			
			GoodsMtPage gMtPage=new GoodsMtPage();
			switch (chose) {
			case 0:
				return;
			case 1:
				gMtPage.addGoods();
				break;
			case 2:
				gMtPage.updateGoods();
				break;
			case 3:
				gMtPage.deletGoods();
				break;
			case 4:
				gMtPage.showAll();
				break;
			case 5:
				gMtPage.queryGoods();
				break;
				
			default:
				break;
			}
		} while (true);
		
	}

	private static void cashing() throws IOException {
		// TODO Auto-generated method stub
		System.out.println("欢迎使用商超购物管理系统");
		System.out.println("\t1.登陆系统\n"
				+ "\t2.退出");
		System.out.println("********************************");
		System.out.println("请选择，输入数字：");
//		int chose=System.in.read();
		
		do {
			int chose=scanner.nextInt();
			switch (chose) {		
			case 1:
				Scanner sc=new Scanner(System.in);
				System.out.print("请输入用户名：");
				String userName=sc.nextLine();
				System.out.print("请输入密码：");
				String password=sc.nextLine();
				
				break;
			case 2:
				return;
			default:
				break;
			}

		} while (true);
		
	}

	private static void goodsManage() {
		// TODO Auto-generated method stub
		System.out.println("执行商品管理\n"
				+ "商超购物管理系统>>商品管理");
		System.out.println("********************************");
		System.out.println("\t1.列出当日卖出商品列表\n"
				+ "\t2.售货员管理");
		System.out.println("********************************");
		System.out.println("请选择，输入数字或按0返回上一级菜单");
		
		do {
			int chose=scanner.nextInt();
			switch (chose) {
			case 1:
				
				break;
			case 2:
				
				break;
			default:
				break;
			}
		} while (true);
		
	}
	
	
}
