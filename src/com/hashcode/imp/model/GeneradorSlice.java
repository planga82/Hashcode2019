package com.hashcode.imp.model;

import java.util.*;

public class GeneradorSlice {

	private static GeneradorSlice instance = null;
	public List<Slice> listTotalSilces;

	public static GeneradorSlice getInstance(Pizza pizza){
		if(instance == null){
			instance = new GeneradorSlice(pizza);
		}
		return instance;
	}

	private GeneradorSlice(Pizza pizza){
		listTotalSilces = generateAllSlices(pizza);
	}

	public Iterator<Slice> getSlices(){
		return listTotalSilces.iterator();
	}

	private List<Slice> generateAllSlices(Pizza pizza) {

		List<Slice> salida = new ArrayList<>();

		//Go throw all pizza positions
		for(int x = 0; x < pizza.rows; x++){
			for(int y = 0; y < pizza.cols; y ++){
				salida.addAll(generateSlicesPerPosition(x,y,pizza));
			}
		}
        System.out.println("Slices size - " + salida.size());
		return salida;
	}


	private List<Slice> generateSlicesPerPosition(int x, int y,Pizza pizza){

		List<Slice> ret = new ArrayList<>();

		for (int i = 1; i <= pizza.maxCells; i++) {
			for (int j = 1; j <= pizza.maxCells; j++) {
				if(i*j <= pizza.maxCells) {
					Slice l = new Slice(x, y,i, j);
					if(!CompruebaRestricciones.seSalePizza(pizza,l) && CompruebaRestricciones.contieneIngredientesAdecuados(pizza,l)) {
						ret.add(l);
					}
				}
			}
		}
		//System.out.println(ret);
		return ret;
	}



}
