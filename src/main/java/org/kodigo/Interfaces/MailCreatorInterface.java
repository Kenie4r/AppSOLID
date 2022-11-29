package org.kodigo.Interfaces;

import org.kodigo.Class.Casa;
import org.kodigo.Class.Invoice;
import org.kodigo.Class.Person;

public interface MailCreatorInterface {
    public boolean makeBodyForMail(Invoice invoice, Casa c);
    public boolean makeRequestForMail(String body, Casa c);



}
