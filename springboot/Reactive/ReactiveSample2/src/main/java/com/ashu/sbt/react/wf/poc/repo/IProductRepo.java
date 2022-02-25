/**
 * 
 */
package com.ashu.sbt.react.wf.poc.repo;

import org.springframework.data.domain.Range;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.ashu.sbt.react.wf.poc.ent.Product;

import reactor.core.publisher.Flux;

/**
 * @author Ashok Kumar Jha (ashu.kr.jha@gmail.com)
 *
 */
@Repository
public interface IProductRepo extends ReactiveMongoRepository<Product, String> {

    /**
     * @param closed
     * @return
     */
    Flux<Product> findByPriceBetween(Range<Double> closed);

}
