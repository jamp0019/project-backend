# BackendZeusProject

This project was generated with [SpringInitializr](https://start.spring.io/) java-version 17, Spring boot-version 3.1.9 and maven-version 3.8.1.

## Open application
Opening application with IntellijIDEA or Spring Tools Suite.

## Run application
Run main class called ProjectBackendApplication.

## Endpoints expose

Navigate to `http://localhost:8080/api/v1/zeus-project/list-all-employees`. The application will automatically load a list of employees.
![postman-list-employees.png](src%2Fmain%2Fresources%2Fstatic%2Fimg%2Fpostman-list-employees.png)

Navigate to `http://localhost:8080/api/v1/zeus-project/get-employee-by-id/{employeeId}`. The application will automatically load information about a specific employee. 
![postman-employee-by-id.png](src%2Fmain%2Fresources%2Fstatic%2Fimg%2Fpostman-employee-by-id.png)

## ## Running tests
1. Select the test directory, then click on the package `com.zeus.projectbackend` and execute the unit tests.
![running-test.png](src%2Fmain%2Fresources%2Fstatic%2Fimg%2Frunning-test.png)
2. Display results:
![running-test-complete.png](src%2Fmain%2Fresources%2Fstatic%2Fimg%2Frunning-test-complete.png)
