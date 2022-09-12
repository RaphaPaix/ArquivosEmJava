package arquivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LerArquivoTxt {
	public static void main(String[] args) throws FileNotFoundException {
		List<Pessoa>pessoas=new ArrayList<Pessoa>();
		
		FileInputStream entradaArquivo = new FileInputStream(new File("C:\\Users\\Rapha\\git\\arquivosemjava\\arquivos\\src\\arquivos\\arquivo2.csv"));
		Scanner lerArquivo = new Scanner(entradaArquivo, "UTF-8"); //entrada do arquivo e codificação necessária
		
		while(lerArquivo.hasNext()) {
			
			String linha = lerArquivo.nextLine();
			
			if(!linha.isEmpty()&&linha!=null) { //nao imprime as linhas em branco
				String[] dados = linha.split("\\;");
				
				Pessoa pessoa = new Pessoa();
				pessoa.setNome(dados[0]);
				pessoa.setEmail(dados[1]);
				
				pessoa.setIdade(Integer.parseInt(dados[2]));
				pessoas.add(pessoa);
			}
		}
		for (Pessoa pessoa : pessoas) { //poderia gravar no banco de dados, enviar email, gerar boletos, etc
			System.out.println(pessoa);
		}
	
	}
}
