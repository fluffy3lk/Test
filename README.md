<!--- BEGIN: Test Environment Setup Guide -->

## Test Environment Setup Guide

### Prerequisites
- Java Development Kit (JDK) installed on your system. You can download it from [Oracle's website](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) or use OpenJDK.
- Git installed on your system. You can download it from [here](https://git-scm.com/downloads).
- Maven installed on your system. You can download it from [here](https://maven.apache.org/download.cgi).

### Setup Steps

1. **Clone the Repository**
   - Open your terminal or command prompt.
   - Run the following command to clone the repository:
     ```
     git clone https://github.com/fluffy3lk/Test.git
     ```
2. **Navigate to the Project Directory**
   - Change your current directory to the project directory:
     ```
     cd Test
     ```

3. **Build the Project**
   - Run Maven to build the project:
     ```
     mvn clean install
     ```
   - This command will compile the code, run tests, and package the application.

4. **Run Tests**
   - Execute the following command to run tests:
     ```
     mvn test
     ```
   - This command will run all the tests in your project.

<!--- END: Test Environment Setup Guide -->

