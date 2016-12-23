package com.nrf.demo.model;

import jxl.format.*;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.write.*;

/**
 * 定义测试报告格式
 */
public class ReportFormat {
    /**标题字体*/
    private WritableFont titleFont;
    /**标题格式*/
    private WritableCellFormat titleFormat;
    /**正文字体*/
    private WritableFont textFont;
    /**正文格式*/
    private WritableCellFormat textFormat;
    /**测试结果为pass的格式*/
    private WritableCellFormat resultPassFormat;
    /**测试结果为fail的格式*/
    private WritableCellFormat resultFailFormat;

    public WritableCellFormat getTextFormat() {
        return textFormat;
    }

    public void setTextFormat(WritableCellFormat textFormat) {
        this.textFormat = textFormat;
    }


    public WritableFont getTitleFont() {
        return titleFont;
    }

    public void setTitleFont(WritableFont titleFont) {
        this.titleFont = titleFont;
    }

    public WritableCellFormat getTitleFormat() {
        return titleFormat;
    }

    public void setTitleFormat(WritableCellFormat titleFormat) {
        this.titleFormat = titleFormat;
    }

    public WritableFont getTextFont() {
        return textFont;
    }

    public void setTextFont(WritableFont cellFont) {
        this.textFont = cellFont;
    }

    public WritableCellFormat getResultPassFormat() {
        return resultPassFormat;
    }

    public void setResultPassFormat(WritableCellFormat resultPassFormat) {
        this.resultPassFormat = resultPassFormat;
    }

    public WritableCellFormat getResultFailFormat() {
        return resultFailFormat;
    }

    public void setResultFailFormat(WritableCellFormat resultFailFormat) {
        this.resultFailFormat = resultFailFormat;
    }

    public ReportFormat() throws WriteException {
        titleFont = new WritableFont(WritableFont.ARIAL,8,WritableFont.BOLD,false, UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLACK);;
        titleFormat = new WritableCellFormat(titleFont);

        titleFormat.setBackground(Colour.ORANGE);
        titleFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
        textFont = new WritableFont(WritableFont.ARIAL,12,WritableFont.NO_BOLD,false, UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLACK);
        textFormat = new WritableCellFormat(textFont);
        textFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
        resultPassFormat = new WritableCellFormat(textFont);
        resultPassFormat.setBackground(Colour.GREEN);
        resultPassFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
        resultFailFormat = new WritableCellFormat(textFont);
        resultFailFormat.setBackground(Colour.RED);
        resultFailFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
    }
}
