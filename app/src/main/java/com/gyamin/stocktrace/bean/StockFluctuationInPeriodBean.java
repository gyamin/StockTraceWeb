package com.gyamin.stocktrace.bean;

import java.util.Date;

/**
 *
 */
public class StockFluctuationInPeriodBean {
    private String section;             // 市場
    private Integer issueCode;          // 銘柄コード
    private String issueName;           // 銘柄名

    private Date tradeDate;             // 取引日
    private Double nowPrice;            // 現在値

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public Integer getIssueCode() {
        return issueCode;
    }

    public void setIssueCode(Integer issueCode) {
        this.issueCode = issueCode;
    }

    public String getIssueName() {
        return issueName;
    }

    public void setIssueName(String issueName) {
        this.issueName = issueName;
    }

    public Date getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(Date tradeDate) {
        this.tradeDate = tradeDate;
    }

    public Double getNowPrice() {
        return nowPrice;
    }

    public void setNowPrice(Double nowPrice) {
        this.nowPrice = nowPrice;
    }
}
