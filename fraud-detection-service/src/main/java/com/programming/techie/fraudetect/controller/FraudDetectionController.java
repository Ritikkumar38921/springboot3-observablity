package com.programming.techie.fraudetect.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.programming.techie.fraudetect.entity.LoanStatus;
import com.programming.techie.fraudetect.service.FraudDetectionService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/fraud")
@RequiredArgsConstructor
@Slf4j
public class FraudDetectionController {

	@Autowired
	private FraudDetectionService fraudDetectionService;

	private Logger log = LoggerFactory.getLogger(getClass());

	@GetMapping("/check")
	public LoanStatus checkForFraud(@RequestParam int customerId) {
		log.info("Calling Fraud Detection Service for customer id: {}", customerId);
		return fraudDetectionService.checkForFraud(customerId);
	}

}
