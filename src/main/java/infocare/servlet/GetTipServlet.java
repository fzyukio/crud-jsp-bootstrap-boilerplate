package infocare.servlet;

import infocare.dao.TipDao;
import infocare.entity.Tip;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonWriterFactory;
import javax.json.stream.JsonGenerator;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/get-tips")
public class GetTipServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String returnMsg = null;
		PrintWriter out = response.getWriter();

		try {
			TipDao tipDao = new TipDao();
			List<Tip> tips = tipDao.findTipsInEffectToday();
			if (tips != null) {
				JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();

				for (Tip tip : tips) {
					arrayBuilder.add(tip.getJsonObject());
				}
				JsonArray arr = arrayBuilder.build();

				Map<String, Boolean> config = new HashMap<>();
				config.put(JsonGenerator.PRETTY_PRINTING, true);
				JsonWriterFactory writerFactory = Json.createWriterFactory(config);

				try (Writer writer = new StringWriter()) {
					writerFactory.createWriter(writer).write(arr);
					returnMsg = writer.toString();
				}

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
