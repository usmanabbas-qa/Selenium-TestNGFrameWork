# Selenium Java Automation Framework

This project is an automated test suite for the **Demo Web Shop** application using **Selenium WebDriver** with **Java**, following the **Page Object Model (POM)** design pattern.

---

##  Technologies Used

- Java
- Selenium WebDriver
- TestNG
- Maven (optional)
- Page Object Model (POM)

---

## 📁 Project Structure

- `Pages/` – Contains all Page classes (e.g., `LoginPage.java`, `CheckoutPage.java`) which include test actions.
- `Locators/` – Contains locator classes (e.g., `LoginLocators.java`) that store web element locators separately.
- `Tests/` – Contains all TestNG test classes (e.g., `Login.java`, `ShoppingCart.java`) that call page functions.
- `Base/` – Contains base setup like `BaseTest.java`.
- `Utils/` – Reusable helper methods (e.g., `CommonActions.java`).
- `test-output/` - is used for reports 

---

## 📦 How to Use

### 1. Clone the Repository

git clone https://github.com/automation-learning-development/pseb-b3-playwright-java-dwt

### 2. Import the Project
- Open the project in IntelliJ IDEA or Eclipse
- Make sure you have TestNG plugin installed

###  3. Run the Tests
- You can run individual test classes from the Tests/ folder.

- Or you can create and run a testng.xml file to execute multiple tests together.

- Note: All tests extend BaseTest.java which handles WebDriver setup and teardown.


### 📚 Example Imports

- import Pages.LoginPage;
- import Pages.DashboardPage;
- import Locators.LoginLocators;
- import Base.BaseTest;
- import Drivers.DriverManager;


### 🚀 Sample Test Class Structure

public class Login extends BaseTest {
- LoginPage loginPage = new LoginPage(getDriver());

    @Test
    public void testLoginWithValidCredentials() {
        loginPage.enterEmail("test@demo.com");
        loginPage.enterPassword("password123");
        loginPage.clickLogin();
    }
}

### 🧪 Running Tests
### Tests are written using TestNG

### Use @Test annotations

- Execute from:
  - TestNG XML
    - Right-click test class > Run

- Command line (if Maven is configured)

### 🔖 Author
- Usman
  - QA Engineer 

```bash