package br.com.mpbruder.storage02.service;

import br.com.mpbruder.storage02.model.Author;
import br.com.mpbruder.storage02.repository.AuthorRepo;
import br.com.mpbruder.storage02.service.interfaces.IAuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorService implements IAuthorService {

    private final AuthorRepo repository;

    @Override
    public Author insert(Author author) {
        return repository.save(author);
    }

    @Override
    public Author findById(long id) {
        Optional<Author> optionalAuthor = repository.findById(id);
        return optionalAuthor.orElse(null);
    }
}
