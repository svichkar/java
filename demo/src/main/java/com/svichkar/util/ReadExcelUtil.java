package com.svichkar.util;

import com.svichkar.model.Book;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * Created by svichkar on 3/28/2016.
 */
public class ReadExcelUtil {

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

    public static HashMap<String, List<String>> readData(MultipartFile file) {

        HashMap<String, List<String>> result = new HashMap<>();
        InputStream inputStream;
        try {
            inputStream = file.getInputStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Workbook workbook = null;
        String extension = FilenameUtils.getExtension(file.getOriginalFilename());
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

    public static Set<String> readTitles(File file) {
        return readData(file).keySet();
    }

    private static String getCellValue(Cell cell) {

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

    public static Workbook prepareWorkBook(List<Book> data) throws IOException {

        String[] titles = {"ID", "TITLE", "AUTHOR"};

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("All Books");

        //create row with titles
        Row row = sheet.createRow(0);
        for (int i = 0; i < titles.length; i++) {
            row.createCell(i).setCellValue(titles[i]);
        }

        //fill all rows with data
        data.forEach((Book b) -> {
            Row r = sheet.createRow(data.indexOf(b) + 1);
            r.createCell(0).setCellValue(b.getId());
            r.createCell(1).setCellValue(b.getTitle());
            r.createCell(2).setCellValue(b.getAuthor());
        });

        return workbook;
    }
}
