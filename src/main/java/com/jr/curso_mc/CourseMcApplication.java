package com.jr.curso_mc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jr.curso_mc.domain.Address;
import com.jr.curso_mc.domain.Category;
import com.jr.curso_mc.domain.City;
import com.jr.curso_mc.domain.Client;
import com.jr.curso_mc.domain.Product;
import com.jr.curso_mc.domain.State;
import com.jr.curso_mc.domain.enums.ClientType;
import com.jr.curso_mc.repositories.AddressRepository;
import com.jr.curso_mc.repositories.CategoryRepository;
import com.jr.curso_mc.repositories.CityRepository;
import com.jr.curso_mc.repositories.ClientRepository;
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
		
	}

}
