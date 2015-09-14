/* @uthor tarun kumar yadav
 * roll no.= 2014110
 * 
 * 
 */
		
		



package com.iiitd.ap.lab5;




import java.util.Date;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class Expense {

	SimpleStringProperty category;
	SimpleIntegerProperty amount;
	SimpleStringProperty dt;

	public Expense(String category, int amount,String dt )
	{
		this.category=new SimpleStringProperty(category);
		this.amount=new SimpleIntegerProperty(amount);
		this.dt=new SimpleStringProperty(dt);
	}

	public String getCategory()
	{
		return category.get();
	}

	public Integer getAmount()
	{
		return amount.get();
	}

	public String getDt()
	{
		return dt.get();
	}

	public void setCategory(String category)
	{
		this.category.set(category);
	}

	public void setAmount(Integer amount)
	{
		this.amount.set(amount);
	}

	public void setDate(String dt)
	{
		this.dt.set(dt);
	}
}