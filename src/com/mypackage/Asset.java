package com.mypackage;

import java.math.BigDecimal;

public class Asset {

    /* Asset international identifier */
    public String ISIN;

    /* represents the number of shares held in the given asset, i.e. 4 shares of AAPL */
    public BigDecimal units;

    public Asset(String ISIN, BigDecimal units) {
        this.ISIN = ISIN;
        this.units = units;
    }
    public Asset(){}
}