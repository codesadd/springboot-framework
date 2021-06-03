package com.krungsri.aycap.payment.db.repository;

import com.krungsri.aycap.payment.db.entity.TransactionPaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionPaymentRepository extends JpaRepository<TransactionPaymentEntity, Long> {

}
