package com.sample;

import java.util.List;
import java.util.ArrayList;
// Import required java libraries
import java.io.*;
import java.util.Map;
import javax.servlet.*;
import javax.servlet.http.*;
import org.json.JSONObject;

// Extend HttpServlet class
public class HelloWorldServlet extends HttpServlet {

    private String message;

    public void init() throws ServletException {
        // Do required initialization
        message = "Hello World! It is  Monday today!!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("The query string is: " + request.getQueryString());
        String queryString = request.getQueryString();

        java.lang.String[] params = queryString.split("&");
        String fileName = "";

        for(int i = 0; i < params.length; i++){
            System.out.println("param: " + params[i]);

            String[] variables = params[i].split("=");
            System.out.println("Variable "+ variables[0] + " has value of "+ variables[1]);
            if(variables[0].equalsIgnoreCase("fileName")){
                fileName = variables[1];
            }
        }

        System.out.println("Found value for fileName " + fileName);

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        Map<String, Object> excelData = ExcelReader.readExcel(new File("/projects/workshop/"+fileName));
        System.out.println("After reading excel data");
        //out.println("{\"Hello\":\"World\"}");

        JSONObject json = new JSONObject();

        for(Map.Entry<String, Object> entry: excelData.entrySet()){
            json.put(entry.getKey(), String.valueOf(entry.getValue()));
        }

        out.println(json.toString());
    }

    public void destroy() {
        // do nothing.
    }
}