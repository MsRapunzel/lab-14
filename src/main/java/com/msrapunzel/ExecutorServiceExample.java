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
import jakarta.enterprise.concurrent.ManagedExecutorService;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.concurrent.Future;

@ApplicationScoped
public class ExecutorServiceExample {

    @Resource
    ManagedExecutorService executorService;

    public Future<?> executeTasks() {
        Future<?> task1Future = executorService.submit(this::taskOne);

        executorService.submit(this::taskTwo);

        return task1Future;
    }

    private void taskOne() {
        try {
            Thread.sleep(2000);
            System.out.println("Task 1 is done");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void taskTwo() {
        try {
            Thread.sleep(3000);
            System.out.println("Task 2 is done");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
