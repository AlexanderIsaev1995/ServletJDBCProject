package app.servlets;

import app.jdbc.JDBC;
import lombok.SneakyThrows;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class FriendListServlet extends HttpServlet {
    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JDBC jdbc = JDBC.getInstance();
        jdbc.connect();
        List<String> friends = jdbc.getAll();
        req.setAttribute("friendsNames", friends);
        RequestDispatcher rD = req.getRequestDispatcher(
                "views/friend-list.jsp");
        rD.forward(req, resp);
        jdbc.close();
    }
}
