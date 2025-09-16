package com.unifor.paymment.context;

import com.unifor.paymment.exceptions.PaymentException;
import com.unifor.paymment.interfaces.PaymentStrategy;

public class PaymentContext {
    private PaymentStrategy paymentStrategy;

    public PaymentContext(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public PaymentContext() {} // público para o Singleton poder instanciar

    public void executePayment(double amount) {
        try {
            paymentStrategy.pay(amount);
        } catch (PaymentException e) {
            System.err.println("Erro ao efetuar pagamento!");
        }
    }

}
