import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		//get info from user
		System.out.println("Enter size of house (m2).");
		float size=scan.nextFloat();
		System.out.println("Enter total number of bedrooms.");
		int numBedrooms=scan.nextInt();
		
		//create client
		HttpClient client = HttpClient.newHttpClient();
		
		//format numbers into json string
		String url="http://127.0.0.1:8000/predictPrice?house_size="+size+"&num_bedrooms="+numBedrooms;
		//build request
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(url))
				.header("Accept", "application/json")
				.GET()
				.build();
		
		//communicate with API
		HttpResponse<String> response;
		try {
			response = client.send(request,
					HttpResponse.BodyHandlers.ofString());
			
			System.out.println(response.body());
		} catch (IOException e) {
			System.out.println("Error 1 occured");
		} catch (InterruptedException e) {
			 System.out.println("Error 2 occured");
		}

	}

}
