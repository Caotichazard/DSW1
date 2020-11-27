package br.ufscar.dc.dsw.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Promocao{
    private String CNPJhotel;
    private String urlSite;
    private String preco;
    private Date inicio, fim;

    public Promocao(String CNPJhotel, String urlSite, String preco, Date inicio, Date fim){
        this.CNPJhotel = CNPJhotel;
        this.urlSite = urlSite;
        this.preco = preco;
        this.inicio = inicio;
        this.fim = fim;
    }

    public void setCnpjhotel(String cnpjhotel){
        this.CNPJhotel = cnpjhotel;
    }

    public String getCnpjhotel(){
        return this.CNPJhotel;
    }

    public void setUrlSite(String urlSite){
        this.urlSite = urlSite;
    }

    public String getUrlSite(){
        return this.urlSite;
    }

    public void setPreco(String preco){
        this.preco = preco;
    }

    public String getPreco(){
        return this.preco;
    }

    public void setInicio(Date inicio){
        this.inicio = inicio;
    }

    public Date getInicio(){
        return this.inicio;
    }

    public void setFim(Date fim){
        this.fim = fim;
    }

    public Date getFim(){
        return this.fim;
    }
}