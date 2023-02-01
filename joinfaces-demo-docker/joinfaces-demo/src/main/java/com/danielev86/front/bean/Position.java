package com.danielev86.front.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class Position implements Serializable {

    private static final long serialVersionUID = -651704705507823306L;

    private String positionCode;

    private BigDecimal ctv;

    private BigDecimal qta;

    private Product product;

    private List<Position> underlines;

    public String getPositionCode() {
        return positionCode;
    }

    public void setPositionCode(String positionCode) {
        this.positionCode = positionCode;
    }

    public BigDecimal getCtv() {
        return ctv;
    }

    public void setCtv(BigDecimal ctv) {
        this.ctv = ctv;
    }

    public BigDecimal getQta() {
        return qta;
    }

    public void setQta(BigDecimal qta) {
        this.qta = qta;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Position> getUnderlines() {
        return underlines;
    }

    public void setUnderlines(List<Position> underlines) {
        this.underlines = underlines;
    }

}
