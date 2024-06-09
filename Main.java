/**
 * Class Description: Class used to import json URL, create new json, and output new json. It uses the link that was given (link) and client.
 */

import com.google.gson.Gson;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class Main {

    // Custom URL given
    private static final String link = "https://challenge.sandboxnu.com/s/PMRGIYLUMERDU6ZCMVWWC2LMEI5CE23VNVQXELTTNBUXEZKANZXXE5DIMVQXGZLSNYXGKZDVEIWCEZDVMURDUMJXGE3TSOJRHE4TSLBCMNUGC3DMMVXGOZJCHIREM3DPO4RH2LBCNBQXG2BCHIRFK2RRO5IXC4KRFNIGUMKVOJMXAZ3IM46SE7I=";
    private HttpClient client = HttpClient. newHttpClient();

    /**
     * Description: Inputs the given URL and creates json/gson
     * @return jsonString: The json with the list of outputs
     * @throws IOException: Input/Output exception
     * @throws InterruptedException: interrupted exception
     */
    public String inputURL() throws IOException, InterruptedException
    {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(link))
                .header("accept","application/json")
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        Reader reader = new StringReader(response.body());
        Gson gson = new Gson();
        Initial data = gson.fromJson(reader, Initial.class);
        processParticipants p = new processParticipants(data);
        List<Output> output = p.process();
        String jsonString = gson.toJson(output);
        return jsonString;
    }

    /**
     * Description: POST function used to post to API
     * @param jsonString: The json with the list of outputs
     * @throws IOException: Input/Output exception
     * @throws InterruptedException: interrupted exception
     */
    public void output(String jsonString) throws IOException, InterruptedException
    {
        HttpRequest postRequest = HttpRequest.newBuilder()
                .uri(URI.create(link))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonString, StandardCharsets.UTF_8))
                .build();

        // Send the POST request and get the response
        HttpResponse<String> postResponse = client.send(postRequest, HttpResponse.BodyHandlers.ofString());

        // Output the response code and body
        System.out.println("POST Response Code :: " + postResponse.statusCode());
        System.out.println("POST Response Body :: " + postResponse.body());
    }

    public static void main(String[] args) throws IOException, InterruptedException {
//        HttpClient client = HttpClient. newHttpClient();
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create(link))
//                .header("accept","application/json")
//                .GET()
//                .build();
//        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//        Reader reader = new StringReader(response.body());
//        Gson gson = new Gson();
//        Initial data = gson.fromJson(reader, Initial.class);
//        processParticipants p = new processParticipants(data);
//        List<Output> output = p.process();
//        String jsonString = gson.toJson(output);
//
//        // Output JSON string
//       // System.out.println(jsonString);
//
//        HttpRequest postRequest = HttpRequest.newBuilder()
//                .uri(URI.create(link))
//                .header("Content-Type", "application/json")
//                .POST(HttpRequest.BodyPublishers.ofString(jsonString, StandardCharsets.UTF_8))
//                .build();
//
//        // Send the POST request and get the response
//        HttpResponse<String> postResponse = client.send(postRequest, HttpResponse.BodyHandlers.ofString());
//
//        // Output the response code and body
//        System.out.println("POST Response Code :: " + postResponse.statusCode());
//        System.out.println("POST Response Body :: " + postResponse.body());

        Main main = new Main();
        main.output(main.inputURL());

    }
}