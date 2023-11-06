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

    
}
