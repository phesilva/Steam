package controller;
import java.io.*;
public class SteamController {
	private static final String ARQ_STEAM = "C:\\Users\\phe\\Downloads\\Exercicio_Arquivos_Steam\\SteamCharts.csv";
	
	public void buscaMesAnoValor(int ano, String mes, int valor) throws IOException{
		File arq = new File(ARQ_STEAM);
		
		if(arq.exists()&& arq.isFile()) {
			FileInputStream fis = new FileInputStream(arq);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(isr);
			String linha = br.readLine();
			linha = br.readLine();
			
			while (linha != null) {
				String[] vetLinha = linha.split(",");
				if(ano == Integer.parseInt(vetLinha[1])&& mes.equalsIgnoreCase(vetLinha[2])&& Float.parseFloat(vetLinha[3])>valor) {
					System.out.println(vetLinha[0]+"||"+vetLinha[3]);
				 }
				linha = br.readLine();
				}
				
				br.close();
				isr.close();
				fis.close();
			}

		}
	private void bufferParaArquivo(StringBuffer sb, File newArq)throws IOException {
		FileWriter fw = new FileWriter(newArq,false);
		PrintWriter pw = new PrintWriter(fw);
		pw.write(sb.toString());
		pw.close();
		fw.close();
	}
	
	private StringBuffer arquivoParaBuffer(int ano, String mes,  File arq) throws FileNotFoundException, IOException {
		StringBuffer sb = new StringBuffer();
		FileInputStream fis = new FileInputStream(arq);
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		String linha = br.readLine();
		linha = br.readLine();
		
		while (linha != null) {
			String[] vetLinha = linha.split(",");
			if(ano == Integer.parseInt(vetLinha[1])&& mes.equalsIgnoreCase(vetLinha[2])){
				sb.append(vetLinha[0]+";"+vetLinha[3]+"\r\n");
			}
			linha = br.readLine();
		}
		br.close();
		isr.close();
		fis.close();
		return sb;
	}
	public void geraArquivo(int ano, String mes, String arquivo,String diretorio)throws IOException {
		File arq = new File(ARQ_STEAM);
		
		if(arq.exists() && arq.isFile()) {
			StringBuffer sb = arquivoParaBuffer(ano, mes ,arq);
			
			File dir = new File(diretorio);
			
			if(dir.exists()&& dir.isDirectory()) {
				File newArq = new File(dir, arquivo);
				if(!newArq.exists()) {
					bufferParaArquivo(sb,newArq);
				}else {
					throw new IOException("Arquivo não existente");
				}
			}else {
				throw new IOException("Diretorio de destino não encontrado");
			}	
		}else {
			throw new IOException("Arquivo não foi encontrado");
		}
	}
	
	
}
