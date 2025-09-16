package com.unifor.paymment.singleton;

import com.unifor.paymment.context.PaymentContext;
import com.unifor.paymment.factories.PaymentFactory;

public class Singleton {
    private static PaymentFactory paymentFactoryInstance;
    private static PaymentContext paymentContextInstance;

    private Singleton() {
        // Impede criação externa
    }

    public static PaymentFactory getPaymentFactory() {
        if (paymentFactoryInstance == null) {
            paymentFactoryInstance = new PaymentFactory();
        }
        return paymentFactoryInstance;
    }

    public static PaymentContext getPaymentContext() {
        if (paymentContextInstance == null) {
            paymentContextInstance = new PaymentContext();
        }
        return paymentContextInstance;
    }
}
