package br.com.mpbruder.storage02.service;

import br.com.mpbruder.storage02.model.Book;
import br.com.mpbruder.storage02.repository.BookRepo;
import br.com.mpbruder.storage02.service.interfaces.IBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService implements IBookService {

    private final BookRepo repository;

    @Override
    public Book findById(long id) {
        Optional<Book> optionalBook = repository.findById(id);
        return optionalBook.orElse(null);
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }
}
