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
@WebServlet("/create-user")
public class CreateUser extends HttpServlet {

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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String age = request.getParameter("age");
        String last_name = request.getParameter("last_name");
        String first_name = request.getParameter("first_name");

        // Проверка параметров
        if (first_name == null || first_name.isEmpty() ||
                last_name == null || last_name.isEmpty() ||
                age == null || age.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing or invalid parameters");
            return;
        }

        try {
            int ageUser = Integer.parseInt(age);
            User newUser = new User(first_name, last_name, ageUser);

            // Сохранение пользователя в репозитории
            userRepository.createUser(newUser);

            // Установка атрибутов для JSP
            request.setAttribute("first_name", first_name);
            request.setAttribute("last_name", last_name);
            request.setAttribute("age", age);

            // Перенаправление на JSP
//            getServletContext().getRequestDispatcher("/WEB-INF/createUser.jsp").forward(request, response);
            response.sendRedirect(request.getContextPath() + "/show-user");

        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid 'age' parameter");
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