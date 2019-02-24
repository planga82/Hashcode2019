package com.hashcode.generic;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ParalellDeepSearch {

    ExecutorService poolExecutors;
    int numThreads;

    public ParalellDeepSearch(int numThreads) {
        poolExecutors = Executors.newFixedThreadPool(numThreads);
        this.numThreads = numThreads;
    }

    public void executeParallel( List<Node> initialNode,String fileName) throws InterruptedException {

        initialNode.forEach(node -> {
            int x = (int)(node.numChilds() * Math.random());
            for(int i =0; i< x; i++){
                node.updateStateNextChild();
                node.rollBackState();
            }
            poolExecutors.submit(new Runnable() {
                public void run() {
                    new DeepSearch(node,fileName).execute();
                }
            });

        });

        poolExecutors.shutdown();
        poolExecutors.awaitTermination(Long.MAX_VALUE, TimeUnit.MINUTES);


    }

}
