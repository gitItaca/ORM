package ACDT_practica02.ORM.exceptions;

public class DuplicateCodeException extends Exception{

	public String getMessage() {
		return "El codigo que ha escrito esta duplicado.";
	}
}
