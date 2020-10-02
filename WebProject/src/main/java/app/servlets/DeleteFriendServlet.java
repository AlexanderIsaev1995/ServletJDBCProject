package app.servlets;

import app.jdbc.JDBC;
import lombok.SneakyThrows;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteFriendServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rD = req.getRequestDispatcher(
                "views/delete-friend.jsp");
        rD.forward(req, resp);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        JDBC jdbc = JDBC.getInstance();
        jdbc.connect();
        jdbc.deleteFriend(name);
        req.setAttribute("friendName", name);
        doGet(req, resp);
        jdbc.close();
    }
}