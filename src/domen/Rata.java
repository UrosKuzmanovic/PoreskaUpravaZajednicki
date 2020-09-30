/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author Ookee
 */
public class Rata implements GeneralEntity {

    private int brRate;
    private Obaveza resenje;
    private double iznosRate;
    private Date rokZaUplatu;

    public Rata() {
    }

    public Rata(int brRate, Obaveza resenje) {
        this.brRate = brRate;
        this.resenje = resenje;
    }

    public Rata(int brRate, Obaveza resenje, double iznosRate, Date rokZaUplatu) {
        this.brRate = brRate;
        this.resenje = resenje;
        this.iznosRate = iznosRate;
        this.rokZaUplatu = rokZaUplatu;
    }

    public Date getRokZaUplatu() {
        return rokZaUplatu;
    }

    public void setRokZaUplatu(Date rokZaUplatu) {
        this.rokZaUplatu = rokZaUplatu;
    }

    public int getBrRate() {
        return brRate;
    }

    public void setBrRate(int brRate) {
        this.brRate = brRate;
    }

    public Obaveza getResenje() {
        return resenje;
    }

    public void setResenje(Obaveza resenje) {
        this.resenje = resenje;
    }

    public double getIznosRate() {
        return iznosRate;
    }

    public void setIznosRate(double iznosRate) {
        this.iznosRate = iznosRate;
    }

    @Override
    public String getClassName() {
        return "Rata";
    }

    @Override
    public String getAtrValue() {
        StringBuilder sb = new StringBuilder();
        sb.append("").append("default").
                append(", '").append(resenje.getBrResenja()).
                append("', '").append(iznosRate).
                append("', '").append(new java.sql.Date(rokZaUplatu.getTime())).
                append("'");
        return sb.toString();
    }

    @Override
    public String setAtrValue() {
        StringBuilder sb = new StringBuilder();
        sb.append("BrRate").append("=").append(brRate).append(",").
                append("BrResenja").append("=").append(resenje.getBrResenja()).append(",").
                append("IznosRate").append("=").append(iznosRate).append(",").
                append("RokZaUplatu").append("='").append(rokZaUplatu).append("'");
        return sb.toString();
    }

    @Override
    public String getNameByColumn(int i) {
        String[] atributi = {"BrRate", "BrResenja", "IznosRate", "RokZaUplatu"};
        return atributi[i];
    }

    @Override
    public String getWhereCondition() {
        return "BrRate = " + brRate + " and BrResenja = " + resenje.getBrResenja();
    }

    @Override
    public GeneralEntity getNewRecord(ResultSet rs) throws SQLException {
        return new Rata(rs.getInt("BrRate"), new Obaveza(rs.getInt("BrResenja")), rs.getDouble("IznosRate"), rs.getDate("RokZaUplatu"));
    }
    
    @Override
    public String getSpecialCondition() {
        return "";
    }
    
    @Override
    public String getForeignKeyCondition() {
        return "BrResenja = " + resenje.getBrResenja();
    }

}
