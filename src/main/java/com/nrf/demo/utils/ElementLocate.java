package com.nrf.demo.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * 工具类，对元素定位进行封装，方便将来将页面元素放进excel进行维护
 */
public class ElementLocate {

    public static WebElement locate(WebDriver driver, String key, String value){
        WebElement element = null;
        if("id".equals(key)){
            element = driver.findElement(By.id(value));
        }else if("classname".equals(key)){
            element = driver.findElement(By.className(value));
        }else if("name".equals(key)){
            element = driver.findElement(By.name(value));
        }else if("cssSelector".equals(key)){
            element = driver.findElement(By.cssSelector(value));
        }else if("linkText".equals(key)){
            element = driver.findElement(By.linkText(value));
        }else if("partialLinkText".equals(key)){
            element = driver.findElement(By.partialLinkText(value));
        }else if("tagName".equals(key)){
            element = driver.findElement(By.tagName(value));
        }else if("xpath".equals(key)){
            element = driver.findElement(By.xpath(value));
        }else {
            return null;
        }
        return element;
    }
}
