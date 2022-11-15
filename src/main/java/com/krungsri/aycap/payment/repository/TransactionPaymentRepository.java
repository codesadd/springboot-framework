package com.krungsri.aycap.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.krungsri.aycap.payment.models.entity.TransactionPaymentEntity;

@Repository
public interface TransactionPaymentRepository extends JpaRepository<TransactionPaymentEntity, Long> {

}
