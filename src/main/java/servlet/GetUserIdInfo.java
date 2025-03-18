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

@WebServlet("/get-user")
public class GetUserIdInfo extends HttpServlet {

    private UserRepository userRepository;

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            userRepository = new UserRepository();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParam = request.getParameter("id");
        if (idParam == null || idParam.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing or invalid 'id' parameter");
            return;
        }

        try {
            int idUser = Integer.parseInt(idParam);
            User userInfo = userRepository.getUserById(idUser);

            if (userInfo == null) {
                String errorid = "Такого ID юзера нету введите другой ID";
                request.setAttribute("error", errorid);
                getServletContext().getRequestDispatcher("/WEB-INF/errorPage.jsp").forward(request, response);
            }

            request.setAttribute("first_name", userInfo.getFirst_name());
            request.setAttribute("last_name", userInfo.getLast_name());
            request.setAttribute("age", userInfo.getAge());
            request.setAttribute("id", idUser);

            getServletContext().getRequestDispatcher("/WEB-INF/userInfoId.jsp").forward(request, response);

        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid 'id' parameter");
        } catch (SQLException e) {
            log("SQL error occurred: " + e.getMessage(), e);
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Internal server error");
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