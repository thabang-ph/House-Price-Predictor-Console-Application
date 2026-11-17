import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        //get info from user
        System.out.println("Enter size of house (m2).");

        float size = scan.nextFloat();

        System.out.println("Enter total number of bedrooms.");

        int numBedrooms = scan.nextInt();

        //validate input
        if (size <= 0 || numBedrooms <= 0) {
            System.out.println("Invalid input. Values must be greater than zero.");
            scan.close();
            return;
        }

        //create client
        HttpClient client = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(10))
                .build();

        //format numbers into url
        String url = "http://127.0.0.1:8000/predictPrice?house_size="+ size + "&num_bedrooms=" + numBedrooms;

        //build request
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Accept", "application/json")
                .timeout(Duration.ofSeconds(15))
                .GET()
                .build();

        //communicate with API
        HttpResponse<String> response;

        try {

            response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());

            //check response status
            if (response.statusCode() == 200) {

                System.out.println(response.body());

            } else {

                System.out.println("API Error: " + response.statusCode());
                System.out.println("Details: " + response.body());

            }

        } catch (IOException e) {

            System.out.println("Error: Could not connect to the API.");
            System.out.println("Make sure the API server is running.");

        } catch (InterruptedException e) {

            System.out.println("Error: Request was interrupted.");
            Thread.currentThread().interrupt();

        } catch (Exception e) {

            System.out.println("Unexpected error: " + e.getMessage());

        } finally {

            scan.close();

        }
    }
}