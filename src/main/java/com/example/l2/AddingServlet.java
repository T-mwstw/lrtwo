package com.example.untitled8;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;

import com.google.gson.*;


class GFG {
    String name;
    String poroda;
    String age;
    String color;
    String warning;

    public GFG() {
        this.name = "";
        this.poroda = "";
        this.age = "";
        this.color= 0;
        this.warning = "";
    }
}

class User {
    private String name;
    private String poroda;
    private Integer age;
    private String color;
    private String warning;

    public User(String name, String poroda, Integer age, Integer color, String warning) {
        this.name = name;
        this.poroda = poroda;
        this.age = age;
        this.color = color;
        this.warning = warning;
    }
}
@WebServlet("/AddingServlet")
public class AddingServlet extends HttpServlet {
    ArrayList<User> user = new ArrayList<>();
    Integer i = 0;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServletContext sc = getServletContext();
        sc.getRequestDispatcher("/jsp/addUserss.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        GFG gfg;
        response.setContentType("application/json");
        String data = request.getParameter("data");
        String path = "C:\\Program Files (x86)\\Apache Software Foundation\\Tomcat 9.0\\webapps\\untitled8_war_exploded\\json\\data.json";

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        gfg = gson.fromJson(data, GFG.class);
        String name = gfg.name;
        String poroda = gfg.poroda;
        Integer age = gfg.age;
        String color = gfg.color;
        String warning = gfg.warning;

        User users = new User(name, poroda, age, color, warning);
        user.add(users);
        gson.toJson(user);

        try {
            Files.write(Paths.get(path), gson.toJson(user).getBytes());
        }catch (IOException e) {

        }
    }
}
