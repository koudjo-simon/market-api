package oks.ro.marketapi.service.serviceInterfaces;

import oks.ro.marketapi.exceptions.ProductNotFoundException;
import oks.ro.marketapi.model.Customer;
import oks.ro.marketapi.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductServiceInterface {
    List<Product> findProducts();
    Product findProductById(Long productId) throws ProductNotFoundException;

    Product addProduct(Product product);
    Product updateProduct(Long productId, Product product) throws ProductNotFoundException;
    void deleteProduct(Long productId) throws ProductNotFoundException;
}
