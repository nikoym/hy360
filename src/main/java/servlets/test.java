package servlets;

import com.google.gson.Gson;
import db.CS360DB;
import db.doctorService;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/test")
public class test extends HttpServlet {
    private Gson gson = new Gson();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            doctorService.getDoctor(68);
            resp.getWriter().print(gson.toJson(doctorService.getDoctor(68)));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
