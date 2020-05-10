package infocare.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import infocare.dao.TipDao;
import infocare.entity.Tip;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/findlog")
public class GetLogServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            TipDao tipDao = new TipDao();
            List<Tip> list = tipDao.findAll();
            PrintWriter out = response.getWriter();

            JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd";
            String json= JSON.toJSONString(list, SerializerFeature.WriteDateUseDateFormat);
            out.println(json);
            out.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
