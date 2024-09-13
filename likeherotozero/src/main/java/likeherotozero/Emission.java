package likeherotozero;

import javax.persistence.*;

@Entity
@Table(name = "emissionsdaten")

public class Emission extends MySQL {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int countryCode;

    @Column(name = "country_name")
	protected String countryName;

    @Column(name = "emission")
	protected float emission;

    public int getCountryCode() {
        return countryCode;
    }

    public void setId(int countryCode) {
        this.countryCode = countryCode;
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
}