package likeherotozero;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped

    public class EmissionData extends Emission {
     

        public EmissionData(int countryCode, String countryName, float emission) {
		
	}

		public EmissionData(String countryName, float emission, int countryCode) {
		
		}

		public void Emission(String countryName, float emission, int countryCode) {
            this.countryName = countryName;
            this.emission = emission;
            this.countryCode = countryCode;
        }

    public List<EmissionData> getEmissions() {
        List<EmissionData> emissionsList = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, username, password);
             PreparedStatement statement = connection.prepareStatement(QUERY);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                String countryName = resultSet.getString("country_name");
                float emission = (float) resultSet.getDouble("emission");
                int countryCode = resultSet.getInt("country_code");

                emissionsList.add(new EmissionData(countryName, emission, countryCode));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return emissionsList;
    }
}

