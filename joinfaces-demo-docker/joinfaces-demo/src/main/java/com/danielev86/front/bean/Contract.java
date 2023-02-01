package com.danielev86.front.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class Contract implements Serializable {

    private String contractCode;

    private String contractType;

    private BigDecimal totCtvPosition;

    private List<Position> positions;

    private boolean expanded;

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    public BigDecimal getTotCtvPosition() {
        return totCtvPosition;
    }

    public void setTotCtvPosition(BigDecimal totCtvPosition) {
        this.totCtvPosition = totCtvPosition;
    }

    public List<Position> getPositions() {
        return positions;
    }

    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }

    public String getEscapedContractCode(){
        return contractCode.replaceAll("/", "_");
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }
}
