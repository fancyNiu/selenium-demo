package com.nrf.demo.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.Iterator;
import java.util.Set;

/**
 * Created by puhui on 2016/12/19.
 */
public class BaiduLoginWindow {
    private WebDriver driver;
    //用户名输入框
    @FindBy(xpath="//*[@id=\"TANGRAM__PSP_8__userName\"]")
    @CacheLookup
    public By userNameBox;

    //密码输入框
    @FindBy(xpath=".//*[@id='TANGRAM__PSP_8__userName']")
    @CacheLookup
    public By passwordBox;

    //验证码输入框
    @FindBy(name="verifyCode")
    @CacheLookup
    public By verifyCodeBox;

    //自动登陆选择框
    @FindBy(id="TANGRAM__PSP_8__memberPass")
    @CacheLookup
    public By memberPassCheckBox;

    //登陆按钮
    @FindBy(id="TANGRAM__PSP_8__submit")
    @CacheLookup
    public By loginButton;

    public BaiduLoginWindow(WebDriver driver) throws InterruptedException {
        BaiduHomePage baiduHomePage = new BaiduHomePage(driver);
        this.driver = baiduHomePage.getLoginWindow();
    }

    /**登陆功能*/
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
