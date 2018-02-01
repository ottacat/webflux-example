package com.wpc.webfluxexample.repository;

import com.wpc.webfluxexample.domain.Vendor;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface VendorRepository extends ReactiveMongoRepository<Vendor, String> {
}
