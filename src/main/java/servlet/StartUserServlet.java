package servlet;

import Repository.crud.UserRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet("/start")
public class StartUserServlet extends HttpServlet {
    private UserRepository userRepository;

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("GetUserServlet init");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = "Pavel";
        String age = "29";

        request.setAttribute("name", name);
        request.setAttribute("age", age);
        getServletContext().getRequestDispatcher("/WEB-INF/responseForm.jsp").forward(request, response);

    }
}