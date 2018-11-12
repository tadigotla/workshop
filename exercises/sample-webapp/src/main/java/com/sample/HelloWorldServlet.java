package com.sample;

// Import required java libraries
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

// Extend HttpServlet class
public class HelloWorldServlet extends HttpServlet {

   private String message;

   public void init() throws ServletException {
      // Do required initialization
      message = "Hello World! It is  Monday today!!";
   }

   public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

          System.out.println("Writing to Standard Out");

      // Set response content type
      response.setContentType("application/json");
    //   response.setContentType("text/html");

      // Actual logic goes here.
      PrintWriter out = response.getWriter();
    //   out.println("<h1>" + message + "</h1>");
      out.println("{\"test\":\"anyting\"}");
   }

   public void destroy() {
      // do nothing.
   }
}