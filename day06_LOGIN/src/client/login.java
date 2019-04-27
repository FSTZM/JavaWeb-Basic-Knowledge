package client;

import java.util.Scanner;

import entity.User;
import service.Dologin;

public class login {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		
		System.out.println("请输入用户名：");
		String name = input.nextLine();
		
		System.out.println("请输入密码：");
		String password = input.nextLine();
		
		Dologin d = new Dologin();
		User user = d.findUser(name, password);
		if(user!=null){
			System.out.println("欢迎━(*｀∀´*)ノ："+user.getName());
		}else{
			System.out.println("用户名或密码错误！");
		}
		


	}

}
