package tn.esprit.devops_project.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.devops_project.entities.Stock;
import tn.esprit.devops_project.repositories.StockRepository;
import tn.esprit.devops_project.services.Iservices.IStockService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StockServiceImplTest {

    @Mock
    private StockRepository stockRepository;

    @InjectMocks
    private StockServiceImpl stockService;

    @BeforeEach
    public void setUp() {
        // Configure le comportement du mock avant chaque test si nécessaire
    }

    @Test
    public void retrieveStockTest() {
        Long stockId = 1L;
        Stock expectedStock = new Stock();
        expectedStock.setIdStock(stockId);
        expectedStock.setTitle("Sample Stock");

        when(stockRepository.findById(stockId)).thenReturn(Optional.of(expectedStock));

        Stock retrievedStock = stockService.retrieveStock(stockId);

        assertEquals(expectedStock.getIdStock(), retrievedStock.getIdStock());
        assertEquals(expectedStock.getTitle(), retrievedStock.getTitle());
    }
}
