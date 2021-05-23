# Pantheon_Problem-Statement-1
 purchasing “product”
 
 
 1.Create an automation test script to test end to end checkout flow for purchasing
“product” using Credit Card as payment method. This should be a SUCCESSFUL
payment flow.
2. Write a test with fail flow
3. Implement a reporting framework of your choice to display the test results
4. The above tests should be cross-browser compatible on Chrome and Firefox

Used libraries selenium 3x,TestNG 7.1 

Created two classes files BaseDriver and TestDriver

BaseDriver - Contians initilizing the driver
TestDriver - Contains actual test case, where we add locators and test data in this file itself to fulfill the test case.

BaseDriver and TestDriver classes are in seperate package which used to seperate the diver code and test code. Further we can enhance it by sperating TestDriver test with Hybrid driven approach, which means we can externalize the test data and for locators we can proceed with POM(Page Object Model).
