package org.kodigo.Class;

import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InvoiceTest extends TestCase {

    @Test
    void totalUpdateTest(){
        List<Charge> chargesExample = new ArrayList<>();
        chargesExample.add(new Charge("example", 1.32));
        chargesExample.add(new Charge("example2", 2.32));
        Invoice invoice = new Invoice(new Servicio("example", "", 0.00, new Date()), chargesExample);
        assertEquals(invoice.getTotal(), 3.64);
    }
}