package com.nrf.demo.model;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by puhui on 2016/12/19.
 */
public class BaiduHomePage {
    public WebDriver driver;
    //百度首页地址
    private final String url = "https://www.baidu.com";
    //百度搜索框
    @FindBy(id="kw")
    @CacheLookup
    private By searchBox;
    //百度一下按钮
    @FindBy(id="su")
    @CacheLookup
    private By searchButton;
    //登陆按钮
    @FindBy(className="lb")
    @CacheLookup
    private By login;

    public BaiduHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getSearchBox(){
        return driver.findElement(searchBox);
    }

    public WebElement getSearchButton(){
        return driver.findElement(searchButton);
    }

    public WebElement getLogin(){
        return driver.findElement(login);
    }

    /**打开百度首页*/
    public WebDriver getUrl(){
        driver.get(url);
        return driver;
    }

    /**打开登陆窗口*/
    public WebDriver getLoginWindow(){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        List<WebElement> elements = (List<WebElement>) javascriptExecutor.executeScript("return jQuery.find('a.lb')");
        elements.get(1).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return driver;
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

    public void switchToNewWindow(){
        //得到当前句柄
        String currentWindow = driver.getWindowHandle();
        //得到所有窗口的句柄
        Set<String> handles = driver.getWindowHandles();

        //排除当前窗口的句柄，则剩下是新窗口
        Iterator<String> it = handles.iterator();
        while(it.hasNext()){
            if(currentWindow == it.next())  continue;
            driver.switchTo().window(it.next());
        }
    }
}
