package javagda21.servlets;

import javagda21.database.EntityDao;
import javagda21.model.Hotel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/hotel/list")
public class ListHotelServlet extends HttpServlet {
    EntityDao entityDao = new EntityDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Hotel> hotelList = entityDao.findAll(Hotel.class);
        req.setAttribute("hotelList",hotelList);
        req.getRequestDispatcher("/hotel/list.jsp").forward(req,resp);
    }
}
