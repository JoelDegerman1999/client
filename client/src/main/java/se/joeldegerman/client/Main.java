package se.joeldegerman.client;

import java.util.Date;
import java.util.List;

import se.joeldegerman.domain.Address;
import se.joeldegerman.domain.Customer;

/**
 * Hello world!
 *
 */
public class Main {
	public static void main(String[] args) {
		RestClient restClient = new RestClient();

		List<Customer> customers = restClient.getCustomers();
		System.out.println(customers);
		
		System.out.println();

		Customer c = new Customer(0, "Lars", "Degerman", new Address(), new Date());
		Customer newC = restClient.addCustomer(c);

		System.out.println(newC);
		System.out.println();

		Address address = new Address();
		address.setCity("Rosersberg");
		address.setHouseNumber("43A");
		address.setState("Stockholm");
		address.setStreetAddress("Kungsvägen");
		address.setZipCode("19570");
		
		newC.setAddress(address);
		
		restClient.updateCustomer(newC);
		
		List<Customer> customerss = restClient.getCustomers();
		System.out.println(customerss);
		

//        System.out.println();
//        System.out.println();
//        System.out.println();
//        
//        List<Customer> customers = restClient.getCustomers();
//        customers.forEach(System.out::println);
//        
//        System.out.println();
//        
//        Customer customer2 = restClient.getCustomer(1);
//        Address address = new Address();
//        address.setCity("Rosersberg");
//        address.setHouseNumber("43A");
//        address.setState("Stockholm");
//        address.setStreetAddress("Kungsvägen");
//        address.setZipCode("19570");
//        
//        customer2.setAddress(address);
//        
//        restClient.updateCustomer(customer2);
//        
//        List<Customer> customers2 = restClient.getCustomers();
//        customers2.forEach(System.out::println);
	}

}
