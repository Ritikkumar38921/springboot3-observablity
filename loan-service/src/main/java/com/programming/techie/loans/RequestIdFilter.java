package com.programming.techie.loans;

import java.util.UUID;

import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

@Component
public class RequestIdFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {
		try {
			// Generate or retrieve the RequestId
			String requestId = UUID.randomUUID().toString();
			// Set it in the MDC
			MDC.put("RequestId", requestId);
			// Proceed with the filter chain
			chain.doFilter(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// Clear MDC after the request
			MDC.clear();
		}
	}

}
