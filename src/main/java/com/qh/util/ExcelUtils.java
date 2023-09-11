package com.qh.util;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelUtils {

    public static Map<String,List<List<String>>> parseExcel(InputStream inputStream, String fileName) {
        Workbook workbook;

        try {
            if (fileName.endsWith(".xls")) {
                workbook = new HSSFWorkbook(inputStream);
            } else if (fileName.endsWith(".xlsx")) {
                workbook = new XSSFWorkbook(inputStream);
            } else {
                throw new Exception("Invalid file format");
            }
            return readWorkbook(workbook,fileName);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static Map<String,List<List<String>>> readWorkbook(Workbook workbook, String fileName) {


        List<List<String>> dataList  = new ArrayList<>();
        //存放月份的sheet
        List<Sheet> sheets = new ArrayList<>();

        //key为月份，value为sheet数据
        Map<String,List<List<String>>> sheetMap = new HashMap<>();

        /*//获取sheet数量
        int numberOfSheets = workbook.getNumberOfSheets();*/



        //获取sheet名称
/*        for (int i = 0; i < numberOfSheets; i++) {
            String sheetName = workbook.getSheetName(i);


            if (sheetName.endsWith("月")&&sheetName.length()==2){
                Sheet sheetAt = workbook.getSheetAt(i);
                sheets.add(sheetAt);
            }
        }*/


        Sheet sheet = workbook.getSheetAt(0);

        /*     //循环所有sheet
        for (Sheet sheet:sheets
        ) {*/


            int rows = sheet.getLastRowNum() + 1;

            for (int i = 0; i < rows; i++) {
                Row row = sheet.getRow(i);

                //每一行的数据
                List<String> rowData = new ArrayList<>();

                for (Cell cell : row) {
                    cell.setCellType(CellType.STRING);
                    rowData.add(cell.getStringCellValue());

                }

                dataList.add(rowData);

            }

            sheetMap.put(fileName.split("\\.")[0],dataList);

       /* }*/

        return sheetMap;
    }
}
