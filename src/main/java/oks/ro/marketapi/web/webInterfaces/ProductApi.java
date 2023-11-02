package oks.ro.marketapi.web.webInterfaces;

import oks.ro.marketapi.exceptions.CategoryNotFoundException;
import oks.ro.marketapi.exceptions.ProductNotFoundException;
import oks.ro.marketapi.model.Product;
import oks.ro.marketapi.params.ProductParams;
import oks.ro.marketapi.web.webInterfaces.utils.Constants;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
public interface ProductApi {
    String URL = "/product";
    String ID = "/{productId}";

    @GetMapping(Constants.BASE_URL + URL + "/list")
    List<Product> getProducts();

    @GetMapping(Constants.BASE_URL + URL + ID)
    Product getProduct(@PathVariable Long productId) throws ProductNotFoundException;

    @PostMapping(Constants.BASE_URL + URL + "/add")
    Product addProduct(@RequestParam Long categoryId, @RequestBody ProductParams productParams) throws CategoryNotFoundException;

    @PutMapping(Constants.BASE_URL+ URL + ID + "/update")
    Product updateProduct(@PathVariable Long productId,
                          @RequestBody ProductParams productParams) throws ProductNotFoundException;

    @DeleteMapping(Constants.BASE_URL+ URL + ID + "/delete")
    void deleteProduct(@PathVariable Long productId) throws ProductNotFoundException;
}
