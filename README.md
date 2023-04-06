# JuseShopTest

Dependency:
1. May need to use new account.
2. Just Change the Email and Password from the cucumber file 'Login.feature' after create a new user.


Framework Layer:

Singly Driver architecture
|_Parent Driver > where driver is created. if not created any driver then create a new one
   |_Parent Scenario > inherit the driver from parent scenario
   
      |_BasePage      |- basepage, where all common functionalities are written. So, that can commonly use
      |_LoginPage     |__take the drive from parent scenario class if there 
      |_OrderPage     |
      |_SearchPage    |
        
         |_LoginStepDef     |
         |_OrderStepDef     |_here all written all step definition
         |_SearchStepDef    |
         
            |_Login.feature     |
            |_Order.feature     |_these are all feature file
            |_Search.feature    |
   
   
   


