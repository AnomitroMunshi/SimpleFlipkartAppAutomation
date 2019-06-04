# SimpleFlipkartAppAutomation
Framework for flipkart assessment
******************************************************************************************************************************************
Important Points:

1. All test data required is placed in "properties.properties" file which is available in src/main/java/com/callhub/flipkart/resources/
2. User need to provide their own emailId,password and username in properties file.

	email=youremail
	
	pass=yourpassword
	
	Checkname=yourusername
	
3. Path for browser is provided by OsPath.java class inside com.callhub.flipkart.base package.

4. Browser exe driver files are available in com.callhub.flipkart.resources package

5. Extent report is generated inside test-output folder.

6. Log file is generated inside Log folder.


Note:: Trigger the suite by running testng.xml.



***************************Working of Program*******************************

Note :: All tescases are independent of each other.

Overall test scenario:

a) Login to flipkart.com (assume you have a login with flipkart)

b) After login, search for iPhone7 in Electronics section

c) Pick up top 25 products listed in this category and add one of the products to Shopping Cart

d) Now browse to your Cart and take a screenshot of the product that got added to your Cart

e) Remove the product from the Cart and Logout



--TestCases Covered--

Requirements: Login to flipkart.com (assume you have a login with flipkart)

No.of testCase :1

TestCase : LoginPageVerifyLogin 

Descripton: It will login to the flipkart website and will traverse to homepage.

***********************************************************************************************

Requirements:After login, search for iPhone7 in Electronics section

No.of testCase :3

TestCase : verifyHomePageTitileTest

Descripton: It will verify whether the user logged in to homepage or not.


TestCase : verifyHomepageCorrectSignIn

Descripton: It will verify whether the username is correct.


TestCase : searchProductFromHomepage

Descripton: It will search product from homepage and will traverse to SearchPage



***********************************************************************************************

Requirements: Pick up top 25 products listed in this category and add one of the products to Shopping Cart

No.of testCase :3


TestCase : countProductsOnPageinSearchPage

Descripton: It will take datas of first 25 products.


TestCase:clickonProductinSearchPage

Descripton: It will Click on 1st product and will traverse to Productpage.


TestCase:verifyCartAdditionfromProductPage

Descripton: It will Click on addToCart from ProductPage and will traverse to cartpage


***********************************************************************************************

Requirements: Now browse to your Cart and take a screenshot of the product that got added to your Cart

No.of testCase :1


TestCase : ScreenshotCartPage

Descripton: It will take screenshot of the cart.


***********************************************************************************************

Requirements: Remove the product from the Cart and Logout

No.of testCase :2


TestCase : removeFromCart

Descripton: It will remove the 1st product from the cartpage.



TestCase : logoutfromAppinCart

Descripton: It will logout from flipkartApplication and will verify whether loginpage is shown.


****************************************************************************************************************************************



