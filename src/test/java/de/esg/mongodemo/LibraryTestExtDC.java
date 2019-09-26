package de.esg.mongodemo;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@DisplayName("Test mit eigenständigem Dockercontainer")
@Tag("external-container")
@TestMethodOrder(OrderAnnotation.class)
public class LibraryTestExtDC
{
	Library classUnderTest = new Library();

	@BeforeEach
	public void connectToServer()
	{
		this.classUnderTest.connectToServer();
	}

	@AfterEach
	public void disconnectFromServer()
	{
		this.classUnderTest.disconnectFromServer();
	}

	@Test
	@Order(1)
	public void testCreateProject()
	{
		// prepare
		final Version v1 = new Version(1, "neu", "Initialversion");
		final Project project = new Project("Demo-Projekt", "PROJ", v1);

		// act
		this.classUnderTest.createProject(project);
		// assert
		assertNotNull(project.getId());

	}

	@Test
	@Order(2)
	public void testFindFirstProject()
	{
		// prepare

		// act
		final Project project = this.classUnderTest.getFirstProject();

		// assert
		assertNotNull(project);
		assertEquals("Demo-Projekt", project.getName());

		System.out.println(project.toString());

	}

	@Test
	@Order(3)
	public void testCountProject()
	{
		// act
		final long count = this.classUnderTest.getCountProject();

		// assert
		assertEquals(1L, count);

	}

}
