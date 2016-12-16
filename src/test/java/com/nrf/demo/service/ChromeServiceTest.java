package com.nrf.demo.service;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by puhui on 2016/12/16.
 */
public class ChromeServiceTest {

    private WebDriver driver;

    @Test
    public void initWithoutPluginTest() throws InterruptedException {
        String url = "https://www.baidu.com/";
        driver = new ChromeService().init();
        driver.manage().window().maximize();
        driver.get(url);
        Assert.assertEquals("没有成功打开" + url, url, driver.getCurrentUrl());
    }

    @After
    public void tearDown(){
        driver.close();
    }
}
