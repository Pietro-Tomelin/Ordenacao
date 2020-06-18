//Classe principal

package Ordenacao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Ordenar {
	public static void main (String [] args) throws IOException{
		
		// instancia dos construtores
		PesquisaBinaria binaria = new PesquisaBinaria();
		BuscaLinear linear = new BuscaLinear();
	    
		//defini��o dos m�todos
		String linha;
		ArrayList<String> lista = new ArrayList<String>();
		
		//informa o arquivo
		String caminho = JOptionPane.showInputDialog("Informe o caminho do arquivo:");
		
		//l� o arquivo
		
		try { 
		FileReader ler = new FileReader(caminho);
		BufferedReader reader = new BufferedReader(ler);
		
        while( (linha = reader.readLine()) != null ){//se encontrar o arquivo joga no arraylist string
	                lista.add(linha);
        }
            
	    // arraylist string para long
	    ArrayList<Long> listaInt = new ArrayList<Long>(lista.size()) ;
	    for (String myInt : lista) {
	    listaInt.add(Long.valueOf(myInt));
	    }
	        
	    //joption pane para escolhas de m�todos
		Object [] opcoesMetodos = {"Quick Sort","Insertion Sort","Merge Sort"};
		int escolhaMetodo =  JOptionPane.showOptionDialog( null , "Op��es" , "Escolha um m�todo de ordena�o!" ,
		JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE , null , opcoesMetodos , opcoesMetodos );
		
		//case para impress�o das ordena��es
		switch(escolhaMetodo){
		case 0:
			long tempoInicial = System.currentTimeMillis();//temporizador inicial
			
			QuickSort quick = new QuickSort(listaInt);//construtor quick sort
	        quick.startQuickStart(0, listaInt.size()-1);//chama o metodo
	     
	     	
	        for(Long i:quick.getSortedArray()){
	            System.out.println(i);//imprime array ordenado
	        }
	        
	        long tempoFinal = System.currentTimeMillis();//temporizador final
	        
	        long tempo = tempoFinal - tempoInicial;//calculo tempo execu��o
	        JOptionPane.showMessageDialog(null, "Tempo de execu��o: "+tempo+"ms");//imprime tempo execu��o
	        		
		break;
		case 1:
			tempoInicial = System.currentTimeMillis();
			
			InsertionSort insertion = new InsertionSort();//construtor do metodo insertion
			insertion.sort(listaInt);// chama o metodo para ordenar
			InsertionSort print = new InsertionSort();// construtor para imprimir
			print.printArray(listaInt);// imprime o array ordenado
			
			tempoFinal = System.currentTimeMillis();
			
			tempo = tempoFinal - tempoInicial;
			JOptionPane.showMessageDialog(null, "Tempo de execu��o: "+tempo+"ms");
			break;
			
		case 2: 
			tempoInicial = System.currentTimeMillis();//temporizador inicial
			
			MergeSort merge = new MergeSort(listaInt);//construtor merge sort
	        merge.sortGivenArray();//chama o metodo
	        
	        for(long i:merge.getSortedArray()){
	            System.out.println(i);//imprime array ordenado
	        }
	        
	        tempoFinal = System.currentTimeMillis();//temporizador final
	        
	         tempo = tempoFinal- tempoInicial;//calculo tempo execu��o
	        JOptionPane.showMessageDialog(null, "Tempo de execu��o: "+tempo+"ms");//imprime tempo execu��o
			break;
			
		}
		
		//busca bin�ria e linear
		Object [] opcoesPesquisa = {"Pesquisa Bin�ria","Busca Linear"};
		int escolhaPesquisa =  JOptionPane.showOptionDialog( null , "Op��es" , "Escolha um m�todo de pesquisa!" ,
		JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE , null , opcoesPesquisa , opcoesPesquisa );
		
		switch(escolhaPesquisa) {
			case 0:
				
				//entrada para buscar valor no array
				long busca = Long.parseLong(JOptionPane.showInputDialog(null, "Digite o valor que deseja buscar:"));
				
				//entrada para buscar valor no array
				binaria.retorno(listaInt, busca);
	
			break;
			case 1:
				
				//entrada para buscar valor no array
				busca = Long.parseLong(JOptionPane.showInputDialog(null, "Digite o valor que deseja buscar:"));
				
				//entrada para buscar valor no array
				linear.retornoLinear(listaInt, busca);
				
			break;
		}
		
		//excess�es caso houver erros
		} catch (java.io.FileNotFoundException exception) {
		       JOptionPane.showMessageDialog(null, "N�o foi poss�vel ler o arquivo!");
		}
		
		catch (java.lang.NullPointerException exception) {
		}
		
		catch (java.lang.NumberFormatException exception) {
			JOptionPane.showMessageDialog(null, "Insira apenas n�meros!");
		}
	}
}




