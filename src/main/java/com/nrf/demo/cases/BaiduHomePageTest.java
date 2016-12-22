package com.nrf.demo.cases;

import com.nrf.demo.model.BaiduHomePage;
import com.nrf.demo.model.TestCase;
import com.nrf.demo.service.ChromeService;
import com.nrf.demo.service.FirefoxService;
import com.nrf.demo.utils.ExcelUtil;
import com.sun.xml.internal.fastinfoset.algorithm.BooleanEncodingAlgorithm;
import org.apache.bcel.util.ClassLoader;
import org.apache.xpath.SourceTree;
import org.apache.xpath.operations.Bool;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * 测试百度首页
 * 1. 加载用例
 * 2. 执行测试步骤
 * 3. 结果对比
 * 4. 回写结果
 */
public class BaiduHomePageTest {
    private WebDriver driver;
    private String baseUrl = "https://www.baidu.com/";
    private File caseFile;
    private File resultReprot;

    /**加载用例并初始化页面*/
    @Parameters({"caseFile","resultReprot"})
    @BeforeTest
    public void beforeTest(String caseFile, String resultReport){
        //获取用例文件
        this.caseFile = new File(ClassLoader.getSystemResource(caseFile).getFile());
        this.resultReprot = new File(resultReport);

        //浏览器带插件初始化

//        service.addPlugin("extensions.firebug.currentVersion",new File(ClassLoader.getSystemResource("plugins/firebug@software.joehewitt.com.xpi").getFile()),"2.0.17");

    }

    @Test(groups = {"BaiduHomePage"})
    public void menuTest() throws InterruptedException {
        //加载用例
        String sheetName = "menu";
        List<TestCase> testCases= ExcelUtil.readExcel(caseFile,sheetName);
        testCases.remove(0);

        //初始化浏览器
        driver = new FirefoxService().init();

        //执行用例
        for(TestCase testCase : testCases){

            //打开链接
            new BaiduHomePage(driver).openLinkByText(testCase.getInput());

            //获取新链接
            String currentUrl = driver.getCurrentUrl();
            System.out.println(currentUrl);

            //判断链接是否正确
            Boolean result = resultCompare(testCase.getExpectResult(),currentUrl);
            testCase.setActualResult(currentUrl);
            testCase.setResult(result);

        }

    }
    @AfterTest
    public  void  AfterTest(){
        driver.quit();
    }

    /**结果对比*/
    public Boolean resultCompare(String expect, String actual){
        if(expect.equals(actual)){
            System.out.println("测试通过");
            return true;
        }else {
            System.out.println("测试失败");
            return false;
        }
    }
}
