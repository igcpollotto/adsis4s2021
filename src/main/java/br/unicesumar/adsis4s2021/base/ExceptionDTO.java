package br.unicesumar.adsis4s2021.base;

public class ExceptionDTO {
	private String exceptionType;
	private String message;
	
	
	public ExceptionDTO() {
	}
	
	public String getExceptionType() {
		return exceptionType;
	}
	public String getMessage() {
		return message;
	}

	public ExceptionDTO(String exceptionType, String message) {
		super();
		this.exceptionType = exceptionType;
		this.message = message;
	}
	

}
