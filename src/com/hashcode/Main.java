package com.hashcode;

import java.util.LinkedList;
import java.util.List;

import com.hashcode.pizza.model.Utils;
import com.hashcode.slideshow.PhotoCollection;
import com.hashcode.slideshow.Slide;


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

        PhotoCollection pc = new PhotoCollection(Utils.readFromFile("D:\\EclipseWorkspace\\HashCode\\"+ filename+".txt"));
        new HorizontalProcess().process(pc.getSlides());

        pc.toString();
    }
}
