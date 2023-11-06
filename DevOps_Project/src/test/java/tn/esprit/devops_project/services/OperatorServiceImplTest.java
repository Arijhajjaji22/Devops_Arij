package tn.esprit.devops_project.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.devops_project.entities.Operator;
import tn.esprit.devops_project.repositories.OperatorRepository;
import tn.esprit.devops_project.services.Iservices.IOperatorService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OperatorServiceImplTest {

    @Mock
    private OperatorRepository operatorRepository;

    @InjectMocks
    private OperatorServiceImpl operatorService;

    @Test
    public void retrieveAllOperatorsTest() {
        List<Operator> operatorList = new ArrayList<>();
        // Ajoutez des opérateurs fictifs à la liste
        Operator operator1 = new Operator();
        operator1.setIdOperateur(1L);
        operator1.setFname("John");
        operator1.setLname("Doe");

        Operator operator2 = new Operator();
        operator2.setIdOperateur(2L);
        operator2.setFname("Jane");
        operator2.setLname("Smith");

        operatorList.add(operator1);
        operatorList.add(operator2);

        when(operatorRepository.findAll()).thenReturn(operatorList);

        List<Operator> retrievedOperators = operatorService.retrieveAllOperators();
        assertNotNull(retrievedOperators);
        assertEquals(2, retrievedOperators.size());
    }

    @Test
    public void addOperatorTest() {
        Operator newOperator = new Operator();
        newOperator.setFname("Alice");
        newOperator.setLname("Johnson");

        when(operatorRepository.save(any(Operator.class))).thenReturn(newOperator);

        Operator addedOperator = operatorService.addOperator(newOperator);
        assertNotNull(addedOperator);
        assertEquals("Alice", addedOperator.getFname());
        assertEquals("Johnson", addedOperator.getLname());
    }

    @Test
    public void deleteOperatorTest() {
        Long operatorId = 1L;
        operatorService.deleteOperator(operatorId);
        verify(operatorRepository).deleteById(operatorId);
    }

    @Test
    public void updateOperatorTest() {
        Operator existingOperator = new Operator();
        existingOperator.setIdOperateur(1L);
        existingOperator.setFname("Bob");
        existingOperator.setLname("Williams");

        when(operatorRepository.save(any(Operator.class))).thenReturn(existingOperator);

        Operator updatedOperator = operatorService.updateOperator(existingOperator);
        assertNotNull(updatedOperator);
        assertEquals("Bob", updatedOperator.getFname());
        assertEquals("Williams", updatedOperator.getLname());
    }

    // Ajoutez d'autres méthodes de test pour les autres fonctionnalités de votre service
}
