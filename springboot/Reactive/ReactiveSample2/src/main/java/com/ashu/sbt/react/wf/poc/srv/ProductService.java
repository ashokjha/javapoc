/**
 * 
 */
package com.ashu.sbt.react.wf.poc.srv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Range;
import org.springframework.stereotype.Service;

import com.ashu.sbt.react.wf.poc.dto.ProductDto;
import com.ashu.sbt.react.wf.poc.repo.IProductRepo;
import com.ashu.sbt.react.wf.poc.utility.ConvertUtil;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Ashok Kumar Jha (ashu.kr.jha@gmail.com)
 *
 */
@Service
public class ProductService {
    @Autowired
    private IProductRepo repo;

    public Flux<ProductDto> getAllProducts() {
        return repo.findAll().map(ConvertUtil::entToDto);
    }

    public Mono<ProductDto> getProductById(String id) {
        return repo.findById(id).map(ConvertUtil::entToDto);
    }

    public Flux<ProductDto> findProductsInPriceBetween(double min, double max) {
        return repo.findByPriceBetween(Range.closed(min, max))
                .map(ConvertUtil::entToDto);
    }

    public Mono<ProductDto> saveProduct(Mono<ProductDto> prodto) {
        return prodto.map(ConvertUtil::dtoToEnt).flatMap(repo::insert)
                .map(ConvertUtil::entToDto);
    }

    public Mono<ProductDto> updateProduct(Mono<ProductDto> prodto, String id) {
        return repo.findById(id)
                .flatMap(p -> prodto.map(ConvertUtil::dtoToEnt)
                        .doOnNext(o -> o.setId(id)))
                .flatMap(repo::save).map(ConvertUtil::entToDto);

    }

    public Mono<Void> deleteProduct(String id) {
        return repo.deleteById(id);

    }

}
