---

# Selenium Java Test Automation Framework

## Overview

This repository houses a robust Selenium-based test automation framework tailored for web applications. The framework is meticulously designed to simplify the automation process, fostering easy onboarding and seamless maintenance for all team members.

## Components

### 1. Project Structure

The project structure is organized for clarity and efficiency:

- **browserDrivers:** Holds browser drivers needed for Selenium WebDriver.
- **src/main/java:**
  - **base:** Contains the `BaseTest` class providing foundational functionalities.
  - **configurations:** Houses the `config.properties` file specifying browser type configurations.
  - **pages:** Stores page objects following the Page Object Model design pattern.
  - **reports:** Stores generated test reports.
  - **resources:** Contains utility classes and configurations.
  - **utilities:** Holds the `ReusableMethods` class with reusable methods and elements.

- **src/test/java:**
  - **data:** Contains JSON files for test data.
  - **listeners:** Includes the `Listeners` class implementing TestNG's `ITestListener` for event handling.
  - **testCases:** Houses test cases implemented using TestNG.
  - **testSuite:** Contains TestNG XML files for executing test suites.

### 2. Selenium WebDriver Integration

The framework seamlessly integrates with Selenium WebDriver, utilizing WebDriverManager to simplify setup and ensure compatibility.

### 3. Page Object Model (POM)

The Page Object Model design pattern enhances test script readability and maintainability. Page classes in the `pages` package represent web pages, and methods within these classes correspond to actions on those pages.

### 4. TestNG Test Cases

Test cases are written using TestNG, providing a structured and organized approach to test execution. Retry functionality is implemented using the `Retry` class.

### 5. Configuration

Configuration settings, such as browser type and other parameters, are stored in the `config.properties` file in the `configurations` package. This allows easy adaptation to different testing environments.

### 6. Reporting

Test reports are generated using ExtentReports, and they can be found in the `reports` directory after test execution. The `Reporter` class in the `resources` package configures the content of HTML reports.

### 7. Utilities

The `utilities` package contains the `ReusableMethods` class, which includes reusable methods and elements that contribute to code reusability.

## Getting Started

To begin using the framework, follow these steps:

1. **Clone the Repository:**
   ```
   git clone https://github.com/razaqyaro/Test-driven-Automation-Framework-with-Selenium-Java-.git
   ```

2. **Install Dependencies:**
   ```
   cd your-repo
   mvn clean install
   ```

3. **Run Sample Test:**
   ```
   mvn test -Dtest=TestCase1
   ```

## Configuration

Adjust the configuration settings in `src/main/java/configurations/config.properties` to match your testing environment.

## Writing Tests

1. Create a new test class in `src/test/java/testCases`.
2. Extend the base test class (`BaseTest`) to inherit common functionalities.
3. Utilize the Page Object Model for interacting with web elements on pages.

## Reporting

View test reports generated in the `reports` directory after test execution.

## Contributing

Feel free to contribute to the development of this framework. If you encounter issues or have suggestions for improvements, please open an issue or submit a pull request.

--- 

