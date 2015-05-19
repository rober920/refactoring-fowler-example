package ubu.gii.dass.refactoring;

public abstract class MovieType {

	
	
	public static final int CHILDRENS = 2;
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;

	public abstract int getMovietype();

	public double getCharge(Rental rental) {
		double result = 0;
		switch (rental.getMovie().getPriceCode()) {
		case MovieType.REGULAR:
			result += 2;
			if (rental.getDaysRented() > 2)
				result += (rental.getDaysRented() - 2) * 1.5;
			break;
		case MovieType.NEW_RELEASE:
			result += rental.getDaysRented() * 3;
			break;
		case MovieType.CHILDRENS:
			result += 1.5;
			if (rental.getDaysRented() > 3)
				result += (rental.getDaysRented() - 3) * 1.5;
			break;
		}
		return result;
	}
	
	
}
