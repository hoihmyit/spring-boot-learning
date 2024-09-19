package com.spl.hm.service;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

@RunWith(MockitoJUnitRunner.class)
public class ReadExcelFileTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReadExcelFileTest.class);

    @Test
    public void testReadExcelFile() {

        try {
            File excelFile = new File(getClass().getClassLoader().getResource("employees_info.xlsx").getFile());

            // Creating a Workbook from an Excel file (.xls or .xlsx)
            Workbook workbook = WorkbookFactory.create(excelFile);

            // Retrieving the number of sheets in the Workbook
            System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");

            // Iterating over all the sheets in the workbook
            System.out.println("Retrieving Sheets using Java 8 forEach with lambda");
            workbook.forEach(sheet -> System.out.println("=> " + sheet.getSheetName()));

            // Iterating over all the rows and columns in a Sheet
            // Getting the Sheet at index zero
            Sheet sheet = workbook.getSheetAt(0);

            // Create a DataFormatter to format and get each cell's value as String
            DataFormatter dataFormatter = new DataFormatter();

            System.out.println("\nIterating over Rows and Columns using Java 8 forEach with lambda\n");
            sheet.forEach(row -> {
                row.forEach(cell -> {
                    String cellValue = dataFormatter.formatCellValue(cell);
                    System.out.print(cellValue + "\t");
                });
                System.out.println();
            });

            // Closing the workbook
            workbook.close();
        } catch (Exception e) {
            LOGGER.error("Error while reading excel .xlsx file: {}", e.getMessage());
        }
    }
}
