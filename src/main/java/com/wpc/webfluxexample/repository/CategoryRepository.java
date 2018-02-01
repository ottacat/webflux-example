package com.wpc.webfluxexample.repository;

import com.wpc.webfluxexample.domain.Category;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CategoryRepository extends ReactiveMongoRepository<Category, String> {
}
