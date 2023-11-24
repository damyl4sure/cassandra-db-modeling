package com.cassandra.springbootcassandra.repository;


import com.cassandra.springbootcassandra.model.Product;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface ProductRepository extends CassandraRepository<Product,Integer> {
}