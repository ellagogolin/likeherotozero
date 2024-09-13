package likeherotozero;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public abstract class EmissionBean extends Emissiondata {
	public abstract void useEmissiondata(); 
    private List<EmissionData> emissionsList;
    
    private EmissionData selectedEmission;

   
    public List<EmissionData> getEmissionsList() {
        if (emissionsList == null) {
            emissionsList = new ArrayList<>();
            String query = "SELECT country_code, country_name, emission FROM emissionsdaten";

            try (Connection connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, username, password);
                 PreparedStatement statement = connection.prepareStatement(query);
                 ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    int CountryCode = resultSet.getInt("country_code");
                    String countryName = resultSet.getString("country_name");
                    float emission = resultSet.getFloat("emission");

                    emissionsList.add(new EmissionData(CountryCode, countryName, emission));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return emissionsList;
    }

    public void updateEmission(EmissionData emission) {
        String updateQuery = "UPDATE emissionsdaten SET country_name = ?, emission = ? WHERE country_code = ?";

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, username, password);
             PreparedStatement statement = connection.prepareStatement(updateQuery)) {

            statement.setString(1, emission.getCountryName());
            statement.setFloat(2, emission.getEmission());
            statement.setInt(3, emission.getCountryCode());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public EmissionData getSelectedEmission() {
        return selectedEmission;
    }

    public void setSelectedEmission(EmissionData selectedEmission) {
        this.selectedEmission = selectedEmission;
    }
    
}