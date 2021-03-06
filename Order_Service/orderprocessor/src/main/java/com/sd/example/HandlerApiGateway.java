package com.sd.example;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Map;
import java.util.HashMap;

import com.sd.example.model.Greeting;
// Handler value: example.HandlerApiGateway
public class HandlerApiGateway implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent>{
  Gson gson = new GsonBuilder().setPrettyPrinting().create();
  @Override
  public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent event, Context context)
  {
    LambdaLogger logger = context.getLogger();
    APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent();
    response.setIsBase64Encoded(false);
    response.setStatusCode(200);
    HashMap<String, String> headers = new HashMap<String, String>();
    headers.put("Content-Type", "application/json");
    response.setHeaders(headers);
    
   	Greeting g = new Greeting(111, "Sibendu testing");
    response.setBody(gson.toJson(g));
    
    Util.logEnvironment(event, context, gson);
    return response;
  }
}