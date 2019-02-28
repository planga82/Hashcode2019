package com.hashcode;

import java.util.LinkedList;
import java.util.List;

import com.hashcode.pizza.model.Utils;
import com.hashcode.slideshow.PhotoCollection;
import com.hashcode.slideshow.Slide;
import com.hashcode.slideshow.SlideShow;


public class Main {

    public static void main(String[] args) throws Exception {
        //String filename = "a_example";
        //String filename = "b_lovely_landscapes";
        //String filename = "c_memorable_moments";
        //String filename = "d_pet_pictures";
        String filename = "e_shiny_selfies";


        //List<Node> branches = new ArrayList<>();
        //int numBranches = 10;
        //for(int i=0; i< numBranches; i++){
        //    branches.add(new PizzaEvolution(new Pizza()));
        //}

        //new ParalellDeepSearch(4).executeParallel(branches,filename);
        //new DeepSearch(n,filename).execute();

        //PhotoCollection pc = new PhotoCollection(Utils.readFromFile("D:\\EclipseWorkspace\\HashCode"+ filename+".txt"));

        String outFile = "/home/pablo.langa/EntornoTrabajo/hashcode2019/Hashcode2019/"+ filename+".out";

        PhotoCollection pc = new PhotoCollection(Utils.readFromFile("/home/pablo.langa/EntornoTrabajo/hashcode2019/Hashcode2019/"+ filename+".txt"));
        SlideShow result = new HorizontalProcess().process(pc.getSlides(),outFile);

        result.write(outFile);

        pc.toString();
    }
}
