package eg.edu.alexu.csd.oop.calculator.cs44;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import eg.edu.alexu.csd.oop.calculator.Calculator;


public class Project implements Calculator {
	
	public  ArrayList<String> data = new ArrayList<>();
	public int current = -1;

	@Override
	public void input(String s) {
		// TODO Auto-generated method stub
		data.add(s);
		current = data.size()-1;
		if(data.size() == 6)
		{
			data.remove(0);
			current--;
		}
		
	}

	@Override
	public String getResult() {
		// TODO Auto-generated method stub
		String currentString = data.get(current);
		int index = 0;
		String num1 = "";
		String num2 = "";
		char sign = ' '; 
		if(currentString.charAt(0) != '-')
		{ 
			for(int i = 0;i<currentString.length();i++)
			{
				if(Character.isDigit(currentString.charAt(i)) || currentString.charAt(i) == '.')
				{
					num1 += currentString.charAt(i);
				} else 
				{
					sign = currentString.charAt(i);
					index = i;
					break;
				}
			}
			num2 = currentString.substring(index+1);
		} else {
			num1 += "-";
			for(int i = 1;i<currentString.length();i++)
			{
				if(Character.isDigit(currentString.charAt(i)) || currentString.charAt(i) == '.')
				{
					num1 += currentString.charAt(i);
				} else 
				{
					sign = currentString.charAt(i);
					index = i;
					break;
				}
			}
			num2 = currentString.substring(index+1);
		}
		
		double number1;
		double number2;
		double answer;
		String sol;
		if(sign == '*')
		{
			answer = Double.parseDouble(num1)* Double.parseDouble(num2);
		    sol = String.valueOf(answer);
			return sol;
		} else if(sign == '/')
		{
			answer = Double.parseDouble(num1)/ Double.parseDouble(num2);
		    sol = String.valueOf(answer);
			return sol;
		} else if(sign == '+')
		{
			answer = Double.parseDouble(num1)+ Double.parseDouble(num2);
		    sol = String.valueOf(answer);
			return sol;
		} else if(sign == '-')
		{
			answer = Double.parseDouble(num1)- Double.parseDouble(num2);
		    sol = String.valueOf(answer);
			return sol;
		}
		
		return null;
	}

	@Override
	public String current() {
		// TODO Auto-generated method stub
		if(data.size()>0 && current != -1)
		{
			return data.get(current);
		}
		else {
			return null;
		}
	}

	@Override
	public String prev() {
		// TODO Auto-generated method stub
		if(current > 0 )
		{
			current--;
			return data.get(current);
		} else {
			return null;
		}
	}

	@Override
	public String next() {
		// TODO Auto-generated method stub
		if(current < (data.size()-1))
		{
			current++;
			return data.get(current);
		} else {
		return null;
		}
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub
		try {
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("operations.txt")));
			for(int i = 0;i < data.size();i++)
			{
				if(i == data.size()-1)
				{
					bufferedWriter.append(data.get(i));
				} else {
					bufferedWriter.append(data.get(i)+"&");
				}
			}
			bufferedWriter.newLine();
			bufferedWriter.append(String.valueOf(current));
			bufferedWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void load() {
		// TODO Auto-generated method stub
		String operations = "";
		//int c = -1;
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("operations.txt")));
			for(int i = 0;i < 2;i++)
			{
				if(i == 0)
				{
					operations = bufferedReader.readLine();
				} else {
					current =Integer.parseInt(bufferedReader.readLine());
				}
			}
			
			String[] temp = operations.split("&");
			
			data = new ArrayList<>();
			for(int i = 0;i<temp.length;i++)
			{
				data.add(temp[i]);
			}
			
			if(current == -1 && data.size() == 1)
			{
				data.remove(0);
			}
			//current = c;
			bufferedReader.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
