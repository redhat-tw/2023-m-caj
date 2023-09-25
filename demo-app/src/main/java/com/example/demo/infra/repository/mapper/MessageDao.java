package com.example.demo.infra.repository.mapper;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.infra.repository.po.MessagePo;

public interface MessageDao extends JpaRepository<MessagePo, String> {

}

