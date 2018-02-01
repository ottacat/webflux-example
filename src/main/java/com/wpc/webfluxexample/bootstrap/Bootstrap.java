package com.wpc.webfluxexample.bootstrap;

import com.wpc.webfluxexample.domain.Category;
import com.wpc.webfluxexample.domain.Vendor;
import com.wpc.webfluxexample.repository.CategoryRepository;
import com.wpc.webfluxexample.repository.VendorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final VendorRepository vendorRepository;

    public Bootstrap(CategoryRepository packageRepository, VendorRepository vendorRepository) {
        this.categoryRepository = packageRepository;
        this.vendorRepository = vendorRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (categoryRepository.count().block() == 0) {

            System.out.println("### Initializing Categories ###");

            categoryRepository.save(Category.builder().description("Fruits").build()).block();
            categoryRepository.save(Category.builder().description("Nuts").build()).block();
            categoryRepository.save(Category.builder().description("Breads").build()).block();
            categoryRepository.save(Category.builder().description("Meats").build()).block();
            categoryRepository.save(Category.builder().description("Eggs").build()).block();

            System.out.println("Category count: " + categoryRepository.count().block());
        }

        if (vendorRepository.count().block() == 0) {

            System.out.println("### Initializing Vendors ###");

            vendorRepository.save(Vendor.builder().firstName("Joe").lastName("Buck").build()).block();
            vendorRepository.save(Vendor.builder().firstName("Michael").lastName("Weston").build()).block();
            vendorRepository.save(Vendor.builder().firstName("Jessie").lastName("Waters").build()).block();
            vendorRepository.save(Vendor.builder().firstName("Bill").lastName("Nershi").build()).block();
            vendorRepository.save(Vendor.builder().firstName("Jimmy").lastName("Buffet").build()).block();

            System.out.println("Vendor count: " + vendorRepository.count().block());
        }
    }
}
