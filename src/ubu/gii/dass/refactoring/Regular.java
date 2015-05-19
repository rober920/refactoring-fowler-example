package ubu.gii.dass.refactoring;

public class Regular extends MovieType {

	public static final int REGULAR = 0;

	public Regular() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getMovietype() {

		return MovieType.REGULAR;
	}

	@Override
	public double getCharge(Rental rental) {
		double result = 0;

		result += 2;
		if (rental.getDaysRented() > 2)
			result += (rental.getDaysRented() - 2) * 1.5;

		return result;
	}

}
