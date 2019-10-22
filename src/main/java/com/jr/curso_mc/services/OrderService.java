package com.jr.curso_mc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jr.curso_mc.domain.Order_;
import com.jr.curso_mc.repositories.OrderRepository;
import com.jr.curso_mc.services.exceptions.ObjectNotFoundException;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repo;

	public Order_ find(Integer id) {
		Optional<Order_> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Order_.class.getName()));
	}
}
