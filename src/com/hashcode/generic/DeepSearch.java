package com.hashcode.generic;


public class DeepSearch {
    private static DeepSearch ourInstance = null;

    private final int numNodesCommit = 10000;

    public static DeepSearch getInstance(Node initialNode, String fileName) {
        if(ourInstance == null){
            ourInstance = new DeepSearch(initialNode,fileName);
        }
            return ourInstance;
    }

    private Node processingNode;
    private String fileName;
    private int numNodesProcessed=0;

    private int bestSolution;

    private DeepSearch(Node initialNode,String fileName) {
        processingNode = initialNode;
        this.fileName=fileName;
    }


    public void execute() {
        if(!processingNode.updateStateNextChild()){
            printIfIsBestNode();
        }else{
            do{
                numNodesProcessed++;
                if (numNodesProcessed> numNodesCommit){
                    printIfIsBestNode();
                }
                execute();
                processingNode.rollBackState();
            }while(processingNode.updateStateNextChild());


        }
    }

    private synchronized void printIfIsBestNode() {
        if(processingNode.getWeigth() > bestSolution){
            processingNode.printSolution(fileName);
            bestSolution = processingNode.getWeigth();
        }
    }
}
