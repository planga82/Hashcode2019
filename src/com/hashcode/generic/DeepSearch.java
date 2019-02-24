package com.hashcode.generic;


public class DeepSearch {

    private final int numNodesCommit = 10000;

    private Node processingNode;
    private String fileName;
    private int numNodesProcessed=0;

    private int bestSolution;

    public DeepSearch(Node initialNode,String fileName) {
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
                    numNodesProcessed=0;
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
