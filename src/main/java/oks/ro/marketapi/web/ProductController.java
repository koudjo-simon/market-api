package oks.ro.marketapi.web;

import oks.ro.marketapi.exceptions.CategoryNotFoundException;
import oks.ro.marketapi.exceptions.ProductNotFoundException;
import oks.ro.marketapi.model.Category;
import oks.ro.marketapi.model.Product;
import oks.ro.marketapi.model.model_utils.ProductStatus;
import oks.ro.marketapi.params.ProductParams;
import oks.ro.marketapi.service.serviceInterfaces.ProductServiceInterface;
import oks.ro.marketapi.service.service_utils.VerifyEntity;
import oks.ro.marketapi.web.webInterfaces.ProductApi;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class ProductController implements ProductApi {

    private final ProductServiceInterface productServiceInterface;
    private final VerifyEntity verifyEntity;

    public ProductController(ProductServiceInterface productServiceInterface, VerifyEntity verifyEntity) {
        this.productServiceInterface = productServiceInterface;
        this.verifyEntity = verifyEntity;
    }

    @Override
    public List<Product> getProducts() {
        return productServiceInterface.findProducts();
    }

    @Override
    public Product getProduct(Long productId) throws ProductNotFoundException {
        return productServiceInterface.findProductById(productId);
    }

    @Override
    public Product addProduct(Long categoryId, ProductParams productParams) throws CategoryNotFoundException {
        Product product = new Product();
        Category verifiedCategory = verifyEntity.verifyCategory(categoryId);
        product.setCategory(verifiedCategory);
        product.setName(productParams.getName());
        product.setAddDate(new Date());
        product.setDescription(productParams.getDescription());
        product.setImageUrl(productParams.getImageUrl());
        product.setPrice(productParams.getPrice());
        product.setStockQte(productParams.getStockQte());
        product.setProductStatus(ProductStatus.valueOf(productParams.getProductStatus()));

        return productServiceInterface.addProduct(product);
    }

    @Override
    public Product updateProduct(Long productId, ProductParams productParams) throws ProductNotFoundException {
        Product product = new Product();
        Product verifiedProduct = verifyEntity.verifyProduct(productId);
        product.setProductId(verifiedProduct.getProductId());
        product.setCategory(verifiedProduct.getCategory());
        product.setName(productParams.getName());
        product.setAddDate(new Date());
        product.setDescription(productParams.getDescription());
        product.setImageUrl(productParams.getImageUrl());
        product.setPrice(productParams.getPrice());
        product.setStockQte(productParams.getStockQte());
        product.setProductStatus(ProductStatus.valueOf(productParams.getProductStatus()));
        return productServiceInterface.updateProduct(productId, product);
    }

    @Override
    public void deleteProduct(Long productId) throws ProductNotFoundException {
        productServiceInterface.deleteProduct(productId);
    }
}
