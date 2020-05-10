package infocare.servlet;

import infocare.dao.UserDao;
import infocare.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String username = request.getParameter("username");
			String password = request.getParameter("password");

			if (username == null || password == null) {
				request.getRequestDispatcher("/login.jsp").forward(request, response);
				return;
			}

			String ctxPath = request.getContextPath();
			UserDao ud = new UserDao();
			User u = ud.get(username, password);
			String indexPage = "/index";
			PrintWriter out = response.getWriter();
			if (u == null) {
				out.println("Username doesn't exist or password is not correct");
				out.close();
			} else {
				request.getSession().setAttribute("UserIsAuthenticated", true);
				URLEncoder.encode("Name","UTF-8");
				Cookie name = new Cookie("Name", u.getUsername());
				response.addCookie(name);
				response.sendRedirect(ctxPath + indexPage);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}
