package com.programming.techie.loans.service;

import com.programming.techie.loans.client.FraudDetectionClient;
import com.programming.techie.loans.dto.LoanDto;
import com.programming.techie.loans.entity.Loan;
import com.programming.techie.loans.entity.LoanStatus;
import com.programming.techie.loans.repository.LoanRepository;
import lombok.RequiredArgsConstructor;

import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoanService {

	@Autowired
    private FraudDetectionClient fraudDetectionClient;
	@Autowired
    private LoanRepository loanRepository;

    public List<LoanDto> listAllLoans() {
        return loanRepository.findAll()
                .stream()
                .map(LoanDto::from)
                .toList();
    }

    public String applyLoan(LoanDto loanDto) {
    	
    	
    	Loan loan = Loan.from(loanDto);
        LoanStatus loanStatus = fraudDetectionClient.evaluateLoan(loan.getCustomerId());
        loan.setLoanStatus(loanStatus);
        if (loanStatus.equals(LoanStatus.APPROVED)) {
            loanRepository.save(loan);
            return "Loan applied successfully";
        }
        return "Sorry! Your loan was not approved";
    }
}
