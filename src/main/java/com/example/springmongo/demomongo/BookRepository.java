package com.example.springmongo.demomongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookRepository extends MongoRepository<Book,Integer> {

    public List<Book> findByAuthorName(String name);
}
