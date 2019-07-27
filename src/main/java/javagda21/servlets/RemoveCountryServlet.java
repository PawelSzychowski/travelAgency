package javagda21.servlets;

import javagda21.database.EntityDao;
import javagda21.model.Country;
import javagda21.model.Country;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/country/remove")
public class RemoveCountryServlet extends HttpServlet {
    EntityDao entityDao = new EntityDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long position = Long.parseLong(req.getParameter("id"));
        entityDao.removeById(Country.class,position);
        resp.sendRedirect("/country/list");
    }
}
