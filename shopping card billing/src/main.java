import java.util.Scanner;
import java.util.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				Scanner input = new Scanner(System.in);
				System.out.println("Give the number of items: ");
				int n; 
				n = input.nextInt(); //number of items in the list
				
				int total;
				
				int m = n + 1;
				String[][] str1 = new String[m][1];  //n ->number of items in the list, m=1 -> 1 item	specifically	
				
				System.out.println("\n");
				
				System.out.println("Input  ");
				for(int i=0; i<m; i++) {
					str1[i][0]= input.nextLine();
					
				}
				
				System.out.println("\n");
				
				System.out.println(" Output ");
				
				System.out.println("\t\t" + "   Quantity " + "\t" + "UnitPrice" + "\t" + "Discount " + "\t" + "Final Price");
				shoppingItems(str1, m);
				
				
				
	}		
				
				

	
	
	
	
	
	static double billingGroceryItems(String[][] str, int n) { 
		String str1 = new String(); //has the quantity
		String str3 = new String(); //has the Unit price
		String str4 = new String();
		str4 = str[n][0];
			
			str1 = str4.replaceAll(" .*", "");//replaceAll method -> Replace everything after the space including the space
			str3 = str4.split(" ", 5)[4]; //splits strings by spaces, into more than 5 chunks. the last chunk with index 4 will contain everything after fourth space
			

			
			int quantity= Integer.parseInt(str1); 
		    float price = Float.parseFloat(str3);
			double finalPrice =(float)Math.round(( quantity*price-(7.5/100 * (quantity*price))) * 100.0)/100.0;
		   
			
			return finalPrice;
		}
	
	
	static double billingBook(String[][] str, int n) {
		String str1 = new String(); //has the quantity
		String str3 = new String(); //has the Unit price
		String str4 = new String();
		str4 = str[n][0];
		
		str1 = str4.replaceAll(" .*", "");//replaceAll method -> Replace everything after the space including the space
		str3 = str4.split(" ", 4)[3]; //splits strings by spaces, into more than 5 chunks. the last chunk with index 4 will contain everything after fourth space
		
		
		int quantity1= Integer.parseInt(str1); 
	    float price1 = Float.parseFloat(str3);
		double finalPrice2 =(float)Math.round(( quantity1*price1-(12.0/100 * (quantity1*price1)))*100.0)/100.0;
		
		
		return finalPrice2;
	}
	
	
	static double billingOther(String[][] str, int n) {
		String str1 = new String(); //has the quantity
		String str3 = new String(); //has the Unit price
		String str4 = new String();
		str4 = str[n][0];
		
		str1 = str4.replaceAll(" .*", "");//replaceAll method -> Replace everything after the space including the space
		str3 = str4.split(" ", 4)[3]; //splits strings by spaces, into more than 5 chunks. the last chunk with index 4 will contain everything after fourth space
		
		
		int quantity1= Integer.parseInt(str1); 
	    float price1 = Float.parseFloat(str3);
		double finalPrice3 = (float) Math.round((quantity1*price1)*100.0)/100.0;
	    
		
		return finalPrice3;
	}
	
	
	
	static void shoppingItems(String[][] str, int m) {
		
		String str1 = new String(); //has the quantity
		String str2 = new String(); //has the name of the product 
		String str3 = new String(); //has the Unit price
		String str4 = new String();
		String[] parts = new String[4];
		
		float quantity; 
	    float price;
	    String discount1 = "7.5%";
	    String discount2 = "12%";
	    String discount3 = "0%";
	    
		double[] total1= new double[m];
		double[] totDiscount= new double[m];
		
		for(int i=0; i<m; i++){ 
			str4 = str[i][0];
			
			if(str[i][0].contains("Pasta")  || str[i][0].contains("Coffe")){
				
				str1 = str4.replaceAll(" .*", "");//replaceAll method -> Replace everything after the space including the space
				str2 = str4.substring(str4.indexOf(" "), str4.indexOf("at"));
				str3 = str4.split(" ", 5)[4]; //splits strings by spaces, into more than 5 chunks. the last chunk with index 4 will contain everything after fourth space
				
				quantity= Integer.parseInt(str1); 
			    price = Float.parseFloat(str3);
					
				
				System.out.println(str2 + "        " + str1 + " \t\t" + str3 + " \t\t" + discount1 + " \t\t" + billingGroceryItems(str, i));
				
				total1[i]= billingGroceryItems(str,i);
				totDiscount[i] = (7.5/100) *quantity* price;
				
			}else if((str[i][0].contains("Wine")  || str[i][0].contains("Cake") || str[i][0].contains("Apple") || str[i][0].contains("Chocolate"))){
				
				str1 = str4.replaceAll(" .*", "");//replaceAll method -> Replace everything after the space including the space
				parts = str4.split(" ");
				str2= parts[1];
				str3 = str4.split(" ", 4)[3]; //splits strings by spaces, into more than 4 chunks. the last chunk with index 3 will contain everything after fourth space
				
				quantity= Integer.parseInt(str1); 
			    price = Float.parseFloat(str3);
			    
				
				System.out.println(" " + str2 + "    \t" + str1 + "   \t\t" + str3 + "  \t\t" + discount3 + " \t\t" + billingOther(str, i));
				
				total1[i]= billingOther(str,i);
				totDiscount[i] = 0;
				
			}else if((str[i][0].contains("Book"))){
				
				str1 = str4.replaceAll(" .*", "");//replaceAll method -> Replace everything after the space including the space
				str2 = str4.substring(str4.indexOf(" "), str4.indexOf("at"));
				str3 = str4.split(" ", 4)[3]; //splits strings by spaces, into more than 5 chunks. the last chunk with index 4 will contain everything after fourth space
				
				quantity= Integer.parseInt(str1); 
			    price = Float.parseFloat(str3);
				
				
				
				System.out.println(str2 + "             " + str1+ "   \t\t" + str3 + "  \t\t" + discount2 + " \t\t" + billingBook(str, i));
				
				total1[i]= billingBook(str,i);
				totDiscount[i] = (12.0/100) *quantity* price;
				
			}
		}
		
		
		
		double sum=0;
		double sumTotDiscount = 0;
		
		for(int i=0; i< total1.length; i++) {
			sum= sum + total1[i];
		}
		
		for(int i=0; i< totDiscount.length; i++) {
			sumTotDiscount= sumTotDiscount + totDiscount[i];
		}
		
		
		sumTotDiscount = Math.round(sumTotDiscount*100.0)/100.0;
		
		if(sum>40.0) {
			System.out.println(" Gross Total     \t\t\t\t\t\t" + sum);
			System.out.println(" Volume Discount     \t\t\t" + "\t5% \t\t" + Math.round(((5.0/100)*sum)*100.0)/100.0);
			System.out.println(" Total   \t\t\t\t\t\t\t" + Math.round((sum-((5.0/100)*sum))*100.0)/100.0);
			System.out.println("\n");
			System.out.println("(Total discounts " + sumTotDiscount + " )");
		}else {
			System.out.println(" Total     \t\t\t\t\t\t\t" + Math.round(sum * 100.0)/100.0);
			System.out.println("\n");
			System.out.println("(Total discounts " + sumTotDiscount + ")");
		}
		
	}
		
			
		
	}
	
	
	

