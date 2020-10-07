package com.firstlab.dto;


public class ExpenditureDTO {
    private String tittle;
    private Integer money;
    private String firmName;
    private String firmManager;
    private String firmContactNumber;
    private String realmTittle;

    public ExpenditureDTO() {
    }

    public ExpenditureDTO(String tittle, Integer money, String firmName, String firmManager, String firmContactNumber, String realmTittle) {
        this.tittle = tittle;
        this.money = money;
        this.firmName = firmName;
        this.firmManager = firmManager;
        this.firmContactNumber = firmContactNumber;
        this.realmTittle = realmTittle;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public String getFirmName() {
        return firmName;
    }

    public void setFirmName(String firmName) {
        this.firmName = firmName;
    }

    public String getFirmManager() {
        return firmManager;
    }

    public void setFirmManager(String firmManager) {
        this.firmManager = firmManager;
    }

    public String getFirmContactNumber() {
        return firmContactNumber;
    }

    public void setFirmContactNumber(String firmContactNumber) {
        this.firmContactNumber = firmContactNumber;
    }

    public String getRealmTittle() {
        return realmTittle;
    }

    public void setRealmTittle(String realmTittle) {
        this.realmTittle = realmTittle;
    }

    @Override
    public String toString() {
        return "ExpenditureDTO{" +
                "tittle='" + tittle + '\'' +
                ", money=" + money +
                ", firmName='" + firmName + '\'' +
                ", firmManager='" + firmManager + '\'' +
                ", firmContactNumber='" + firmContactNumber + '\'' +
                ", realmTittle='" + realmTittle + '\'' +
                '}';
    }
}
