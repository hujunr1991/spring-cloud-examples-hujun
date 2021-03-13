package com.hujun.sharding.controller;

import com.hujun.sharding.entity.Book;
import com.hujun.sharding.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Macky
 * @Title class BookController
 * @Description: TODO
 * @date 2019/7/12 20:53
 */
@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @RequestMapping(value = "/book", method = RequestMethod.GET)
    public List<Book> getItems(){
        return bookService.getBookList();
    }

    @RequestMapping(value = "/book",method = RequestMethod.POST)
    public Boolean saveItem(@RequestBody Book book){
        return bookService.save(book);
    }
}
