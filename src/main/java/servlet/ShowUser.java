package servlet;

import Repository.crud.UserRepository;
import Repository.users.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/show-user")
public class ShowUser extends HttpServlet {
    private UserRepository userRepository;

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            userRepository = new UserRepository();
        } catch (SQLException e) {
            throw new ServletException("Failed to initialize UserRepository", e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Получение всех пользователей из репозитория
            List<User> allUsers = userRepository.getAllUsers();

            // Установка атрибута для JSP
            request.setAttribute("all_users", allUsers);

            // Перенаправление на JSP
            getServletContext().getRequestDispatcher("/WEB-INF/showUser.jsp").forward(request, response);

        } catch (SQLException e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database error");
        }
    }

    @Override
    public void destroy() {
        if (userRepository != null) {
            userRepository.close();
        }
        super.destroy();
    }
}
