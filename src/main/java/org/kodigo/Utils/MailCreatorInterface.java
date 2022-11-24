package org.kodigo.Utils;

import org.kodigo.Class.Invoice;

public interface MailCreatorInterface {
    public boolean makeBodyForMail(Invoice invoice);
    public boolean makeRequestForMail(String body);

}
