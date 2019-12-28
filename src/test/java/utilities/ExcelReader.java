package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	public String path;
	public FileInputStream fis;
	public FileOutputStream fos;
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	private XSSFRow row;
	private XSSFCell cell;
	
	public ExcelReader(String path) throws Exception {
		this.path=path;
		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(0);
			fis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public int getRowCount(String sheetName) {
		int index = workbook.getSheetIndex(sheetName);
		if(index==-1) {
			return 0;
		}else {
			sheet = workbook.getSheetAt(index);
			int totalRow=sheet.getLastRowNum()+1;
			return totalRow;
		}	
	}
	public int getColoumnCount(String sheetName) {
		int index = workbook.getSheetIndex(sheetName);
		if(index==-1) {
			return 0;
		}else {
			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(0);
			int totalColoumn = row.getLastCellNum();
			return totalColoumn;
		}
	}
	public String getCellData(String sheetName, String colName, int rowNum) {
		int index = workbook.getSheetIndex(sheetName);
		if(index==-1)
			return "";
		int col_Num = -1;
		sheet = workbook.getSheetAt(index);
		row = sheet.getRow(0);
		for(int i=0;i<row.getLastCellNum();i++) {
			if(row.getCell(i).getStringCellValue().trim().equals(colName.trim())) {
				col_Num = i;
			}
		}
		if(col_Num==-1)
			return "";
		
		sheet = workbook.getSheetAt(index);
		row = sheet.getRow(rowNum-1);
		if(row==null)
			return "";
		cell = row.getCell(col_Num);
		if(cell==null)
			return "";
		
		if(cell.getCellType()==CellType.STRING) {
			return cell.getStringCellValue();
		}else if(cell.getCellType()==CellType.NUMERIC || cell.getCellType()==CellType.FORMULA) {
			String cellData = String.valueOf(cell.getNumericCellValue());
			return cellData;
		}else if(cell.getCellType()==CellType.BLANK) {
			return "";
		}else {
			return String.valueOf(cell.getBooleanCellValue());
		}
	}
}
