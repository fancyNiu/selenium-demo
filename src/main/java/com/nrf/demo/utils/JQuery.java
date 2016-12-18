package com.nrf.demo.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriverException;

/**
 * jquery相关工具类
 */
public class JQuery {

    /**  jquery注入方法  */
    public static void inJectJQuery(JavascriptExecutor javascriptExecutor){
        javascriptExecutor.executeScript("var headID = document.getElementsByTagName(\"head\")[0];"
                + "var newScript = document.createElement('script');"
                + "newScript.type = 'text/Javascript';"
                + "newScript.src = \"http://code.jquery.com/jquery-3.1.1.min.js\";"
                + "headID.appendChild(newScript)");
    }
    /**  判断当前页面是否使用了jquery   */
    public static Boolean isJQueryLoaded(JavascriptExecutor javascriptExecutor){
        Boolean isLoaded = true;
        try{
            isLoaded = (Boolean) javascriptExecutor.executeScript("return jQuery()!=null");
        }catch (WebDriverException e){
            isLoaded =false;
        }
        return isLoaded;
    }
}
