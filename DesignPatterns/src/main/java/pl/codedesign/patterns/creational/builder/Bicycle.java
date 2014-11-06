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

	private final Break breaks;
	private final Suspension suspensionFront;
	private final Suspension suspensionBack;
	private final Material rims;
	private final Material frame;
	private final Tire tires;

	/**
	 * Single constructor filling all needed info from builder.
	 * 
	 * @param builder
	 */
	public Bicycle(Builder builder) {
		this.breaks = builder.breaks;
		this.suspensionBack = builder.suspensionBack;
		this.suspensionFront = builder.suspensionFront;
		this.rims = builder.rims;
		this.frame = builder.frame;
		this.tires = builder.tires;
	}

	/** Allows swift object construction. */
	static class Builder {
		private Break breaks;
		private Suspension suspensionFront;
		private Suspension suspensionBack;
		private Material rims;
		private Material frame;
		private Tire tires;

		public Bicycle build() {
			return new Bicycle(this);
		}

		public Builder breaks(Break breaks) {
			this.breaks = breaks;
			return this;
		}

		public Builder suspensionFront(Suspension suspensionFront) {
			this.suspensionFront = suspensionFront;
			return this;
		}

		public Builder suspensionBack(Suspension suspensionBack) {
			this.suspensionBack = suspensionBack;
			return this;
		}

		public Builder rims(Material rims) {
			this.rims = rims;
			return this;
		}

		public Builder frame(Material frame) {
			this.frame = frame;
			return this;
		}

		public Builder tires(Tire tires) {
			this.tires = tires;
			return this;
		}
	}

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

	@Override
	public String toString() {
		return "Bicycle [breaks=" + breaks + ", suspensionFront=" + suspensionFront + ", suspensionBack="
				+ suspensionBack + ", rims=" + rims + ", frame=" + frame + ", tires=" + tires + "]";
	}

}
