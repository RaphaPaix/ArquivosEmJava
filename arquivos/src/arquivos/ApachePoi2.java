package arquivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ApachePoi2 {
	public static void main(String[] args) throws IOException {
		
		
		FileInputStream entrada = new FileInputStream(new File("C:\\Users\\Rapha\\git\\arquivosemjava\\arquivos\\src\\arquivos\\arquivo_excel.xls"));
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(entrada); //prepara o arquivo do excel para leitura
		HSSFSheet planilha = hssfWorkbook.getSheetAt(0); //pega a primeira planilha do nosso arquivo excel
		
		Iterator<Row> linhaIterator = planilha.iterator();
		List<Pessoa>pessoas = new ArrayList<Pessoa>();
		while(linhaIterator.hasNext()) {//enquanto tiver linha no arquivo excel
			Row linha = linhaIterator.next(); //dados da pessoa na linha
			Iterator<Cell> celulas = linha.iterator();
			Pessoa pessoa = new Pessoa();
			while(celulas.hasNext()) { //percorrer as células
				Cell cell = celulas.next();
				
				switch (cell.getColumnIndex()) {
				case 0:
					pessoa.setNome(cell.getStringCellValue());
					break;
				case 1:
					pessoa.setEmail(cell.getStringCellValue());
					break;
				case 2:
					pessoa.setIdade(Double.valueOf(cell.getNumericCellValue()).intValue());
					break;
				default:
					break;
				}
			}//fim das celulas da linha
			
			pessoas.add(pessoa);
			
		}
		entrada.close();//terminou de ler o arquivo excel
		for (Pessoa pessoa : pessoas) {
			System.out.println(pessoa);
		}
	
	
	}
}