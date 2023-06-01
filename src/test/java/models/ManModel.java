package models;

import com.opencsv.bean.CsvBindByName;

public class ManModel {
    @CsvBindByName(column = "firstNameMan")
    private String firstNameMan;
    @CsvBindByName(column = "lastNameMan")
    private String lastNameMan;
    @CsvBindByName(column = "ageManSimple")
    private int ageManSimple;
    @CsvBindByName(column = "ageManRetired")
    private int ageManRetired;
    @CsvBindByName(column = "manPartner")
    private String partner;

    public int getSimpleMan() {
        return ageManSimple;
    }

    public void setSimpleMan(int simpleMan) {
        this.ageManSimple = simpleMan;
    }

    public int getRetiredMan() {
        return ageManRetired;
    }

    public void setRetiredMan(int retiredMan) {
        this.ageManRetired = retiredMan;
    }

    public String getFirstNameMan() {
        return firstNameMan;
    }

    public void setFirstNameMan(String firstNameMan) {
        this.firstNameMan = firstNameMan;
    }

    public String getLastNameMan() {
        return lastNameMan;
    }

    public void setLastNameMan(String lastNameMan) {
        this.lastNameMan = lastNameMan;
    }

    public String getManPartner() {
        return partner;
    }

    public void setPartner(String partner) {
        this.partner = partner;
    }
}
