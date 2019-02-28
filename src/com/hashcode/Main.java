package com.hashcode;

import com.hashcode.generic.Node;
import com.hashcode.generic.ParalellDeepSearch;
import com.hashcode.pizza.model.PizzaEvolution;
import com.hashcode.pizza.model.Pizza;
import com.hashcode.pizza.model.Utils;
import com.hashcode.slideshow.PhotoCollection;

import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) throws Exception {
        String filename = "a_example";
        //String filename = "b_small";
        //String filename = "c_medium";
        //String filename = "d_big";
        //List<Node> branches = new ArrayList<>();
        //int numBranches = 10;
        //for(int i=0; i< numBranches; i++){
        //    branches.add(new PizzaEvolution(new Pizza()));
        //}

        //new ParalellDeepSearch(4).executeParallel(branches,filename);
        //new DeepSearch(n,filename).execute();

        PhotoCollection pc = new PhotoCollection(Utils.readFromFile("/home/pablo.langa/EntornoTrabajo/hashcode2019/Hashcode2019/"+ filename+".txt"));
        pc.toString();
    }
}
