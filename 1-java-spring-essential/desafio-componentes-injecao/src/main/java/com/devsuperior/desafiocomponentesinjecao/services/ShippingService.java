package com.devsuperior.desafiocomponentesinjecao.services;

import com.devsuperior.desafiocomponentesinjecao.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {
    public double shipment(Order order) {
        double frete;
        if(order.getBasic() <= 99.99) {
            frete = 20.0;
        } else if (order.getBasic() >= 100.00 && order.getBasic() <= 199.99) {
            frete = 12.0;
        } else {
            frete = 0.0;
        }
        return frete;
    }
}

