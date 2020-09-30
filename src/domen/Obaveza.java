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
public class Obaveza implements GeneralEntity {

    private int brResenja;
    private double ukupniIznos;
    private Date datumKreiranja;
    private Racun racun;

    public Obaveza() {
    }

    public Obaveza(int brResenja) {
        this.brResenja = brResenja;
    }

    public Obaveza(int brResenja, double ukupniIznos, Date datumKreiranja, Racun racun) {
        this.brResenja = brResenja;
        this.ukupniIznos = ukupniIznos;
        this.datumKreiranja = datumKreiranja;
        this.racun = racun;
    }

    public Racun getRacun() {
        return racun;
    }

    public void setRacun(Racun racun) {
        this.racun = racun;
    }

    public int getBrResenja() {
        return brResenja;
    }

    public void setBrResenja(int brResenja) {
        this.brResenja = brResenja;
    }

    public double getUkupniIznos() {
        return ukupniIznos;
    }

    public void setUkupniIznos(double ukupniIznos) {
        this.ukupniIznos = ukupniIznos;
    }

    public Date getDatumKreiranja() {
        return datumKreiranja;
    }

    public void setDatumKreiranja(Date datumKreiranja) {
        this.datumKreiranja = datumKreiranja;
    }

    @Override
    public String getClassName() {
        return "Obaveza";
    }

    @Override
    public String getAtrValue() {
        StringBuilder sb = new StringBuilder();
        sb.append("").append("default").
                append(", '").append(ukupniIznos).
                append("', '").append(new java.sql.Date(datumKreiranja.getTime())).
                append("', '").append(racun.getObveznik().getBrObveznika()).
                append("', '").append(racun.getRacun().getBrRacuna()).
                append("'");
        return sb.toString();
    }

    @Override
    public String setAtrValue() {
        StringBuilder sb = new StringBuilder();
        sb.append("BrResenja").append("='").append(brResenja).append("',").
                append("UkupniIznos").append("='").append(ukupniIznos).append("',").
                append("DatumKreiranja").append("='").append(datumKreiranja).append("',").
                append("BrObveznika").append("='").append(racun.getObveznik().getBrObveznika()).append("',").
                append("BrRacuna").append("='").append(racun.getRacun().getBrRacuna()).append("'");
        return sb.toString();
    }

    @Override
    public String getNameByColumn(int i) {
        String[] atributi = {"BrResenja", "UkupniIznos", "DatumKreiranja", "BrObveznika", "BrRacuna"};
        return atributi[i];
    }

    @Override
    public String getWhereCondition() {
        return "BrResenja = " + brResenja;
    }

    @Override
    public GeneralEntity getNewRecord(ResultSet rs) throws SQLException {
        return new Obaveza(rs.getInt("BrResenja"), rs.getDouble("UkupniIznos"), rs.getDate("DatumKreiranja"), new Racun(new Obveznik(rs.getInt("BrObveznika")), new VrstaRacuna(rs.getInt("BrRacuna"))));
    }

    @Override
    public String getSpecialCondition() {
        return "";
    }

    @Override
    public String getForeignKeyCondition() {
        return "BrRacuna = " + racun.getRacun().getBrRacuna() + " and BrObveznika = " + racun.getObveznik().getBrObveznika();
    }

}
