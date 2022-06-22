package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/form-handler")
public class FormHandlerServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String finalText = "";

        // Get the value entered in the form.
        String textValue = request.getParameter("text-input");
        boolean phone = Boolean.parseBoolean(request.getParameter("phone"));
        boolean linkedin = Boolean.parseBoolean(request.getParameter("linkedin"));
        boolean handshake = Boolean.parseBoolean(request.getParameter("handshake"));
        boolean email = Boolean.parseBoolean(request.getParameter("email"));
        boolean other = Boolean.parseBoolean(request.getParameter("other"));

        if (phone == true) {
            finalText = "Phone Number: " + phone;
        } else if (linkedin == true) {
            finalText = "Linkedin: " + linkedin;
        } else if (handshake == true) {
            finalText = "Handshake: " + handshake;
        } else if (email == true) {
            finalText = "Email: " + email;
        }
        else if (other == true) {
            finalText = "Other: " + email;
        }

        // Respond with the result.
        response.setContentType("text/html;");
        response.getWriter().println("You submitted: " + textValue);
        System.out.println("Submission: " + finalText);

    }

    /**
     * @return the request parameter, or the default value if the parameter
     *         was not specified by the client
     */
    private String getParameter(HttpServletRequest request, String name, String defaultValue) {
        String value = request.getParameter(name);
        if (value == null) {
            return defaultValue;
        }
        return value;
    }
}