package br.ufscar.dc.dsw.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;



@Entity
@Table(
    name = "Promocao"
)
public class Promocao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @ManyToOne
    
	@JoinColumn(name = "site_id")
    private SiteReservas site;
    
    @Column(nullable = false)
    @NotNull
    private String preco;

    @Column(nullable = false)
    @NotNull
    private String inicio;

    @Column(nullable = false)
    @NotNull
    private String fim;

    


    public Promocao(){

    }

    public Promocao(Hotel hotel, SiteReservas site, String preco, String inicio, String fim){
        this.hotel = hotel;
        this.site = site;
        this.preco = preco;
        this.inicio = inicio;
        this.fim = fim;
    }

    public Promocao(Long id,Hotel hotel, SiteReservas site, String preco, String inicio, String fim){
        this.id = id;
        this.hotel = hotel;
        this.site = site;
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

   
    public Hotel getHotel() {
        return hotel;
    }

    
    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    
    public SiteReservas getSite() {
        return site;
    }

    
    public void setSite(SiteReservas site) {
        this.site = site;
    }

    
    public String getPreco() {
        return preco;
    }

    
    public void setPreco(String preco) {
        this.preco = preco;
    }

    
    public String getInicio() {
        return inicio;
    }

    
    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    
    public String getFim() {
        return fim;
    }

    
    public void setFim(String fim) {
        this.fim = fim;
    }

    public String getHotelNome(){
        return this.hotel.getNome();
    }

    public String getSiteNome(){
        return this.site.getNome();
    }

    



    @Override
	public String toString() {
		return "Promocao [Hotel= " + hotel.getNome() + " Site= " + site.getNome() +" Preço="+ preco +"]";
	}
}