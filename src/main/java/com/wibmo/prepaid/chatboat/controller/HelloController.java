package com.wibmo.prepaid.chatboat.controller;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.google.api.client.json.JsonGenerator;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.dialogflow.v2.model.*;

import com.wibmo.prepaid.chatboat.dos.ResponseDo;

@RestController

public class HelloController {
	@Autowired
	private  JacksonFactory JacksoFactory;
	
	@GetMapping("/")
	String hello() {
		return "Hello World";
	}
	
	
	@PostMapping("/dialogflow-fulfilment")
	//@ResponseBody ResponseDo dialogfufilment(String request) {
      String  dialogfufilment(@RequestBody String request) throws IOException {
		System.out.println("testing dialogflow-1 app");
		//ResponseDo do1 =new ResponseDo();do1.setResponse("from spring boot app");
		//return do1 ;
		
		
		
		GoogleCloudDialogflowV2IntentMessage msg = new GoogleCloudDialogflowV2IntentMessage();
		GoogleCloudDialogflowV2IntentMessageText text =new GoogleCloudDialogflowV2IntentMessageText();
		text.setText(Arrays.asList("welcome to spring boot"));
		msg.setText(text);
		
		
		
		GoogleCloudDialogflowV2WebhookResponse response = new GoogleCloudDialogflowV2WebhookResponse();
		response.setFulfillmentMessages(Arrays.asList(msg));
		
		StringWriter stringWriter = new StringWriter();
		JsonGenerator generator = JacksoFactory.createJsonGenerator(stringWriter);
		generator.enablePrettyPrint();
		generator.serialize(response);
		generator.flush();
		
		
		return stringWriter.toString();
	}
}
