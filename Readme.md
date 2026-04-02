# 🔬 Selenium — TestNG Framework

> A structured Selenium WebDriver automation framework integrated with **TestNG** — built for cross-browser testing, parallel execution, and comprehensive regression testing.

![Selenium](https://img.shields.io/badge/Selenium-43B02A?style=for-the-badge&logo=selenium&logoColor=white)
![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![TestNG](https://img.shields.io/badge/TestNG-FF6C37?style=for-the-badge&logo=testing-library&logoColor=white)
![Jenkins](https://img.shields.io/badge/Jenkins-D24939?style=for-the-badge&logo=jenkins&logoColor=white)

---

## 📌 Project Overview

This project is a complete **Selenium WebDriver + TestNG** automation framework built in Java. It demonstrates cross-browser testing, parallel test execution, data-driven testing, and CI/CD integration with Jenkins — following industry-standard practices used in professional QA teams.

---

## ✅ Test Coverage

| Test Type | Description |
|-----------|-------------|
| 🌐 Cross-Browser Testing | Chrome, Firefox, Edge support |
| 🔁 Regression Suite | Full regression across all modules |
| 📊 Data-Driven Testing | TestNG DataProvider with Excel/JSON |
| ⚡ Parallel Execution | Multi-thread test execution via TestNG XML |
| 📋 Reporting | ExtentReports for rich HTML reports |

---

## 🏗️ Project Structure

```
Selenium-TestNGFrameWork/
│
├── src/
│   ├── main/java/
│   │   ├── base/
│   │   │   └── BaseTest.java          # WebDriver setup & teardown
│   │   ├── pages/
│   │   │   ├── LoginPage.java
│   │   │   └── DashboardPage.java
│   │   └── utils/
│   │       ├── DriverFactory.java     # Browser factory
│   │       ├── ExtentReportManager.java
│   │       └── DataProviderUtils.java
│   │
│   └── test/java/
│       ├── LoginTests.java
│       ├── DashboardTests.java
│       └── RegressionSuite.java
│
├── testng.xml                         # TestNG suite configuration
├── pom.xml                            # Maven dependencies
└── README.md
```

---

## 🛠️ Tech Stack

- **Automation Tool:** Selenium WebDriver
- **Language:** Java
- **Test Framework:** TestNG
- **Build Tool:** Maven
- **Design Pattern:** Page Object Model (POM)
- **Reporting:** ExtentReports
- **CI/CD:** Jenkins
- **Browsers:** Chrome · Firefox · Edge

---

## ⚙️ Prerequisites

- Java JDK 11 or above
- Maven 3.6+
- Chrome / Firefox / Edge browser installed

---

## 🚀 Getting Started

### 1. Clone the repository
```bash
git clone https://github.com/usmanabbas-qa/Selenium-TestNGFrameWork.git
cd Selenium-TestNGFrameWork
```

### 2. Install dependencies
```bash
mvn clean install
```

### 3. Run all tests
```bash
mvn test
```

### 4. Run specific suite
```bash
mvn test -DsuiteXmlFile=testng.xml
```

### 5. Run on specific browser
```bash
mvn test -Dbrowser=firefox
mvn test -Dbrowser=chrome
```

---

## 📊 Sample Test Case

```java
// LoginTests.java — Selenium + TestNG Test
public class LoginTests extends BaseTest {

    LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        loginPage = new LoginPage(driver);
        loginPage.navigateTo("https://example.com/login");
    }

    @Test(description = "Valid user login")
    public void testValidLogin() {
        loginPage.enterUsername("testuser@example.com");
        loginPage.enterPassword("password123");
        loginPage.clickLoginButton();

        Assert.assertTrue(driver.getCurrentUrl().contains("/dashboard"),
            "User should be redirected to dashboard after login");
    }

    @Test(dataProvider = "invalidCredentials",
          description = "Invalid login scenarios")
    public void testInvalidLogin(String email, String password) {
        loginPage.enterUsername(email);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();

        Assert.assertTrue(loginPage.isErrorMessageDisplayed(),
            "Error message should be shown for invalid credentials");
    }

    @DataProvider(name = "invalidCredentials")
    public Object[][] invalidCredentials() {
        return new Object[][] {
            {"wrong@email.com", "wrongpass"},
            {"", "password123"},
            {"user@test.com", ""}
        };
    }
}
```

---

## 📈 Jenkins CI/CD Integration

This framework is configured to run with **Jenkins**:

1. Create a new Jenkins Pipeline job
2. Connect to this GitHub repository
3. Set build trigger: `Poll SCM` or `GitHub Webhooks`
4. Add build step: `mvn clean test`
5. Publish ExtentReports HTML output as build artifact

---

## 🤝 Connect With Me

[![LinkedIn](https://img.shields.io/badge/LinkedIn-usmanabbas--qa-0077B5?style=flat-square&logo=linkedin&logoColor=white)](https://linkedin.com/in/usmanabbas-qa)
[![Gmail](https://img.shields.io/badge/Gmail-usmanabbas7400@gmail.com-D14836?style=flat-square&logo=gmail&logoColor=white)](mailto:usmanabbas7400@gmail.com)

---

⭐ **If you found this project helpful, please give it a star!**
