package com.mg.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mg.entity.User;
import com.mg.service.UserService;
import com.mg.service.impl.UserServiceImpl;

/**
 * Servlet implementation class ActiveServlet
 */
@WebServlet("/ActiveServlet")
public class ActiveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ActiveServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		// 接受激活码
		String code = request.getParameter("code");
		// 根据激活码查询用户
		UserService userService = new UserServiceImpl();
		try {
			User user = userService.findByCode(code);
			if (user != null) {
				// 已经查询到,修改用户的状态
				user.setState(1);// 状态码为空表示已经激活
				user.setCode(null);
				userService.update(user);
				request.setAttribute("msg", "你已激活成功,请去登录");
			} else {
				// 根据激活码没有查询到用户
				request.setAttribute("msg", "你的激活码有误,请重新激活");
			}
			//页面跳转
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
