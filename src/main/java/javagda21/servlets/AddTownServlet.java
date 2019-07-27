package javagda21.servlets;

import javagda21.database.EntityDao;
import javagda21.model.Country;
import javagda21.model.Town;

import javax.persistence.EntityNotFoundException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet("/town/add")
public class AddTownServlet extends HttpServlet {
    EntityDao entityDao = new EntityDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Country> countryList = entityDao.findAll(Country.class);
        req.setAttribute("countryList",countryList);
        req.getRequestDispatcher("/town/addTown.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String countryId = req.getParameter("country");
        Town town = new Town();
        Optional<Country> country = entityDao.findById(Country.class,Long.parseLong(countryId));
        if(country.isPresent()){
            town.setNazwa(name);
            town.setCountry(country.get());
            entityDao.saveOrUpdate(town);
        }else{
            System.err.println("Nie udało sie znaleźć państwa");
        }
        resp.sendRedirect("/town/add");
    }
}
