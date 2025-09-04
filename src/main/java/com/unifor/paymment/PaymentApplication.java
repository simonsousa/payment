package com.unifor.paymment;

import com.unifor.paymment.context.PaymentContext;
import com.unifor.paymment.exceptions.PaymentException;
import com.unifor.paymment.factories.PaymentFactory;
import com.unifor.paymment.interfaces.PaymentStrategy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PaymentApplication {
	public static void main(String[] args) {
		SpringApplication.run(PaymentApplication.class, args);

		try {
			//Pagamento com Cartão de Crédito
			PaymentStrategy creditCard = PaymentFactory.createPayment(
					"creditcard",
					"1234567812345678",
					"123",
					"Jully Emerson",
					"12/26"
			);

			PaymentContext context1 = new PaymentContext(creditCard);
			context1.executePayment(55.17);

			//Pagamento via PIX
			PaymentStrategy pix = PaymentFactory.createPayment(
					"pix",
					"joao.oliveira@gmail.com",
					"Joao Oliveira"
			);

			PaymentContext context2 = new PaymentContext(pix);
			context2.executePayment(150);


		} catch (PaymentException e) {
			System.out.println("Erro: "+e.getMessage());
		}
	}

}
