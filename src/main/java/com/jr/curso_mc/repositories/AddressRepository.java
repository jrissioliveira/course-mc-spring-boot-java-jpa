package com.jr.curso_mc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jr.curso_mc.domain.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

}
