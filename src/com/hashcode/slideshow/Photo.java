package com.hashcode.slideshow;

import java.util.LinkedList;
import java.util.List;

public class Photo {

    List<String> tags = new LinkedList<>();
    boolean vertival;
    
    
   
    public int getCoincidencias(Photo p) {
    	int num=0;
    	for(String s: tags) {
    		//To do: se puede optimizar la busqueda.
    		if(p.tags.contains(s)) {
    			num++;
    		}
    	}
    	
    	return num;
    }

}
