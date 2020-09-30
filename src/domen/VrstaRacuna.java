/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Ookee
 */
public class VrstaRacuna implements GeneralEntity {

    private int brRacuna;
    private String naziv;

    public VrstaRacuna() {
    }

    public VrstaRacuna(int brRacuna) {
        this.brRacuna = brRacuna;
    }

    public VrstaRacuna(int brRacuna, String naziv) {
        this.brRacuna = brRacuna;
        this.naziv = naziv;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getBrRacuna() {
        return brRacuna;
    }

    public void setBrRacuna(int brRacuna) {
        this.brRacuna = brRacuna;
    }

    @Override
    public String toString() {
        return naziv;
    }

    @Override
    public String getClassName() {
        return "VrstaRacuna";
    }

    @Override
    public String getAtrValue() {
        StringBuilder sb = new StringBuilder();
        sb.append("").append("default").
                append(", '").append(naziv).
                append("'");
        return sb.toString();
    }

    @Override
    public String setAtrValue() {
        StringBuilder sb = new StringBuilder();
        sb.append("BrRacuna").append("='").append(brRacuna).append("',").
                append("Naziv").append("='").append(naziv).append("',");
        return sb.toString();
    }

    @Override
    public String getNameByColumn(int i) {
        String[] atributi = {"BrRacuna", "Naziv"};
        return atributi[i];
    }

    @Override
    public String getWhereCondition() {
        return "BrRacuna = " + brRacuna;
    }

    @Override
    public GeneralEntity getNewRecord(ResultSet rs) throws SQLException {
        return new VrstaRacuna(rs.getInt("BrRacuna"), rs.getString("Naziv"));
    }

    @Override
    public String getSpecialCondition() {
        return "";
    }

    @Override
    public String getForeignKeyCondition() {
        return "";
    }

}
