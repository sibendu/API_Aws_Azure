package com;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.LambdaLogger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Map;

// Handler value: example.HandlerWeatherData
public class Function2 implements RequestHandler<Customer, Customer>{
  Gson gson = new GsonBuilder().setPrettyPrinting().create();
  @Override
  public Customer handleRequest(Customer event, Context context)
  {
    LambdaLogger logger = context.getLogger();
    // process event
    logger.log("EVENT: " + gson.toJson(event));
    event.setAge(event.getAge()-2);
    logger.log("EVENT: " + gson.toJson(event));
    logger.log("EVENT TYPE: " + event.getClass().toString());
    return event;
  }
}