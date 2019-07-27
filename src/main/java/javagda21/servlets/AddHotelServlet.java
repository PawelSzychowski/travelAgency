package javagda21.servlets;

import javagda21.database.EntityDao;
import javagda21.model.Hotel;
import javagda21.model.Town;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet("/hotel/add")
public class AddHotelServlet extends HttpServlet {
    EntityDao entityDao = new EntityDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Town> townList = entityDao.findAll(Town.class);
        req.setAttribute("townList",townList);
        req.getRequestDispatcher("/hotel/add.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String standard = req.getParameter("standard");
        String discription = req.getParameter("discription");
        String townId = req.getParameter("town");
        Hotel hotel = new Hotel();
        Optional<Town> town = entityDao.findById(Town.class,Long.parseLong(townId));
        if(town.isPresent()){
            hotel.setName(name);
            hotel.setDiscription(discription);
            hotel.setStandard(Integer.parseInt(standard));
            hotel.setTown(town.get());
            entityDao.saveOrUpdate(hotel);
        }
        else{
            System.err.println("Nie znaleziona miasta");
        }
        resp.sendRedirect("/hotel/add");
    }
}
