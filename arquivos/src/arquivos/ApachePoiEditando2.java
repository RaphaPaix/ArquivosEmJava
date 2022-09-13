package arquivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ApachePoiEditando2 {
	public static void main(String[] args) throws Exception {
		File file = new File("C:\\Users\\Rapha\\git\\arquivosemjava\\arquivos\\src\\arquivos\\arquivo_excel.xls");
		FileInputStream entrada = new FileInputStream(file);
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(entrada); //prepara a entrada do arquivo xls excel
		HSSFSheet planilha = hssfWorkbook.getSheetAt(0); //pega a planilha
		Iterator<Row>linhaIterator=planilha.iterator();
		while(linhaIterator.hasNext()) { //enquanto tiver linha
			Row linha = linhaIterator.next(); //dados da pessoa na linha
			int numeroCelulas = linha.getPhysicalNumberOfCells(); //quantidade de células
			String valorCelula = linha.getCell(0).getStringCellValue();
			linha.getCell(0).setCellValue(valorCelula+"* EDITADA");
		}
		entrada.close();
		FileOutputStream saida = new FileOutputStream(file);
		hssfWorkbook.write(saida);
		saida.flush();
		saida.close();
		System.out.println("Planilha atualizada");
	}
}
