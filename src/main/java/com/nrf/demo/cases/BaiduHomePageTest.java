package com.nrf.demo.cases;

import com.nrf.demo.service.FirefoxService;
import org.apache.bcel.util.ClassLoader;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016/12/18.
 */
public class BaiduHomePageTest {
    private WebDriver driver;
    private String baseUrl = "https://www.baidu.com/";

    @BeforeTest
    public void beforeTest(){
        FirefoxService service = new FirefoxService();
        service.addPlugin("extensions.firebug.currentVersion",new File(ClassLoader.getSystemResource("plugins/firebug@software.joehewitt.com.xpi").getFile()),"2.0.17");
        driver = service.init();
        driver.manage().window().maximize();
    }

    @Test
    public void menuTest(){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        List<WebElement> webElementList = (List<WebElement>)javascriptExecutor.executeScript("return jQuery.find('a.mnav')");
        Assert.assertEquals(webElementList.size(),6);
        for(WebElement element : webElementList){
            System.out.println(element.getText());
        }
    }

    @AfterTest
    public  void  tearDown(){
        driver.quit();
    }
}
