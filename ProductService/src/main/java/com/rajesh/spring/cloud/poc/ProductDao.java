package com.rajesh.spring.cloud.poc;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ProductDao extends CrudRepository<Product,Long> {

}
