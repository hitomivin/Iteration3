package sample;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Patient {
    private int borgerID;
    private String CPR;
    private String fornavn;
    private String efternavn;
    private String fødslesdato;
    private String køn;
    private String postnr;
    private String bynavn;
    private String adresse1;
    private String adresse2;

    public int getAlderFraFødselsdato() {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("uuuuMMdd");
        LocalDate today = LocalDate.now();
        LocalDate birthday = LocalDate.parse(this.fødslesdato, dateFormat);

        int age = Period.between(birthday, today).getYears();

        return age;
    }

    public int getBorgerID() {
        return borgerID;
    }

    public void setBorgerID(int borgerID) {
        this.borgerID = borgerID;
    }

    public String getCPR() {
        return CPR;
    }

    public void setCPR(String CPR) {
        this.CPR = CPR;
    }

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEfternavn() {
        return efternavn;
    }

    public void setEfternavn(String efternavn) {
        this.efternavn = efternavn;
    }

    public String getFødslesdato() {
        return fødslesdato;
    }

    public void setFødslesdato(String fødslesdato) {
        this.fødslesdato = fødslesdato;
    }

    public String getKøn() {
        if (køn == "K") { return "kvinder"; }
        else if (køn == "M") { return "mænd"; }
        else { return ""; }
    }

    public void setKøn(String køn) {
        this.køn = køn;
    }

    public String getPostnr() {
        return postnr;
    }

    public void setPostnr(String postnr) {
        this.postnr = postnr;
    }

    public String getBynavn() {
        return bynavn;
    }

    public void setBynavn(String bynavn) {
        this.bynavn = bynavn;
    }

    public String getAdresse1() {
        return adresse1;
    }

    public void setAdresse1(String adresse1) {
        this.adresse1 = adresse1;
    }

    public String getAdresse2() {
        return adresse2;
    }

    public void setAdresse2(String adresse2) {
        this.adresse2 = adresse2;
    }
}
