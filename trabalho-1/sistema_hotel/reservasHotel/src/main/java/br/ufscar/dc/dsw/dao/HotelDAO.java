package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ufscar.dc.dsw.domain.Hotel;

//alterar todos os argumentos para a estrutura do Hotel
public class HotelDAO extends GenericDAO {

    public void insert(Hotel hotel) {    
        String sql = "INSERT INTO Hotel (nome, login, senha, papel) VALUES (?, ?, ?, ?)";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);;    
            statement = conn.prepareStatement(sql);
            statement.setString(1, hotel.getNome());
            statement.setString(2, hotel.getLogin());
            statement.setString(3, hotel.getSenha());
            statement.setString(4, hotel.getPapel());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Hotel> getAll() {   
        List<Hotel> listaHotels = new ArrayList<>();
        String sql = "SELECT * from Hotel u";
        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String nome = resultSet.getString("nome");
                String login = resultSet.getString("login");
                String senha = resultSet.getString("senha");
                String papel = resultSet.getString("papel");
                Hotel hotel = new Hotel(id, nome, login, senha, papel);
                listaHotels.add(hotel);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaHotels;
    }
    
    public void delete(Hotel hotel) {
        String sql = "DELETE FROM Hotel where id = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setLong(1, hotel.getId());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
        }
    }
    
    public void update(Hotel hotel) {
        String sql = "UPDATE Hotel SET nome = ?, login = ?, senha = ?, papel = ? WHERE id = ?";
    
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, hotel.getNome());
            statement.setString(2, hotel.getLogin());
            statement.setString(3, hotel.getSenha());
            statement.setString(4, hotel.getPapel());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public Hotel getbyID(Long id) {
        Hotel hotel = null;
        String sql = "SELECT * from Hotel WHERE id = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String login = resultSet.getString("login");
                String senha = resultSet.getString("senha");
                String papel = resultSet.getString("papel");
                hotel = new Hotel(id, nome, login, senha, papel);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return hotel;
    }
    
    public Hotel getbyLogin(String login) {
        Hotel hotel = null;
        String sql = "SELECT * from Hotel WHERE login = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
            	Long id = resultSet.getLong("id");
                String nome = resultSet.getString("nome");
                String senha = resultSet.getString("senha");
                String papel = resultSet.getString("papel");
                hotel = new Hotel(id, nome, login, senha, papel);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return hotel;
    }
}
*/
