package javagda21.servlets;

import javagda21.database.EntityDao;
import javagda21.model.Hotel;
import javagda21.model.Town;
import javagda21.model.Trip;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@WebServlet("/trip/add")
public class AddTripServlet extends HttpServlet {
    EntityDao entityDao = new EntityDao();
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Town> townList = entityDao.findAll(Town.class);
        List<Hotel> hotelList = entityDao.findAll(Hotel.class);
        req.setAttribute("townList",townList);
        req.setAttribute("hotelList",hotelList);
        req.getRequestDispatcher("/trip/add.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String dateOfDeparture = req.getParameter("dateOfDeparture");
        String dateOfArrive = req.getParameter("dateOfArrive");
        String townToId = req.getParameter("townTo");
        String townFromId = req.getParameter("townFrom");
        String hotelId = req.getParameter("hotel");
        String avibleSitsForAdult = req.getParameter("avibleSitsForAdult");
        String avibleSitesForKids = req.getParameter("avibleSitesForKids");

        Trip trip = new Trip();
        Optional<Hotel> hotel = entityDao.findById(Hotel.class,Long.parseLong(hotelId));
        Optional<Town> townTo = entityDao.findById(Town.class,Long.parseLong(townToId));
        Optional<Town> townFrom = entityDao.findById(Town.class,Long.parseLong(townFromId));
        if(townTo.isPresent() && townFrom.isPresent() && hotel.isPresent()){
            trip.setDateOfArrive(LocalDate.parse(dateOfArrive, formatter));
            trip.setDateOfDeparture(LocalDate.parse(dateOfDeparture, formatter));
            trip.setAvibleSitesForKids(Integer.parseInt(avibleSitesForKids));
            trip.setAvibleSitsForAdult(Integer.parseInt(avibleSitsForAdult));
            trip.setFrom(townFrom.get());
            trip.setTo(townTo.get());
            trip.setHotel(hotel.get());
            trip.setPromoted(req.getParameter("toCorrect") == null ? false : req.getParameter("promoted").equalsIgnoreCase("on"));
            entityDao.saveOrUpdate(trip);
        }
        else{
            System.err.println("coś poszło nie tak :(");
        }
        resp.sendRedirect("/trip/add");
    }
}
