package se.joeldegerman.client;

import java.util.List;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import se.joeldegerman.domain.Customer;

public class RestClient {

	private static final String REST_URI = "http://localhost:8080/javaeelabb/rest/customers/";

	private Client client = ClientBuilder.newClient();

	public Customer getCustomer(int id) {
		try {
			return client.target(REST_URI).path(String.valueOf(id)).request().get(Customer.class);
		} catch (NotFoundException e) {
			return null;
		}
	}

	public List<Customer> getCustomers() {
		return client.target(REST_URI).request().get(new GenericType<List<Customer>>() {
		});
	}

	public Customer addCustomer(Customer customer) {
		Response customerResponse = client.target(REST_URI).request()
				.post(Entity.entity(customer, MediaType.APPLICATION_JSON));
		return customerResponse.readEntity(Customer.class);
	}

	public Customer updateCustomer(Customer customer) {
		try {
			Response put = client.target(REST_URI).path(String.valueOf(customer.getId())).request()
					.put(Entity.entity(customer, MediaType.APPLICATION_JSON));
			return put.readEntity(Customer.class);
		} catch (NotFoundException e) {
			return null;
		}
	}

	public Customer deleteCustomer(int id) {
		Response delete = client.target(REST_URI).path(String.valueOf(id)).request().delete();
		return delete.readEntity(Customer.class);
	}

}
