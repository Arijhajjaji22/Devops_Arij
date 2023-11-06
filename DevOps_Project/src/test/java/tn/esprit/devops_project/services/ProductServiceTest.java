package tn.esprit.devops_project.services;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import tn.esprit.devops_project.entities.Product;
import tn.esprit.devops_project.entities.ProductCategory;
import tn.esprit.devops_project.entities.Stock;
import tn.esprit.devops_project.repositories.ProductRepository;
import tn.esprit.devops_project.repositories.StockRepository;
import tn.esprit.devops_project.services.ProductServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

    @InjectMocks
    private ProductServiceImpl productService;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private StockRepository stockRepository;

    @Before
    public void setUp() {
        // Initialisation ou configuration des dépendances si nécessaire
    }

    @Test
    public void testAddProduct() {
        // Créez un produit fictif
        Product product = new Product();
        product.setTitle("Sample Product");
        product.setPrice(10.0F);
        product.setQuantity(100);
        product.setCategory(ProductCategory.ELECTRONICS);

        // Simulez le comportement de stockRepository
        when(stockRepository.findById(any(Long.class))).thenReturn(Optional.of(new Stock()));

        // Simulez le comportement de productRepository pour l'ajout de produit
        when(productRepository.save(any(Product.class))).thenReturn(product);

        // Appelez la méthode d'ajout de produit du service
        Product addedProduct = productService.addProduct(product, 1L);

        // Vérifiez que le produit ajouté est correct
        assertNotNull(addedProduct);
        assertEquals("Sample Product", addedProduct.getTitle());
        assertEquals(10.0, addedProduct.getPrice(), 0.001);
        assertEquals(100, addedProduct.getQuantity());
        assertEquals(ProductCategory.ELECTRONICS, addedProduct.getCategory());

        // Vérifiez que la méthode save du repository a été appelée
        verify(productRepository, Mockito.times(1)).save(any(Product.class));
    }

    @Test
    public void testRetrieveProduct() {
        // Créez un produit fictif
        Product product = new Product();
        product.setIdProduct(1L);
        product.setTitle("Sample Product");
        product.setPrice(10.0F);

        // Simulez le comportement de productRepository pour la récupération de produit
        when(productRepository.findById(1L)).thenReturn(Optional.of(product));

        // Appelez la méthode de récupération de produit du service
        Product retrievedProduct = productService.retrieveProduct(1L);

        // Vérifiez que le produit récupéré est correct
        assertNotNull(retrievedProduct);
        assertEquals(1L, retrievedProduct.getIdProduct().longValue());
        assertEquals("Sample Product", retrievedProduct.getTitle());
        assertEquals(10.0, retrievedProduct.getPrice(), 0.001);
    }

    @Test
    public void testRetreiveAllProduct() {
        // Créez une liste fictive de produits
        List<Product> products = new ArrayList<>();
        products.add(new Product());
        products.add(new Product());

        // Simulez le comportement de productRepository pour la récupération de tous les produits
        when(productRepository.findAll()).thenReturn(products);

        // Appelez la méthode de récupération de tous les produits du service
        List<Product> retrievedProducts = productService.retreiveAllProduct();

        // Vérifiez que la liste de produits récupérée n'est pas vide
        assertNotNull(retrievedProducts);
        // Vérifiez que le nombre de produits récupérés correspond au nombre de produits simulés
        assertEquals(products.size(), retrievedProducts.size());
    }

    // Vous pouvez ajouter d'autres méthodes de test pour couvrir les autres fonctionnalités du service ProductServiceImpl
}
