package com.test.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.test.model.FlowVariables;
import com.test.services.StatusQr;
import com.test.services.PaymentQr;
import com.test.services.InquiryQr;
import com.test.utils.UtilsHelper;

@RestController
public class TestDeveloperV7Controller {
	
	@Autowired
	UtilsHelper util;
	
	@Autowired
	InquiryQr inquiryQr;
	
	@Autowired
	PaymentQr paymentQr;
	
	@Autowired
	StatusQr statusQr;
	
	private Logger log = LogManager.getLogger(TestDeveloperV7Controller.class);
	
	@PostMapping("${server.path.inquiry-qr}")
	public Map<String, Object> InquiryQr (HttpServletRequest request,
			@RequestHeader Map<String, Object> header, @RequestBody Map<String, Object> parameters) {
		
		FlowVariables flowVars = new FlowVariables();
		Map<String, Object> response = new HashMap<String, Object>();
		
		try {
			log.info("=============== INQUIRY QR PROCESS ===============");
			log.info("Request Message -> "+parameters);
			
			// SET REQUEST
			flowVars.setRequest(request);
			flowVars.setHeaders(header);
			flowVars.setParameters(parameters);
			
			// HIT SERVICE
			response = inquiryQr.hitInquiryQr(flowVars);
			
			log.info("Response Message -> "+response);
			log.info("=============== END PROCESS ===============");
			
			return response;
			
			
		} catch (Exception e) {
			log.info("Error Caused By : "+e.toString());
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	@PostMapping("${server.path.payment-qr}")
	public Map<String, Object> PaymentQr (HttpServletRequest request,
			@RequestHeader Map<String, Object> header, @RequestBody Map<String, Object> parameters) {
		
		FlowVariables flowVars = new FlowVariables();
		Map<String, Object> response = new HashMap<String, Object>();
		
		try {
			log.info("=============== PAYMENT QR PROCESS ===============");
			log.info("Request Message -> "+parameters);
			
			// SET REQUEST
			flowVars.setRequest(request);
			flowVars.setHeaders(header);
			flowVars.setParameters(parameters);
			
			// HIT SERVICE
			response = paymentQr.hitPaymentQr(flowVars);
			
			log.info("Response Message -> "+response);
			log.info("=============== END PROCESS ===============");
			
			return response;
			
			
		} catch (Exception e) {
			log.info("Error Caused By : "+e.toString());
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	@PostMapping("${server.path.status-qr}")
	public Map<String, Object> StatusQr (HttpServletRequest request,
			@RequestHeader Map<String, Object> header, @RequestBody Map<String, Object> parameters) {
		
		FlowVariables flowVars = new FlowVariables();
		Map<String, Object> response = new HashMap<String, Object>();
		
		try {
			log.info("=============== STATUS QR PROCESS ===============");
			log.info("Request Message -> "+parameters);
			
			// SET REQUEST
			flowVars.setRequest(request);
			flowVars.setHeaders(header);
			flowVars.setParameters(parameters);
			
			// HIT SERVICE
			response = statusQr.hitStatusQr(flowVars);
			
			log.info("Response Message -> "+response);
			log.info("=============== END PROCESS ===============");
			
			return response;
			
			
		} catch (Exception e) {
			log.info("Error Caused By : "+e.toString());
			e.printStackTrace();
		}
		
		return null;
		
	}
}
