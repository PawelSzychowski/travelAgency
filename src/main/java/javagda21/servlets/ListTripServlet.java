package javagda21.servlets;

import javagda21.database.EntityDao;
import javagda21.model.Trip;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/trip/list")
public class ListTripServlet extends HttpServlet {
    EntityDao entityDao = new EntityDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Trip> tripList = entityDao.findAll(Trip.class);
        req.setAttribute("tripList",tripList);
        req.getRequestDispatcher("/trip/list.jsp").forward(req,resp);
    }
}
