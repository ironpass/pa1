
public class UnitConverter {
	public double convert(double amount, Unit fromUnit, Unit toUnit) {
		return amount*fromUnit.getValue()/toUnit.getValue();
	}
	public Length[] getLength() {
		return Length.values();
	}
	public Weight[] getWeight() {
		return Weight.values();
	}
	public Area[] getArea() {
		return Area.values();
	}
	public Time[] getTime() {
		return Time.values();
	}
}
