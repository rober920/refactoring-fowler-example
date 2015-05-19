package ubu.gii.dass.refactoring;

public class NewRelease extends MovieType {

	public NewRelease() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getMovietype() {

		return MovieType.NEW_RELEASE;
	}

	@Override
	public double getCharge(Rental rental) {
		double result = 0;
		result += rental.getDaysRented() * 3;
		return result;
	}

}
