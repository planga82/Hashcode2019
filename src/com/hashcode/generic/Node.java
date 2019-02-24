package com.hashcode.generic;

import java.util.Iterator;
import java.util.Optional;

public interface Node {


    public int getWeigth();

    public boolean updateStateNextChild();

    public void rollBackState();

    public void printSolution(String fileName);

    public int numChilds();


}
