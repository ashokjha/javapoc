/**
 * 
 */
package com.ashu.sbt.react.wf.poc;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Ashok Kumar Jha (ashu.kr.jha@gmail.com)
 *
 */
class MonoTest {

    @Test
    void test() {

        assertTrue(Boolean.TRUE);
    }

    @Test
    void testMono() {
        Mono<String> publisher = Mono.just("Ashu");
        publisher.subscribe(System.out::println);

    }

    @Test
    void testMonoWithLog() {
        Mono<String> publisher = Mono.just("Ashu").log();
        publisher.subscribe(System.out::println);

    }

    @Test
    void testMonoWithExp() {
        Mono<?> publisher = Mono.just("Ashu")
                .then(Mono.error(new RuntimeException("onError Event POC")))
                .log();
        publisher.subscribe(System.out::println,
                exp -> System.out.println(exp.getMessage()));

    }

    @Test
    void testManyWithFlux() {
        Flux<String> publisher = Flux
                .just("Ashu", "kr", "jha", "Ashok", "Kumar", "Jha")
                .concatWithValues("sKY", "Is", "LimitInf")
                .concatWith(
                        Flux.error(new RuntimeException("onError Event POC")))
                .concatWithValues("Won't come").log();
        publisher.subscribe(System.out::println,
                exp -> System.out.println(exp.getMessage()));

    }
}
