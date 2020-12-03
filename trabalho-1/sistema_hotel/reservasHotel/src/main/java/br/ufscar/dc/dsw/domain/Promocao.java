package br.ufscar.dc.dsw.domain;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class Promocao{

    private Long id;
    private String CNPJhotel;
    private String urlSite;
    private String preco;
    private LocalDate inicio, fim;

    public Promocao(Long id){
        this.id = id;
    }
    public Promocao(String urlSite, String CNPJhotel, String preco, LocalDate inicio, LocalDate fim){
        super();
        this.CNPJhotel = CNPJhotel;
        this.urlSite = urlSite;
        this.preco = preco;
        this.inicio = inicio;
        this.fim = fim;
    }

    public Promocao(String urlSite, String CNPJhotel, String preco, LocalDate inicio, LocalDate fim, Long id){
        super();
        this.id = id;
        this.CNPJhotel = CNPJhotel;
        this.urlSite = urlSite;
        this.preco = preco;
        this.inicio = inicio;
        this.fim = fim;
    }

    public Long getId() {
		return id;
	}	
	public void setId(Long id) {
		this.id = id;
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

    public void setInicio(LocalDate inicio){
        this.inicio = inicio;
    }

    public LocalDate getInicio(){
        return this.inicio;
    }

    public void setFim(LocalDate fim){
        this.fim = fim;
    }

    public LocalDate getFim(){
        return this.fim;
    }
}