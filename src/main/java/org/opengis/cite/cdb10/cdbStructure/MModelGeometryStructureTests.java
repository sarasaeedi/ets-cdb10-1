package org.opengis.cite.cdb10.cdbStructure;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.opengis.cite.cdb10.CommonFixture;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MModelGeometryStructureTests extends CommonFixture {
	/**
	 * Validates that MModelGeometry DIS Entity Kind directories have valid codes/names.
	 *
	 * @throws IOException
	 */
	@Test
	public void verifyDISEntityKind() throws IOException {
		ArrayList<String> errors = new ArrayList<String>();
		MovingModelCodesXml mmcDefs = new MovingModelCodesXml("src/test/resources/CDB");

		for (Path kindDir : Files.newDirectoryStream(Paths.get(this.path, "MModel", "600_MModelGeometry"))) {
			String filename = kindDir.getFileName().toString();
			String code = null;
			Integer codeID = null;
			String kindName = null;
			try {
				code = filename.split("_")[0];
				codeID = Integer.parseInt(code);
				kindName = filename.split("_")[1];
			}
			catch (NumberFormatException e) {
				errors.add("Invalid number format: " + filename);
			}
			catch (ArrayIndexOutOfBoundsException e) {
				errors.add("Missing kind name: " + filename);
			}

			if (codeID != null) {
				if (codeID < 0) {
					errors.add("Invalid prefix cannot be below 0: " + filename);
				} else if (!mmcDefs.isValidKindCode(codeID)) {
					errors.add("Invalid DIS Entity Kind code: " + filename);
				} else if (!mmcDefs.isValidKindName(kindName)) {
					errors.add("Invalid DIS Entity Kind name: " + filename);
				} else if (!mmcDefs.kindNameForCode(codeID).equals(kindName)) {
					errors.add("Invalid DIS Entity Kind code/name combination: " + filename);
				}
			}
		}

		Assert.assertTrue(errors.size() == 0, StringUtils.join(errors, "\n"));
	}

	/**
	 * Validates that MModelGeometry DIS Domain directories have valid codes/names.
	 *
	 * @throws IOException
	 */
	@Test
	public void verifyDISDomain() throws IOException {
		ArrayList<String> errors = new ArrayList<String>();
		MovingModelCodesXml mmcDefs = new MovingModelCodesXml("src/test/resources/CDB");

		for (Path kindDir : Files.newDirectoryStream(Paths.get(this.path, "MModel", "600_MModelGeometry"))) {
			DirectoryStream<Path> domainDirs = Files.newDirectoryStream(kindDir);

			for (Path domainDir : domainDirs) {
				String filename = domainDir.getFileName().toString();
				String code = null;
				Integer codeID = null;
				String domainName = null;
				try {
					code = filename.split("_")[0];
					codeID = Integer.parseInt(code);
					domainName = filename.split("_")[1];
				}
				catch (NumberFormatException e) {
					errors.add("Invalid number format: " + filename);
				}
				catch (ArrayIndexOutOfBoundsException e) {
					errors.add("Missing kind name: " + filename);
				}

				if (codeID != null) {
					if (codeID < 0) {
						errors.add("Invalid prefix cannot be below 0: " + filename);
					} else if (!mmcDefs.isValidDomainCode(codeID)) {
						errors.add("Invalid DIS Domain code: " + filename);
					} else if (!mmcDefs.isValidDomainName(domainName)) {
						errors.add("Invalid DIS Domain name: " + filename);
					} else if (!mmcDefs.domainNameForCode(codeID).equals(domainName)) {
						errors.add("Invalid DIS Domain code/name combination: " + filename);
					}
				}
			}
		}

		Assert.assertTrue(errors.size() == 0, StringUtils.join(errors, "\n"));
	}

	/**
	 * Validates that MModelGeometry DIS Country directories have valid codes/names.
	 *
	 * @throws IOException
	 */
	@Test
	public void verifyDISCountry() throws IOException {
		ArrayList<String> errors = new ArrayList<String>();
		DISCountryCodesXml dccDefs = new DISCountryCodesXml("src/test/resources/CDB");

		for (Path kindDir : Files.newDirectoryStream(Paths.get(this.path, "MModel", "600_MModelGeometry"))) {
			DirectoryStream<Path> domainDirs = Files.newDirectoryStream(kindDir);

			for (Path domainDir : domainDirs) {
				DirectoryStream<Path> countryDirs = Files.newDirectoryStream(domainDir);

				for (Path countryDir : countryDirs) {
					String filename = countryDir.getFileName().toString();
					String code = null;
					Integer codeID = null;
					String countryName = null;
					try {
						code = filename.split("_")[0];
						codeID = Integer.parseInt(code);
						countryName = filename.split("_")[1];
					}
					catch (NumberFormatException e) {
						errors.add("Invalid number format: " + filename);
					}
					catch (ArrayIndexOutOfBoundsException e) {
						errors.add("Missing kind name: " + filename);
					}

					if (codeID != null) {
						if (codeID < 0) {
							errors.add("Invalid prefix cannot be below 0: " + filename);
						} else if (!dccDefs.isValidCountryCode(codeID)) {
							errors.add("Invalid DIS Country code: " + filename);
						} else if (!dccDefs.isValidCountryName(countryName)) {
							errors.add("Invalid DIS Country name: " + filename);
						} else if (!dccDefs.countryNameForCode(codeID).equals(countryName)) {
							errors.add("Invalid DIS Country code/name combination: " + filename);
						}
					}
				}
			}
		}

		Assert.assertTrue(errors.size() == 0, StringUtils.join(errors, "\n"));
	}

	/**
	 * Validates that MModelGeometry DIS Category directories have valid codes/names.
	 *
	 * @throws IOException
	 */
	@Test
	public void verifyDISCategory() throws IOException {
		ArrayList<String> errors = new ArrayList<String>();
		MovingModelCodesXml mmcDefs = new MovingModelCodesXml("src/test/resources/CDB");

		for (Path kindDir : Files.newDirectoryStream(Paths.get(this.path, "MModel", "600_MModelGeometry"))) {
			DirectoryStream<Path> domainDirs = Files.newDirectoryStream(kindDir);

			for (Path domainDir : domainDirs) {
				DirectoryStream<Path> countryDirs = Files.newDirectoryStream(domainDir);

				for (Path countryDir : countryDirs) {
					DirectoryStream<Path> categoryDirs = Files.newDirectoryStream(countryDir);

					for (Path categoryDir : categoryDirs) {
						String filename = categoryDir.getFileName().toString();
						String code = null;
						Integer codeID = null;
						String categoryName = null;
						try {
							code = filename.split("_")[0];
							codeID = Integer.parseInt(code);
							categoryName = filename.split("_")[1];
						}
						catch (NumberFormatException e) {
							errors.add("Invalid number format: " + filename);
						}
						catch (ArrayIndexOutOfBoundsException e) {
							errors.add("Missing kind name: " + filename);
						}

						if (codeID != null) {
							if (codeID < 0) {
								errors.add("Invalid prefix cannot be below 0: " + filename);
							} else if (!mmcDefs.isValidCategoryCode(codeID)) {
								errors.add("Invalid DIS Category code: " + filename);
							} else if (!mmcDefs.isValidCategoryName(categoryName)) {
								errors.add("Invalid DIS Category name: " + filename);
							} else if (!mmcDefs.categoryNameForCode(codeID).equals(categoryName)) {
								errors.add("Invalid DIS Category code/name combination: " + filename);
							}
						}
					}
				}
			}
		}

		Assert.assertTrue(errors.size() == 0, StringUtils.join(errors, "\n"));
	}

	/**
	 * Validates that MModelGeometry DIS Entity directories have valid codes/names.
	 *
	 * @throws IOException
	 */
	@Test
	public void verifyDISEntity() throws IOException {
		ArrayList<String> errors = new ArrayList<String>();
		Pattern entityPattern = Pattern.compile("^(?<kind>\\d+)_(?<domain>\\d+)_(?<country>\\d+)_(?<category>\\d+)_(\\d+)_(\\d+)_(\\d+)$");

		for (Path kindDir : Files.newDirectoryStream(Paths.get(this.path, "MModel", "600_MModelGeometry"))) {
			DirectoryStream<Path> domainDirs = Files.newDirectoryStream(kindDir);
			String kindFilename = kindDir.getFileName().toString();
			String kindCode = kindFilename.split("_")[0];

			for (Path domainDir : domainDirs) {
				DirectoryStream<Path> countryDirs = Files.newDirectoryStream(domainDir);
				String domainFilename = domainDir.getFileName().toString();
				String domainCode = domainFilename.split("_")[0];

				for (Path countryDir : countryDirs) {
					DirectoryStream<Path> categoryDirs = Files.newDirectoryStream(countryDir);
					String countryFilename = countryDir.getFileName().toString();
					String countryCode = countryFilename.split("_")[0];

					for (Path categoryDir : categoryDirs) {
						DirectoryStream<Path> entityDirs = Files.newDirectoryStream(categoryDir);
						String categoryFilename = categoryDir.getFileName().toString();
						String categoryCode = categoryFilename.split("_")[0];

						for (Path entityDir : entityDirs) {
							String filename = entityDir.getFileName().toString();

							if (StringUtils.countMatches(filename, "_") != 6) {
								errors.add("Should be six underscore separators: " + filename);
							} else {
								Matcher match = entityPattern.matcher(filename);
								if (!match.find()) {
									errors.add("Invalid DIS entity directory name: " + filename);
								} else {
									if (!match.group("kind").equals(kindCode)) {
										errors.add("DIS Entity Code does not match parent directory: "
												+ filename);
									}

									if (!match.group("domain").equals(domainCode)) {
										errors.add("DIS Entity Domain does not match parent directory: "
												+ filename);
									}

									if (!match.group("country").equals(countryCode)) {
										errors.add("DIS Country Code does not match parent directory: "
												+ filename);
									}

									if (!match.group("category").equals(categoryCode)) {
										errors.add("DIS Entity Category does not match parent directory: "
												+ filename);
									}
								}
							}
						}
					}
				}
			}
		}

		Assert.assertTrue(errors.size() == 0, StringUtils.join(errors, "\n"));
	}
}
