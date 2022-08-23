package arquivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Arquivos {
	public static void main(String[] args) throws IOException {
		
		Pessoa pessoa1 = new Pessoa();
		pessoa1.setEmail("123@gmail.com");
		pessoa1.setIdade(20);
		pessoa1.setNome("Gi");
		
		Pessoa pessoa2 = new Pessoa();
		pessoa2.setEmail("456@gmail.com");
		pessoa2.setIdade(32);
		pessoa2.setNome("Joao");
		
		Pessoa pessoa3 = new Pessoa();
		pessoa3.setEmail("789@gmail.com");
		pessoa3.setIdade(22);
		pessoa3.setNome("Rapha");
		
		//a lista pode vir do banco de dados ou qualquer fonte de dados
		List<Pessoa>pessoas=new ArrayList<Pessoa>();
		pessoas.add(pessoa1);
		pessoas.add(pessoa2);
		pessoas.add(pessoa3);
		
		File arquivo = new File("C:\\Users\\Rapha\\git\\arquivosemjava\\arquivos\\src\\arquivos\\arquivo.txt");
		if(!arquivo.exists()) { //(! antes da condiçao serve para negá-la)
			arquivo.createNewFile();
		}
		FileWriter escrever_no_arquivo = new FileWriter(arquivo);
		/*
		for(int i=1;i<=10;i++) {
			escrever_no_arquivo.write("Texto da linha: "+i+"\n");
		}
		*/
		for (Pessoa pessoa : pessoas) {
			escrever_no_arquivo.write(pessoa.getNome()+";"+pessoa.getEmail()+";"+pessoa.getIdade()+"\n");
		}
		escrever_no_arquivo.flush();
		escrever_no_arquivo.close();
		//f5 atualiza a página (tem que compilar primeiro)
	}
}
