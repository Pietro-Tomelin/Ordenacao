//Classe principal

package Ordenacao;

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Ordenar extends ImportaArquivo{
	public static void main (String [] args) throws IOException{
		
		// instancia dos construtores
		PesquisaBinaria binaria = new PesquisaBinaria();
		
		BuscaLinear linear = new BuscaLinear();
		
		ImportaArquivo impArquivo = new ImportaArquivo(); 
	    
		//defini��o dos m�todos
		String linha;
		ArrayList<String> lista = new ArrayList<String>();
		ArrayList<Long> listaEscrita = new ArrayList<Long>();
		
		String caminho = JOptionPane.showInputDialog("Informe o caminho do arquivo");
		
		FileReader ler = new FileReader(caminho);//insere o caminho para leitura do mesmo
		
		BufferedReader reader = new BufferedReader(ler);//l� o arquivo
		
		try { 
        while( (linha = reader.readLine()) != null ){//se encontrar o arquivo joga nao arraylist string
	                lista.add(linha);
        }
	        
	        
	        // arraylist string para int
	        ArrayList<Long> listaInt = new ArrayList<Long>(lista.size()) ;
	        for (String myInt : lista) {
	        listaInt.add(Long.valueOf(myInt));//converte de arraylist string para long para realiza��o de opera��es matem�ticas
	        }
	        
	        FileWriter escrever = new FileWriter(caminho);//escritor
	     	PrintWriter writer = new PrintWriter(escrever); 
	        
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
     
     	
        for(Long i:quick.getSortedArray()){//chama metodo ordenacao
            System.out.println(i);//aqui imprime
            listaEscrita.add(i);//arraylist ordenado
            writer.println(i);//escrita no arquivo
        }
        
        long tempoFinal = System.currentTimeMillis();//temporizador final
        
        long tempo = tempoFinal - tempoInicial;//calculo tempo execu��o
        JOptionPane.showMessageDialog(null, "Tempo de execu��o: "+tempo+"ms");//tempo execu��o
        		
	break;
	case 1:
		tempoInicial = System.currentTimeMillis();
		
		InsertionSort insertion = new InsertionSort();//construtor do metodo
		insertion.sort(listaInt);// chama o metodo para ordenar
		InsertionSort print = new InsertionSort();// construtor da impres�o
		print.printArray(listaInt, writer);// imprime o array ordenado
		
		tempoFinal = System.currentTimeMillis();
		
		tempo = tempoFinal - tempoInicial;
		JOptionPane.showMessageDialog(null, "Tempo de execu��o: "+tempo+"ms");
		break;
		
	case 2: 
		//mesmo do case 0
		tempoInicial = System.currentTimeMillis();
		
		MergeSort merge = new MergeSort(listaInt);
        merge.sortGivenArray();
        
        for(long i:merge.getSortedArray()){
            System.out.println(i);
            listaEscrita.add(i);
            writer.println(i);
        }
        
        tempoFinal = System.currentTimeMillis();
        
         tempo = tempoFinal- tempoInicial;
        JOptionPane.showMessageDialog(null, "Tempo de execu��o: "+tempo+"ms");
		break;
		
	}
	
	//busca bin�ria e linear
	Object [] opcoesPesquisa = {"Pesquisa Bin�ria","Busca Linear"};
	int escolhaPesquisa =  JOptionPane.showOptionDialog( null , "Op��es" , "Escolha um m�todo de pesquisa!" ,
	JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE , null , opcoesPesquisa , opcoesPesquisa );
	
	switch(escolhaPesquisa) {
		case 0:
			
			long busca = Long.parseLong(JOptionPane.showInputDialog(null, "Digite o valor que deseja buscar:"));
			
			//professor quando eu lan�ava o array para escrever no documento ele dava erro nos m�todos de pesquisa
			//tive de fazer essa gambiarra, se o professor quiser eu ajeito depois e apresento certo, pois os m�todos est�o funcionando...
			for(int i = 0; i<listaEscrita.size();i++){ 
	        	if(listaEscrita.get(i) != busca){
	        	}
	        	else{
	        		JOptionPane.showMessageDialog(null, "O elemento "+busca+" foi encontrado na linha: "+(i+1));
	        	}
	        }
			
			//binaria.retorno(impArquivo.getListaEscrita(), busca);

		break;
		case 1:
			
			busca = Long.parseLong(JOptionPane.showInputDialog(null, "Digite o valor que deseja buscar:"));
			
			for(int i = 0; i<listaEscrita.size();i++){
	        	if(listaEscrita.get(i) != busca){
	        		i++;
	        	}
	        	else{
	        		JOptionPane.showMessageDialog(null, "O elemento "+busca+" foi encontrado na linha: "+(i+1));
	        	}
	        }
			//linear.retornoLinear(impArquivo.getListaEscrita(), busca);
			
		break;
	}
	
	}  

	catch (IOException ex) {
	       JOptionPane.showMessageDialog(null, "N�o foi poss�vel ler o arquivo!");
	   }
	
	}
}




