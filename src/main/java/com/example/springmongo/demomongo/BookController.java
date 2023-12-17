package com.example.springmongo.demomongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @GetMapping("/getBooks")
    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    @PostMapping("/insertBook")
    public void insertBook(@RequestBody CreateRequest request){
        Book book = new Book(request.getName(), request.getAuthorName(), request.getCost());
        bookRepository.save(book);
    }

    @GetMapping("/getBookByAuthor")
    public List<Book> getBookByAuthor(@RequestParam("name") String name){
        return bookRepository.findByAuthorName(name);
    }
}
