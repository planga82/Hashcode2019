package com.hashcode.imp.model;

public class CompruebaRestricciones {

	
	

	//comprueba que no se sale de la pizza
	public static boolean seSalePizza(Pizza pizza, Slice slice) {
		return (slice.posRowIni + slice.rows > pizza.rows) ||
				(slice.posColIni + slice.cols > pizza.cols);
	}
	//comprueba que no pisa otro slice
	public static boolean pisaOtroSlice(PizzaEvolution estadoPizza, Slice slice) {
		for (int i = 0; i < slice.rows; i++) {
			for (int j = 0; j < slice.cols; j++) {
				int row = slice.posRowIni+i;
				int col = slice.posColIni+j;
				if(estadoPizza.base[row][col].withSlice) {
					return true;
				}				
			}
		} 
		return false;
	}
	
	//Contiene el numero de ingredientes adecuado
	public static boolean contieneIngredientesAdecuados(Pizza pizza, Slice slice) {
			
			int tomato =0;
			int mushroom=0;
			for (int i = 0; i < slice.rows; i++) {
				for (int j = 0; j < slice.cols; j++) {
					int row = slice.posRowIni+i;
					int col = slice.posColIni+j;
					if(pizza.base[row][col] == 'T') {
						tomato++;
					}else {
						mushroom++;
					}
				}
			} 
			return tomato>=pizza.numIngrdientsPerSlice && mushroom>=pizza.numIngrdientsPerSlice;
			
		}
	
}
