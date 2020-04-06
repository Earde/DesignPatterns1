package com.company;

import com.company.Controllers.Controller;
import com.company.Models.Movie;
import com.company.Views.View;

public class Main {
    public static void main(String[] args) {
        View v = new View("Add Movies");
        Controller c = Controller.getInstance();
        c.initController(v);
    }
}
