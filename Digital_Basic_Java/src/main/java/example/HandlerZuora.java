package example;

import java.awt.PageAttributes.MediaType;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.CompletableFuture;
import java.util.logging.Level;

import org.apache.http.HttpEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sd.model.AccessTokenDTO;
import com.sd.model.ProductList;
import com.sd.util.ZuoraUtil;

//import software.amazon.awssdk.services.lambda.LambdaAsyncClient;
//import software.amazon.awssdk.services.lambda.model.GetAccountSettingsRequest;
//import software.amazon.awssdk.services.lambda.model.GetAccountSettingsResponse;

// Handler value: example.Handler
public class HandlerZuora implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {
	private static final Logger logger = LoggerFactory.getLogger(HandlerZuora.class);
	private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
	//private static final LambdaAsyncClient lambdaClient = LambdaAsyncClient.create();

	public HandlerZuora() {
		/*
		 * CompletableFuture<GetAccountSettingsResponse> accountSettings = lambdaClient
		 * .getAccountSettings(GetAccountSettingsRequest.builder().build()); try {
		 * GetAccountSettingsResponse settings = accountSettings.get(); } catch
		 * (Exception e) { e.getStackTrace(); }
		 */
	}

	public static void main(String[] args) throws Exception {
		HandlerZuora h = new HandlerZuora();
		logger.info("Getting account settings");
		System.setProperty("AWS_REGION", "eu-west-1");
		APIGatewayProxyRequestEvent request = new APIGatewayProxyRequestEvent();
		request.setBody("dsadsads sdas");
		APIGatewayProxyResponseEvent response = h.handleRequest(request, null);
		System.out.println(response.getBody());
	}

	@Override
	public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent event, Context context) {

		long t1 = System.currentTimeMillis();

		APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent();

		ProductList products = null;

		// call Lambda API
//		CompletableFuture<GetAccountSettingsResponse> accountSettings = lambdaClient
//				.getAccountSettings(GetAccountSettingsRequest.builder().build());
		// log execution details
		logger.info("ENVIRONMENT VARIABLES: {}", gson.toJson(System.getenv()));
		logger.info("CONTEXT: {}", gson.toJson(context));
		logger.info("EVENT: {}", gson.toJson(event));
		
		logger.info("Time : {}", (System.currentTimeMillis()-t1));

		try {
			String payload = "{\"queryString\": \"select Id,Name,Category,Description,SKU,EffectiveStartDate,EffectiveEndDate,CreatedById,UpdatedById,CreatedDate,UpdatedDate,AppName__c,SellerAccountNumber__c,Type__c,DealType__c,AppKeyFeatures__c,AppRegulatoryStatus__c,AppTerms__c,AppSupport__c,AppTraining__c from Product \"}";

			String accessToken = ZuoraUtil.getToken();
			
			logger.info("accessToken: {}", accessToken);
			
			logger.info("Time : {}", (System.currentTimeMillis()-t1));
			
			String uri = ZuoraUtil.ZUORA_URL + "/v1/action/query";
			URL url = new URL(uri);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("Authorization", "Bearer " + accessToken);

			conn.setDoOutput(true);

			OutputStream os = conn.getOutputStream();
			os.write(payload.getBytes());
			os.flush();

			if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output;
			output = br.readLine();

			conn.disconnect();

			// products = new Gson().fromJson(output, ProductList.class);

			response.setBody(output);

			logger.info("output: {}", output);

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Response : {}", gson.toJson(response));
		
		logger.info("Time : {}", (System.currentTimeMillis()-t1));

		return response;
	}

	/*
	 * @Override public String handleRequest(SQSEvent event, Context context) {
	 * String response = new String(); // call Lambda API
	 * logger.info("Getting account settings");
	 * CompletableFuture<GetAccountSettingsResponse> accountSettings =
	 * lambdaClient.getAccountSettings(GetAccountSettingsRequest.builder().build());
	 * // log execution details logger.info("ENVIRONMENT VARIABLES: {}",
	 * gson.toJson(System.getenv())); logger.info("CONTEXT: {}",
	 * gson.toJson(context)); logger.info("EVENT: {}", gson.toJson(event)); //
	 * process event for(SQSMessage msg : event.getRecords()){
	 * logger.info(msg.getBody()); } // process Lambda API response try {
	 * GetAccountSettingsResponse settings = accountSettings.get(); response =
	 * gson.toJson(settings.accountUsage()); logger.info("Account usage: {}",
	 * response); } catch(Exception e) { e.getStackTrace(); } return response; }
	 */
}