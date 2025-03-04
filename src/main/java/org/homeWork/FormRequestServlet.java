package org.homeWork;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(name = "formRequestServlet", value = "/request-servlet")
public class FormRequestServlet extends HttpServlet {


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("nameInput").trim();
        String age = request.getParameter("ageInput").trim();

        if (name == null || name.isEmpty() || age == null || age.isEmpty()) {
            response.sendRedirect("/form/save-request.jsp");
        } else {
            request.setAttribute("name", name);
            request.setAttribute("age", age);

            getServletContext().getRequestDispatcher("/form/responseForm.jsp").forward(request,response);
        }

    }


}
