package org.opengis.cite.cdb10.cdbStructure;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.opengis.cite.cdb10.TestFixture;

public class VerifyMModelStructureTests extends StructureTestFixture<MModelStructureTests> {

	public VerifyMModelStructureTests() throws IOException {
		this.testSuite = new MModelStructureTests();
	}

	@Test(expected = AssertionError.class)
	public void verifyDataset_BadShort() throws IOException {
		// setup
		Files.createDirectories(this.cdb_root.resolve(Paths.get("MModel", "6_MModelGeometry")));

		// execute
		this.testSuite.verifyDataset();
	}

	@Test(expected = AssertionError.class)
	public void verifyDataset_BadNumber() throws IOException {
		// setup
		Files.createDirectories(this.cdb_root.resolve(Paths.get("MModel", "6xx_MModelGeometry")));

		// execute
		this.testSuite.verifyDataset();
	}

	@Test(expected = AssertionError.class)
	public void verifyDataset_BadRange() throws IOException {
		// setup
		Files.createDirectories(this.cdb_root.resolve(Paths.get("MModel", "-1_MModelGeometry")));

		// execute
		this.testSuite.verifyDataset();
	}

	@Test(expected = AssertionError.class)
	public void verifyDataset_BadValue() throws IOException {
		// setup
		Files.createDirectories(this.cdb_root.resolve(Paths.get("MModel", "999_MModelGeometry")));

		// execute
		this.testSuite.verifyDataset();
	}

	@Test
	public void verifyDataset_Good() throws IOException {
		// setup
		Files.createDirectories(this.cdb_root.resolve(Paths.get("MModel", "600_MModelGeometry")));

		// execute
		this.testSuite.verifyDataset();
	}

	@Test
	public void verifyDataset_Skip() throws IOException {
		// setup
		// execute
		this.testSuite.verifyDataset();
	}

}
