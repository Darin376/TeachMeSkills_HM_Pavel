package org.lessonWork;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "goodServlet", value = "/good-Servlet")
public class GoodServlet extends HttpServlet {
    private String message;



    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
       String strName = request.getParameter("nameInput");
       int secondNumber = Integer.parseInt(request.getParameter("ageInput"));
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      out.println(strName);
      out.println(secondNumber);

    }


}
