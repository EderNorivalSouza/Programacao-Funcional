package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Product;

public class Program {

	public static void main(String[] args) {
		
Scanner sc =new Scanner(System.in);
		
		List<Product> list = new ArrayList<>();
		
		System.out.print("Enter file full path: ");
		String path = sc.nextLine();
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			
			String line = br.readLine();
			
			while(line!=null) {
				String[] fields = line.split(",");
				String nome = fields[0];
				String email = fields[1];
				double salary = Double.parseDouble(fields[2]);
				list.add(new Product(nome,email,salary));
				
				line = br.readLine();
			}
			System.out.print("Enter salary: ");
			double desireSalary = sc.nextDouble();
			System.out.println("Email of people whose salary is more than:"+String.format("%.2f", desireSalary));
			List <String> list1 = list.stream().filter(p->p.getSalary()>=desireSalary).map(p->p.getEmail()).sorted().collect(Collectors.toList());
			list1.forEach(System.out::println);
			
			double sum = list.stream().filter(p->p.getName().charAt(0)=='M').map(p->p.getSalary()).reduce(0.0,(x,y)->x+y);
			
			System.out.println("Sum of salary of people whose name starts with 'M': "+sum);
			
			
		}catch(IOException e) {
		System.out.println(e.getMessage());
		}

	}

}
