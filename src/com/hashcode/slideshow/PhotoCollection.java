package com.hashcode.slideshow;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class PhotoCollection {

	List<Photo> photos = new LinkedList<>();

	public PhotoCollection(List<String> fileLines) {
		int numPhotos = Integer.parseInt(fileLines.get(0));

		for (int x = 1; x <= numPhotos; x++) {

			Photo p = new Photo(x-1);

			String line = fileLines.get(x);
			String[] elements = line.split(" ");
			String vertical = elements[0];
			p.vertival = vertical.equals("V");

			int numTags = Integer.parseInt(elements[1]);
			for (int i = 0; i < numTags; i++) {
				p.tags.add(elements[2 + i]);
			}
			Collections.sort(p.tags);
			photos.add(p);
		}
	}

	public List<Slide> getSlides() {
		List<Slide> slides = new LinkedList<Slide>();

		for (Photo p : photos) {

			if (!p.vertival) {
				slides.add(new Slide(p));
				photos.remove(p);
			} else {
				Photo p2 = buscarVertical(p);
				if (p2 != null) {
					slides.add(new Slide(p, p2));
					photos.remove(p);
					photos.remove(p2);
				} else {
					photos.remove(p);
				}
			}

		}

		return slides;

	}

	private Photo buscarVertical(Photo p) {

		Photo aux=null;
		int min=1000;
		
		for (Photo p2 : photos) {
			if (p2.vertival) {
				int i = p2.getCoincidencias(p);
				if (i<min) {
					aux=p2;
					min=i;
				}
			}
		}
		return aux;
	}
}
