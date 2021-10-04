package com.javatesting;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FindFirstSolutionThread {

    ExecutorService service = Executors.newFixedThreadPool(5);

    public static void main(String[] args) {
        FindFirstSolutionThread solution = new FindFirstSolutionThread();
        solution.findSolution("", "", 0);

    }

    public void findSolution(String s1, String s2, int max) {

        Solution sol1 = (a, b, c) -> solution1(a, b, c);
        Solution sol2 = (a, b, c) -> solution2(a, b, c);

        List<Future<Integer>> futureTasks = new ArrayList<Future<Integer>>();

        futureTasks.add(service.submit(new Callable<Integer>() {

            @Override
            public Integer call() throws Exception {
                // TODO Auto-generated method stub
                Integer sol = sol2.find(s1, s2, max);
                return sol;
            }
        }));

        futureTasks.add(service.submit(new Callable<Integer>() {

            @Override
            public Integer call() throws Exception {
                // TODO Auto-generated method stub
                Integer sol = sol1.find(s1, s2, max);
                return sol;
            }
        }));


        while (true) {
            boolean isDone = false;
            for (Future<Integer> task : futureTasks) {

                if (task.isDone()) {

                    futureTasks.forEach(tempTask -> {
                        if (tempTask != task)
                            tempTask.cancel(true);
                    });

                    isDone = true;
                    break;
                }

            }
            if (isDone)
                break;
        }

        for (Future<Integer> ans : futureTasks) {

            if (ans.isDone() && !ans.isCancelled()) {
                try {
                    System.out.println(ans.get());
                } catch (InterruptedException | ExecutionException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

        }

        service.shutdown();
    }

    public Integer solution1(String s1, String s2, int max) {
        try {
            System.out.println("solution1");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return 1;
    }

    public Integer solution2(String s1, String s2, int max) {
        try {
            System.out.println("solution2");
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return 1;
    }

}