package com.unifor.paymment.strategies;

import com.unifor.paymment.exceptions.PaymentException;
import com.unifor.paymment.interfaces.PaymentStrategy;

public class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String cvv;
    private String name;
    private String expiryDate;

    public CreditCardPayment(String cardNumber, String cvv, String name, String expiryDate) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.name = name;
        this.expiryDate = expiryDate;
    }

    @Override
    public void pay(double amount) throws PaymentException {
        if (cardNumber == null || cardNumber.length() != 16) {
            throw new PaymentException("Número de cartão de crédito inválido");
        }

        //implementa sua regra de negocio
        System.out.println("Pagamento de R$"
                + amount + " realizado com " +
                "cartão de crédito: " + cardNumber +
                " em nome de " + name);
    }

    @Override
    public String getPaymentDetails() {
        return "Cartão de credito " + cardNumber + " Nome: " + name;

    }
}
