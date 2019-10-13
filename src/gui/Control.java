package gui;

import eg.edu.alexu.csd.oop.calculator.cs44.Project;
import eg.edu.alexu.csd.oop.calculator.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Control {
	//Calculator calc;
	
	 
	
	public Calculator calc = new Project();
	
	
	
//	public Control(Calculator calc) {
//		// TODO Auto-generated constructor stub
//		this.calc = calc;
//	}

	@FXML
	TextField text1;
	
	@FXML
	Label label1;
	
	@FXML
	public void write1(ActionEvent event)
	{
		text1.appendText("1");
	}
	
	@FXML
	public void write2(ActionEvent event)
	{
		text1.appendText("2");
	}
	
	@FXML
	public void write3(ActionEvent event)
	{
		text1.appendText("3");
	}
	
	@FXML
	public void write4(ActionEvent event)
	{
		text1.appendText("4");
	}
	
	@FXML
	public void write5(ActionEvent event)
	{
		text1.appendText("5");
	}
	
	@FXML
	public void write6(ActionEvent event)
	{
		text1.appendText("6");
	}
	
	@FXML
	public void write7(ActionEvent event)
	{
		text1.appendText("7");
	}
	
	@FXML
	public void write8(ActionEvent event)
	{
		text1.appendText("8");
	}
	
	@FXML
	public void write9(ActionEvent event)
	{
		text1.appendText("9");
	}
	
	@FXML
	public void write0(ActionEvent event)
	{
		text1.appendText("0");
	}
	
	@FXML
	public void writex(ActionEvent event)
	{
		text1.appendText("*");
	}
	
	@FXML
	public void writeDiv(ActionEvent event)
	{
		text1.appendText("/");
	}
	
	@FXML
	public void writePlus(ActionEvent event)
	{
		text1.appendText("+");
	}
	
	@FXML
	public void writeMinus(ActionEvent event)
	{
		text1.appendText("-");
	}
	
	@FXML
	public void dot(ActionEvent event)
	{
		text1.appendText(".");
	}
	
	@FXML
	public void equal(ActionEvent event)
	{
		try {
			
			//calc.input(text1.getText());
			String answer = calc.getResult();
			if(text1.getText() != calc.current())
			{
				text1.setText(calc.current());
			}
			//System.out.println(answer);
			label1.setText(answer);
			
		} catch (Exception e) {
			// TODO: handle exception
			label1.setText("Wrong input!!");
		}
		
	}
	
	@FXML
	public void add(ActionEvent event)
	{
		try {
			if(text1.getText().length() !=0)
			{
			
			calc.input(text1.getText());
			label1.setText("");
			//text1.setText("");
			//String answer = calc.getResult();
			//System.out.println(answer);
			//label1.setText(answer);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			label1.setText("Wrong input!!");
		}
		
	}
	
	
	@FXML
	public void delete(ActionEvent event)
	{
		try {
			text1.setText(text1.getText().substring(0, text1.getText().length()-1));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@FXML
	public void next(ActionEvent event)
	{
		try {
			String s = calc.next();
			if(s == null)
			{
				label1.setText("No next operation");

			} else {
			text1.setText(s);
			label1.setText("");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	@FXML
	public void prev(ActionEvent event)
	{
		try {
			String s = calc.prev();
			if(s == null)
			{
				label1.setText("No prev operation");

			} else {
			text1.setText(s);
			label1.setText("");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@FXML
	public void save(ActionEvent event)
	{
		calc.save();
	}
	
	@FXML
	public void load(ActionEvent event)
	{
		try {
			
			calc.load();
			if(calc.current() == null)
			{
				label1.setText("No operations");
				//calc.data.remove(0);

			} else {
			text1.setText(calc.current());
			label1.setText("");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			label1.setText("No operations");
		}
	}
	
	

}
