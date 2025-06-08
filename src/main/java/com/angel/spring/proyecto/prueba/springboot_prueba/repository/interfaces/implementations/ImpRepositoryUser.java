package com.angel.spring.proyecto.prueba.springboot_prueba.repository.interfaces.implementations;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.angel.spring.proyecto.prueba.springboot_prueba.models.dto.User;
import com.angel.spring.proyecto.prueba.springboot_prueba.repository.interfaces.RepositoryUser;

@Repository
public class ImpRepositoryUser implements RepositoryUser {

   private final static Logger logger = LoggerFactory.getLogger(ImpRepositoryUser.class);

    @Autowired
    private DataSource dataSource;

    @Value("${query.users.save}")
    private String querySaveUser;

    @Value("${query.users.findById}")
    private String queryFindByIdUser;
    
    @Value("${query.users.findByUsername}")
    private String queryFindByUsernameUser;

    @Value("${query.users.findByEmail}")
    private String queryFindByEmailUser;

    public ImpRepositoryUser(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public User save(User user) {
        try (PreparedStatement ps = dataSource.getConnection().prepareStatement(querySaveUser, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getEmail());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                user.setId(rs.getLong(1));
                logger.info("Usuario guardado con ID: " + user.getId());
            }
        } catch (SQLException e) {
            logger.error("Error al guardar al usuario",e);
        }
       
        return user; 
    }

    @Override
    public Optional<User> findById(Long id_User) {
        try(PreparedStatement ps = dataSource.getConnection().prepareStatement(queryFindByIdUser)) {
            ps.setLong(1, id_User);
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            if (rs.next()) {
                User user = new User();
                user.setId(rs.getLong("id_User"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));

                Optional<User> optionalUser = Optional.of(user);
                
                return optionalUser;
            }
        } catch (SQLException e) {
            logger.error("Error al buscar usuario por ID", e);

        }
        return Optional.empty();
    }

    @Override
    public Optional<User> findByUsername(String username) {
        try(PreparedStatement ps = dataSource.getConnection().prepareStatement(queryFindByUsernameUser)){
        ps.setString(1, username);
        ps.executeQuery();
        ResultSet rs = ps.getResultSet();
        while (rs.next()) {
            User user = new User();
            user.setId(rs.getLong("id_User"));
            user.setUsername(rs.getString("username"));
            user.setEmail(rs.getString("email"));

            Optional<User> optionalUser = Optional.of(user);
            return optionalUser;
        }
        }catch (SQLException e) {
            logger.error("Error al buscar usuario por username", e);
        }
        return Optional.empty();
    }

    @Override
    public Optional<User> findByEmail(String email) {
        try(PreparedStatement ps = dataSource.getConnection().prepareStatement(queryFindByEmailUser)){
        ps.setString(1, email);
        ps.executeQuery();
        ResultSet rs = ps.getResultSet();
        while(rs.next()){
            User user = new User();
            user.setId(rs.getLong("id_User"));
            user.setUsername(rs.getString("username"));
            user.setEmail(rs.getString("email"));

            Optional<User> optionalUser = Optional.of(user);
            return optionalUser;
        }
        }catch (SQLException e) {
            logger.error("Error al buscar usuario por email", e);
        }
        return Optional.empty();
    }

}
