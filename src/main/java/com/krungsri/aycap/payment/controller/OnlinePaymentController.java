package com.krungsri.aycap.payment.controller;

import com.krungsri.aycap.payment.models.request.RequestModel;
import com.krungsri.aycap.payment.models.response.ResponseModel;
import com.krungsri.aycap.payment.services.OnlinePaymentService;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

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

    Map<String, String> user = new HashMap<>();
    user.put("user_id", "87656");
    user.put("SSN", "786445563");
    user.put("address", "22 Street");
    user.put("city", "Chicago");
    user.put("Country", "U.S.");
    user.put("ip_address", "192.168.1.1");
    user.put("cardNo", "1234567894561234");
    user.put("firstName", "Kriangkrai");
    user.put("lastName", "Prommaithong");
    user.put("email_id", "spring@baeldung.com");
    JSONObject userDetails = new JSONObject(user);

    log.info("User JSON: {}", userDetails);
//    log.info("[REQUEST] >> {}", obj);
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
