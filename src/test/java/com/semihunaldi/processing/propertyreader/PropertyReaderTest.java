package com.semihunaldi.processing.propertyreader;

import org.junit.Assert;
import org.junit.Test;

import java.net.URL;
import java.util.Map;

/**
 * Created by semihunaldi on 9.04.2019
 */
public class PropertyReaderTest {

	@Test
	public void test() {
		URL resource = getClass().getClassLoader().getResource("config.properties");
		String replace = resource.getFile().replace("config.properties", "");
		PropertyReader propertyReader = new PropertyReader(replace);
		Map<String, Property> prop = propertyReader.read();

		System.out.println(prop);
		Assert.assertEquals("hello",prop.get("testprop0").getString());
		Assert.assertEquals("hello",prop.get("testprop1").getString());
		Assert.assertEquals("hello",prop.get("testprop2").getString());
		Assert.assertEquals("hello",prop.get("testprop3").getString());
		Assert.assertEquals("hello",prop.get("testprop4").getString());
		Assert.assertEquals(true,prop.get("testprop5").getBool());
	}
}
