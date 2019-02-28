package com.hashcode.slideshow;

import java.util.LinkedList;
import java.util.List;

public class PhotoCollection {

    List<Photo> photos = new LinkedList<>();

    public PhotoCollection(List<String> fileLines){
        int numPhotos = Integer.parseInt(fileLines.get(0));

        for(int x = 1; x<= numPhotos; x++){

            Photo p = new Photo();

            String line =  fileLines.get(x);
            String[] elements = line.split(" ");
            String vertical = elements[0];
            p.vertival = vertical.equals("V");

            int numTags = Integer.parseInt(elements[1]);
            for(int i = 0; i< numTags; i++){
                Tag tag = new Tag();
                tag.text = elements[2+i];
                p.tags.add(tag);
            }

            photos.add(p);
        }
    }
}
