
public enum Area implements Unit {
	SQUAREMETER("Square meter", 1.00),
	SQUAREKILOMETER("Square kilometer", 1000000.0),
	SQUAREMILE("Square mile", 38610000.0),
	SQUAREFOOT("Square foot", 10.76),
	ACRE("Acre", 4046.86),
	RAI("Rai", 1600);
	
	private final String name;
	private final double value;
	
	private Area(String name, double value) {
		this.name = name;
		this.value = value;
	}
	public String getName() {
		return this.name;
	}
	public double getValue() {
		return value;
	}
}
