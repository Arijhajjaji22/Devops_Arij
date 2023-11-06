package tn.esprit.devops_project.services;



import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.devops_project.entities.Invoice;
import tn.esprit.devops_project.repositories.InvoiceRepository;
import tn.esprit.devops_project.repositories.OperatorRepository;
import tn.esprit.devops_project.repositories.SupplierRepository;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
//@Slf4j
//@DataJpaTest
public class InvoiceServiceImplTest {

    @Mock
    private InvoiceRepository invoiceRepository;

    @Mock
    private OperatorRepository operatorRepository;

    @Mock
    private SupplierRepository supplierRepository;

    @InjectMocks
    private InvoiceServiceImpl invoiceService;

    @Test
    public void retrieveAllInvoicesTest() {
        List<Invoice> invoiceList = new ArrayList<>();
        // Add some test invoices to the list

        Mockito.when(invoiceRepository.findAll()).thenReturn(invoiceList);
        List<Invoice> allInvoices = invoiceService.retrieveAllInvoices();
        Assertions.assertTrue(allInvoices.isEmpty());
    }

    @Test
    public void cancelInvoiceTest() {
        Long invoiceId = 1L;
        Invoice invoice = new Invoice(); // Create a test invoice

        Mockito.when(invoiceRepository.findById(invoiceId)).thenReturn(java.util.Optional.of(invoice));

        // Call the cancelInvoice method from your service
        invoiceService.cancelInvoice(invoiceId);

        // Verify that the invoice is archived
        Assertions.assertTrue(invoice.isArchived());
    }

    // Add more test methods for other functionalities of your service
}
