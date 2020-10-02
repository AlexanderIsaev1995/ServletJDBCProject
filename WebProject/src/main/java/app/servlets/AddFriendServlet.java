package app.servlets;

import app.entites.Friend;
import app.jdbc.JDBC;
import lombok.SneakyThrows;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddFriendServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rD = req.getRequestDispatcher(
                "views/add-friend.jsp");
        rD.forward(req, resp);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        String password = req.getParameter("pass");
        Friend friend = new Friend(name, password);
        JDBC jdbc = JDBC.getInstance();
        jdbc.connect();
        jdbc.add(friend);
        jdbc.close();

        req.setAttribute("friendName", name);
        doGet(req, resp);

    }
}
