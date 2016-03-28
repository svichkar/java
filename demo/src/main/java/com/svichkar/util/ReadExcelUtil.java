package com.svichkar.util;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
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

    public static HashMap<String, List<String>> readData(File file) {

        HashMap<String, List<String>> result = new HashMap<>();
        InputStream inputStream;
        try {
            inputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        Workbook workbook;
        String extension = FilenameUtils.getExtension(file.getName());
        switch (extension.toLowerCase()) {
            case "xls": {
                try {
                    workbook = new HSSFWorkbook(inputStream);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            }
            case "xlsx": {
                try {
                    workbook = new XSSFWorkbook(inputStream);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            }
            default:
                throw new RuntimeException("Unsupported file extension. Valid are XLS and XLSX.");
        }

        Sheet sheet = workbook.getSheetAt(0);
        for (int i = 0; i < sheet.getRow(0).getLastCellNum(); i++) {
            final int cellIndex = i;
            final List<String> value = new ArrayList<>();
            final String[] key = {""};
            sheet.forEach((Row row) -> {
                row.forEach((Cell cell) -> {

                    final int rowIndex = row.getRowNum();
                    if (cellIndex == cell.getColumnIndex()) {
                        if (rowIndex == 0) {
                            key[0] = getCellValue(cell);
                        } else {
                            value.add(getCellValue(cell));
                        }
                    }
                });
                result.put(key[0], value);
            });
        }
        return result;
    }

    public static String getCellValue(Cell cell) {

        String result = "";
        if (cell != null) {
            switch (cell.getCellType()) {
                case Cell.CELL_TYPE_BOOLEAN:
                    result = String.valueOf(cell.getBooleanCellValue());
                    break;
                case Cell.CELL_TYPE_NUMERIC:
                    result = String.valueOf(cell.getNumericCellValue());
                    break;
                case Cell.CELL_TYPE_STRING:
                    result = cell.getStringCellValue();
                    break;
                case Cell.CELL_TYPE_BLANK:
                    break;
                case Cell.CELL_TYPE_ERROR:
                    break;
            }
        }
        return result;
    }
}
