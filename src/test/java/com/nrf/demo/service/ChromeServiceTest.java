package com.nrf.demo.service;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

/**
 * Created by puhui on 2016/12/16.
 */
public class ChromeServiceTest {

    private WebDriver driver;

    @Test
    public void initTest(){
        String url = "https://www.baidu.com/";
        ChromeService service = new ChromeService();
        driver = service.init();
        driver.manage().window().maximize();
        driver.get(url);
        Assert.assertEquals("没有成功打开" + url, url, driver.getCurrentUrl());
    }

    @Test
    public void addOptionTest() throws InterruptedException {
        String url = "https://www.baidu.com/";
        ChromeService service = new ChromeService();
        service.addOptions("--user-data-dir=C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\User Data");
        driver = service.init();
//        driver.wait(2);
        driver.manage().window().maximize();
        driver.get(url);
        Assert.assertEquals("没有成功打开" + url, url, driver.getCurrentUrl());
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
