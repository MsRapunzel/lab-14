/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.msrapunzel;

/**
 *
 * @author msrapunzel
 */

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.Future;

@WebServlet("/start-tasks")
public class AppServlet extends HttpServlet {

    @Inject
    ExecutorServiceExample executorServiceExample;

    @Inject
    ScheduledExecutorServiceExample scheduledExecutorServiceExample;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder result = new StringBuilder();
        
        Future<?> task1Future = executorServiceExample.executeTasks();

        scheduledExecutorServiceExample.scheduleTask();

        try {
            task1Future.get();
            result.append("Tasks has started. Check the console for the results.");
        } catch (Exception e) {
            result.append("Error: ").append(e.getMessage());
        }

        resp.getWriter().write(result.toString());
        
    }
}
