package com.nrf.demo.service;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.service.DriverService;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 启动firfox浏览器
 */
public class FirefoxService {

    WebDriver driver;

    /**
     * 简单启动firefox浏览器
     */
    public WebDriver init(){
//        System.setProperty("webdriver.firefox.bin","D:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
        System.setProperty("webdriver.gecko.driver",ClassLoader.getSystemResource("drivers/geckodriver.exe").getFile());
        FirefoxBinary firefoxBinary = new FirefoxBinary(new File("D:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe"));
        driver = new FirefoxDriver(firefoxBinary,null);
        return driver;
    }



    /**
     * 带插件启动firefox浏览器
     */
    public WebDriver init(File plugin , String pluginVersion){
        //指定firefox路径
        System.setProperty("webdriver.firefox.driver","D:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");

        //声明一个profile对象，里面保存用户的相关信息
        FirefoxProfile firefoxProfile = new FirefoxProfile();

        //把firebug插件加入profile
        firefoxProfile.addExtension(plugin);

        //设置插件版本
        firefoxProfile.setPreference("extensions.plugin.version",pluginVersion);

        //启动firefox
        driver = new FirefoxDriver(firefoxProfile);
        return driver;
    }
}
