/**
 * 
 */
package com.ashu.sbt.react.wf.poc.cntl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ashu.sbt.react.wf.poc.dto.ProductDto;
import com.ashu.sbt.react.wf.poc.srv.ProductService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Ashok Kumar Jha (ashu.kr.jha@gmail.com)
 *
 */

@RestController
@RequestMapping("/ashu/products")
public class ProductCntl {

    @Autowired
    private ProductService pdtSrv;

    @GetMapping
    public Flux<ProductDto> getProducts() {
        return pdtSrv.getAllProducts();
    }

    @GetMapping("/{id}")
    public Mono<ProductDto> getProductById(@PathVariable String id) {
        return pdtSrv.getProductById(id);
    }

    @GetMapping("/price_range")
    public Flux<ProductDto> getProductsBetweenPriceRange(
            @RequestParam("from") double from, @RequestParam("to") double to) {
        return pdtSrv.findProductsInPriceBetween(from, to);
    }

    @PostMapping("/")
    public Mono<ProductDto> saveProducts(
            @RequestBody Mono<ProductDto> product) {
        return pdtSrv.saveProduct(product);
    }

    @PutMapping("/update/{id}")
    public Mono<ProductDto> updateProduct(@RequestBody Mono<ProductDto> product,
            @PathVariable String id) {
        return pdtSrv.updateProduct(product, id);
    }

    @DeleteMapping("/delete/{id}")
    public Mono<Void> deleteProduct(@PathVariable String id) {
        return pdtSrv.deleteProduct(id);
    }

}
