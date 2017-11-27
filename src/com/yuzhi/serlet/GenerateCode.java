package com.yuzhi.serlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GenerateCode
 */
@WebServlet("*.do")
public class GenerateCode extends HttpServlet {
	private String code2;
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GenerateCode() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// 获取来之客户端的信息
		String servletPath = request.getServletPath();
		System.out.println(servletPath);
		switch (servletPath) {
		case "/login.do":
			String uname = request.getParameter("uname");
			System.out.println(uname);
			String upwd = request.getParameter("upwd");
			System.out.println(upwd);
			String code = request.getParameter("vcode");
			System.out.println(code);
			HttpSession session = request.getSession();
			System.out.println(code2);
			// 获取服务器生成的随机码
			// String code1 = (String) session.getAttribute("code");
			// 进行比较最后选择是否可以登录
			if ("admin".equals(uname) && "123".equals(upwd) && code.equals(code2)) {
				request.setAttribute("uname", uname);
				request.setAttribute("mess", "您已经登录成功。。");
				request.getRequestDispatcher("successful.jsp").forward(request, response);

			} else {
				request.setAttribute("mess", "您登陆失败，请重新登录。。");
				request.getRequestDispatcher("login.jsp").forward(request, response);

			}

			break;
		case "/code.do":
			// 进行判读生成随机数
			// 获取画板
			BufferedImage bufferedImage = new BufferedImage(60, 30, BufferedImage.TYPE_INT_BGR);
			// 获取pen
			Graphics graphics = bufferedImage.getGraphics();
			// 设置随机数，随机产生颜色
			Random random = new Random();
			// 设置画笔的颜色
			graphics.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
			// 给画布添加颜色
			graphics.drawRect(0, 0, 60, 30);

			// 调用自定义的方法来产生随机数
			String string = creatRandom(4);
			// 设置字体
			graphics.setFont(new Font("黑体", Font.BOLD, 24));
			code2 = string;
			// 绘制产生的字符串
			graphics.drawString(string, 5, 25);
			// 设置输出的内容
			response.setContentType("image/jpeg");
			// 字节输出流
			ServletOutputStream stream = response.getOutputStream();
			// 输出的输出流
			ImageIO.write(bufferedImage, "jpeg", stream);

			stream.close();

			break;

		}

	}

	private String creatRandom(int i) {
		String string = "qwertyuiopasdfghjklZxcbnm1234567890";
		String string2 = "";
		// 产生随机数
		Random random = new Random();
		for (int j = 0; j < i; j++) {
			string2 += string.charAt(random.nextInt(string.length()));

		}

		return string2;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
