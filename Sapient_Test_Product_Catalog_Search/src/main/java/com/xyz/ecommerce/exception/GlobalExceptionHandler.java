package com.xyz.ecommerce.exception;

import java.util.Date;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@RestController
@ControllerAdvice
public class GlobalExceptionHandler implements ErrorController{
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException(ProductNotFoundException RuntimeException, WebRequest request)
	{
		System.out.println("request : "+request);
		ErrorDetails errorDetails = new ErrorDetails(new Date(), 
				RuntimeException.getMessage(), 
				request.getDescription(false));
		return new ResponseEntity(errorDetails,HttpStatus.NOT_FOUND);
				
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity handleGlobalException(Exception exception, WebRequest request)
	{
		System.out.println("handleGlobalException called");
		//System.out.println("request : "+request);
		ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
		return new ResponseEntity(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
				
	}

	@Override
	public String getErrorPath() {
		return "/error";
	}
	
	@GetMapping("/error")
	public String errorMessage()
	{
		return "We couldn't found the page you were looking for. Contact Administrator";
	}
}
