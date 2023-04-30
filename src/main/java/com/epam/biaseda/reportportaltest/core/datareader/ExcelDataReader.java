package com.epam.biaseda.reportportaltest.core.datareader;

import com.epam.biaseda.reportportaltest.core.logger.CustomLogger;
import com.epam.biaseda.reportportaltest.core.logger.CustomLoggerProvider;
import lombok.Getter;
import lombok.Setter;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;

@Setter
@Getter
public class ExcelDataReader {

    private static final CustomLogger log = CustomLoggerProvider.getLogger();

    private static final String TEST_RESOURCES_FOLDER = "src/test/resources";
    private static final String FILE_TO_READ = "/data/report_portal_test_data.xls";
    private static final int MAX_NUMBER_OF_COLUMNS = 5;
    private static final int MAX_NUMBER_OF_ROWS = 20;
    private static final String EMPTY_CELL = "";

    //    private Workbook workbook;
    private Sheet worksheet;


    private ExcelDataReader() {
    }

    public static ExcelDataReader init(String worksheetName) {
        ExcelDataReader excelDataReader = new ExcelDataReader();
        Workbook workbook;
        File sourceFile = new File(Paths.get(TEST_RESOURCES_FOLDER, FILE_TO_READ).toAbsolutePath().toString());
        try (FileInputStream inputFile = new FileInputStream(sourceFile)) {
            workbook = new HSSFWorkbook(inputFile);
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        excelDataReader.setWorksheet(workbook.getSheet(worksheetName));

        log.info(String.format("%s worksheet initialization ended...", worksheetName));
        return excelDataReader;
    }

    private static void initWorkbook() {

    }

    public Object[][] readTableData() {
        int columnNumber = worksheet.getRow(0).getPhysicalNumberOfCells();
        int rowNumber = worksheet.getLastRowNum();

        Object[][] data = new Object[rowNumber - 1][columnNumber];

        for (int i = 1; i < rowNumber; i++) {
            Row row = worksheet.getRow(i);
            for (int j = 0; j < columnNumber; j++) {
                Cell cell = row.getCell(j);
                switch (cell.getCellType()) {
                    case NUMERIC:
                        data[i - 1][j] = String.valueOf(Math.round(cell.getNumericCellValue()));
                        break;
                    case STRING:
                        data[i - 1][j] = cell.getStringCellValue();
                        break;
                    default:
                        data[i - 1][j] = cell.getCellType();
                }
            }
        }
        log.info(String.format("Data from %s worksheet read", worksheet.getSheetName()));
        return data;
    }
}
