
/*  tarun kumar yadav
 *  2014110
 * 
 * 
 */

package com.iiitd.ap.lab5;




import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;



import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.Control;
import javafx.scene.control.DatePicker;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


/**
 * Sample application that shows how the sized of controls can be managed.
 * Sample is for demonstration purposes only, most controls are inactive.
 */
public class Main extends Application {
    
	static int Budget ;
	static int Available ;
	static int expen;
	// static Hashtable htable = new Hashtable();  
	static private TableView table = new TableView();
	 
	 static ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
	 final static ObservableList<Expense> data = FXCollections.observableArrayList();
		
    // Define buttons here for access by multiple methods
    private Button btnApply = new Button("Apply");
    private Button btnContinue = new Button("Continue");
    private Button btnExit = new Button("Exit");

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	update();
    	
        Application.launch(Main.class, args);
    }
    
    
    public static void update ()
    {
    	pieChartData.clear();
    	data.clear();
    	//table.clear();
    	//table.
    	table.getColumns().clear();
    	String separator = " ";
        BufferedReader br = null;
    	File f = new File("/home/tarun/workspace/Test1/src/Expenses.txt");
    	try  
    	 {
    		br = new BufferedReader(new FileReader(f));
    	   String line;
    	 int temp=0;
    	   while ((line = br.readLine()) != null) 
    	   {	
    		   if(temp==0)
    		   {String[] c = line.split(separator);
    		  // System.out.println(c[1]);
    		   ++temp;
    		  // Budget=c[1];
    			   Budget=Integer.parseInt(c[1].substring(3));
    		  
    		   }
    		   else if(temp==1)
    		   {String[] c = line.split(separator);
    			  Available=Integer.parseInt(c[1].substring(3));
    		   ++temp;
    		   }
    		   //System.out.println("ooo");
    	      expen=Budget-Available;
    		   if(line.equals(""))
    		   {
    			   temp=3;
    		   }
    		   else if(temp==3)
    		   {	String[] c = line.split(separator);
    		  // String[] d=c[1].split(".");
    		   c[1]=c[1].substring(3);
    		   System.out.println("ll"+c[1]);
    		   System.out.println("ff"+Integer.parseInt(c[1]));
    		  // arr.add(new Expense(c[0],Integer.parseInt(c[1]),c[2]));
    		   
    		   data.add(new Expense(c[0],Integer.parseInt(c[1]),c[2]));
    		   pieChartData.add(new PieChart.Data(c[0],Integer.parseInt(c[1])));
    		   System.out.println("ff"+Integer.parseInt(c[1]));
    		  // htable.put(c[0],c[1]);
    		   }
    		
    	   
    	   	{
    	   
    	  // 	
    	   	}
    	   }
    		//System.out.println("iiiiii"+htable.get("Water"));
   br.close();
    	 }
    	catch(IOException e1)
    	{System.out.println("error");
    		e1.printStackTrace();
    	}

    	
    }
    
    
    
    
    @Override
    public void start(Stage primaryStage) {
        
        // Make Exit button bigger by using larger font for label
        btnExit.setStyle("-fx-font-size: 15pt;");
        
        // Use tab pane with one tab for sizing UI and one tab for alignment UI
        TabPane tabs = new TabPane();
        
        Tab tabBudget = new Tab();
        tabBudget.setText("Enter/update Budget");
        tabBudget.setContent(sizingSample());
        
        Tab tabExpense = new Tab();
        tabExpense.setText("Add Expense");
        tabExpense.setContent(alignmentSample());
        
        Tab tabRecord = new Tab();
        tabRecord.setText("Records");
        tabRecord.setContent(Records());
        
        Tab tabAnalysis = new Tab();
        tabAnalysis.setText("Analysis");
        tabAnalysis.setContent(Analysis());
        
        
        
             tabs.getSelectionModel().selectedItemProperty().addListener(new
        		ChangeListener<Tab>() {public void changed(ObservableValue<? extends Tab> tab, Tab
        		oldTab, Tab newTab) {
        			update();
        		if(newTab==tabAnalysis)
        		{
        			tabAnalysis.setContent(Analysis());
        		}
       		else if(newTab==tabExpense)
        		{
        			tabExpense.setContent(alignmentSample());
        		}
        		else if(newTab==tabRecord)
        		{
        			tabRecord.setContent(Records());
        		}
        		else if(newTab==tabBudget)
        		{
        			tabBudget.setContent(sizingSample());
        		}
        		
        		}
        		});
        
        
        
        tabs.getTabs().addAll(tabBudget, tabExpense,tabRecord,tabAnalysis);
        
        Scene scene = new Scene(tabs, 500, 400); // Manage scene size
        primaryStage.setTitle("Budget");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    
    
    
    
/*
 * Creates the UI for the sizing sample, which demonstrates ways to manage
 * the size of controls when you don't want the default sizes.
 */
    private Pane sizingSample() {
        
       
        //VBox vbox = new VBox();
    	   GridPane grid = new GridPane();
      
		  Text scenetitle2 = new Text("Total Budget(in Rupees)");
	//VBox.setMargin(scenetitle2, new Insets(50, 0, 0, 100));
		//vbox.getChildren().add(scenetitle2);
		grid.add(scenetitle2, 1, 1);
		  
		 final TextField value = new TextField();
		 	value.setText("0");
		    Button submit = new Button("Enter");
		    final Text actiontarget = new Text();
		    grid.add(actiontarget, 7, 1);
		   
		  
		
		    //vbox.getChildren().addAll(value, submit);
		  grid.add(value, 3, 1);
		    grid.add(submit, 5, 1);
		    grid.setHgap(5);
		    grid.setVgap(70);
		    grid.setPadding(new Insets(10, 0, 0, 10));
		   		    
		    submit.setOnAction(new EventHandler<ActionEvent>() {
	        	 
	            @Override
	            public void handle(ActionEvent e) {
	                actiontarget.setFill(Color.CHARTREUSE);
	            //            Text1.setText("Budget :"+value.getText());
	            	
	               // Text3.setFill(Color.CHARTREUSE);
	                //Text3.setText("Added");
	                actiontarget.setText("Entered!");
	                
	                String separator = " ";
	                BufferedReader br = null;
	                BufferedWriter bw =null;
	            	File f = new File("/home/tarun/workspace/Test1/src/Expenses.txt");
	            	File f1 = new File("/home/tarun/workspace/Test1/src/temp.txt");
	            	
	            	
	            	try  
	            	 {
	            		
	            		br = new BufferedReader(new FileReader(f));
	            	  
	            	
	                     bw = new BufferedWriter(new FileWriter(f1));
	        
	            		String line;
	            	// int temp=0;
	            	   while ((line = br.readLine()) != null) 
	            	   {
	            		   
	            		   System.out.println(line);
	            	   	String[] c = line.split(separator);
	            	  
	            	   	
	            	   		if(c[0].equals("Budget" ))
	            		   	{  
	            	   			line="Budget Rs."+value.getText();
	            	   			Budget=Integer.parseInt(value.getText());
	            	   	 		line=line+"\n";
		            	   		bw.write(line);

	            		   	}
	            	   		
	            	   		else if(c[0].equals("Available" ))
	            		   	{  Available=Budget;
	            		   	
	            	   			line="Available Rs."+Budget;
	            	   			
	            	   	 		line=line+"\n\n";
		            	   		bw.write(line);
		            	   			
	            		   	}
	            	   		//Available=Integer.parseInt(value.getText());
	            	   		expen=0;
	            	   		
	            	  	          
	            	   } 
	            	   br.close();
	            	   bw.close();
	            	 }
	            	catch(IOException e1)
	            	{System.out.println("error");
	            		e1.printStackTrace();
	            	}
	            	
	            	
	            finally
	            	       {
	            	       	if(br != null)
	            	       	{
	            	       		try
	            	       		{
	            	       			br.close();
	            	       	    }
	            	       		catch(IOException e1)
	            	       		{
	            	       			e1.printStackTrace();
	            	       		}
	            	       	}
	            	       }
	            f.delete();
	            f1.renameTo(f);
	           
	            }
	                            
	        });
		    
		    
		    
		    
		
		

        return grid;
    }
  
    
    
    
    
    
/*
 * Creates the UI for the alignment sample, which demonstrates ways to manage
 * the alignment of controls when you don't want the default alignment.
 */
    private Pane alignmentSample() {
       // Global Text1;
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
       // grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10, 10, 10, 10));

        
        Text Text1 = new Text();
        Text Text2 = new Text();
        Text Text3 = new Text();
       
        
        Text1.setText("Total Budget : Rs."+Budget);
       
        Text2.setText("Available :Rs."+Available);
      //  Text1.textProperty().bind((ObservableValue<? extends String>) htable.get("Budget"));
        
        
      //  grid.setAlignment(Pos.TOP_CENTER);  // Override default
       grid.add(Text1, 0, 0);
       grid.add(Text2, 10, 0);
      // grid.add((Node) htable.get("Budget"), 0,0);
       
       Label date = new Label("Date:");
       date.setPrefWidth(100);
       grid.add(date, 0, 3);
       
       DatePicker datefield = new DatePicker();
       grid.add(datefield, 10, 3);
        
       Label category = new Label("Category:");
       category.setPrefWidth(100);
       grid.add(category, 0, 4);

       TextField categoryfield = new TextField();
       grid.add(categoryfield, 10, 4);
       

       Label amount = new Label("Amount(in Rupees):");
       grid.add(amount, 0, 5);
       amount.setPrefWidth(250);
       
       TextField amountfield = new TextField();
       grid.add(amountfield, 10, 5);
       
       Button submit = new Button("Submit"); 
       submit.setPrefWidth(200);
       grid.add(submit, 10, 7);

       grid.add(Text3, 5, 8);
       
       
       
       
       submit.setOnAction(new EventHandler<ActionEvent>() {
      	 
           @Override
           public void handle(ActionEvent e) {
               Text3.setFill(Color.CHARTREUSE);
               Text3.setText("Added");
               Text2.setText("Available :Rs."+(Available-Integer.parseInt(amountfield.getText())));
               
               try{
            	   
            	   BufferedWriter out = new BufferedWriter(new FileWriter
            		         ("/home/tarun/workspace/Test1/src/Expenses.txt",true));
            		         out.write(categoryfield.getText()+" Rs."+amountfield.getText()+" "+datefield.getValue());
            		         out.close();
            		         expen=expen+Integer.parseInt(amountfield.getText());
            		         Available=Available-Integer.parseInt(amountfield.getText());
            		         //System.out.println("iii"+Available);
            		         
            		    
               }
               catch(Exception e1)
               {
            	   
               }
          
               
               
           	String separator = " ";
            BufferedReader br = null;
            BufferedWriter bw =null;
        	File f = new File("/home/tarun/workspace/Test1/src/Expenses.txt");
        	File f1 = new File("/home/tarun/workspace/Test1/src/temp.txt");

        	try  
        	 {
        		
        		br = new BufferedReader(new FileReader(f));
        	  
        	
                 bw = new BufferedWriter(new FileWriter(f1));
    
        		String line;
           	   while ((line = br.readLine()) != null) 
        	   {
        		   
        	   	String[] c = line.split(separator);
        	  
        	   		if(c[0].equals("Available" ))
        		   	{  //Available=Available+Integer.parseInt(value.getText())-Budget;
        		   	
        	   			line="Available Rs."+Available;
        	   		
        		   	}
        	   		
        	   		
        	   		line=line+"\n";
        	   		bw.write(line);
      
        	   } 
        	 //  br.close();
        	   bw.close();
        	 }
        	catch(IOException e1)
        	{System.out.println("error");
        		e1.printStackTrace();
        	}
        	
        	
        finally
        	       {
        	       	if(br != null)
        	       	{
        	       		try
        	       		{
        	       			br.close();
        	       	    }
        	       		catch(IOException e1)
        	       		{
        	       			e1.printStackTrace();
        	       		}
        	       	}
        	       }
        f.delete();
        f1.renameTo(f);
               
               
               
               
               
               
               
           	
           }
                           
       });
       
       
       
       
        
     

        return grid;
    }
 
    
    
    
    private Pane Records() {
    
    	  final Label label = new Label("Address Book");
          label.setFont(new Font("Arial", 20));
          
         // table.setEditable(true);
          Text Text1 = new Text();
          Text Text2 = new Text();
         
         
          
          Text1.setText("Total Budget : Rs."+Budget);
         
          Text2.setText("Total Expenses :Rs."+expen);
          
   
          TableColumn category = new TableColumn("category");
          category.setMinWidth(165);
          TableColumn amount = new TableColumn("amount");
          amount.setMinWidth(165);
          TableColumn dt = new TableColumn("dt");
          dt.setMinWidth(167);
          
          
          
          	category.setCellValueFactory(new PropertyValueFactory<>("category") );
          	amount.setCellValueFactory( new PropertyValueFactory<>("amount")	);
          	dt.setCellValueFactory( new PropertyValueFactory<>("dt"));
          
          
          	table.setItems(data);
              
          	
          	
          
          table.getColumns().addAll(category, amount, dt);
   
          final VBox vbox = new VBox();
          vbox.setSpacing(5);
         // vbox.setPadding(new Insets(10, 0, 0, 10));
          vbox.getChildren().addAll(Text1,Text2,label, table);
    
    return vbox;
}
    

    
    
    
    
    private Pane Analysis() {
    	
   
    
    pieChartData.add(new PieChart.Data("Unused",Available));
    
    final PieChart chart = new PieChart(pieChartData);
    chart.setTitle("Expense Analysis");
    final VBox vbox = new VBox();
    vbox.setSpacing(5);
   // vbox.setPadding(new Insets(10, 0, 0, 10));
    vbox.getChildren().addAll( chart);
    
    return vbox;
    }
    
   
}






