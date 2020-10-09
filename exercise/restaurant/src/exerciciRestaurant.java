import java.util.*;

public class exerciciRestaurant {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		
		String [] menu = new String[5];
		double [] price = new double[5];
		HashMap<String,Double> priceDishMap = new HashMap<>();
		
		for(int i=0; i<5; i++) {
			System.out.println("Add a dish: ");
			menu[i]=sc.next();
			System.out.println("Add a pice: ");
			price[i]=sc.nextInt();
			priceDishMap.put(menu[i], price[i]);
		}
		
		for (int i=0; i<5;i++) {
			System.out.println(menu[i] + " = " + price[i] + " € ");
		}
		
		ArrayList<String> order = new ArrayList<>();
			
		boolean orderP=false;
		
		System.out.println("What do you want to eat?");
		order.add(sc.next());
		
		while(orderP==false) {			
			System.out.println("Do you want to eat something more? (yes/no)");
				String response = sc.next();
				if (response.equals("yes")) {
					System.out.println("What do you want to eat?");
					order.add(sc.next());
					orderP=false;
				}
				else if (response.equals("no")) {
					orderP=true;
				}
		}
		
		ArrayList<String> newMenu = new ArrayList<String>(Arrays.asList(menu));
		
		HashMap<String,Integer> orderMap = new HashMap<>();
		
		for(String i : order) {
			if (!newMenu.contains(i)) {
				System.out.println("\n" + "There was an error processing your order. The product ( " + i + " ) does not exist.");
			}
			else {
				if(orderMap.containsKey(i)) {
					orderMap.put(i, orderMap.get(i) + 1);
				}
				else {
					orderMap.put(i, 1);
				}
			}
		}

		System.out.println("Your order is: " + order + "\n");
		//
		
		ArrayList<Double> bill = new ArrayList<>();
		
		for (Map.Entry<String, Double> entry1 : priceDishMap.entrySet()) {
		      String key = entry1.getKey(); 
                   
		      if(orderMap.containsKey(key)){
		          Double value1 = entry1.getValue();
		          Double value2 = (double)orderMap.get(key);
		          bill.add(value1*value2);
		        System.out.println ("Product: " + key + " Unit: " + value2 + " Total cost: " + (value1 * value2) + " €");            
		      }
		}
		
		double sum = 0;
		
		for(double i : bill) {
			sum += i;
		}
		
		System.out.println("Total..... " + sum + " € .");
	
	}
	
	int fiveEuros;
	int tenEuros;
	int twentyEuros;
	int fiftyEuros;
	int oneHundredEuros;
	int twoHundredEuros;
	int fiveHundredEuros;
	
}