package com.hashcode.slideshow;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Slide {

    public List<Photo> elements = new LinkedList<>();

    private List<String> getTags(){
        List<String> ret = new ArrayList<>();
        for(int x = 0; x < elements.size(); x++){
            ret.addAll(elements.get(0).tags);
        }
        return ret;
    }
    
    public Slide(Photo p) {
    	elements.add(p);
    }
    
    public Slide(Photo p, Photo p2) {
    	elements.add(p);
    	elements.add(p2);
    }

    public int getCoincidencias(Slide slide){
        List<String> tags = new LinkedList<>();
        List<String> tagsActual = new LinkedList<>();

        Iterator<Photo> it = slide.elements.iterator();
        while(it.hasNext()){
            tags.addAll(it.next().tags);
        }

        Iterator<Photo> it2 = this.elements.iterator();
        while(it2.hasNext()){
            tagsActual.addAll(it2.next().tags);
        }


        int num=0;
        for(String s: tags) {
            //To do: se puede optimizar la busqueda.
            if(tagsActual.contains(s)) {
                num++;
            }
        }

        return num;

    }


}
