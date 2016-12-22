package com.nrf.demo.service;

import org.apache.bcel.util.ClassLoader;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.io.File;

/**
 * Created by puhui on 2016/12/16.
 */
public class FireFoxServiceTest {

    private WebDriver driver;

    @Test
    public void initTest() throws InterruptedException {
        String url = "https://www.baidu.com/";
        driver = new FirefoxService().init();
        driver.manage().window().maximize();
        driver.get(url);
        Assert.assertEquals("没有成功打开" + url, url, driver.getCurrentUrl());
        driver.close();

    }

    @Test
    public void addPluginTest(){
        String url = "https://www.baidu.com/";
        FirefoxService service = new FirefoxService();
//        service.addPlugin("extensions.firebug.currentVersion",new File(ClassLoader.getSystemResource("plugins/firebug@software.joehewitt.com.xpi").getFile()),"2.0.17");
        driver = service.init();
        driver.manage().window().maximize();
        driver.get(url);
        Assert.assertEquals("没有成功打开" + url, url, driver.getCurrentUrl());
    }

    @After
    public void tearDown(){
//        driver.quit();
    }

}
