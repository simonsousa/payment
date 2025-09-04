package com.unifor.paymment.factories;

import com.unifor.paymment.exceptions.PaymentException;
import com.unifor.paymment.interfaces.PaymentStrategy;
import com.unifor.paymment.strategies.CreditCardPayment;
import com.unifor.paymment.strategies.PixPayment;

public class PaymentFactory {
    public static PaymentStrategy createPayment(String type, String ... params) throws PaymentException {
        switch (type.toLowerCase()) {
            case "creditcard":
                if (params.length < 4) {
                    throw new PaymentException("Dados do cartão incompleto");
                }
                return new CreditCardPayment(params[0], params[1], params[2], params[3]);

            case "pix":
                if (params.length < 2) {
                    throw new PaymentException("Dados do pix incompletos");
                }
                return new PixPayment(params[0], params[1]);

            default:
                throw new PaymentException("tipo do pagamento inválido");
        }
    }
}
