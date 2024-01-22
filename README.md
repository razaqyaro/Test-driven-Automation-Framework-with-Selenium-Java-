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

---
Certainly! Let's include a section in your README explaining the use of Maven profiles and their significance:

---

# Maven Profiles

Maven profiles provide a way to customize build configurations based on different environments, requirements, or scenarios. In this project, profiles are utilized to enable the execution of specific sets of tests or configurations.

## Profiles Overview

### 1. **TestSuiteID Profile:**
   - **ID:** `TestSuiteID`
   - **Description:** This profile is configured to execute a specific TestNG XML suite file named `TestSuite2.xml`. It allows users to run a predefined suite of tests by activating this profile.

   ```bash
   mvn test -PTestSuiteID
   ```

### 2. **Test_Suite_Identifier Profile:**
   - **ID:** `Test_Suite_Identifier`
   - **Description:** This profile is set up to run a different TestNG suite file (`TestSuite3.xml`). It provides flexibility to execute a distinct suite of tests based on specific criteria.

   ```bash
   mvn test -PTest_Suite_Identifier
   ```

### 3. **Test_Identifier Profile:**
   - **ID:** `Test_Identifier`
   - **Description:** The `Test_Identifier` profile is configured to execute a specific TestNG XML suite file (`TestSuite4.xml`). This profile allows running a targeted set of tests specified in the corresponding suite file.

   ```bash
   mvn test -PTest_Identifier
   ```

## How to Use Profiles

To run tests with a specific profile, use the `-P` option followed by the profile ID:

```bash
mvn test -PProfile_ID
```

Replace `Profile_ID` with the desired profile identifier (`TestSuiteID`, `Test_Suite_Identifier`, or `Test_Identifier`).

## Why Profiles Are Useful

- **Environment-specific Configurations:** Profiles allow you to set up environment-specific configurations, ensuring your tests can adapt to different environments (e.g., development, staging, production).

- **Selective Test Execution:** Profiles enable the execution of specific sets of tests, helping you focus on targeted test scenarios during development or as part of your CI/CD pipeline.

- **Reusability:** By using profiles, you can create a more flexible and reusable Maven project that adapts to various testing needs without modifying the core project structure.

---

Feel free to adjust the content to better fit your project's specifics or add any additional information you find relevant.

# GitHub Actions

This project is integrated with GitHub Actions to automate the testing process. GitHub Actions provides continuous integration and delivery (CI/CD) capabilities directly within your GitHub repository. The workflow configuration is defined in the `.github/workflows` directory.

## Workflow Configuration

The CI workflow is triggered on every push to the repository and on manual workflow dispatch events. The main workflow file is `.github/workflows/buildPipeline.yml` and it contains the following steps:

```yaml
name: Test Build

on:
  push:
  workflow_dispatch:

jobs:
  build:
    runs-on: windows-latest
    steps:
    - uses: actions/checkout@v3
    
    - name: Set up JDK 17
      uses: actions/setup-java@v3
      with:
        java-version: '17'
        distribution: 'temurin'
        cache: maven

    - name: Clean and Run Tests
      run: mvn clean test
```

This workflow performs the following tasks:

1. Checks out the repository.
2. Sets up JDK 17 using the `actions/setup-java` action.
3. Cleans the project and runs the tests using Maven.

## Viewing Workflow Runs

GitHub Actions provides a detailed log for each workflow run, allowing you to monitor the progress and outcome of the CI process. You can view the workflow runs by navigating to the "Actions" tab in your GitHub repository.

## Contributing to the Workflow

Feel free to customize the workflow according to your specific needs. You can add additional steps, integrate with other services, or modify the triggers based on your project requirements.

For more information on GitHub Actions and workflow customization, refer to the [official documentation](https://docs.github.com/en/actions).

---

Make sure to adjust the content based on the specifics of your GitHub Actions workflow and any customizations you've made. This section provides a brief overview and guidance for users who want to understand and potentially modify the CI workflow.

## Contributing

Feel free to contribute to the development of this framework. If you encounter issues or have suggestions for improvements, please open an issue or submit a pull request.

--- 

