package com.nrf.demo.cases;

import com.nrf.demo.model.BaiduHomePage;
import com.nrf.demo.model.TestCase;
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
//    private WebDriver driver;
    private String baseUrl = "https://www.baidu.com/";
    private File caseFile;

    /**加载用例并初始化页面*/
    @Parameters({"caseFile","resultReprot"})
    @BeforeTest
    public void beforeTest(String caseFile, String resultReport){
        //获取用例文件
        this.caseFile = new File(ClassLoader.getSystemResource(caseFile).getFile());

        //浏览器带插件初始化

//        service.addPlugin("extensions.firebug.currentVersion",new File(ClassLoader.getSystemResource("plugins/firebug@software.joehewitt.com.xpi").getFile()),"2.0.17");

    }

    @Test(groups = {"BaiduHomePage"})
    public void menuTest() throws InterruptedException {
        //加载用例
        String sheetName = "menu";
        List<TestCase> testCases= ExcelUtil.readExcel(caseFile,sheetName);
        testCases.remove(0);

        //执行用例
        for(TestCase testCase : testCases){
            //获取百度首页的菜单栏
            FirefoxService service = new FirefoxService();
            WebDriver driver = service.init();
            List<WebElement> menuList = new BaiduHomePage(driver).getMenu();

            Boolean result = true;
            if(menuList.size() == 6){
                System.out.println("共找到了6个标签");
            }else {
                System.out.println("找到的标签数量不对，目标是6个，只找到了{}" + menuList.size());
            }
            for(WebElement menu : menuList){
                testCase.getInput();
                if(testCase.getInput().equals(menu.getText())){
                    menu.click();
                    Thread.sleep(500);
                    //获取所有新窗口的句柄，
                    String currentUrl = driver.getCurrentUrl();

                    //如果只打开了目标窗口，则测试通过
                    if(currentUrl.equals(testCase.getExpectResult())){
                        continue;
                    }else if(!currentUrl.equals(baseUrl) && currentUrl.equals(testCase.getExpectResult())){
                        System.out.println("打开的窗口不正确，预期打开窗口"+testCase.getExpectResult()+"，实际打开窗口"+currentUrl);
                        result = false;
                    }else {
                        System.out.println("没有成功打开窗口");
                        result = false;
                    }

                    testCase.setActualResult(currentUrl);
                    testCase.setResult(result);
                }

            }
            //关闭浏览器
            String handle = driver.getWindowHandle();
            driver.switchTo().window(handle);
            driver.quit();
        }

    }

    @AfterTest
    public  void  AfterTest(){

    }
}
