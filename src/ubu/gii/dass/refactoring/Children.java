package ubu.gii.dass.refactoring;

public class Children extends MovieType {

	public Children() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getMovietype() {

		return MovieType.CHILDRENS;
	}

	@Override
	public double getCharge(Rental rental) {
		double result = 0;
		result += 1.5;
		if (rental.getDaysRented() > 3)
			result += (rental.getDaysRented() - 3) * 1.5;

		return result;
	}

}
