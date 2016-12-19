package com.nrf.demo.model;

import com.nrf.demo.service.FirefoxService;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

/**
 * Created by Administrator on 2016/12/19.
 */
public class BaiduHomePageTest {
    @Test
    public void getUrl(){
        WebDriver driver = new FirefoxService().init();
        BaiduHomePage baiduHomePage = new BaiduHomePage(driver);
        baiduHomePage.getUrl();
    }

    @Test
    public void getLoginWindow(){
        WebDriver driver = new FirefoxService().init();
        BaiduHomePage baiduHomePage = new BaiduHomePage(driver);
        baiduHomePage.getLoginWindow();
    }



}
