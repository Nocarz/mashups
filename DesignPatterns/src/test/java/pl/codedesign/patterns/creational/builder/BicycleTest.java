package pl.codedesign.patterns.creational.builder;

import static org.fest.assertions.api.Assertions.assertThat;

import org.junit.Test;

import pl.codedesign.patterns.creational.builder.Bicycle;
import pl.codedesign.patterns.creational.builder.Bicycle.Break;
import pl.codedesign.patterns.creational.builder.Bicycle.Material;
import pl.codedesign.patterns.creational.builder.Bicycle.Suspension;
import pl.codedesign.patterns.creational.builder.Bicycle.Tire;

public class BicycleTest {

	@Test
	public void test() {
		Bicycle downhill = new Bicycle.Builder().breaks(Break.DISC).frame(Material.ALLUMINIUM).tires(Tire.OFFROAD)
				.suspensionBack(Suspension.OIL).suspensionFront(Suspension.OIL).build();

		assertThat(Tire.OFFROAD).isEqualTo(downhill.getTires());
	}

}