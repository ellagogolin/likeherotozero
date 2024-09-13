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
public class Emissiondata {

	protected static final String host = "localhost";
	protected static final String port = "3306";
	protected static final String database = "mysql-likeherotozero";
	protected static final String username ="root";
	protected static final String password = "";
	protected static final String QUERY = "SELECT country_name, emission FROM emissionsdaten";

    
    public static class EmissionData {
        private String countryName;
        private float emission;
		private int countryCode;

        public EmissionData(String countryName, float emission, int countryCode) {
            this.countryName = countryName;
            this.emission = emission;
            this.countryCode = countryCode;
        }

        public EmissionData(int countryCode, String countryName, float emission) {
		}

		public String getCountryName() {
            return countryName;
        }

        public void setCountryName(String countryName) {
            this.countryName = countryName;
        }

        public float getEmission() {
            return emission;
        }

        public void setEmission(float emission) {
            this.emission = emission;
        }

		public int getCountryCode() {
			return countryCode;
		}
		 public void setCountryCode(int countryCode) {
	            this.countryCode = countryCode;
	        }
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

