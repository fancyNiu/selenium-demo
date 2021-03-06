package com.nrf.demo.service;


import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

/**
 * 启动firfox浏览器
 */
public class FirefoxService {

    private WebDriver driver;
    private FirefoxProfile profile = new FirefoxProfile();

    /**
     * 简单启动firefox浏览器
     */
    public WebDriver init(){
        //指定firefox的driver
//        System.setProperty("webdriver.firefox.bin","D:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
        System.setProperty("webdriver.gecko.driver",ClassLoader.getSystemResource("drivers/geckodriver.exe").getFile());
        FirefoxBinary firefoxBinary = new FirefoxBinary(new File("D:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe"));
//        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
//        capabilities.setCapability("webdriver.firefox.bin","D:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
        driver = new FirefoxDriver(firefoxBinary,null);
        return driver;
    }

    /**
     * firefox浏览器中加入插件
     */
//    public void addPlugin(String pluginKey, File firebug, String firebugVersion){
//        //把插件加入profile,此处需要注意安装的插件是否通过火狐签名认证，没有通过认证的插件是装不上的
//        profile.addExtension(firebug);
//        //设置插件版本
//        profile.setPreference(pluginKey,firebugVersion);
//    }
}
