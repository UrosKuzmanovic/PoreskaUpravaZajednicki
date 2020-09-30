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
public class Transakcija implements GeneralEntity {

    private int brTransakcije;
    private double iznosTransakcije;
    private Date datumTransakcije;
    private String opis;
    private Racun racun;

    public Transakcija() {
    }

    public Transakcija(int brTransakcije, double iznosTransakcije, Date datumTransakcije, String opis, Racun racun) {
        this.brTransakcije = brTransakcije;
        this.iznosTransakcije = iznosTransakcije;
        this.datumTransakcije = datumTransakcije;
        this.opis = opis;
        this.racun = racun;
    }

    public Transakcija(int brTransakcije) {
        this.brTransakcije = brTransakcije;
    }

    public Racun getRacun() {
        return racun;
    }

    public void setRacun(Racun racun) {
        this.racun = racun;
    }

    public int getBrTransakcije() {
        return brTransakcije;
    }

    public void setBrTransakcije(int brTransakcije) {
        this.brTransakcije = brTransakcije;
    }

    public double getIznosTransakcije() {
        return iznosTransakcije;
    }

    public void setIznosTransakcije(double iznosTransakcije) {
        this.iznosTransakcije = iznosTransakcije;
    }

    public Date getDatumTransakcije() {
        return datumTransakcije;
    }

    public void setDatumTransakcije(Date datumTransakcije) {
        this.datumTransakcije = datumTransakcije;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    @Override
    public String getClassName() {
        return "Transakcija";
    }

    @Override
    public String getAtrValue() {
        StringBuilder sb = new StringBuilder();
        sb.append("").append("default").
                append(", '").append(iznosTransakcije).
                append("', '").append(new java.sql.Date(datumTransakcije.getTime())).
                append("', \"").append(opis).
                append("\", '").append(racun.getObveznik().getBrObveznika()).
                append("', '").append(racun.getRacun().getBrRacuna()).
                append("'");
        return sb.toString();
    }

    @Override
    public String setAtrValue() {
        StringBuilder sb = new StringBuilder();
        sb.append("BrTransakcije").append("='").append(brTransakcije).append("',").
                append("IznosTransakcije").append("='").append(iznosTransakcije).append("',").
                append("DatumTransakcije").append("='").append(datumTransakcije).append("',").
                append("Opis").append("=\"").append(opis).append("\",").
                append("BrObveznika").append("='").append(racun.getObveznik().getBrObveznika()).append("'").
                append("BrRacuna").append("='").append(racun.getRacun().getBrRacuna()).append("'");
        return sb.toString();
    }

    @Override
    public String getNameByColumn(int i) {
        String[] atributi = {"BrTransakcije", "IznosTransakcije", "DatumTransakcije", "Opis", "BrObveznika", "BrRacuna"};
        return atributi[i];
    }

    @Override
    public String getWhereCondition() {
        return "BrTransakcije = " + brTransakcije;
    }

    @Override
    public GeneralEntity getNewRecord(ResultSet rs) throws SQLException {
        return new Transakcija(rs.getInt("BrTransakcije"), rs.getDouble("IznosTransakcije"), rs.getDate("DatumTransakcije"), rs.getString("Opis"), new Racun(new Obveznik(rs.getInt("BrObveznika")), new VrstaRacuna(rs.getInt("BrRacuna"))));
    }

    @Override
    public String getSpecialCondition() {
        return "";
    }

    @Override
    public String getForeignKeyCondition() {
        if (racun.getRacun().getBrRacuna() > 0) {
            return "BrRacuna = " + racun.getRacun().getBrRacuna();
        } else {
            return "BrObveznika = " + racun.getObveznik().getBrObveznika();
        }
    }

}
