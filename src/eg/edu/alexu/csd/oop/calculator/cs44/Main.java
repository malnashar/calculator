package eg.edu.alexu.csd.oop.calculator.cs44;

import javax.sound.midi.Soundbank;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Project p = new Project();
		
		p.input("1+2");
		p.input("2+3");
		p.input("3+4");
		System.out.println(p.current());
		System.out.println(p.prev());
		System.out.println(p.next());
		System.out.println(p.next());
		System.out.println(p.prev());
		System.out.println(p.prev());
		System.out.println(p.prev());
		p.save();
		System.out.println(p.next());
		System.out.println(p.current());
		p.load();
		System.out.println(p.current());


		
		
		
		
		
		
		

	}

}
