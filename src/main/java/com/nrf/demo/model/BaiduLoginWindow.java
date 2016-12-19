package com.nrf.demo.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by puhui on 2016/12/19.
 */
public class BaiduLoginWindow {
    private WebDriver driver;
    //用户名输入框
    @FindBy(name="userName")
    @CacheLookup
    public By userNameBox;

    //密码输入框
    @FindBy(name="password")
    @CacheLookup
    public By passwordBox;

    //验证码输入框
    @FindBy(name="verifyCode")
    @CacheLookup
    public By verifyCodeBox;

    //验证码输入框
    @FindBy(name="memberPass")
    @CacheLookup
    public By memberPassCheckBox;

    //登陆按钮
    @FindBy(id="TANGRAM__PSP_8__submit")
    @CacheLookup
    public By loginButton;

    public BaiduLoginWindow(WebDriver driver) {
        BaiduHomePage baiduHomePage = new BaiduHomePage(driver);
        baiduHomePage.getLoginWindow();
        this.driver = driver;
    }

    public void login(String userName, String password, Boolean memberPass){
        driver.findElement(userNameBox).clear();
        driver.findElement(userNameBox).sendKeys(userName);
        driver.findElement(passwordBox).clear();
        driver.findElement(passwordBox).sendKeys(password);
        if(driver.findElement(memberPassCheckBox).isSelected()!=memberPass){
            driver.findElement(memberPassCheckBox).click();
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(loginButton).submit();
    }

}
