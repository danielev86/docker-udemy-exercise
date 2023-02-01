package com.danielev86.front.controller;

import com.danielev86.front.bean.Contract;
import com.danielev86.service.PtfService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean(name = "homeController")
@ViewScoped
public class HomeBackingBean implements Serializable {

    private String testField;

    private List<Contract> contracts;

    @ManagedProperty(value = "#{ptfService}")
    private PtfService ptfService;

    @PostConstruct
    public void init(){
        contracts = ptfService.getAllContracts();
    }

    public void refreshRowExpansion(Contract contract, boolean expanded){
        contract.setExpanded(expanded);
    }

    public String getTestField() {
        return testField;
    }

    public void setTestField(String testField) {
        this.testField = testField;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    public PtfService getPtfService() {
        return ptfService;
    }

    public void setPtfService(PtfService ptfService) {
        this.ptfService = ptfService;
    }
}
