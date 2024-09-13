package likeherotozero;

public class Main {

	public static void main(String[] args) {
		try {
			MySQL.connect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		MySQL.disconnect();
	}
}

