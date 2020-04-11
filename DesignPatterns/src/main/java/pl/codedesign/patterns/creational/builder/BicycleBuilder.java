package pl.codedesign.patterns.creational.builder;

import pl.codedesign.patterns.creational.builder.Bicycle.Break;
import pl.codedesign.patterns.creational.builder.Bicycle.Material;
import pl.codedesign.patterns.creational.builder.Bicycle.Suspension;
import pl.codedesign.patterns.creational.builder.Bicycle.Tire;

/** Fluent builder battern. Allows swift object construction. */
public class BicycleBuilder {

	private Break breaks;
	private Suspension suspensionFront;
	private Suspension suspensionBack;
	private Material rims;
	private Material frame;
	private Tire tires;

	public static BicycleBuilder builder() {
		return new BicycleBuilder();
	}
	
	public Bicycle build() {
		Bicycle b = new Bicycle();
		b.setBreaks(this.breaks);
		b.setSuspensionBack(this.suspensionBack);
		b.setSuspensionFront(this.suspensionFront);
		b.setRims(this.rims);
		b.setFrame(this.frame);
		b.setTires(this.tires);
		
		return b;
	}

	public BicycleBuilder breaks(Break breaks) {
		this.breaks = breaks;
		return this;
	}

	public BicycleBuilder suspensionFront(Suspension suspensionFront) {
		this.suspensionFront = suspensionFront;
		return this;
	}

	public BicycleBuilder suspensionBack(Suspension suspensionBack) {
		this.suspensionBack = suspensionBack;
		return this;
	}

	public BicycleBuilder rims(Material rims) {
		this.rims = rims;
		return this;
	}

	public BicycleBuilder frame(Material frame) {
		this.frame = frame;
		return this;
	}

	public BicycleBuilder tires(Tire tires) {
		this.tires = tires;
		return this;
	}

}
