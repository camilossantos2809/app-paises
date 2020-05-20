package br.pucpr.apppaises;

import android.util.JsonReader;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class PaisData {
    private String url;
    private String presidente;
    private String lingua;
    private String continente;
    private String area;
    private String populacao;
    private String capital;
    private String distancia;
    private String moeda;
    private List<ArtistaData> artistas;

    @Override
    public String toString() {
        return "PaisData{" +
                "url='" + url + '\'' +
                '}';
    }

    public List<ArtistaData> getArtistas() {
        return artistas;
    }

    public void setArtistas(List<ArtistaData> artistas) {
        this.artistas = artistas;
    }

    public String getDistancia() {
        return distancia;
    }

    public void setDistancia(String distancia) {
        this.distancia = distancia;
    }

    public String getMoeda() {
        return moeda;
    }

    public void setMoeda(String moeda) {
        this.moeda = moeda;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPresidente() {
        return presidente;
    }

    public void setPresidente(String presidente) {
        this.presidente = presidente;
    }

    public String getLingua() {
        return lingua;
    }

    public void setLingua(String lingua) {
        this.lingua = lingua;
    }

    public String getContinente() {
        return continente;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getPopulacao() {
        return populacao;
    }

    public void setPopulacao(String populacao) {
        this.populacao = populacao;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }
}
