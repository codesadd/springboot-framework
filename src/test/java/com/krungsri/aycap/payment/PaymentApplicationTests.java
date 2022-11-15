package com.krungsri.aycap.payment;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executors;

import com.krungsri.aycap.payment.models.request.RequestModel;
import com.krungsri.aycap.payment.models.response.ResponseModel;
import com.krungsri.aycap.payment.repository.TransactionPaymentRepository;
import com.krungsri.aycap.payment.services.OnlinePaymentService;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.powermock.utils.Asserts;

@ExtendWith(MockitoExtension.class)
class PaymentApplicationTests {

  @Mock
  private TransactionPaymentRepository transactionPaymentRepository;

  @InjectMocks OnlinePaymentService onlinePaymentService;


  @Test @DisplayName("Case 1")
  void Case1() {
    // given
    // when
    ResponseModel responseModel = onlinePaymentService.onGetPayment();
    // assert
    Assertions.assertThat(responseModel.getStatus()).isEqualTo("success");
  }

}
