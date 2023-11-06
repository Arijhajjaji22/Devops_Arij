package tn.esprit.devops_project.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.devops_project.entities.Supplier;
import tn.esprit.devops_project.repositories.SupplierRepository;
import tn.esprit.devops_project.services.Iservices.ISupplierService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SupplierServiceImplTest {

    @Mock
    private SupplierRepository supplierRepository;

    @InjectMocks
    private SupplierServiceImpl supplierService;

    @BeforeEach
    public void setUp() {
        // Configure le comportement du mock avant chaque test si nécessaire
    }

    @Test
    public void retrieveSupplierTest() {
        Long supplierId = 1L;
        Supplier expectedSupplier = new Supplier();
        expectedSupplier.setIdSupplier(supplierId);
        expectedSupplier.setCode("Sample Code");
        expectedSupplier.setLabel("Sample Label");

        when(supplierRepository.findById(supplierId)).thenReturn(Optional.of(expectedSupplier));

        Supplier retrievedSupplier = supplierService.retrieveSupplier(supplierId);

        assertEquals(expectedSupplier.getIdSupplier(), retrievedSupplier.getIdSupplier());
        assertEquals(expectedSupplier.getCode(), retrievedSupplier.getCode());
        assertEquals(expectedSupplier.getLabel(), retrievedSupplier.getLabel());
    }
}
