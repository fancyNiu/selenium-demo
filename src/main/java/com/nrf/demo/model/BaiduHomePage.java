package com.nrf.demo.model;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by puhui on 2016/12/19.
 */
public class BaiduHomePage {
    private WebDriver driver;
    //百度首页地址
    private final String url = "https://www.baidu.com";
    //百度搜索框
    @FindBy(id="kw")
    @CacheLookup
    public WebElement searchBox;
    //百度一下按钮
    @FindBy(id="su")
    @CacheLookup
    public By searchButton;
    //登陆按钮
    @FindBy(className="lb")
    @CacheLookup
    public By login;

    public BaiduHomePage(WebDriver driver) {
        this.driver = driver;
    }

    /**打开百度首页*/
    public WebDriver getUrl(){
        driver.get(url);
        return driver;
    }

    /**打开登陆窗口*/
    public void getLoginWindow(){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        List<WebElement> elements = (List<WebElement>) javascriptExecutor.executeScript("return jQuery.find('a.lb')");
        elements.get(1).click();
    }

    /**定位到标签栏*/
    public void openLinkByText(String text) throws InterruptedException {
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        List<WebElement> menus = null;
        try {
            menus = (List<WebElement>) ((JavascriptExecutor)driver).executeScript("return jQuery.find('a.mnav')");
        }catch (RuntimeException e){
            e.printStackTrace();
        }

        for(WebElement menu : menus){
            if(text.equals(menu.getText())){
                menu.click();
                break;
            }
        }
        Thread.sleep(1000);
    }
}
