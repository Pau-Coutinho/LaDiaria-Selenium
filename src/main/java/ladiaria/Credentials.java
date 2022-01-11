package ladiaria;
import java.util.Random;

public class Credentials {
	
	private String email;
	private String password;
	
	public Credentials(String user, String password) {
		this.email=user;
		this.password=password;
	}
	
	public void setEmail (String email) {
		this.email = email;
	}
	
	public String getEmail (){
		return this.email;
		
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	
	public static String generateRandomPassword() {
		Random r = new Random();
		String output= "";
		//We generate a 8 characters long password with an uppercase letter, 6 lower case letters and a symbol.
		output = output+ (char)(r.nextInt(26) + 'A'); //
		for (int i = 0; i<6 ; i++) {
			output += (char)(r.nextInt(26) + 'a');
			
		}
		output += '!'; //todo: get this properly done. Maybe from a pool of symbols on a string?
		return output;
	}
}
