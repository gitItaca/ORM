package ACDT_practica02.ORM.exceptions;

public class ZeroPriceException extends Exception{

	public String getMessage() {
		return "Los precios no pueden estar a 0.";
	}
	
}
