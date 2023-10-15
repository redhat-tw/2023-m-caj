package com.caj.infra.repository.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.caj.infra.repository.po.SchedulePo;

@Repository
public interface ScheduleDao extends JpaRepository<SchedulePo, String> {

}

