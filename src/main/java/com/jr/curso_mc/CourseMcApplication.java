package com.jr.curso_mc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jr.curso_mc.domain.Address;
import com.jr.curso_mc.domain.CardPayment;
import com.jr.curso_mc.domain.Category;
import com.jr.curso_mc.domain.City;
import com.jr.curso_mc.domain.Client;
import com.jr.curso_mc.domain.InvoicePayment;
import com.jr.curso_mc.domain.OrderItem;
import com.jr.curso_mc.domain.Order_;
import com.jr.curso_mc.domain.Payment;
import com.jr.curso_mc.domain.Product;
import com.jr.curso_mc.domain.State;
import com.jr.curso_mc.domain.enums.ClientType;
import com.jr.curso_mc.domain.enums.PaymentStatus;
import com.jr.curso_mc.repositories.AddressRepository;
import com.jr.curso_mc.repositories.CategoryRepository;
import com.jr.curso_mc.repositories.CityRepository;
import com.jr.curso_mc.repositories.ClientRepository;
import com.jr.curso_mc.repositories.OrderItemRepository;
import com.jr.curso_mc.repositories.OrderRepository;
import com.jr.curso_mc.repositories.PaymentRepository;
import com.jr.curso_mc.repositories.ProductRepository;
import com.jr.curso_mc.repositories.StateRepository;

@SpringBootApplication
public class CourseMcApplication implements CommandLineRunner {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private StateRepository stateRepository;
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CourseMcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
				
		Category cat1 = new Category(null, "Informática");
		Category cat2 = new Category(null, "Escritório");
		
		Product p1 = new Product(null, "Computador", 2000.00);
		Product p2 = new Product(null, "Impressora", 800.00);
		Product p3 = new Product(null, "Mouse", 80.00);
		
		cat1.getProducts().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProducts().addAll(Arrays.asList(p2));
		
		p1.getCategories().addAll(Arrays.asList(cat1));
		p2.getCategories().addAll(Arrays.asList(cat1, cat2));
		p3.getCategories().addAll(Arrays.asList(cat1));
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2));
		productRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		State sta1 = new State(null, "Minas Gerais");
		State sta2 = new State(null, "São Paulo");
		
		City c1 = new City(null, "Urbelândia", sta1);
		City c2 = new City(null, "São Paulo", sta2);
		City c3 = new City(null, "Campinas", sta2);
		
		sta1.getCities().addAll(Arrays.asList(c1));
		sta1.getCities().addAll(Arrays.asList(c2, c3));
		
		stateRepository.saveAll(Arrays.asList(sta1, sta2));
		cityRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		Client cl1 = new Client(null, "Maria Silva", "maria@gmail.com", "36378912377", ClientType.PESSOAFISICA);
		
		cl1.getPhones().addAll(Arrays.asList("27363323", "93838393"));
		
		Address ad1 = new Address(null, "Ruas Flores", "300", "Apt 303", "Jardim", "38220834", cl1, c1);
		Address ad2 = new Address(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cl1, c2);
		
		cl1.getAdresses().addAll(Arrays.asList(ad1, ad2));
		
		clientRepository.saveAll(Arrays.asList(cl1));
		addressRepository.saveAll(Arrays.asList(ad1, ad2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		
		Order_ ord1 = new Order_(null, sdf.parse("30/09/2017 10:32"), cl1, ad1);
		Order_ ord2 = new Order_(null, sdf.parse("10/10/2017 19:35"), cl1, ad2);
		
		cl1.getOrders().addAll(Arrays.asList(ord1, ord1));
		
		Payment pay1 = new CardPayment(null, PaymentStatus.QUITADO, ord1, 6);
		ord1.setPayment(pay1);
		
		Payment pay2 = new InvoicePayment(null, PaymentStatus.PENDENTE, ord2, sdf.parse("20/10/2017 00:00"), null);
		ord2.setPayment(pay2);
		
		orderRepository.saveAll(Arrays.asList(ord1, ord2));
		paymentRepository.saveAll(Arrays.asList(pay1, pay2));
		
		OrderItem oi1 = new OrderItem(ord1, p1, 0.00, 1, 2000.00);
		OrderItem oi2 = new OrderItem(ord1, p3, 0.00, 2, 80.00);
		OrderItem oi3 = new OrderItem(ord2, p2, 100.00, 1, 800.00);
		
		ord1.getItems().addAll(Arrays.asList(oi1, oi2));
		ord2.getItems().addAll(Arrays.asList(oi3));
		
		p1.getItems().addAll(Arrays.asList(oi1));
		p2.getItems().addAll(Arrays.asList(oi3));
		p3.getItems().addAll(Arrays.asList(oi2));
		
		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3));
	}

}
