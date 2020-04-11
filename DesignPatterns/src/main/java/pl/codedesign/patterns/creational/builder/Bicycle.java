package pl.codedesign.patterns.creational.builder;

/**
 * Builder command pattern example.
 * 
 * @author B.Denk
 */
public class Bicycle {
	
	enum Break {
		U, V, DISC;
	}

	enum Suspension {
		NONE, SPRING, AIR, OIL;
	}

	enum Material {
		STEEL, ALLUMINIUM, CARBON;
	}

	enum Tire {
		XCOUNTRY, STREET, OFFROAD;
	}

	private Break breaks;
	private Suspension suspensionFront;
	private Suspension suspensionBack;
	private Material rims;
	private Material frame;
	private Tire tires;

	public Break getBreaks() {
		return breaks;
	}

	public Suspension getSuspensionFront() {
		return suspensionFront;
	}

	public Suspension getSuspensionBack() {
		return suspensionBack;
	}

	public Material getRims() {
		return rims;
	}

	public Material getFrame() {
		return frame;
	}

	public Tire getTires() {
		return tires;
	}
	
	public void setBreaks(Break breaks) {
		this.breaks = breaks;
	}

	public void setSuspensionFront(Suspension suspensionFront) {
		this.suspensionFront = suspensionFront;
	}

	public void setSuspensionBack(Suspension suspensionBack) {
		this.suspensionBack = suspensionBack;
	}

	public void setRims(Material rims) {
		this.rims = rims;
	}

	public void setFrame(Material frame) {
		this.frame = frame;
	}

	public void setTires(Tire tires) {
		this.tires = tires;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Bicycle [breaks=").append(breaks).append(", suspensionFront=").append(suspensionFront)
				.append(", suspensionBack=").append(suspensionBack).append(", rims=").append(rims).append(", frame=")
				.append(frame).append(", tires=").append(tires).append("]");
		return builder.toString();
	}
}
