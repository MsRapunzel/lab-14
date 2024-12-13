/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.msrapunzel;

/**
 *
 * @author msrapunzel
 */
import jakarta.annotation.Resource;
import jakarta.enterprise.concurrent.ManagedScheduledExecutorService;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.concurrent.TimeUnit;

@ApplicationScoped
public class ScheduledExecutorServiceExample {

    @Resource
    ManagedScheduledExecutorService scheduledExecutorService;

    public void scheduleTask() {
        scheduledExecutorService.schedule(this::scheduledTask, 5, TimeUnit.SECONDS);
    }

    private void scheduledTask() {
        System.out.println("Planned task is done 5 seconds after.");
    }
}
