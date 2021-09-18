package com.sd.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.sd.model.AccessTokenDTO;

import example.HandlerZuora;

public class ZuoraUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(ZuoraUtil.class);
	
	public static final String CLIENT_ID = "";
	public static final String CLIENT_SECRET = "";

	public static final String ZUORA_URL = "https://rest.sandbox.eu.zuora.com";

	public static void main(String[] args) throws Exception {
		// generateAccessToken();
		String token = getToken();

		System.out.println(token);
	}

	public static String generateAccessToken() throws Exception {
		String uri = ZUORA_URL + "/oauth/token";
		AccessTokenDTO dto = null;
		try {
			String payload = "grant_type=client_credentials&client_id=" + CLIENT_ID + "&client_secret=" + CLIENT_SECRET;

			URL url = new URL(uri);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			
			conn.setDoOutput(true);
			
			OutputStream os = conn.getOutputStream();
			os.write(payload.getBytes());
			os.flush();

			//System.out.println(conn.getResponseCode());
			
			if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output;
			//System.out.println("Output from Server .... \n");
//			while ((output = br.readLine()) != null) {
//				System.out.println(output);
//			}
			output = br.readLine();
			//System.out.println(output);
			dto = new Gson().fromJson(output, AccessTokenDTO.class);
			//System.out.println(dto);
			//saveToken(dto);
			
			conn.disconnect();
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		//System.out.println("Generated access token and saved to file:: " + dto.getAccess_token());

		return dto.getAccess_token();
	}

	public static String getToken() throws Exception {
		
		String message = System.getProperty("ZUORA_ACCESS_TOKEN");
		String time = System.getProperty("ZUORA_ACCESS_TOKEN_TIME");
		
		String token = null;
		
		if(message != null && time != null) {
			
			if (System.currentTimeMillis() - new Long(time).longValue() > 45 * 60000) {
				
				logger.info("More than 45 minutes; Generated new token and saved in memory: {} " , token);
				
				token = generateAccessToken();
				
				System.setProperty("ZUORA_ACCESS_TOKEN_TIME", System.currentTimeMillis() + "");
				System.setProperty("ZUORA_ACCESS_TOKEN", token);
				
				
			
			} else {
				logger.info("Last token still valid : {} " , token);
			}
		
		}else {
			logger.info("No token found , generating one");
			token = generateAccessToken();
		}
		
		return token;
	}

}
