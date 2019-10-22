package com.jr.curso_mc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jr.curso_mc.domain.Order_;

@Repository
public interface OrderRepository extends JpaRepository<Order_, Integer> {

}
