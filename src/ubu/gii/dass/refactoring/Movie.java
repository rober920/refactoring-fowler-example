package ubu.gii.dass.refactoring;
/**
 * Tema Refactorizaciones
 * 
 * Ejemplo de aplicaci�n de refactorizaciones. Actualizado para colecciones
 * gen�ricas de java 1.5
 * 
 * @author M. Fowler y <A HREF="mailto:clopezno@ubu.es">Carlos L�pez</A>
 * @version 1.1
 * @see java.io.File
 * 
 */

public class Movie {
	private String _title;
	private int _priceCode;
	private MovieType _type;

	public Movie(String title, int priceCode) {
		_title = title;
		_priceCode = priceCode;
		setPriceCode(priceCode);
		
		
	}

	public int getPriceCode() {
		return _priceCode;
	}

	public void setPriceCode(int arg) {
		_priceCode = arg;
		switch (arg) {
		case MovieType.CHILDRENS:
			setType(new Children());
			break;
		case MovieType.REGULAR:
			setType(new Regular());
			break;
		case MovieType.NEW_RELEASE:
			setType(new NewRelease());
			break;
		default:
			break;
		}
	}

	public String getTitle() {
		return _title;
	}

	public double getCharge(Rental rental) {
		
		return getType().getCharge(rental);
	}

	public int getFrequentRenterPoints(Rental rental) {
		int frequentRenterPoints=0;
		// add frequent renter points
		frequentRenterPoints++;
		// add bonus for a two day new release rental
		if ((rental.getMovie().getPriceCode() == MovieType.NEW_RELEASE)
				&& rental.getDaysRented() > 1)
			frequentRenterPoints++;
		return frequentRenterPoints;
	}
	
	public MovieType getType(){
		return _type;
	}
	
	void setType(MovieType type){
		_type=type;
	}
}
