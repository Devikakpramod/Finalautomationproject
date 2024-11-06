package utilitiespackage; 

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelutils {
    public static String getcellvalue1(String exl, String Sheet1, int r, int c) {
        try {
            FileInputStream fp = new FileInputStream(exl);
            XSSFWorkbook xf = new XSSFWorkbook(fp);
            XSSFCell cell = xf.getSheet(Sheet1).getRow(r).getCell(c);
            if (cell.getCellType() == CellType.STRING) {
                return cell.getStringCellValue();
            } else {
                return cell.getRawValue();
            }
        } catch (Exception e) {
            return "";
        }
    }

    public static int getRowCount1(String exl, String Sheet1) {
        try {
            FileInputStream fp = new FileInputStream(exl);
            XSSFWorkbook xf = new XSSFWorkbook(fp);
            return xf.getSheet(Sheet1).getLastRowNum();
        } catch (Exception e) {
            return 0;
        }
    }
}