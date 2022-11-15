package com.krungsri.aycap.payment.controller;

import com.krungsri.aycap.payment.models.request.RequestModel;
import com.krungsri.aycap.payment.models.response.ResponseModel;
import com.krungsri.aycap.payment.services.OnlinePaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class OnlinePaymentController extends BaseController {

  private final OnlinePaymentService onlinePaymentService;

  ResponseModel responseModel = new ResponseModel();

  public OnlinePaymentController(OnlinePaymentService onlinePaymentService) {
    this.onlinePaymentService = onlinePaymentService;
  }

  @GetMapping(value = "/test")
  public ResponseEntity<ResponseModel> onlinePayment(@RequestBody RequestModel obj) {
    log.info("[REQUEST] >> {}", obj);
    try {
      onlinePaymentService.onSavePayment();
      responseModel = onlinePaymentService.onGetPayment();
      return new ResponseEntity<>(responseModel, HttpStatus.OK);

    } catch (Exception e) {
      log.error(extractExceptionDetail(e));
      responseModel.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
      return new ResponseEntity<>(responseModel, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}
