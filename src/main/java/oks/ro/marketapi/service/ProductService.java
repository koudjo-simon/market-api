package oks.ro.marketapi.service;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import oks.ro.marketapi.exceptions.ProductNotFoundException;
import oks.ro.marketapi.model.Product;
import oks.ro.marketapi.model.model_utils.ProductStatus;
import oks.ro.marketapi.repository.ProductRepository;
import oks.ro.marketapi.service.serviceInterfaces.ProductServiceInterface;
import oks.ro.marketapi.service.service_utils.VerifyEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Transactional
@Slf4j
public class ProductService implements ProductServiceInterface {

    private final ProductRepository productRepository;
    private final VerifyEntity verifyEntity;

    public ProductService(ProductRepository productRepository,
                          VerifyEntity verifyEntity) {
        this.productRepository = productRepository;

        this.verifyEntity = verifyEntity;
    }

    @Override
    public List<Product> findProducts() {
        log.info("Getting all of products");
        return productRepository.findAll();
    }

    @Override
    public Product findProductById(Long productId) throws ProductNotFoundException {
        log.info("Getting Product with id = "+ productId +" getting");
        return verifyEntity.verifyProduct(productId);
    }

    @Override
    public Product addProduct(Product product) {
        log.info("Adding Product");
        Date addDate = new Date();
        product.setAddDate(addDate);
        product.setProductStatus(ProductStatus.CREATED);
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long productId, Product product) throws ProductNotFoundException {
        log.info("Updating Product with id = " + product);
        Product verifiedProduct = verifyEntity.verifyProduct(productId);
        product.setProductId(productId);
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long productId) throws ProductNotFoundException {
        log.info("Deleting Product with id = "+productId);
        verifyEntity.verifyProduct(productId);
        productRepository.deleteById(productId);
    }
}
