package models;

import com.opencsv.bean.CsvBindByName;

public class WomanModel {
    @CsvBindByName(column = "firstNameWoman")
    private String firstNameWoman;
    @CsvBindByName(column = "lastNameWoman")
    private String lastNameWoman;
    @CsvBindByName(column = "ageWomanSimple")
    private int ageWomanSimple;
    @CsvBindByName(column = "ageWomanRetired")
    private int ageWomanRetired;
    @CsvBindByName(column = "womanPartner")
    private String partner;

    public String getFirstNameWoman() {
        return firstNameWoman;
    }

    public void setFirstNameWoman(String firstNameWoman) {
        this.firstNameWoman = firstNameWoman;
    }

    public String getLastNameWoman() {
        return lastNameWoman;
    }

    public void setLastNameWoman(String lastNameWoman) {
        this.lastNameWoman = lastNameWoman;
    }

    public int getAgeWomanSimple() {
        return ageWomanSimple;
    }

    public void setAgeWomanSimple(int ageWomanSimple) {
        this.ageWomanSimple = ageWomanSimple;
    }

    public int getAgeWomanRetired() {
        return ageWomanRetired;
    }

    public void setAgeWomanRetired(int ageWomanRetired) {
        this.ageWomanRetired = ageWomanRetired;
    }

    public String getWomanPartner() {
        return partner;
    }

    public void setPartner(String partner) {
        this.partner = partner;
    }
}
