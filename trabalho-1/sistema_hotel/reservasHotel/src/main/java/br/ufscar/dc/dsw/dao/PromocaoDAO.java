
package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import br.ufscar.dc.dsw.domain.Promocao;
import java.time.LocalDate;
import java.sql.Date;

public class PromocaoDAO extends GenericDAO {

    public void insert(Promocao promocao) {    
        String sql = "INSERT INTO Promocoes (url, hotel, preco, inicio, fim) VALUES (?, ?, ?, ?, ?)";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);;    
            statement = conn.prepareStatement(sql);
            statement.setString(1, promocao.getUrlSite());
            statement.setString(2, promocao.getCnpjhotel());
            statement.setString(3, promocao.getPreco());
            
            statement.setDate(4, Date.valueOf(promocao.getInicio()));
            
            statement.setDate(5, Date.valueOf(promocao.getFim()));
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Promocao> getAll() {   
        List<Promocao> listaPromocaos = new ArrayList<>();
        String sql = "SELECT * from Promocoes u";
        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                //long id = resultSet.getLong("id");
                String url = resultSet.getString("url");
                String hotel = resultSet.getString("hotel");
                String preco = resultSet.getString("preco");
                LocalDate inicio = resultSet.getDate("inicio").toLocalDate();
                LocalDate fim = resultSet.getDate("fim").toLocalDate();
                Promocao promocao = new Promocao(url, hotel, preco, inicio, fim);
                listaPromocaos.add(promocao);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaPromocaos;
    }

    public List<Promocao> getAllbyHotel(String cnpj) {   
        List<Promocao> listaPromocaos = new ArrayList<>();
        String sql = "SELECT * from Promocoes WHERE hotel = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, cnpj);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                //long id = resultSet.getLong("id");
                String url = resultSet.getString("url");
                String hotel = resultSet.getString("hotel");
                String preco = resultSet.getString("preco");
                LocalDate inicio = resultSet.getDate("inicio").toLocalDate();
                LocalDate fim = resultSet.getDate("fim").toLocalDate();
                Promocao promocao = new Promocao(url, hotel, preco, inicio, fim);
                listaPromocaos.add(promocao);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaPromocaos;
    }

    public List<Promocao> getAllbySite(String site) {   
        List<Promocao> listaPromocaos = new ArrayList<>();
        String sql = "SELECT * from Promocoes WHERE url = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, site);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                //long id = resultSet.getLong("id");
                String url = resultSet.getString("url");
                String hotel = resultSet.getString("hotel");
                String preco = resultSet.getString("preco");
                LocalDate inicio = resultSet.getDate("inicio").toLocalDate();
                LocalDate fim = resultSet.getDate("fim").toLocalDate();
                Promocao promocao = new Promocao(url, hotel, preco, inicio, fim);
                listaPromocaos.add(promocao);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaPromocaos;
    }
    
    public void delete(Promocao promocao) {
        String sql = "DELETE FROM Promocoes where id = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setLong(1, promocao.getId());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
        }
    }
    
    public void update(Promocao promocao) {
        String sql = "UPDATE Promocoes SET url = ?, hotel = ?, preco = ?, inicio = ?, fim = ? WHERE id = ?";
    
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, promocao.getUrlSite());
            statement.setString(2, promocao.getCnpjhotel());
            statement.setString(3, promocao.getPreco());
            statement.setDate(4, Date.valueOf(promocao.getInicio()));
            statement.setDate(5, Date.valueOf(promocao.getFim()));
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public Promocao getbyID(Long id) {
        Promocao promocao = null;
        String sql = "SELECT * from Promocoes WHERE id = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String url = resultSet.getString("url");
                String hotel = resultSet.getString("hotel");
                String preco = resultSet.getString("preco");
                LocalDate inicio = resultSet.getDate("inicio").toLocalDate();
                LocalDate fim = resultSet.getDate("fim").toLocalDate();
                promocao = new Promocao(url, hotel, preco, inicio, fim, id);
                
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return promocao;
    }
    
    
}
