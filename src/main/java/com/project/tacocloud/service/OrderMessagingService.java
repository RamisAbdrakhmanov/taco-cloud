package com.project.tacocloud.service;


import com.project.tacocloud.model.TacoOrder;

public interface OrderMessagingService {

  void sendOrder(TacoOrder tacoOrder);
  
}
