package com.hashcode.generic;


public class DeepSearch {
    private static DeepSearch ourInstance = null;

    public static DeepSearch getInstance(Node initialNode, String fileName) {
        if(ourInstance == null){
            ourInstance = new DeepSearch(initialNode,fileName);
        }
            return ourInstance;
    }

    private Node processingNode;
    private String fileName;

    private int bestSolution;

    private DeepSearch(Node initialNode,String fileName) {
        processingNode = initialNode;
        this.fileName=fileName;
    }


    public void execute() {
        System.out.println("Next level");
        if(!processingNode.updateStateNextChild()){
            System.out.println("Solution found - " + processingNode.getWeigth());
            printIfIsBestNode();
        }else{
            do{
                execute();
                processingNode.rollBackState();
                System.out.println("Next child");
            }while(processingNode.updateStateNextChild());


        }
    }

    private synchronized void printIfIsBestNode() {
        if(processingNode.getWeigth() >= bestSolution){
            processingNode.printSolution(fileName);
            bestSolution = processingNode.getWeigth();
        }
    }
}
