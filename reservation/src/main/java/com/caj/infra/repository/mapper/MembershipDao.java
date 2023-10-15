package com.caj.infra.repository.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.caj.infra.repository.po.MembershipPo;

@Repository
public interface MembershipDao extends JpaRepository<MembershipPo, String> {

}
