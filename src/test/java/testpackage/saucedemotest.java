package testpackage;

import org.testng.annotations.Test;
import basepackage.basecls;
import pagepackage.saucedemopage;
import utilitiespackage.Excelutils;

public class saucedemotest extends basecls {

    @Test
    public void test() throws Exception {
        saucedemopage sg = new saucedemopage(driver);
        String exl = "path_to_excel_file";  // Your Excel file path
        String Sheet1 = "Sheet1";
        int rowCount = Excelutils.getRowCount1(exl, Sheet1);

        // Iterate over each row in the Excel file
        for (int i = 1; i <= rowCount; i++) {
            String Username = Excelutils.getcellvalue1(exl, Sheet1, i, 0);
            String Password = Excelutils.getcellvalue1(exl, Sheet1, i, 1);

            // Login with credentials from Excel
            sg.setValues(Username, Password);
            sg.clickLoginButton();

            // Handle any login alerts
            sg.handleLoginAlert();

            // Verify page source text after login attempt
            verifyTextOnPage("images");

            // Refresh the page to attempt next login (if any)
            driver.navigate().refresh();
            Thread.sleep(1000);
        }

        // Performing valid login with standard user credentials
        sg.setValues("standard_user", "secret_sauce");
        sg.clickLoginButton();
        sg.handleLoginAlert();  // Handle any login alerts
        Thread.sleep(3000);

        // Verify page source text after successful login
        verifyTextOnPage("images");

        // Verify the page title after login
        verifyTitle("Swag Labs");

        // Perform other actions like adding items to cart, checkout, etc.
        sg.addingToCart();
        sg.clickCart();
        sg.clickCheckout();
        sg.setValues2("Devika", "Pramod", "889495");
        sg.clickContinue();
        sg.clickCancel();
        sg.clickHamburger();
        sg.clickLogout();

        // Verify the URL after logout
        String expectedurl = "https://www.saucedemo.com/";
        String actualurl = driver.getCurrentUrl();
        if (actualurl.equals(expectedurl)) {
            System.out.println("URL verification is Passed");
        } else {
            System.out.println("URL verification failed");
        }
    }

    // Method to verify if specific text is present on the page
    public void verifyTextOnPage(String search) {
        try {
            String source = driver.getPageSource();  // Get the page source
            System.out.println("Page Source: " + source);  // Print the page source for debugging
            if (source.toLowerCase().contains(search.toLowerCase())) {
                System.out.println("Text Verification is Passed");
            } else {
                System.out.println("Text Verification failed");
            }
        } catch (Exception e) {
            System.out.println("Error during text verification: " + e.getMessage());
        }
    }

    // Method to verify the page title
    public void verifyTitle(String expectedTitle) {
        try {
            String actualTitle = driver.getTitle();
            System.out.println("Actual Title: " + actualTitle);  // Print actual title for debugging
            if (actualTitle.equals(expectedTitle)) {
                System.out.println("Title Verification Passed");
            } else {
                System.out.println("Title Verification Failed. Expected: " + expectedTitle + ", but got: " + actualTitle);
            }
        } catch (Exception e) {
            System.out.println("Error during title verification: " + e.getMessage());
        }
    }
}

