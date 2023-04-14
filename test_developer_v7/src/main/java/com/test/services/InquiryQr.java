package com.test.services;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.model.FlowVariables;
import com.test.utils.UtilsHelper;

@Service
public class InquiryQr {
	
	@Autowired
	UtilsHelper util;
	
	private Logger log = LogManager.getLogger(InquiryQr.class);
	
	public Map<String, Object> hitInquiryQr(FlowVariables flowVars) {
		
		Map<String, Object> response = new HashMap<String, Object>();
		
		Map<String, Object> headers =  flowVars.getHeaders();
		Map<String, Object> payload = flowVars.getParameters();
		
		try {
			// here can be input real process (ex. generate/parse qr, validation, etc)
			
			// response process
			response.put("response_code", "00");
			response.put("response_description", "Success");
			response.put("rrn", "034597612911");
			response.put("approval_code", "146004");
			response.put("account", "9426081617616835");
			response.put("beneficiary_name", "ARFAN HERMAN");
			
			
		} catch (Exception e) {
			log.info("Error Caused By : "+e.toString());
			e.printStackTrace();
			
			response.put("response_code", "99");
			response.put("response_description", "General Error");
		}

		return response;
	}
}
