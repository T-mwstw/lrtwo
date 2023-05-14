package com.example.untitled8;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.*;
import java.nio.file.*;
import com.google.gson.*;

@WebServlet("/OutputServlet")
public class OutputServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServletContext sc = getServletContext();
        sc.getRequestDispatcher("/jsp/outputUsers.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String path = "C:\\Program Files (x86)\\Apache Software Foundation\\Tomcat 9.0\\webapps\\untitled8_war_exploded\\json\\data.json";

        Gson gson = new Gson();
        Reader reader = Files.newBufferedReader(Paths.get(path));
        User[] usere = gson.fromJson(reader, User[].class);
        String jsonData = gson.toJson(usere);
        reader.close();

        PrintWriter out=response.getWriter();
        out.println(jsonData);
    }
}
