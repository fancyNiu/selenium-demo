package com.nrf.demo.service;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;

/**
 * 启动firfox浏览器
 */
public class ChromeService {

    WebDriver driver;

    /**
     * 简单启动firefox浏览器
     */
    public WebDriver init(){
        System.setProperty("webdriver.chrome.driver", ClassLoader.getSystemResource("drivers/chromedriver.exe").getFile());
        ChromeDriverService service = new ChromeDriverService.Builder().usingAnyFreePort().build();
        try {
            service.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver = new RemoteWebDriver(service.getUrl(), DesiredCapabilities.chrome());
        return driver;
    }



    /**
     * 带插件启动firefox浏览器
     */
    public WebDriver init(File plugin , String pluginVersion){
        //指定浏览器路径
        System.setProperty("webdriver.chrome.driver","C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");

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
