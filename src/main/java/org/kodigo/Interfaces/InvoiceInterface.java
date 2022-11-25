package org.kodigo.Interfaces;

import org.kodigo.Class.Charge;

public interface InvoiceInterface  {
    public boolean setNewChargeInInvoice(Charge charge);
    @Override
    public String toString();
}
