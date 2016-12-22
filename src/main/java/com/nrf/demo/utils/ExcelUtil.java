package com.nrf.demo.utils;

import com.alibaba.fastjson.JSONObject;
import com.nrf.demo.model.TestCase;
import jxl.Sheet;
import jxl.Workbook;
import jxl.format.UnderlineStyle;
import jxl.read.biff.BiffException;
import jxl.write.*;

import java.io.*;
import java.lang.Boolean;
import java.util.ArrayList;
import java.util.List;

/**
 * 读取测试用例文件，获取测试用例
 */
public class ExcelUtil {

//    private static final Logger LOG = LoggerFactory.getLogger(ExcelUtil.class);

    public static List<TestCase> readExcel(File input, String sheetName){
        //创建一个list 用来存储读取的内容
        List<TestCase> list = new ArrayList<TestCase>();

        try {
            //创建输入流
            InputStream in = new FileInputStream(input);

            //获取Excel文件对象
            Workbook rwb = Workbook.getWorkbook(in);

            Sheet sheet = rwb.getSheet(sheetName);
            int rowCount = sheet.getRows();
            //去除表头，读取每一行的内容,如果是当前测试的用例则存入list中
            for(int i=0;i<rowCount;i++){
                TestCase testCase = new TestCase(sheet.getRow(i));
                list.add(testCase);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void writeExcel(File output,String sheetName, List<TestCase> testCases)throws WriteException {
        WritableWorkbook wwb = null;

        if(isEmpty(output)){
            wwb = loadTemplate(output);
        }else {
            Workbook rwb = null;
            try {
                rwb = Workbook.getWorkbook(output);
                File temp = new File(output.getParent()+File.separator+"tempfile.xls");
                wwb = Workbook.createWorkbook(temp,rwb);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (BiffException e) {
                e.printStackTrace();
            }

        }


        try {

            //设置正文的字体，背景色及边框
            WritableFont textFont = new WritableFont(WritableFont.ARIAL,12,WritableFont.NO_BOLD,false, UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLACK);
            WritableCellFormat passCellFormat = new WritableCellFormat(textFont);
            passCellFormat.setBackground(jxl.format.Colour.GREEN);
            passCellFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
            WritableCellFormat failCellFormat = new WritableCellFormat(textFont);
            failCellFormat.setBackground(jxl.format.Colour.RED);
            failCellFormat.setBorder(Border.ALL, BorderLineStyle.THIN);

            wwb = Workbook.createWorkbook(output);
            for(String sheetName: json.keySet()){
                WritableSheet sheet = wwb.createSheet(sheetName,wwb.getNumberOfSheets());
                List<List<String>> list = (List<List<String>>)json.get(sheetName);
                for(int i=0;i<list.size();i++){
                    List<String> strs = list.get(i);
                    for(int j=0;j<strs.size();j++){
                        Label label;
                        if(j==strs.size()-1 && "pass".equals(strs.get(j))){
                            label = new Label(j,i,strs.get(j),passCellFormat);
                        }else if(j==strs.size()-1 && "failed".equals(strs.get(j))){
                            label = new Label(j,i,strs.get(j),failCellFormat);
                        }else {
                            label = new Label(j,i,strs.get(j));
                        }
                        sheet.addCell(label);
                    }
                }
            }
            wwb.write();
            wwb.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static Boolean isEmpty(File file){
        try {
            Workbook rwb = Workbook.getWorkbook(file);
            Sheet[] sheets = rwb.getSheets();
            if(sheets.length ==0){
                return false;
            }else {
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
    }

    public static WritableWorkbook loadTemplate(File output){
        File template = new File(ClassLoader.getSystemResource("tempalte/TestCaseExample.xls").getFile());
        try {
            Workbook rwb = Workbook.getWorkbook(template);
            WritableWorkbook wwb = Workbook.createWorkbook(output,rwb);
            return wwb;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
    }

    public static reportFormat
}
