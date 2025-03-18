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
@WebServlet("/update-user")
public class UpdateUser extends HttpServlet {
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
        String idParam = request.getParameter("id");
        String newName = request.getParameter("newName");

        // Проверка параметров
        if (idParam == null || idParam.isEmpty() || newName==null || newName.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing or invalid parameters");
            return;
        }

        try {
            int idUser = Integer.parseInt(idParam);

            // Удаление пользователя в репозитории
            userRepository.updateUserLogin(idUser,newName);

            // Перенаправление на страницу со списком пользователей

            response.sendRedirect(request.getContextPath() + "/show-user");


        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid 'id' parameter");
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An unexpected error occurred");
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
