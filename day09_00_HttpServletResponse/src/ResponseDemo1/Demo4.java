package ResponseDemo1;

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


public class Demo4 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		response.setHeader("pragma", "no-cache");
		response.setHeader("cache-control", "no-cache");
		response.setIntHeader("expires", 0);
		
		
		int width = 110;
		int height = 25;
		BufferedImage img = new BufferedImage(width, height , BufferedImage.TYPE_INT_RGB);
		
		
		Graphics g = img.getGraphics();
		
		
		g.setColor(Color.GRAY);
		g.drawRect(1, 1, width-2, height-2);
		
		
		g.setColor(Color.PINK);
		g.drawRect(0, 0, width-1, height-1);
		
		
		g.setFont(new Font("ËÎÌו", Font.BOLD|Font.ITALIC, 15));
		
		
		Random rand = new Random();
		int position = 20; 
		for (int i = 0; i < 4; i++){
			g.drawString(rand.nextInt(10)+"", position, 20);
			position+=20;
		}
		
		
		for (int i = 0; i < 5; i++) {
			g.drawLine(rand.nextInt(width), rand.nextInt(height), rand.nextInt(width), rand.nextInt(height));
		}
		
		
		
		ImageIO.write(img, "jpg", response.getOutputStream());
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
