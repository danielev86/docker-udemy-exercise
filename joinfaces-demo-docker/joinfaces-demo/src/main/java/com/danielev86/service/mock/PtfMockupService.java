package com.danielev86.service.mock;

import com.danielev86.front.bean.Contract;
import com.danielev86.front.bean.Position;
import com.danielev86.front.bean.Product;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PtfMockupService implements Serializable {

    private static final long serialVersionUID = 2205542894794319213L;

    public List<Contract> buildContracts(){
        Contract cntr1 = new Contract();
        cntr1.setContractCode("000100/9999999/00001");
        cntr1.setContractType("CNTR_TIT");
        cntr1.setPositions(buildDossierPosition());
        cntr1.setExpanded(true);

        Contract cntr2 = new Contract();
        cntr2.setContractCode("068/68/68/6888");
        cntr2.setPositions(Arrays.asList(buildPosPolWithUnderline()));
        cntr2.setExpanded(true);

        List<Contract> contracts = new ArrayList<>();
        contracts.add(cntr1);
        contracts.add(cntr2);
        return contracts;
    }

    private List<Position> buildDossierPosition(){
        List<Position> positions = new ArrayList<>();
        Product prod1 = buildProduct("000PRODDOS1", "DOSSIERTESTSHIT1", "DOSSIER POSITION TEST 1", "FON");
        Position pos1 = buildPosition("000POSDOS1", new BigDecimal("1000.00"), new BigDecimal("100.50"), prod1, null);
        Product prod2 = buildProduct("000PRODDOS2", "DOSSIERTESTSHIT1", "DOSSIER POSITION TEST 2", "FON");
        Position pos2 = buildPosition("000POSDOS2", new BigDecimal("1000.00"), new BigDecimal("100.50"), prod2, null);
        positions.add(pos1);
        positions.add(pos1);
        return positions;
    }

    private Position buildPosPolWithUnderline(){
        Product prodPol1 = buildProduct("000PRODPOL1", "PLSHIT", "SHIT BANK ASSURANCE POL 1", "POL");
        Position pos = buildPosition("000POSPOL1", new BigDecimal("2000.00"), null, prodPol1, buildUnderlinePosition());
        return pos;
    }

    private List<Position> buildUnderlinePosition(){
        List<Position> positions = new ArrayList<>();
        Product prodPol1 = buildProduct("000PRODPOL1", "PL1UNSHIT", "SHIT BANK ASSURANCE UNDER POL 1", "POL");
        Position underPos1 = buildPosition("000POSPOL1", new BigDecimal("1000.00"), new BigDecimal("100.50"), prodPol1, null);
        Product prodPol2 = buildProduct("000PRODPOL2", "PL2UNSHIT", "SHIT BANK ASSURANCE UNDER POL 2", "POL");
        Position underPos2 = buildPosition("000POSPOL2", new BigDecimal("1000.00"), new BigDecimal("100.50"), prodPol1, null);
        positions.add(underPos1);
        positions.add(underPos2);
        return positions;
    }

    private Contract buildContract(String contractCode,String contractType
            ,BigDecimal totCtvPosition,List<Position> positions){
        Contract contract = new Contract();
        contract.setContractCode(contractCode);
        contract.setContractType(contractType);
        contract.setPositions(positions);
        return contract;
    }

    private Position buildPosition(String positionCode, BigDecimal ctv, BigDecimal qta
            , Product product, List<Position> underlines){
        Position position = new Position();
        position.setPositionCode(positionCode);
        position.setCtv(ctv);
        position.setQta(qta);
        position.setProduct(product);
        position.setUnderlines(underlines);
        return position;
    }

    private Product buildProduct(String productCode, String isinCode, String productDesc, String productTypeCode){
        Product product = new Product();
        product.setProductCode(productCode);
        product.setProductDesc(productDesc);
        product.setIsinCode(isinCode);
        product.setProductTypeCode(productTypeCode);
        return product;
    }
}
