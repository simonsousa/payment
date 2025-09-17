package com.unifor.paymment;

import com.unifor.paymment.builder.PaymentByBankSlipBuilder;
import com.unifor.paymment.builder.CreditCardPaymentBuilder;
import com.unifor.paymment.builder.PixPaymentBuilder;
import com.unifor.paymment.context.PaymentContext;
import com.unifor.paymment.exceptions.PaymentException;
import com.unifor.paymment.factories.PaymentFactory;
import com.unifor.paymment.interfaces.PaymentStrategy;
import com.unifor.paymment.singleton.Singleton;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PaymentApplication {
	public static void main(String[] args) {
		SpringApplication.run(PaymentApplication.class, args);
//
//		try {
//			//Pagamento com Cartão de Crédito
//			PaymentStrategy creditCard = PaymentFactory.createPayment(
//					"creditcard",
//					"1234567812345678",
//					"123",
//					"Jully Emerson",
//					"12/26"
//			);
//            PaymentContext context1 = Singleton.getPaymentContext();
//            context1 = new PaymentContext(creditCard); // se quiser, pode definir direto no construtor
//            context1.executePayment(55.17);
//
//			//Pagamento via PIX
//			PaymentStrategy pix = PaymentFactory.createPayment(
//					"pix",
//					"joao.oliveira@gmail.com",
//					"Joao Oliveira"
//			);
//            PaymentContext context2 = Singleton.getPaymentContext();
//            context2 = new PaymentContext(pix);
//            context2.executePayment(150);
//
//            //Pagamento via Boleto
//            PaymentStrategy bankslip = PaymentFactory.createPayment(
//                    "bankslip",
//                    "12345678901234567890123456789012345678901234123456",
//                    "Caixa Econômica Federal",
//                    "Pedro Pereira da Silva",
//                    "123-245-212-09"
//            );
//            PaymentContext context3 = Singleton.getPaymentContext();
//            context3 = new PaymentContext(bankslip);
//            context3.executePayment(85.67);
//
//        } catch (PaymentException e) {
//			System.out.println("Erro: "+e.getMessage());
//		}
//
//	}
		try {
			// Pagamento com Cartão de Crédito usando Builder
			PaymentStrategy creditCard = new CreditCardPaymentBuilder()
					.setCardNumber("1234567812345678")
					.setCvv("123")
					.setName("Jully Emerson")
					.setExpiryDate("12/26")
					.setAmount(55.17)
					.build();

			PaymentContext context1 = Singleton.getPaymentContext();
			context1 = new PaymentContext(creditCard);
			context1.executePayment(55.17);

			// Pagamento via PIX usando Builder
			PaymentStrategy pix = new PixPaymentBuilder()
					.setPixKey("joao.oliveira@gmail.com")
					.setBeneficiary("Joao Oliveira")
					.setAmount(150)
					.build();

			PaymentContext context2 = Singleton.getPaymentContext();
			context2 = new PaymentContext(pix);
			context2.executePayment(150);

			// Pagamento via Boleto usando Builder
			PaymentStrategy bankslip = new PaymentByBankSlipBuilder()
					.setIdBoleto("12345678901234567890123456789012345678901234123456")
					.setBeneficiario("Caixa Econômica Federal")
					.setPagador("Pedro Pereira da Silva")
					.setNumeroDocumento("123-245-212-09")
					.setAmount(85.67)
					.build();

			PaymentContext context3 = Singleton.getPaymentContext();
			context3 = new PaymentContext(bankslip);
			context3.executePayment(85.67);

		} catch (PaymentException e) {
			System.out.println("Erro: " + e.getMessage());
		}

	}
}
