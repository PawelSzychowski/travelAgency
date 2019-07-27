package javagda21.servlets;

import javagda21.database.EntityDao;
import javagda21.model.Town;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/town/list")
public class ListTownServlet extends HttpServlet {
    EntityDao entityDao = new EntityDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Town> townList = entityDao.findAll(Town.class);
        req.setAttribute("townList", townList);
        req.getRequestDispatcher("/town/list.jsp").forward(req,resp);
    }
}
