package com.danielev86.service;

import com.danielev86.front.bean.Contract;
import com.danielev86.service.mock.PtfMockupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Service
public class PtfService implements Serializable {

    @Autowired
    private PtfMockupService ptfMockService;

    public List<Contract> getAllContracts(){
        List<Contract> contracts = ptfMockService.buildContracts();
        for (Contract contract : contracts){
            BigDecimal ctvTot = contract.getPositions()
                    .stream().filter(pos -> pos.getCtv() != null)
                    .map(pos -> pos.getCtv())
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
            contract.setTotCtvPosition(ctvTot);
        }
        return contracts;
    }
}
