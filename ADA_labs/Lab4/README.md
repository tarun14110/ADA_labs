# BudgetBuddy   

This application is used to keep track of your Budget. You can dynamically update your Budget and spent amount. It keeps track of records of your money spent. The most cool part is that you can analyse your your spent money in a colorful piechart. 

This application is designed using JavaFx(may also use scenebuilder along) to maintain a household budget. 
The default value of budget should be 0.

The application supports the following functionalities -

  - Enter/Update the budget
  - Enter the expense details- Expense type/Category, Expense Amount, Date spent on
  - Check if an expense is permissible i.e if it has exceeded the allocated budget. Show message
warning indicating ‘budget exceeded’ if so
  - Be able to view all logged expenses in a tabular form
  - Be able to view analysis of all logged expenses in the form of PIE chart

All budget and expense related details are to be maintained in a file called Expenses.txt. So any entry/update of budget amount or addition of expense details/logs is reflected in this text file.

Note that if on an entry the available budget is exceeded, such entry cannot be entered in the file and should prompt a message, ‘budget exceeded’

Population of data should be done from this txt file while viewing the table in the Records tab or
PIE chart in the Analysis tab

### Detailed Description of each tab panes:

##### Enter/Update Budget

Pressing Enter should Check if textfield filled
  - Update the ‘Budget’ in your Expenses.txt file
  - Set a label ‘Entered’ in green as can be seen

##### Add Expense
Moving to Add Expense tab should invoke listener on tabpane to fetch the current
Budget and Available amount from the txt file and update the label as shown above.
Further on entering all fields, click of Submit button should
  - Check if all fields are filled, else prompt to fill
  - Check if amount entered does not exceed available
    - If exceeds, then set a label ‘Budget exceeded’ in orange
    - Else
      - Update Available amount in the txt file and the Available Budget label
      - Add the Expense details in your Expenses.txt file as described in the sample
      - Set a label ‘Added’ in green as can be seen


##### Records
Moving to Records tab should invoke listener on tabpane to
  - Fetch the current Budget and Available amount from the txt file and update the label as shown above. Note that here the second label is of total expense which is budget-available.
  - Read expense logs from the txt file to populate the table rows. Make use of the Expense class in Expense.java provided to implement TableView of type
TableView<Expense>.


##### Analysis
Moving to Analysis tab should invoke listener on tabpane to
  - Read expense logs from the txt file to populate the data for Pie Chart.
  - Note that you would need to fetch the Available amount from the txt file to update data for Unspent category incase the budget is not completely consumed.


