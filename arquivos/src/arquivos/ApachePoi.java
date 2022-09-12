package arquivos;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ApachePoi {
	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\Rapha\\git\\arquivosemjava\\arquivos\\src\\arquivos\\arquivo_excel.xls");
		if(!file.exists()) {
			file.createNewFile();
		}
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
		
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(); //usado para escrever a planilha
		HSSFSheet linhasPessoa = hssfWorkbook.createSheet("Planilha de Pessoas JDEV treinamento");
	
		
		//pra cada pessoa uma linha
		//pra cada atributo uma célula
		int numeroLinha=0;
		for (Pessoa p: pessoas) {
			Row linha = linhasPessoa.createRow(numeroLinha++);//criando a linha na planilha
		
			int celula=0;
			Cell celNome = linha.createCell(celula++);
			celNome.setCellValue(p.getNome());
			Cell celEmail = linha.createCell(celula++);
			celEmail.setCellValue(p.getEmail());
			Cell celIdade = linha.createCell(celula++);
			celIdade.setCellValue(p.getIdade());
		}
		
		FileOutputStream saida = new FileOutputStream(file);
		hssfWorkbook.write(saida);//escreve planilha em arquivo
		
		saida.flush();
		saida.close();
		
		System.out.println("Planilha foi criada");
	
	
	
	}
}
