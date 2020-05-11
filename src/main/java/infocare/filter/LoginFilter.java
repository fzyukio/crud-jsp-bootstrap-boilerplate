package infocare.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("*")
public class LoginFilter implements Filter {
	private static final String loginServlet = "/login";
	private static final String getTipsServlet = "/get-tips";

	public void destroy() {
	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;

		String requestedUri = request.getRequestURI();
		String ctxPath = request.getContextPath();
		String targetURL = requestedUri.substring(ctxPath.length());

		if(targetURL.matches(".*(css|jpg|png|gif|js)")){
			chain.doFilter(request, response);
			return;
		}

		if (getTipsServlet.equalsIgnoreCase(targetURL)) {
			chain.doFilter(request, response);
			return;
		}

		if (loginServlet.equalsIgnoreCase(targetURL)) {
			chain.doFilter(request, response);
			return;
		}

		HttpSession session = request.getSession(false);
		boolean userIsAuthenticated = false;
		if (session != null) {
			Object o = session.getAttribute("UserIsAuthenticated");
			if (o != null) {
				userIsAuthenticated = (boolean) o;
			}
		}

		if (!userIsAuthenticated) {
			response.sendRedirect(ctxPath + loginServlet);
		} else {
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig config) throws ServletException {

	}

}
