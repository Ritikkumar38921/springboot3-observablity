package com.programming.techie.loans.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.programming.techie.loans.entity.LoanStatus;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class FraudDetectionClient {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private RestTemplate fraudServiceRestTemplate;

	public LoanStatus evaluateLoan(int customerId) {
		logger.info("Calling Fraud Detection Service for customer id: {}", customerId);
		var response = fraudServiceRestTemplate
				.exchange("/fraud/check?customerId=" + customerId, HttpMethod.GET, null, LoanStatus.class).getBody();
		logger.info("Fraud Detection Service response: {}", response);
		return response;
	}

}
