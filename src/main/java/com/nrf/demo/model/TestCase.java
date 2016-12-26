package com.nrf.demo.model;

import jxl.Cell;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        this.id = id;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }

    public String getInput() {
        return input;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getExpectResult() {
        return expectResult;
    }

    public void setExpectResult(String expectResult) {
        this.expectResult = expectResult;
    }

    public String getActualResult() {
        return actualResult;
    }

    public void setActualResult(String actualResult) {
        this.actualResult = actualResult;
    }


    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
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


    public TestCase(Map<String,String> map) {
        id = map.get("测试用例编号");
        page = map.get("测试页面名称");
        module = map.get("测试模块名称");
        name = map.get("测试用例名称");
        priority = map.get("优先级");
        type = map.get("类型");
        step = map.get("步骤");
        input = map.get("输入");
        expectResult = map.get("预期输出");
        actualResult = "";
        result = false;
        log = "";
    }

}
