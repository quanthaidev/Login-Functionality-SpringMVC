package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@RequestMapping(value = "/login")
	public ModelAndView loginAccount(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		// Dùng Spring core
//		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
//		StudentJDBCTemplate studentJDBCTemplate = (StudentJDBCTemplate) context.getBean("studentJDBCTemplate");

		
		//Dùng JDBC Spring MVC
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/shoppingdb");
		dataSource.setUsername("root");
		dataSource.setPassword("12345");

		StudentJDBCTemplate studentJDBCTemplate = new StudentJDBCTemplate();
		studentJDBCTemplate.setDataSource(dataSource);

		// Regex to make sure email are valid
		String regexEmail = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
		// Regex này dùng để check password phải gồm chữ hoa chữ thường, ký tự đặc biệt,
		// phải đủ 8 ký tự
		// String regexPassword =
		// "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";

		if (username != null && password != null) {
			if (username.trim().matches(regexEmail)) {
				System.out.println("1. Email dung syntax.");

				if (studentJDBCTemplate.countRecord(username.trim(), password) == 1) {
					System.out.println("Email va password deu match database: ");
					return new ModelAndView("confirmation", "username", username.toLowerCase());

				} else {
					System.out.println("Email hoac password ko match database: ");
					return new ModelAndView("login", "error", "Email and password are not available in database:");
				}

			} else {
				System.out.println("Email không đúng syntax");
				return new ModelAndView("login", "error", "Email and password must match syntax");
			}

		}


		return new ModelAndView("login", "error", "Please enter username and password");
	}

}

//ClassPathXmlApplicationContext ctx = (ClassPathXmlApplicationContext) context;
//ctx.close();
