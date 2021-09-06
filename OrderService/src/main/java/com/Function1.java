package com;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.LambdaLogger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Map;

// Handler value: example.Handler
public class Function1 implements RequestHandler<Map<String,String>, Customer>{
  Gson gson = new GsonBuilder().setPrettyPrinting().create();
  @Override
  public Customer handleRequest(Map<String,String> event, Context context)
  {
    LambdaLogger logger = context.getLogger();
    Customer cust = new Customer("Sibendu",44);
    // log execution details
    logger.log("ENVIRONMENT VARIABLES: " + gson.toJson(System.getenv()));
    logger.log("CONTEXT: " + gson.toJson(context));
    // process event
    logger.log("EVENT: " + gson.toJson(event));
    logger.log("EVENT TYPE: " + event.getClass());
    return cust;
  }
}