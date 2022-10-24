package br.com.mpbruder.storage02.service.interfaces;

import br.com.mpbruder.storage02.model.Book;

public interface IBookService {
    Book findById(long id);
}