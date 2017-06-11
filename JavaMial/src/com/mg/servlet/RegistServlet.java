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
import com.mg.utils.UUIDUtils;

/**
 * 用户注册的servlet
 * 
 * @author sky_mg 2017年6月11日上午11:10:40 TODO
 */
@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// 中文乱码处理
			request.setCharacterEncoding("UTF-8");
			// 1.接收数据
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String nickname = request.getParameter("nickname");
			String email = request.getParameter("email");
			// 封装数据
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			user.setNickname(nickname);
			user.setEmail(email);
			user.setState(0); // 0:用户未激活;1:用户激活
			// 产生64位激活码
			String code = UUIDUtils.getUUID() + UUIDUtils.getUUID();
			user.setCode(code);

			// 3.业务层处理数据
			// 面向接口方式
			UserService userService = new UserServiceImpl();
			userService.regist(user);
			// 4.页面跳转
			request.setAttribute("msg", "你已注册成功,请去邮箱激活");
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
