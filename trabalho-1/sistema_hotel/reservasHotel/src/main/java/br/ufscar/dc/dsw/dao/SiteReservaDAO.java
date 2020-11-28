package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ufscar.dc.dsw.domain.SiteReservas;

//alterar todos os argumentos para a estrutura do SiteReserva
public class SiteReservaDAO extends GenericDAO {

    public void insert(SiteReservas site) {    
        String sql = "INSERT INTO SiteReserva(email, senha, url, nome, telefone) VALUES (?, ?, ?, ?, ?)";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);;    
            statement = conn.prepareStatement(sql);
            statement.setString(1, site.getEmail());
            statement.setString(2, site.getSenha());
            statement.setString(3, site.getUrl());
            statement.setString(4, site.getNome());
            statement.setString(5, site.getTelefone());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<SiteReservas> getAll() {   
        List<SiteReservas> listaSites = new ArrayList<>();
        String sql = "SELECT * from SiteReservas u";
        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                String url = resultSet.getString("url");
                String nome = resultSet.getString("nome");
                String telefone = resultSet.getString("telefone");
                SiteReservas site = new SiteReservas(email, senha, url, nome, telefone);
                listaSites.add(site);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaSites;
    }
    
    public void delete(SiteReservas site) {
        String sql = "DELETE FROM SiteReservas where url = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, site.getUrl());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
        }
    }
    
    public void update(SiteReservas site) {
        String sql = "UPDATE SiteReservas SET email = ?, senha = ?, nome = ?, telefone = ? WHERE url = ?";
    
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, site.getEmail());
            statement.setString(2, site.getSenha());
            statement.setString(3, site.getNome());
            statement.setString(4, site.getTelefone());
            statement.setString(5, site.getUrl());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public SiteReservas getbyURL(String url) {
        SiteReservas site = null;
        String sql = "SELECT * from SiteReservas WHERE url = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, url);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                String urlT = resultSet.getString("url");
                String nome = resultSet.getString("nome");
                String telefone = resultSet.getString("telefone");
                site = new SiteReservas(email, senha, urlT, nome, telefone);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return site;
    }
    
    public SiteReservas getbyEmail(String email) {
        SiteReservas site = null;
        String sql = "SELECT * from SiteReservas WHERE email = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
            	String emailT = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                String url = resultSet.getString("url");
                String nome = resultSet.getString("nome");
                String telefone = resultSet.getString("telefone");
                site = new SiteReservas(emailT, senha, url, nome, telefone);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return site;
    }
}
