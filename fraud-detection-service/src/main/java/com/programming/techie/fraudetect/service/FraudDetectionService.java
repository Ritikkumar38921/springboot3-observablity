package com.programming.techie.fraudetect.service;

import com.programming.techie.fraudetect.entity.LoanStatus;
import com.programming.techie.fraudetect.repository.FraudRecordRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FraudDetectionService {

	@Autowired
    private FraudRecordRepository fraudRecordRepository;

    public LoanStatus checkForFraud(int customerId) {
        return fraudRecordRepository.existsByCustomerId(customerId) ? LoanStatus.REJECTED : LoanStatus.APPROVED;
    }
}
