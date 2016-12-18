package com.nrf.demo.service;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


/**
 * 启动chrome浏览器
 */
public class ChromeService {

    private WebDriver driver;
    ChromeOptions options = new ChromeOptions();
    /**
     * 简单启动Chrome浏览器
     */
    public WebDriver init(){
        options.addArguments("--test-type", "--ignore-certificate-errors");
        System.setProperty("webdriver.chrome.driver", ClassLoader.getSystemResource("drivers/chromedriver.exe").getFile());
        driver = new ChromeDriver(options);
        return driver;
    }
    /**
     * 添加配置
     */
    public void addOptions(String option){
        options.addArguments(option);
    }
}
