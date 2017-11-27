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
		// ���ñ���
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// ��ȡ��֮�ͻ��˵���Ϣ
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
			// ��ȡ���������ɵ������
			// String code1 = (String) session.getAttribute("code");
			// ���бȽ����ѡ���Ƿ���Ե�¼
			if ("admin".equals(uname) && "123".equals(upwd) && code.equals(code2)) {
				request.setAttribute("uname", uname);
				request.setAttribute("mess", "���Ѿ���¼�ɹ�����");
				request.getRequestDispatcher("successful.jsp").forward(request, response);

			} else {
				request.setAttribute("mess", "����½ʧ�ܣ������µ�¼����");
				request.getRequestDispatcher("login.jsp").forward(request, response);

			}

			break;
		case "/code.do":
			// �����ж����������
			// ��ȡ����
			BufferedImage bufferedImage = new BufferedImage(60, 30, BufferedImage.TYPE_INT_BGR);
			// ��ȡpen
			Graphics graphics = bufferedImage.getGraphics();
			// ��������������������ɫ
			Random random = new Random();
			// ���û��ʵ���ɫ
			graphics.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
			// �����������ɫ
			graphics.drawRect(0, 0, 60, 30);

			// �����Զ���ķ��������������
			String string = creatRandom(4);
			// ��������
			graphics.setFont(new Font("����", Font.BOLD, 24));
			code2 = string;
			// ���Ʋ������ַ���
			graphics.drawString(string, 5, 25);
			// �������������
			response.setContentType("image/jpeg");
			// �ֽ������
			ServletOutputStream stream = response.getOutputStream();
			// ����������
			ImageIO.write(bufferedImage, "jpeg", stream);

			stream.close();

			break;

		}

	}

	private String creatRandom(int i) {
		String string = "qwertyuiopasdfghjklZxcbnm1234567890";
		String string2 = "";
		// ���������
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
