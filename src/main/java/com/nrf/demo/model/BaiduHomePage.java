package com.nrf.demo.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by puhui on 2016/12/19.
 */
public class BaiduHomePage {

    @FindBy(id="kw")
    @CacheLookup
    public WebElement searchBox;

    @FindBy(id="su")
    @CacheLookup
    public WebElement getSearchBoxbutton;

}
