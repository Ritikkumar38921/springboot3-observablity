package com.programming.techie.loans.entity;

import com.programming.techie.loans.dto.LoanDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

//@AllArgsConstructor
public class Loan {
    private Long id;
    private String loanId;
    private String customerName;
    private int customerId;
    private BigDecimal amount;
    private LoanStatus loanStatus;
    
    public Loan(String loanId , BigDecimal amount ,int customerId , String customerName) {
    	this.loanId = loanId;
    	this.amount = amount;
    	this.customerId = customerId;
    	this.customerName = customerName;
    }
    
//    public Loan(String loanId , BigDecimal amount ,int customerId , String customerName , LoanStatus loanStatus) {
//    	this.loanId = loanId;
//    	this.amount = amount;
//    	this.customerId = customerId;
//    	this.customerName = customerName;
//    	this.loanStatus = loanStatus;
//    }
    
    

//    public Loan(Long id, String loanId, String customerName, int customerId, BigDecimal amount, LoanStatus loanStatus) {
//		super();
//		this.id = id;
//		this.loanId = loanId;
//		this.customerName = customerName;
//		this.customerId = customerId;
//		this.amount = amount;
//		this.loanStatus = loanStatus;
//	}

	public static Loan from(LoanDto loanDto) {
//        if (loanDto.getLoanId() == null && loanDto.getLoanStatus() == null) {
            return new Loan(loanDto.getLoanId() , loanDto.getAmount() , loanDto.getCustomerId()
                    ,loanDto.getCustomerName());
//        }
//        return Loan.builder()
//                .loanId(loanDto.getLoanId())
//                .amount(loanDto.getAmount())
//                .customerId(loanDto.getCustomerId())
//                .customerName(loanDto.getCustomerName())
//                .build();
        
        
//        return new Loan(loanDto.getLoanId() , loanDto.getAmount() , loanDto.getCustomerId()
//                ,loanDto.getCustomerName() , loanDto.getLoanStatus());
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLoanId() {
		return loanId;
	}

	public void setLoanId(String loanId) {
		this.loanId = loanId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public LoanStatus getLoanStatus() {
		return loanStatus;
	}

	public void setLoanStatus(LoanStatus loanStatus) {
		this.loanStatus = loanStatus;
	}
    
}
