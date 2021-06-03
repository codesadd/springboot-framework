package com.krungsri.aycap.payment.services;

import com.krungsri.aycap.payment.db.entity.TransactionPaymentEntity;
import com.krungsri.aycap.payment.db.repository.TransactionPaymentRepository;
import com.krungsri.aycap.payment.models.ResponseModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OnlinePaymentService {

  @Autowired
  private TransactionPaymentRepository paymentRepository;

  Logger log = LoggerFactory.getLogger(OnlinePaymentService.class);

  public void onSavePayment() {

    TransactionPaymentEntity catPaymentEntity = new TransactionPaymentEntity();

    catPaymentEntity.setPostilionId("JEERAWAT");
    catPaymentEntity.setKriangkrai("SDFsdflsdf");
    paymentRepository.save(catPaymentEntity);
  }

  public ResponseModel onGetPayment() {
    ResponseModel responseModel = new ResponseModel();
    responseModel.setData(paymentRepository.findAll());
    responseModel.setStatus("success");
    return responseModel;
  }
}
