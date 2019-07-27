package javagda21.servlets;

import javagda21.database.EntityDao;
import javagda21.model.Country;
import javagda21.model.Town;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/town/remove")
public class RemoveTownServlet extends HttpServlet {
    EntityDao entityDao = new EntityDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long position = Long.parseLong(req.getParameter("id"));
        entityDao.removeById(Town.class,position);
        resp.sendRedirect("/town/list");
    }
}
