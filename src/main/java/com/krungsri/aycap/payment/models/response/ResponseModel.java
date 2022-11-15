package com.krungsri.aycap.payment.models.response;

import lombok.Data;

@Data
public class ResponseModel {
  private String amountReceived;
  private String code;
  private String status;
  private Object data;
}
