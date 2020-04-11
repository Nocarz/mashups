package pl.codedesign.patterns.creational.builder;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import pl.codedesign.patterns.creational.builder.Bicycle.Break;
import pl.codedesign.patterns.creational.builder.Bicycle.Material;

public class BuilderUsageExample {

	protected static Logger LOG = LogManager.getLogger(BuilderUsageExample.class);
	
	public static void main(String[] args) {
		Bicycle bicycle = BicycleBuilder.builder()
				.breaks(Break.DISC)
				.rims(Material.ALLUMINIUM)
				.frame(Material.CARBON)
				.build();
		
		LOG.info("Created bicycle: " + bicycle);
	}
	
}