package view;

import java.io.IOException;

import controller.SteamController;

public class Principal {

	public static void main(String[] args) {
		SteamController sc = new SteamController();
		int ano = 2019;
		String mes = "August";
		int valor = 10000;
		try {
			sc.buscaMesAnoValor(ano, mes, valor);
		}catch(IOException e){
			e.printStackTrace();
		}
		
		 String arquivo = "Aug19.csv";
		  String diretorio = "C:\\Users\\phe\\Downloads\\Exercicio_Arquivos_Steam";
		  try{
		  sc.geraArquivo(ano, mes, arquivo,diretorio);
		 }catch(IOException e){
		  	e.printStackTrace();
		 }
			
	}

}
