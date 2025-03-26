package com.boleto.apifatura.repository;


import com.boleto.apifatura.model.Fatura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FaturaRepository extends JpaRepository<Fatura, Long> {

}
