package br.edu.cs.poo.ac.utils;

public class StringUtils {
	
	public static boolean estaVazia(String str) {
		
		if(str == null || str.length()==0 ) return true;
		
		if(str.isBlank()) return true;
		
		return false;
		
	}

	public static boolean tamanhoExcedido(String str, int tamanho) {
		
		if(tamanho<0) return false;
		
		if(str== null) {
			return tamanho > 0;
		}
		else {
			if(str.length() > tamanho) return true;
			else return false;
		}
		
	}

	public static boolean emailValido(String email) {
		return false;
		
	}

	public static boolean telefoneValido(String tel) {
		return false;
	}
}