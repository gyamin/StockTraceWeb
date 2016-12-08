package com.gyamin.stocktrace.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 */
@Entity(listener = StockPricesListener.class)
@Table(name = "stock_prices")
public class StockPrices {

    /** */
    @Id
    @Column(name = "trade_date")
    LocalDate tradeDate;

    /** */
    @Id
    @Column(name = "issue_code")
    Integer issueCode;

    /** */
    @Column(name = "now_price")
    BigDecimal nowPrice;

    /** */
    @Column(name = "start_price")
    BigDecimal startPrice;

    /** */
    @Column(name = "highest_price")
    BigDecimal highestPrice;

    /** */
    @Column(name = "lowest_price")
    BigDecimal lowestPrice;

    /** */
    @Column(name = "year_hgihest_price")
    BigDecimal yearHgihestPrice;

    /** */
    @Column(name = "year_lowest_price")
    BigDecimal yearLowestPrice;

    /** */
    @Column(name = "sales_amount")
    BigDecimal salesAmount;

    /** */
    @Column(name = "trading_value")
    BigDecimal tradingValue;

    /** */
    @Column(name = "market_capitalization")
    BigDecimal marketCapitalization;

    /** 
     * Returns the tradeDate.
     * 
     * @return the tradeDate
     */
    public LocalDate getTradeDate() {
        return tradeDate;
    }

    /** 
     * Sets the tradeDate.
     * 
     * @param tradeDate the tradeDate
     */
    public void setTradeDate(LocalDate tradeDate) {
        this.tradeDate = tradeDate;
    }

    /** 
     * Returns the issueCode.
     * 
     * @return the issueCode
     */
    public Integer getIssueCode() {
        return issueCode;
    }

    /** 
     * Sets the issueCode.
     * 
     * @param issueCode the issueCode
     */
    public void setIssueCode(Integer issueCode) {
        this.issueCode = issueCode;
    }

    /** 
     * Returns the nowPrice.
     * 
     * @return the nowPrice
     */
    public BigDecimal getNowPrice() {
        return nowPrice;
    }

    /** 
     * Sets the nowPrice.
     * 
     * @param nowPrice the nowPrice
     */
    public void setNowPrice(BigDecimal nowPrice) {
        this.nowPrice = nowPrice;
    }

    /** 
     * Returns the startPrice.
     * 
     * @return the startPrice
     */
    public BigDecimal getStartPrice() {
        return startPrice;
    }

    /** 
     * Sets the startPrice.
     * 
     * @param startPrice the startPrice
     */
    public void setStartPrice(BigDecimal startPrice) {
        this.startPrice = startPrice;
    }

    /** 
     * Returns the highestPrice.
     * 
     * @return the highestPrice
     */
    public BigDecimal getHighestPrice() {
        return highestPrice;
    }

    /** 
     * Sets the highestPrice.
     * 
     * @param highestPrice the highestPrice
     */
    public void setHighestPrice(BigDecimal highestPrice) {
        this.highestPrice = highestPrice;
    }

    /** 
     * Returns the lowestPrice.
     * 
     * @return the lowestPrice
     */
    public BigDecimal getLowestPrice() {
        return lowestPrice;
    }

    /** 
     * Sets the lowestPrice.
     * 
     * @param lowestPrice the lowestPrice
     */
    public void setLowestPrice(BigDecimal lowestPrice) {
        this.lowestPrice = lowestPrice;
    }

    /** 
     * Returns the yearHgihestPrice.
     * 
     * @return the yearHgihestPrice
     */
    public BigDecimal getYearHgihestPrice() {
        return yearHgihestPrice;
    }

    /** 
     * Sets the yearHgihestPrice.
     * 
     * @param yearHgihestPrice the yearHgihestPrice
     */
    public void setYearHgihestPrice(BigDecimal yearHgihestPrice) {
        this.yearHgihestPrice = yearHgihestPrice;
    }

    /** 
     * Returns the yearLowestPrice.
     * 
     * @return the yearLowestPrice
     */
    public BigDecimal getYearLowestPrice() {
        return yearLowestPrice;
    }

    /** 
     * Sets the yearLowestPrice.
     * 
     * @param yearLowestPrice the yearLowestPrice
     */
    public void setYearLowestPrice(BigDecimal yearLowestPrice) {
        this.yearLowestPrice = yearLowestPrice;
    }

    /** 
     * Returns the salesAmount.
     * 
     * @return the salesAmount
     */
    public BigDecimal getSalesAmount() {
        return salesAmount;
    }

    /** 
     * Sets the salesAmount.
     * 
     * @param salesAmount the salesAmount
     */
    public void setSalesAmount(BigDecimal salesAmount) {
        this.salesAmount = salesAmount;
    }

    /** 
     * Returns the tradingValue.
     * 
     * @return the tradingValue
     */
    public BigDecimal getTradingValue() {
        return tradingValue;
    }

    /** 
     * Sets the tradingValue.
     * 
     * @param tradingValue the tradingValue
     */
    public void setTradingValue(BigDecimal tradingValue) {
        this.tradingValue = tradingValue;
    }

    /** 
     * Returns the marketCapitalization.
     * 
     * @return the marketCapitalization
     */
    public BigDecimal getMarketCapitalization() {
        return marketCapitalization;
    }

    /** 
     * Sets the marketCapitalization.
     * 
     * @param marketCapitalization the marketCapitalization
     */
    public void setMarketCapitalization(BigDecimal marketCapitalization) {
        this.marketCapitalization = marketCapitalization;
    }
}