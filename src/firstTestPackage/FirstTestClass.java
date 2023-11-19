package firstTestPackage;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstTestClass {

	@Test(priority = 1)
	public void validateChathamkentWebsite() {

		String expectedTitle = "Service Chatham-kent";
		String actualTitle = "Chatham-kent";
		Assert.assertEquals(actualTitle, expectedTitle, "The website title do not match.");
		System.out.println("The website is " + actualTitle);
	}

	@Test(priority = 2)
	public void validateLibraryPortal() {
		boolean isLibraryPortalDisplayed = true;
		Assert.assertTrue(isLibraryPortalDisplayed, "Library poratal is not visible.");
	}

	@Test(priority = 3, invocationCount = 3)
	public void validateLogIn() {
		System.out.println("Opening another window for log in.");
		String expectedMessage = "login successfull";
		String actualMessage = "login successfull";
		Assert.assertEquals(actualMessage, expectedMessage, "The expected message and actual message are diffeernt.");
	}

	@Test(priority = 4, dependsOnMethods = "validateLogIn")
	public void validateBookWishlistFunctionality() {
		boolean isBookadded = true;
		Assert.assertTrue(isBookadded);

	}

	@BeforeMethod
	public void setup() {
		System.out.println("Launch Google chrome browser.");
	}

	@AfterMethod
	public void tearDown() {
		System.out.println("Close Google chrome browser.");
	}
}
