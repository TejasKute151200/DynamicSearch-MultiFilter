# DynamicSearch-MultiFilter
Search And Filter


----------------->
 Multi Filter ||	Fri, Jan 20, 2023 at 4 PM
<-----------------

Details:
Create a table employee with following details

Id
Name
Salary
Department_id
Designation_id
Email
Mobile
Branch_id
Address
Pincode

Department, Designation and Branch are 3 other entities that are linked to the Employee table.
Create CRUD for above all entities.

The list API of employees should contain a filter for department, designation and branch. It should also contain a search that will dynamically search the text in name, email, address, mobile and salary. Only one param of search should be used.
Eg. API: www.ab.com?search=”xyz” Here the xyz string should be searched through name, email, address, mobile and salary. The output will list out all the matching records.

Must have:
Proper error handling and validations.
Standards must be followed.
