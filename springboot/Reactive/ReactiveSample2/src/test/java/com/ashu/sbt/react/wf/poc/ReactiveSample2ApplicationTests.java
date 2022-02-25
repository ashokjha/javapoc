package com.ashu.sbt.react.wf.poc;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.ashu.sbt.react.wf.poc.cntl.ProductCntl;
import com.ashu.sbt.react.wf.poc.dto.ProductDto;
import com.ashu.sbt.react.wf.poc.srv.ProductService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

/**
 * @author Ashok Kumar Jha (ashu.kr.jha@gmail.com)
 *
 */
@RunWith(SpringRunner.class)
@WebFluxTest(ProductCntl.class)
class ReactiveSample2ApplicationTests {

    @Autowired
    private WebTestClient webTstCl;

    @MockBean
    private ProductService prdSrv;
    // @Test
    // void contextLoads() {
    // }

    @Test
    public void saveProductTest() {
        Mono<ProductDto> productDto = Mono
                .just(new ProductDto("101", "TestPrd", 10, 2345.67));
        when(prdSrv.saveProduct(productDto)).thenReturn(productDto);

        webTstCl.post().uri("/ashu/products/")
                .body(Mono.just(productDto), ProductDto.class).exchange()
                .expectStatus().isOk();
    }

    @Test
    public void getProducts() {
        Flux<ProductDto> prdDtos = Flux.just(
                new ProductDto("101", "TestPrd", 10, 2345.67),
                new ProductDto("102", "TestPrd102", 110, 12345.67));
        when(prdSrv.getAllProducts()).thenReturn(prdDtos);

        Flux<ProductDto> resPrdDtos = webTstCl.post().uri("/ashu/products/")
                .exchange().expectStatus().isOk().returnResult(ProductDto.class)
                .getResponseBody();

        StepVerifier.create(resPrdDtos)
                .expectNext(new ProductDto("101", "TestPrd", 10, 2345.67))
                .expectNext(new ProductDto("102", "TestPrd102", 110, 12345.67))
                .expectComplete();
    }

    @Test
    public void getProductsById() {
        Mono<ProductDto> prdDtos = Mono
                .just(new ProductDto("102", "TestPrd102", 110, 12345.67));
        when(prdSrv.getProductById("102")).thenReturn(prdDtos);

        Flux<ProductDto> resPrdDto = webTstCl.get().uri("/ashu/products/102")
                .exchange().expectStatus().isOk().returnResult(ProductDto.class)
                .getResponseBody();

        StepVerifier.create(resPrdDto).expectSubscription()
                .expectNextMatches(elm -> elm.getName().equals("TestPrd102"))
                .verifyComplete();
    }

    @Test
    public void updateProducts() {
        Mono<ProductDto> productDto = Mono
                .just(new ProductDto("101", "TestPrd", 10, 2345.67));
        when(prdSrv.updateProduct(productDto, "101")).thenReturn(productDto);

        webTstCl.put().uri("/ashu/products//update/101")
                .body(Mono.just(productDto), ProductDto.class).exchange()
                .expectStatus().isOk();
    }

    @Test
    public void deleteProducts() {
        Mono.just(new ProductDto("101", "TestPrd", 10, 2345.67));
        when(prdSrv.deleteProduct("101")).thenReturn(Mono.empty());

        webTstCl.delete().uri("/ashu/products/delete/101").exchange()
                .expectStatus().isOk();
    }

}
