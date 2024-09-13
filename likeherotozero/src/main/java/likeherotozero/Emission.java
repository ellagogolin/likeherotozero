package likeherotozero;

import javax.persistence.*;

@Entity
@Table(name = "emissionsdaten")

public class Emission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long countryCode;

    @Column(name = "country_name")
    private String countryName;

    @Column(name = "emission")
    private Double emission;

    public Long getCountryCode() {
        return countryCode;
    }

    public void setId(Long countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Double getEmission() {
        return emission;
    }

    public void setEmission(Double emission) {
        this.emission = emission;
    }
}