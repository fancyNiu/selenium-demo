package com.nrf.demo.utils;

import com.nrf.demo.model.ReportFormat;
import com.nrf.demo.model.TestCase;
import jxl.Sheet;
import jxl.Workbook;
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
    private static WritableWorkbook wwb = null;
    private static WritableSheet sheet = null;

    public static List<TestCase> readTestCase(File input, String sheetName){
        //创建一个list 用来存储读取的内容
        List<TestCase> list = new ArrayList<TestCase>();

        try {
            //创建输入流
            InputStream in = new FileInputStream(input);

            //获取Excel文件对象及表对象
            Workbook rwb = Workbook.getWorkbook(in);
            Sheet sheet = rwb.getSheet(sheetName);
            int rowCount = sheet.getRows();

            //去除表头，读取每一行的内容,将其加载成测试用例，并存放到list中
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

    public static void writeReport(File output, List<TestCase> testCases) throws WriteException, IOException, BiffException {
        String sheetName = "test_case";
        int row = 0;
        int length = testCases.size();
        //如果该测试报告是空的，则新建文件并加载测试报告模板，如果非空，则在test_case页中追加正在执行的用例
        if(isEmpty(output)){
            wwb = loadTemplate(output);
            sheet = wwb.createSheet(sheetName,1);
            writeTitle();
            row = 1;
        }else {
            Workbook rwb = null;
            try {
                rwb = Workbook.getWorkbook(output);
                File temp = new File(output.getParent()+File.separator+"tempfile.xls");
                wwb = Workbook.createWorkbook(temp,rwb);
                sheet = wwb.getSheet(sheetName);
                row = sheet.getRows();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (BiffException e) {
                e.printStackTrace();
            }
        }
        //写入测试用例执行情况
        for(int i=0;i<length;i++){
            writeText(testCases.get(i),i+row);
        }
        //保存测试报告
        wwb.write();
        wwb.close();

    }

    private static Boolean isEmpty(File file) throws IOException, BiffException {
        Workbook rwb = Workbook.getWorkbook(file);
        Sheet[] sheets = rwb.getSheets();
        if(sheets.length ==0){
            return false;
        }else {
            return true;
        }
    }

    private static WritableWorkbook loadTemplate(File output) throws IOException, BiffException {
        File template = new File(ClassLoader.getSystemResource("tempalte/TestCaseExample.xls").getFile());
        Workbook rwb = Workbook.getWorkbook(template);
        WritableWorkbook wwb = Workbook.createWorkbook(output,rwb);
        return wwb;
    }

    /**在test_case的sheet中写入title*/
    private static void writeTitle(){
        try {
            WritableCellFormat titleFormat = new ReportFormat().getTitleFormat();
            WritableCellFormat textFormat = new ReportFormat().getTextFormat();
            sheet.addCell(new Label(0,0,"测试用例编号",titleFormat));
            sheet.addCell(new Label(1,0,"测试页面名称",titleFormat));
            sheet.addCell(new Label(2,0,"测试模块名称",titleFormat));
            sheet.addCell(new Label(3,0,"测试用例名称",titleFormat));
            sheet.addCell(new Label(4,0,"优先级",titleFormat));
            sheet.addCell(new Label(5,0,"类型",titleFormat));
            sheet.addCell(new Label(6,0,"步骤",titleFormat));
            sheet.addCell(new Label(7,0,"输入",titleFormat));
            sheet.addCell(new Label(8,0,"预期输出",titleFormat));
            sheet.addCell(new Label(9,0,"实际输出",titleFormat));
            sheet.addCell(new Label(10,0,"测试结果",titleFormat));
            sheet.addCell(new Label(11,0,"完整日志",titleFormat));
        } catch (WriteException e) {
            e.printStackTrace();
        }
    }

    /***/
    private static void writeText(TestCase testCase, int row){
        try {
            WritableCellFormat textFormat = new ReportFormat().getTextFormat();
            WritableCellFormat resultPassFormat= new ReportFormat().getResultPassFormat();
            WritableCellFormat resultFailFormat = new ReportFormat().getResultFailFormat();
            sheet.addCell(new Label(sheet.getCell("测试用例编号").getColumn(), row, testCase.getId(), textFormat));
            sheet.addCell(new Label(sheet.getCell("测试页面名称").getColumn(), row, testCase.getPage(), textFormat));
            sheet.addCell(new Label(sheet.getCell("测试模块名称").getColumn(), row, testCase.getModule(), textFormat));
            sheet.addCell(new Label(sheet.getCell("测试用例名称").getColumn(), row, testCase.getName(), textFormat));
            sheet.addCell(new Label(sheet.getCell("优先级").getColumn(), row, testCase.getPriority(), textFormat));
            sheet.addCell(new Label(sheet.getCell("类型").getColumn(), row, testCase.getType(), textFormat));
            sheet.addCell(new Label(sheet.getCell("步骤").getColumn(), row, testCase.getStep(), textFormat));
            sheet.addCell(new Label(sheet.getCell("输入").getColumn(), row, testCase.getId(), textFormat));
            sheet.addCell(new Label(sheet.getCell("预期输出").getColumn(), row, testCase.getExpectResult(), textFormat));
            sheet.addCell(new Label(sheet.getCell("实际输出").getColumn(), row, testCase.getActualResult(), textFormat));
            sheet.addCell(new Label(sheet.getCell("完整日志").getColumn(), row, testCase.getLog(), textFormat));
            if(testCase.getResult()){
                sheet.addCell(new Label(sheet.getCell("测试结果").getColumn(), row, "pass", resultPassFormat));
            }else {
                sheet.addCell(new Label(sheet.getCell("测试结果").getColumn(), row, "failed", resultPassFormat));
            }

        } catch (WriteException e) {
            e.printStackTrace();
        }

    }
}
