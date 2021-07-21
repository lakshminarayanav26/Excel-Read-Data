package testcase;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadExcelData {
	public String[][] ReadData(String FileName) throws IOException {
		XSSFWorkbook ws = new XSSFWorkbook("./Data/"+FileName+".xlsx");
		XSSFSheet sheet = ws.getSheet("Sheet1");
		int lastRowNum = sheet.getLastRowNum();
		int lastCellNum = sheet.getRow(0).getLastCellNum();
		String[][] data = new String[lastRowNum][lastRowNum];
		for (int i = 1; i <=lastRowNum; i++) {
			for (int j = 0; j < lastCellNum; j++) {
				String cell = sheet.getRow(i).getCell(j).getStringCellValue();
				System.out.println(cell);
				data[i-1][j] = cell;
				}
			}
		ws.close();
		return data;
		}
	}