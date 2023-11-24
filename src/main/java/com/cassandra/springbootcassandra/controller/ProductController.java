package com.cassandra.springbootcassandra.controller;


import com.cassandra.springbootcassandra.ResourceNotFoundException;
import com.cassandra.springbootcassandra.model.Product;
import com.cassandra.springbootcassandra.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    private static final Logger log = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    ProductRepository productRepository;

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product){
        productRepository.save(product);
        log.info("POST status 200 OK: POST to DB successful");
        return product;

    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> findById(@PathVariable("id") Integer productId){
        Product product=productRepository.findById(productId).orElseThrow(
                () -> new ResourceNotFoundException("Product not found" + productId));
        log.info("GET status 200 OK: GET {id} from DB successful");
        return ResponseEntity.ok().body(product);
    }


    @GetMapping("/products")
    public List<Product> getProducts(){
        log.info("GET status 200 OK: GET list of products from DB successful");
        return productRepository.findAll();
    }

    @PutMapping("products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable(value = "id") Integer productId,
                                                 @RequestBody Product productDetails) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + productId));
        product.setName(productDetails.getName());
        final Product updatedProduct = productRepository.save(product);
        log.info("PUT status 200 OK: PUT {id} into DB successful");
        return ResponseEntity.ok(updatedProduct);

    }

    @DeleteMapping("products/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable(value = "id") Integer productId) {
        Product product = productRepository.findById(productId).orElseThrow(
                () -> new ResourceNotFoundException("Product not found::: " + productId));
        productRepository.delete(product);
        log.info("DELETE status 200 OK: delete {id} into DB successful");
        return ResponseEntity.ok().build();
    }

}

