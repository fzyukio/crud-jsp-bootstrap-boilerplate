package infocare.servlet;

import infocare.dao.TipDao;
import infocare.entity.Tip;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

@WebServlet("/get-tip")
public class GetTipServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean returnMsg = false;
		PrintWriter out = response.getWriter();

		try {
			Date start = Date.valueOf(request.getParameter("tipStart"));
			Date end = Date.valueOf(request.getParameter("tipEnd"));
			String content = request.getParameter("tipContent");

			Tip tip = new Tip(start, end, content);
			TipDao ld = new TipDao();
			boolean success = ld.add(tip);
			if (success) {
				returnMsg = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.println(returnMsg);
			out.close();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}
