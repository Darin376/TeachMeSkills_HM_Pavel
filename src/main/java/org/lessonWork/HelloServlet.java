package org.lessonWork;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        request.setAttribute("name", name);
        request.setAttribute("str", 233);
        List<String> strList = new ArrayList<String>();
        strList.add("Oleg");
        strList.add("Ilya");
        request.setAttribute("strList", strList);
        String[] users = new String[]{"tom","vilka","slonyara"};
        request.setAttribute("users", users);
        request.setAttribute("isVisible", true);
        request.setAttribute("val", 2);
//        response.setContentType("text/html");
//
//        // Hello
//        PrintWriter out = response.getWriter();
//        out.println("<html><body>");
//        out.println("<h1>" + message + "</h1>");
//        out.println("</body></html>");
        getServletContext().getRequestDispatcher("/WEB-INF/hello.jsp").forward(request,response);
    }

    public void destroy() {
    }
}