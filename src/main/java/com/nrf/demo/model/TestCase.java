package com.nrf.demo.model;

import jxl.Cell;

import java.util.List;

/**
 * Created by puhui on 2016/12/20.
 */
public class TestCase {
    /**测试用例id*/
    public String id;
    /**测试页面名称*/
    public String page;
    /**测试模块名称*/
    public String module;
    /**测试用例名称*/
    public String name;
    /**优先级*/
    public String priority;
    /**用例类型*/
    public String type;
    /**测试步骤*/
    public String step;
    /**测试输入*/
    public String input;
    /**预期输出*/
    public String expectResult;
    /**实际输出*/
    public String actualResult;
    /**测试结果*/
    public Boolean result;
    /**完整日志*/
    public String log;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        id = id;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        page = page;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        module = module;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        priority = priority;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        type = type;
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        step = step;
    }

    public String getInput() {
        return input;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        result = result;
    }

    public void setInput(String input) {
        input = input;
    }

    public String getExpectResult() {
        return expectResult;
    }

    public void setExpectResult(String expectResult) {
        expectResult = expectResult;
    }

    public String getActualResult() {
        return actualResult;
    }

    public void setActualResult(String actualResult) {
        actualResult = actualResult;
    }


    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        log = log;
    }

    @Override
    public String toString() {
        return "TestCase{" +
                "id=" + id +
                ", page='" + page + '\'' +
                ", module='" + module + '\'' +
                ", name='" + name + '\'' +
                ", priority='" + priority + '\'' +
                ", type='" + type + '\'' +
                ", step='" + step + '\'' +
                ", input='" + input + '\'' +
                ", expectResult='" + expectResult + '\'' +
                ", actualResult='" + actualResult + '\'' +
                ", result='" + result + '\'' +
                ", log='" + log + '\'' +
                '}';
    }

    public TestCase(Cell[] cells) {
        id = cells[0].getContents();
        page = cells[1].getContents();
        module = cells[2].getContents();
        name = cells[3].getContents();
        priority = cells[4].getContents();
        type = cells[5].getContents();
        step = cells[6].getContents();
        input = cells[7].getContents();
        expectResult = cells[8].getContents();
        actualResult = "";
        result = false;
        log = "";
    }

}
