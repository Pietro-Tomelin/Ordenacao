//clase para busca de elemento pelo m�todo linear
package Ordenacao;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class BuscaLinear extends ImportaArquivo{
	public int linear(ArrayList<Long> listaEscrita, long x) {
		
		boolean bolFound = false;
		int indFound = 0;
		long aux = 0;
		
		for (int i = 0; i <= listaEscrita.size(); i++) {
			if (listaEscrita.get(i) == x) {
				bolFound = true;
				indFound = i;
				aux = listaEscrita.get(i);
			}
		}

		if (bolFound == true) {
			JOptionPane.showMessageDialog(null, "O valor de n�mero "+aux+" foi encontrado no �ndice " + (indFound + 1));
		} else {
			System.out.println("Valor n�o encontrado!");
		}
		return indFound;
	}
	
	public void retornoLinear(ArrayList<Long> listaEscrita, long busca){
		int i = linear(listaEscrita, busca);
	}
}