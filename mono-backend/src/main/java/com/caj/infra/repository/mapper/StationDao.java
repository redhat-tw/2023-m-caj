package com.caj.infra.repository.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.caj.infra.repository.po.StationPo;

@Repository
public interface StationDao extends JpaRepository<StationPo, String> {

}