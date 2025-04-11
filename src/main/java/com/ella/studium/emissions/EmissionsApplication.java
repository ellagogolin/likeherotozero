package com.ella.studium.emissions;

import com.ella.studium.emissions.Entity.Emission;
import com.ella.studium.emissions.Entity.User;
import com.ella.studium.emissions.Repository.EmissionRepository;
import com.ella.studium.emissions.Repository.UserRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@SpringBootApplication
public class EmissionsApplication {
	@Autowired
	private EmissionRepository emissionRepository;

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(EmissionsApplication.class, args);
	}

	@Bean
	InitializingBean initDatabase() throws ParseException {
		// Source:
		// https://edgar.jrc.ec.europa.eu/report_2024?vis=co2tot#emissions_table
		// https://en.wikipedia.org/wiki/List_of_telephone_country_codes
		Date date2023 = new GregorianCalendar(2023, Calendar.JANUARY, 1).getTime();
		return () -> {
			this.userRepository.save(new User("alice", "alice"));
			this.userRepository.save(new User("bob", "bob"));

			this.emissionRepository.save(new Emission(1, "United States", date2023, 4682));
			this.emissionRepository.save(new Emission(7, "Russia", date2023, 2069));
			this.emissionRepository.save(new Emission(20, "Egypt", date2023, 249));
			this.emissionRepository.save(new Emission(33, "France and Monaco", date2023, 282));
			this.emissionRepository.save(new Emission(48, "Poland", date2023, 286));
			this.emissionRepository.save(new Emission(49, "Germany", date2023, 582));
			this.emissionRepository.save(new Emission(44, "United Kingdom", date2023, 302));
			this.emissionRepository.save(new Emission(55, "Brazil", date2023, 489));
			this.emissionRepository.save(new Emission(86, "China", date2023, 13259));
			this.emissionRepository.save(new Emission(93, "Afghanistan", date2023, 8));
			this.emissionRepository.save(new Emission(355, "Albania", date2023, 4));
			this.emissionRepository.save(new Emission(213, "Algeria", date2023, 180));
			this.emissionRepository.save(new Emission(244, "Angola", date2023, 28));
			this.emissionRepository.save(new Emission(54, "Argentina", date2023, 183));
			this.emissionRepository.save(new Emission(374, "Armenia", date2023, 7));
			this.emissionRepository.save(new Emission(297, "Aruba", date2023, 0));
			this.emissionRepository.save(new Emission(61, "Australia", date2023, 373));
			this.emissionRepository.save(new Emission(43, "Austria", date2023, 58));
			this.emissionRepository.save(new Emission(994, "Azerbaijan", date2023, 42));
			this.emissionRepository.save(new Emission(973, "Bahrain", date2023, 37));
			this.emissionRepository.save(new Emission(880, "Bangladesh", date2023, 124));
			this.emissionRepository.save(new Emission(375, "Belarus", date2023, 54));
			this.emissionRepository.save(new Emission(32, "Belgium", date2023, 84));
			this.emissionRepository.save(new Emission(501, "Belize", date2023, 0));
			this.emissionRepository.save(new Emission(229, "Benin", date2023, 6));
			this.emissionRepository.save(new Emission(975, "Bhutan", date2023, 1));
			this.emissionRepository.save(new Emission(591, "Bolivia", date2023, 23));
			this.emissionRepository.save(new Emission(387, "Bosnia and Herzegovina", date2023, 22));
			this.emissionRepository.save(new Emission(267, "Botswana", date2023, 7));
			this.emissionRepository.save(new Emission(673, "Brunei", date2023, 9));
			this.emissionRepository.save(new Emission(359, "Bulgaria", date2023, 39));
			this.emissionRepository.save(new Emission(1, "Canada", date2023, 575));
			this.emissionRepository.save(new Emission(236, "Central African Republic", date2023, 0));
			this.emissionRepository.save(new Emission(56, "Chile", date2023, 84));
			this.emissionRepository.save(new Emission(57, "Colombia", date2023, 100));
			this.emissionRepository.save(new Emission(242, "Congo", date2023, 7));
			this.emissionRepository.save(new Emission(506, "Costa Rica", date2023, 8));
			this.emissionRepository.save(new Emission(385, "Croatia", date2023, 17));
			this.emissionRepository.save(new Emission(53, "Cuba", date2023, 22));
			this.emissionRepository.save(new Emission(357, "Cyprus", date2023, 7));
			this.emissionRepository.save(new Emission(420, "Czech Republic", date2023, 90));
			this.emissionRepository.save(new Emission(243, "Democratic Republic of the Congo", date2023, 3));
			this.emissionRepository.save(new Emission(45, "Denmark", date2023, 26));
			this.emissionRepository.save(new Emission(593, "Ecuador", date2023, 45));
			this.emissionRepository.save(new Emission(240, "Equatorial Guinea", date2023, 3));
			this.emissionRepository.save(new Emission(291, "Eritrea", date2023, 0));
			this.emissionRepository.save(new Emission(251, "Ethiopia", date2023, 16));
			this.emissionRepository.save(new Emission(679, "Fiji", date2023, 2));
			this.emissionRepository.save(new Emission(358, "Finland", date2023, 32));
			this.emissionRepository.save(new Emission(232, "Ghana", date2023, 24));
			this.emissionRepository.save(new Emission(30, "Greece", date2023, 51));
			this.emissionRepository.save(new Emission(299, "Greenland", date2023, 0));
			this.emissionRepository.save(new Emission(502, "Guatemala", date2023, 21));
			this.emissionRepository.save(new Emission(224, "Guinea", date2023, 3));
			this.emissionRepository.save(new Emission(509, "Haiti", date2023, 3));
			this.emissionRepository.save(new Emission(504, "Honduras", date2023, 10));
			this.emissionRepository.save(new Emission(852, "Hong Kong", date2023, 34));
			this.emissionRepository.save(new Emission(36, "Hungary", date2023, 43));
			this.emissionRepository.save(new Emission(354, "Iceland", date2023, 3));
			this.emissionRepository.save(new Emission(91, "India", date2023, 2955));
			this.emissionRepository.save(new Emission(62, "Indonesia", date2023, 674));
			this.emissionRepository.save(new Emission(98, "Iran", date2023, 778));
			this.emissionRepository.save(new Emission(964, "Iraq", date2023, 192));
			this.emissionRepository.save(new Emission(353, "Ireland", date2023, 32));
			this.emissionRepository.save(new Emission(972, "Israel and Palestine", date2023, 61));
			this.emissionRepository.save(new Emission(39, "Italy", date2023, 305));
			this.emissionRepository.save(new Emission(81, "Japan", date2023, 944));
			this.emissionRepository.save(new Emission(962, "Jordan", date2023, 23));
			this.emissionRepository.save(new Emission(997, "Kazakhstan", date2023, 239));
			this.emissionRepository.save(new Emission(254, "Kenya", date2023, 21));
			this.emissionRepository.save(new Emission(371, "Latvia", date2023, 6));
			this.emissionRepository.save(new Emission(961, "Lebanon", date2023, 17));
			this.emissionRepository.save(new Emission(218, "Libya", date2023, 61));
			this.emissionRepository.save(new Emission(370, "Lithuania", date2023, 13));
			this.emissionRepository.save(new Emission(352, "Luxembourg", date2023, 7));
			this.emissionRepository.save(new Emission(261, "Madagascar", date2023, 4));
			this.emissionRepository.save(new Emission(60, "Malaysia", date2023, 283));
			this.emissionRepository.save(new Emission(960, "Maldives", date2023, 2));
			this.emissionRepository.save(new Emission(356, "Malta", date2023, 1));
			this.emissionRepository.save(new Emission(230, "Mauritius", date2023, 4));
			this.emissionRepository.save(new Emission(52, "Mexico", date2023, 487));
			this.emissionRepository.save(new Emission(264, "Namibia", date2023, 4));
			this.emissionRepository.save(new Emission(31, "Netherlands", date2023, 122));
			this.emissionRepository.save(new Emission(64, "New Zealand", date2023, 35));
			this.emissionRepository.save(new Emission(234, "Nigeria", date2023, 127));
			this.emissionRepository.save(new Emission(850, "North Korea", date2023, 64));
			this.emissionRepository.save(new Emission(47, "Norway", date2023, 44));
			this.emissionRepository.save(new Emission(92, "Pakistan", date2023, 200));
			this.emissionRepository.save(new Emission(507, "Panama", date2023, 14));
			this.emissionRepository.save(new Emission(595, "Paraguay", date2023, 8));
			this.emissionRepository.save(new Emission(51, "Peru", date2023, 58));
			this.emissionRepository.save(new Emission(63, "Philippines", date2023, 161));
			this.emissionRepository.save(new Emission(51, "Peru", date2023, 58));
			this.emissionRepository.save(new Emission(351, "Portugal", date2023, 36));
			this.emissionRepository.save(new Emission(974, "Qatar", date2023, 127));
			this.emissionRepository.save(new Emission(40, "Romania", date2023, 70));
			this.emissionRepository.save(new Emission(966, "Saudi Arabia", date2023, 622));
			this.emissionRepository.save(new Emission(221, "Senegal", date2023, 12));
			this.emissionRepository.save(new Emission(381, "Serbia", date2023, 56));
			this.emissionRepository.save(new Emission(248, "Seychelles", date2023, 1));
			this.emissionRepository.save(new Emission(65, "Singapore", date2023, 57));
			this.emissionRepository.save(new Emission(421, "Slovakia", date2023, 34));
			this.emissionRepository.save(new Emission(386, "Slovenia", date2023, 12));
			this.emissionRepository.save(new Emission(252, "Somalia", date2023, 0));
			this.emissionRepository.save(new Emission(27, "South Africa", date2023, 397));
			this.emissionRepository.save(new Emission(82, "South Korea", date2023, 573));
			this.emissionRepository.save(new Emission(34, "Spain", date2023, 217));
			this.emissionRepository.save(new Emission(94, "Sri Lanka", date2023, 20));
			this.emissionRepository.save(new Emission(249, "Sudan", date2023, 21));
			this.emissionRepository.save(new Emission(46, "Sweden", date2023, 35));
			this.emissionRepository.save(new Emission(41, "Switzerland", date2023, 34));
			this.emissionRepository.save(new Emission(963, "Syria", date2023, 25));
			this.emissionRepository.save(new Emission(886, "Taiwan", date2023, 279));
			this.emissionRepository.save(new Emission(255, "Tanzania", date2023, 19));
			this.emissionRepository.save(new Emission(66, "Thailand", date2023, 274));
			this.emissionRepository.save(new Emission(228, "Togo", date2023, 2));
			this.emissionRepository.save(new Emission(216, "Tunisia", date2023, 31));
			this.emissionRepository.save(new Emission(993, "Turkmenistan", date2023, 65));
			this.emissionRepository.save(new Emission(90, "Turkey", date2023, 438));
			this.emissionRepository.save(new Emission(256, "Uganda", date2023, 7));
			this.emissionRepository.save(new Emission(380, "Ukraine", date2023, 136));
			this.emissionRepository.save(new Emission(971, "United Arab Emirates", date2023, 205));
			this.emissionRepository.save(new Emission(598, "Uruguay", date2023, 8));
			this.emissionRepository.save(new Emission(998, "Uzbekistan", date2023, 137));
			this.emissionRepository.save(new Emission(58, "Venezuela", date2023, 84));
			this.emissionRepository.save(new Emission(84, "Vietnam", date2023, 372));
			this.emissionRepository.save(new Emission(967, "Yemen", date2023, 10));
			this.emissionRepository.save(new Emission(260, "Zambia", date2023, 8));
			this.emissionRepository.save(new Emission(263, "Zimbabwe", date2023, 11));
		};
	}
}
