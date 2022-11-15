package com.krungsri.aycap.payment.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class TransactionPaymentEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "TRANSACTION_ID", unique = true, nullable = false, precision = 22, scale = 0)
  private Long trxId;

  @Column(name = "POSTILION_ID")
  private String postilionId;

  @Column(name = "KRIANGKRAI")
  private String kriangkrai;
}
