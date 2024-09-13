package likeherotozero;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings("hiding")
@ManagedBean
@SessionScoped
public class EmissionFilter<SessionFactory> {

    private SessionFactory factory;

    private String selectedCountry; 
    private List<String> countryList; 
    private List<Emission> filteredEmissions; 

    @SuppressWarnings("unchecked")
	public EmissionFilter() {
        factory = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        loadCountryList(); 
        filterEmissions(); 
    }

 
    public String getSelectedCountry() {
        return selectedCountry;
    }

    public void setSelectedCountry(String selectedCountry) {
        this.selectedCountry = selectedCountry;
    }

    public List<String> getCountryList() {
        return countryList;
    }

    public List<Emission> getFilteredEmissions() {
        return filteredEmissions;
    }

    private void loadCountryList() {
        Session session = ((org.hibernate.SessionFactory) factory).openSession();
        try {
            countryList = session.createQuery("SELECT DISTINCT e.countryName FROM Emission e", String.class)
                                 .list();
        } finally {
            session.close();
        }
    }

    public List<Emission> filterEmissions() {
        Session session = ((org.hibernate.SessionFactory) factory).openSession();
//        try {
//            if (selectedCountry != null && !selectedCountry.isEmpty()) {
//               
//                String hql = "FROM Emission WHERE countryName = :countryName";
//                return session.createQuery(hql, Emission.class)
//                                           .setParameter("countryName", selectedCountry)
//                                           .list();
//            } else {
//
//            }
        return session.createQuery("FROM Emission", Emission.class).list();
//        } finally {
//            session.close();
//        }
    }
}