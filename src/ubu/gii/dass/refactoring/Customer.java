package ubu.gii.dass.refactoring;

/**
* Tema  Refactorizaciones 
*
* Ejemplo de aplicaci�n de refactorizaciones. Actualizado para colecciones gen�ricas de java 1.5
*
* @author M. Fowler y <A HREF="mailto:clopezno@ubu.es">Carlos L�pez</A>
* @version 1.1
* @see java.io.File
*
*/
import java.util.*;

public class Customer {
	private String _name;
	private List<Rental> _rentals;

	public Customer(String name) {
		_name = name;
		_rentals = new ArrayList<Rental>();

	};

	public void addRental(Rental arg) {
		_rentals.add(arg);
	}

	public String getName() {
		return _name;
	};

	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Iterator<Rental> rentals = _rentals.iterator();
		String result = "Rental Record for " + getName() + "\n";
		while (rentals.hasNext()) {
			double thisAmount = 0;
			Rental each = rentals.next();
			// determine amounts for each line
			thisAmount = each.getMovie().getCharge(each);
			
			frequentRenterPoints += each.getMovie().getFrequentRenterPoints(each);
			// show figures for this rental
			result += "\t" + each.getMovie().getTitle() + "\t"
					+ String.valueOf(thisAmount) + "\n";
			totalAmount += thisAmount;
		}
		// add footer lines
		result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints)
				+ " frequent renter points";
		return result;
	}
	
	public String htmlStatement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Iterator<Rental> rentals = _rentals.iterator();
		String result = "<H1>Rental Record for " + getName() + "</H1>";
		while (rentals.hasNext()) {
			double thisAmount = 0;
			Rental each = rentals.next();
			// determine amounts for each line
			thisAmount = each.getMovie().getCharge(each);
			
			frequentRenterPoints += each.getMovie().getFrequentRenterPoints(each);
			// show figures for this rental
			result += "<H2>" + each.getMovie().getTitle() + "\t"
					+ String.valueOf(thisAmount) + "</H2>";
			totalAmount += thisAmount;
		}
		// add footer lines
		result += "<P>Amount owed is " + String.valueOf(totalAmount) + "<P>";
		result += "<P>You earned " + String.valueOf(frequentRenterPoints)
				+ " frequent renter points </P>";
		return result;
	}
}
