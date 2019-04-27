package com.itheima.web.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 验证码
 * 
 * @author Diane
 *
 */
public class captcha extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int width = 200;
		int height = 30;

		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();

		// 画边框
		g.setColor(Color.black);
		g.fillRect(1, 1, width - 2, height - 2);

		// 填充颜色
		g.setColor(Color.gray);
		g.drawRect(0, 0, width, height);

		// 画干扰线
		Random r = new Random();
		g.setColor(Color.white);
		for (int i = 0; i < 5; i++) {
			g.drawLine(r.nextInt(width), r.nextInt(height), r.nextInt(width), r.nextInt(height));
		}

		Font f = new Font("宋体", Font.BOLD, 30); 
		
		// 验证内容
		g.setColor(Color.pink);
		int x = 30;
		String str = null;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 4; i++) {
			str = String.valueOf(r.nextInt(10));
			g.drawString(str, x, 15);
			x = x+30;
			sb.append(str);
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("scode", sb.toString());
		
		ImageIO.write(image, "jpg", response.getOutputStream());
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
