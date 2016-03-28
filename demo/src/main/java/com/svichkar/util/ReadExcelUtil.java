package com.svichkar.util;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by svichkar on 3/28/2016.
 */
public class ReadExcelUtil {

    public static List<String> readTitles(File file) throws IOException {

        InputStream inputStream = new FileInputStream(file);
        String extension = FilenameUtils.getExtension(file.getName());
        Workbook workbook;
        switch (extension.toLowerCase()) {
            case "xls": {
                workbook = new HSSFWorkbook(inputStream);
                break;
            }
            case "xlsx": {
                workbook = new XSSFWorkbook(inputStream);
                break;
            }
            default:
                throw new RuntimeException("Unsupported file extension. Valid are XLS and XLSX.");
        }

        List<String> titles = new ArrayList<>();
        workbook.getSheetAt(0).getRow(0).forEach((Cell cell) -> {
            titles.add(cell.getStringCellValue());
        });

        return titles;
    }


    public static HashMap<String, List<String>> readData(File file) throws IOException {

        HashMap<String, List<String>> result = new HashMap<>();
        InputStream inputStream = new FileInputStream(file);
        String extension = FilenameUtils.getExtension(file.getName());
        Workbook workbook;
        switch (extension.toLowerCase()) {
            case "xls": {
                workbook = new HSSFWorkbook(inputStream);
                break;
            }
            case "xlsx": {
                workbook = new XSSFWorkbook(inputStream);
                break;
            }
            default:
                throw new RuntimeException("Unsupported file extension. Valid are XLS and XLSX.");
        }

        Sheet sheet = workbook.getSheetAt(0);

        for (int n = 0; n < sheet.getLastRowNum(); n++) {
            Row row = sheet.getRow(n);
            List<String> value = new ArrayList<>();
            for (int col = 0; col < row.getLastCellNum(); col++) {
                Cell cell = row.getCell(col);
                result.put(row.getCell(0).getStringCellValue(),  new ArrayList<>());
            }
        }

        sheet.forEach((Row row) -> {


            });


            return result;
    }
}
