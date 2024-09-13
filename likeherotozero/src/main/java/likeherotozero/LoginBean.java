package likeherotozero;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class LoginBean {

    private String username;
    private String password;
    private boolean loggedIn;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String login() {
        if (authenticate(username, password)) {
            loggedIn = true;
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Login erfolgreich", null));
            return "index1";  
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ungültiger Benutzername oder Passwort", null));
            return null;  
        }
    }
    private boolean authenticate(String username, String password) {
        boolean isValid = false;
        String dbUrl = "jdbc:mysql://localhost:3306/mysql-likeherotozero";
        String dbUsername = "root"; 
        String dbPassword = "deinPasswort"; 

        String query = "SELECT * FROM users WHERE username = ? AND password = ?";

        try (Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    isValid = true; 
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Datenbankfehler", null));
        }

        return isValid;
    }
    public String logout() {
        loggedIn = false;
        username = null;
        password = null;
        return "index"; 
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }
}