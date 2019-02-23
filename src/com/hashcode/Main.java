package com.hashcode;

import com.hashcode.generic.DeepSearch;
import com.hashcode.generic.Node;
import com.hashcode.imp.model.PizzaEvolution;
import com.hashcode.imp.model.Pizza;
import com.hashcode.imp.model.Utils;


public class Main {

    public static void main(String[] args) throws Exception {
        //String filename = "a_example";
        //String filename = "b_small";
        //String filename = "c_medium";
        String filename = "d_big";
        Node n = new PizzaEvolution(new Pizza(Utils.readFromFile("/home/pablo.langa/EntornoTrabajo/hashcode2019/Hashcode2019/"+ filename+".in")));
        DeepSearch.getInstance(n,filename).execute();
    }
}
