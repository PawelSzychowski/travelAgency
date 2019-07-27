package javagda21.servlets;

import javagda21.database.EntityDao;
import javagda21.model.Country;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/country/list")
public class ListCountryServlet extends HttpServlet {
    EntityDao entityDao = new EntityDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Country> countryList = entityDao.findAll(Country.class);
        req.setAttribute("country",countryList);
        req.getRequestDispatcher("/country/list.jsp").forward(req,resp);
    }
}
