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
public class Obveznik implements GeneralEntity {

    private int brObveznika;
    private String ime;
    private String prezime;
    private String jmbg;
    private String adresa;

    public Obveznik() {
    }

    public Obveznik(int brObveznika) {
        this.brObveznika = brObveznika;
    }

    public Obveznik(int brObveznika, String ime, String prezime, String jmbg, String adresa) {
        this.brObveznika = brObveznika;
        this.ime = ime;
        this.prezime = prezime;
        this.jmbg = jmbg;
        this.adresa = adresa;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public int getBrObveznika() {
        return brObveznika;
    }

    public void setBrObveznika(int brObveznika) {
        this.brObveznika = brObveznika;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
    }

    @Override
    public String getClassName() {
        return "Obveznik";
    }

    @Override
    public String getAtrValue() {
        StringBuilder sb = new StringBuilder();
        sb.append("").append("default").
                append(", '").append(ime).
                append("', '").append(prezime).
                append("', '").append(jmbg).
                append("', '").append(adresa).
                append("'");
        return sb.toString();
    }

    @Override
    public String setAtrValue() {
        StringBuilder sb = new StringBuilder();
        sb.append("BrObveznika").append("='").append(brObveznika).append("',").
                append("Ime").append("='").append(ime).append("',").
                append("Prezime").append("='").append(prezime).append("',").
                append("JMBG").append("='").append(jmbg).append("',").
                append("Adresa").append("='").append(adresa).append("'");
        return sb.toString();
    }

    @Override
    public String getNameByColumn(int i) {
        String[] atributi = {"BrObveznika", "Ime", "Prezime", "JMBG", "Adresa"};
        return atributi[i];
    }

    @Override
    public String getWhereCondition() {
        return "BrObveznika = " + brObveznika;
    }

    @Override
    public GeneralEntity getNewRecord(ResultSet rs) throws SQLException {
        return new Obveznik(rs.getInt("BrObveznika"), rs.getString("Ime"), rs.getString("Prezime"), rs.getString("JMBG"), rs.getString("Adresa"));
    }

    @Override
    public String getSpecialCondition() {
        String kzIme = ime;
        String kzPrezime = prezime;
        if (kzIme == null) {
            kzIme = "";
        }
        if (kzPrezime == null) {
            kzPrezime = "";
        }
        return "Ime like '%" + kzIme + "%' or Prezime like '%" + kzPrezime + "%'";
    }

    @Override
    public String getForeignKeyCondition() {
        return "";
    }

}
