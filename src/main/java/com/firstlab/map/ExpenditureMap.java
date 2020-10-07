package com.firstlab.map;

import com.firstlab.dto.ExpenditureDTO;
import com.firstlab.jpa.Expenditure;
import com.firstlab.jpa.Firm;
import com.firstlab.jpa.Realm;

public class ExpenditureMap implements Mapper<ExpenditureDTO, Expenditure> {

    @Override
    public ExpenditureDTO convertToDto(Expenditure var1) {
        ExpenditureDTO expenditureDTO = new ExpenditureDTO();
        if (var1.getTittle() != null) {
            expenditureDTO.setTittle(var1.getTittle());
        }
        if (var1.getMoney() != null) {
            expenditureDTO.setMoney(var1.getMoney());
        }
        if (var1.getFirm() != null) {
            if (var1.getFirm().getName() != null) {
                expenditureDTO.setFirmName(var1.getFirm().getName());
            }
            if (var1.getFirm().getManager() != null) {
                expenditureDTO.setFirmManager(var1.getFirm().getManager());
            }
            if (var1.getFirm().getContactNumber() != null) {
                expenditureDTO.setFirmContactNumber(var1.getFirm().getContactNumber());
            }
        }
        if (var1.getRealm() != null) {
            if (var1.getRealm().getTittle() != null) {
                expenditureDTO.setRealmTittle(var1.getRealm().getTittle());
            }
        }
        return expenditureDTO;

    }

    @Override
    public Expenditure convertToDocument(ExpenditureDTO var1) {
        try {
            Expenditure expenditure = new Expenditure();
            if (var1.getTittle() != null) {
                expenditure.setTittle(var1.getTittle());
            } else {
                throw new Exception("Error!Tittle is empty");
            }
            if (var1.getMoney() != null) {
                if (var1.getMoney() < 0) {
                    throw new Exception("Error!Money is negative");
                } else {
                    expenditure.setMoney(var1.getMoney());
                }
            }
            boolean isFirm = false;
            Firm firm = new Firm();
            if (var1.getFirmName() != null) {
                firm.setName(var1.getFirmName());
                isFirm = true;
            }
            if (var1.getFirmContactNumber() != null) {
                firm.setContactNumber(var1.getFirmContactNumber());
                isFirm = true;
            }
            if (var1.getFirmManager() != null) {
                firm.setManager(var1.getFirmManager());
                isFirm = true;
            }
            if (isFirm) {
                expenditure.setFirm(firm);
            }
            Realm realm = new Realm();
            boolean isRealm = false;
            if (var1.getRealmTittle() != null) {
                realm.setTittle(var1.getRealmTittle());
                isRealm = true;
            }
            if (isRealm) {
                expenditure.setRealm(realm);
            }
            return expenditure;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
