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
public class Racun implements GeneralEntity {

    private Obveznik obveznik;
    private VrstaRacuna racun;
    private double stanje;

    public Racun() {
    }

    public Racun(Obveznik obveznik, VrstaRacuna racun) {
        this.obveznik = obveznik;
        this.racun = racun;
    }

    public Racun(Obveznik obveznik, VrstaRacuna racun, double stanje) {
        this.obveznik = obveznik;
        this.racun = racun;
        this.stanje = stanje;
    }

    public double getStanje() {
        return stanje;
    }

    public void setStanje(double stanje) {
        this.stanje = stanje;
    }

    public Obveznik getObveznik() {
        return obveznik;
    }

    public void setObveznik(Obveznik obveznik) {
        this.obveznik = obveznik;
    }

    public VrstaRacuna getRacun() {
        return racun;
    }

    public void setRacun(VrstaRacuna racun) {
        this.racun = racun;
    }

    @Override
    public String getClassName() {
        return "Racun";
    }

    @Override
    public String getAtrValue() {
        StringBuilder sb = new StringBuilder();
        sb.append("").append(obveznik.getBrObveznika()).
                append(", ").append(racun.getBrRacuna()).
                append(", ").append(stanje);
        return sb.toString();
    }

    @Override
    public String setAtrValue() {
        StringBuilder sb = new StringBuilder();
        sb.append("BrObveznika").append("=").append(obveznik.getBrObveznika()).append(",").
                append("BrRacuna").append("=").append(racun.getBrRacuna()).append(",").
                append("Stanje").append("=").append(stanje);
        return sb.toString();
    }

    @Override
    public String getNameByColumn(int i) {
        String[] atributi = {"BrObveznika", "BrRacuna", "Stanje"};
        return atributi[i];
    }

    @Override
    public String getWhereCondition() {
        return "BrObveznika = " + obveznik.getBrObveznika() + " and BrRacuna = " + racun.getBrRacuna();
    }

    @Override
    public GeneralEntity getNewRecord(ResultSet rs) throws SQLException {
        return new Racun(new Obveznik(rs.getInt("BrObveznika")), new VrstaRacuna(rs.getInt("BrRacuna")), rs.getDouble("Stanje"));
    }

    @Override
    public String getSpecialCondition() {
        return "BrObveznika = " + obveznik.getBrObveznika();
    }

    /*@Override
    public String toString() {
        return obveznik.getIme() + " " + obveznik.getPrezime() + " - " + racun.getNaziv() + " - " + stanje;
    }*/

    @Override
    public String toString() {
        return racun.getNaziv();
    }

    @Override
    public String getForeignKeyCondition() {
        if (racun.getBrRacuna() > 0) {
            return "BrRacuna = " + racun.getBrRacuna();
        } else {
            return "BrObveznika = " + obveznik.getBrObveznika();
        }
    }

}
