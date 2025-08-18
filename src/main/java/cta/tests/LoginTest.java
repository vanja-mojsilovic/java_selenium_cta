package cta.tests;

import cta.pages.*;
//import cta.tests.*;

public class LoginTest extends BaseTest {
    public static void main(String[] args) {
        LoginTest test = new LoginTest();
        test.runTest();
    }

    public void runTest() {
        setUp();

        LoginPage loginPage = new LoginPage(driver);
        VariablesPage variablesPage = new VariablesPage(driver);

        navigate(variablesPage.googleLoginPage);
        sleep(1000);

        loginPage.enterEmailGoogle(variablesPage.emailGoogle);
        sleep(2000);

        loginPage.clickNextEmailGoogle();
        sleep(2000);

        loginPage.enterPasswordGoogle(variablesPage.passwordGoogle);
        sleep(2000);

        loginPage.clickNextPasswordGoogle();
        sleep(2000);

        loginPage.enterGoogleAuthenticatorCode(variablesPage.googleSecretKey);
        sleep(2000);

        loginPage.clickGoogleAuthenticatorCodeNextButton();
        sleep(4000);

        navigate(variablesPage.spothopperappPage);
 
        loginPage.spothopperappLogin();
        sleep(5000);

        tearDown();
        System.exit(0);
    }
}
