package com.nrf.demo.utils;

import com.nrf.demo.model.TestCase;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by puhui on 2016/12/26.
 */
public class ExcelUtilTest {

    @Test
    public void writeReportTest() throws BiffException, IOException, WriteException {
        List<TestCase> testCases = ExcelUtil.readTestCase(new File("D:\\git\\selenium-demo\\src\\main\\resources\\data\\baidu_home_page.xls"),"menu");
        String path = "D:\\git\\selenium-demo\\report\\nrf0101.xls";
        File output = new File(path);
        ExcelUtil.writeReport(output,testCases);
    }

}
