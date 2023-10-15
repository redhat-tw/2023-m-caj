package com.caj.infra.repository.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.caj.infra.repository.po.PassengerTypePo;

@Repository
public interface PassengerTypeDao extends JpaRepository<PassengerTypePo, String> {

}