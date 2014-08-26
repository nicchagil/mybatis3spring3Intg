package com.nicchagil.mybatis3spring3intg.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nicchagil.mybatis3spring3intg.bean.User;
import com.nicchagil.mybatis3spring3intg.service.UserService;
import com.nicchagil.util.SpringContextUtil;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		UserService service = (UserService)SpringContextUtil.getBean("userServiceImpl");
		
		if ("find".equals(action)) {
			User user = service.query(request.getParameter("username"));
			System.out.println(user.getUsername() + " - " + user.getPassword() + " - " + user.getChildhoodName());
			
		}
		
		if ("save".equals(action)) {
			User user = new User();
			user.setUsername(request.getParameter("username"));
			user.setPassword(request.getParameter("password"));
			
			service.save(user);
			System.out.println(user.getUsername() + " - " + user.getPassword());
			
		}
		
		if ("testTransaction".equals(action)) {
			User user1 = new User();
			user1.setUsername(request.getParameter("username"));
			user1.setPassword(request.getParameter("password"));
			
			User user2 = new User();
			user2.setUsername(request.getParameter("username") + " - Double");
			user2.setPassword(request.getParameter("password") + " - Double");
			
			service.testTransaction(user1, user2);
			System.out.println(user1.getUsername() + " - " + user1.getPassword());
			System.out.println(user2.getUsername() + " - " + user2.getPassword());
			
		}
		
	}

}
