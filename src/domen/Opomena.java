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
public class Opomena implements GeneralEntity {

    private int brOpomene;
    private double iznosZaUplatu;
    private Date datumSlanja;
    private Rata rata;

    public Opomena() {
    }

    public Opomena(int brOpomene) {
        this.brOpomene = brOpomene;
    }

    public Opomena(int brOpomene, double iznosZaUplatu, Date datumSlanja, Rata rata) {
        this.brOpomene = brOpomene;
        this.iznosZaUplatu = iznosZaUplatu;
        this.datumSlanja = datumSlanja;
        this.rata = rata;
    }

    public Rata getRata() {
        return rata;
    }

    public void setRata(Rata rata) {
        this.rata = rata;
    }

    public int getBrOpomene() {
        return brOpomene;
    }

    public void setBrOpomene(int brOpomene) {
        this.brOpomene = brOpomene;
    }

    public double getIznosZaUplatu() {
        return iznosZaUplatu;
    }

    public void setIznosZaUplatu(double iznosZaUplatu) {
        this.iznosZaUplatu = iznosZaUplatu;
    }

    public Date getDatumSlanja() {
        return datumSlanja;
    }

    public void setDatumSlanja(Date datumSlanja) {
        this.datumSlanja = datumSlanja;
    }

    @Override
    public String getClassName() {
        return "Opomena";
    }

    @Override
    public String getAtrValue() {
        StringBuilder sb = new StringBuilder();
        sb.append("").append("default").
                append(", ").append(iznosZaUplatu).
                append(", '").append(new java.sql.Date(datumSlanja.getTime())).
                append("', ").append(rata.getBrRate());
        return sb.toString();
    }

    @Override
    public String setAtrValue() {
        StringBuilder sb = new StringBuilder();
        sb.append("BrOpomene").append("='").append(brOpomene).append("',").
                append("IznosZaUplatu").append("=").append(iznosZaUplatu).append(",").
                append("DatumSlanja").append("='").append(datumSlanja).append("',").
                append("BrRate").append("='").append(rata.getBrRate()).append("',");
        return sb.toString();
    }

    @Override
    public String getNameByColumn(int i) {
        String[] atributi = {"BrOpomene", "IznosZaUplatu", "DatumSlanja", "BrRate"};
        return atributi[i];
    }

    @Override
    public String getWhereCondition() {
        return "BrOpomene = " + brOpomene;
    }

    @Override
    public GeneralEntity getNewRecord(ResultSet rs) throws SQLException {
        return new Opomena(rs.getInt("BrOpomene"), rs.getDouble("IznosZaUplatu"), rs.getDate("DatumSlanja"), new Rata(rs.getInt("BrRate"), new Obaveza(rs.getInt("BrResenja"))));
    }

    @Override
    public String getSpecialCondition( ) {
        return "";
    }
    
    @Override
    public String getForeignKeyCondition() {
        return "BrRate = " + rata.getBrRate();
    }

}
