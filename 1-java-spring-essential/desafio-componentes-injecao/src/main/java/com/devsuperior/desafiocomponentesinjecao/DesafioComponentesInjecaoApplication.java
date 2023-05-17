package com.devsuperior.desafiocomponentesinjecao;

import com.devsuperior.desafiocomponentesinjecao.entities.Order;
import com.devsuperior.desafiocomponentesinjecao.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.Scanner;

@SpringBootApplication
@ComponentScan({"com.devsuperior"})
public class DesafioComponentesInjecaoApplication implements CommandLineRunner {


	@Autowired
	private OrderService orderService;

	@Autowired
	private Order order;

	public static void main(String[] args) {
		SpringApplication.run(DesafioComponentesInjecaoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		order.setCode(scanner.nextInt());
		order.setBasic(scanner.nextDouble());
		order.setDiscount(scanner.nextDouble());

		System.out.println("Pedido código " + order.getCode());
		System.out.println("Valor total: " + orderService.total(order));
	}
}
