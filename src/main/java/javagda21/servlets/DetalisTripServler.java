package javagda21.servlets;

import javagda21.database.EntityDao;
import javagda21.model.Trip;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/trip/detalis")

public class DetalisTripServler extends HttpServlet {
        EntityDao entityDao = new EntityDao();
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            long position = Long.parseLong(req.getParameter("id"));
            Optional<Trip> trip = entityDao.findById(Trip.class,position);
            req.setAttribute("trip",trip);
            req.getRequestDispatcher("/trip/detalis.jsp").forward(req,resp);
        }
}
