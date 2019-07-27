package javagda21.servlets;

import javagda21.database.EntityDao;
import javagda21.model.Continent;
import javagda21.model.Country;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/country/add")
public class AddCountryServlet extends HttpServlet {
    EntityDao entityDao = new EntityDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/country/add.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        Country country = new Country();
        country.setNazwa(name);
        country.setContinent(Continent.valueOf(req.getParameter("continent")));
        entityDao.saveOrUpdate(country);
        resp.sendRedirect("/country/add");


    }
}
