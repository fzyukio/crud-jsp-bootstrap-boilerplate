package infocare.servlet;

import infocare.dao.TipDao;
import infocare.entity.Tip;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.util.List;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		try {
			TipDao tipDao = new TipDao();
			List<Tip> tips = tipDao.findAll();

			String ctxPath = request.getContextPath();

			request.setAttribute("submitTipUrl", ctxPath + "/add-tip");
			request.setAttribute("tips", tips);

			String indexPage = "/index.jsp";
			request.getRequestDispatcher(indexPage).forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		doPost(request, response);
	}
}
