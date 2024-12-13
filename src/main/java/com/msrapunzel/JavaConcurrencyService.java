/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.msrapunzel;

import jakarta.annotation.Resource;
import jakarta.enterprise.concurrent.ContextService;
import jakarta.enterprise.concurrent.ManagedExecutorService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 *
 * @author msrapunzel
 */

@Path("/api")
public class JavaConcurrencyService {
    @Resource
    ManagedExecutorService managedExecutorService;


    @GET
    @Path("managedExecuters")
    @Produces(MediaType.TEXT_PLAIN)
    public String getmanagedExecuters() throws InterruptedException, ExecutionException {
        Future future1 = managedExecutorService.submit(() -> {
            System.out.println("Job 1 running ...");
            System.out.println("Job 1 finished ...");
        });
        Future future2 = managedExecutorService.submit(() -> {
            System.out.println("Job 2 running ...");
            System.out.println("Job 2 finished ...");
        });
        future1.get(); 
        future2.get();
        System.out.println("Jobs completed");
        return "Jobs completed";
    }

}
