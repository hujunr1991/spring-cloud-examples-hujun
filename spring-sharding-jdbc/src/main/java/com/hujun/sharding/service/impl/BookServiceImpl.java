package com.hujun.sharding.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hujun.sharding.mapper.BookMapper;
import com.hujun.sharding.service.BookService;
import org.springframework.stereotype.Service;
import com.hujun.sharding.entity.Book;
import java.util.List;

/**
 * @author Macky
 * @Title class BookServiceImpl
 * @Description: TODO
 * @date 2019/7/12 20:47
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {

    @Override
    public List<Book> getBookList() {
        return baseMapper.selectList(Wrappers.<Book>lambdaQuery());
    }

    @Override
    public boolean save(Book book) {
        return super.save(book);
    }
}
