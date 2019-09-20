/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package de.esg.mongodemo;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.testcontainers.containers.FixedHostPortGenericContainer;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
public class LibraryTest
{
	// will be started before and stopped after each test method
	@Container
	private final GenericContainer<?> mongodbContainer = new FixedHostPortGenericContainer<>("mongo:4.0.4")
			.withExposedPorts(27017).withFixedExposedPort(27017, 27017);

	// will be shared between test methods
	// @Container
	// private static final GenericContainer mongodbContainer = new
	// GenericContainer<>("mongo:4.2.0").withExposedPorts(27017);

	Library classUnderTest = new Library();

	@Test
	public void testCreateProject()
	{
		// final List<Integer> ports = this.mongodbContainer.getExposedPorts();
		// SassertNotNull(ports);

		// act
		final Project project = this.classUnderTest.createProject();
		// assert
		assertNotNull(project);

		System.out.println(project.toString());

	}
}