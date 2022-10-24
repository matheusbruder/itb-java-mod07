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
        author.getAddress().setAuthor(author);
        return repository.save(author);
    }

    @Override
    public Author findById(long id) {
        Optional<Author> optionalAuthor = repository.findById(id);
        return optionalAuthor.orElse(null);
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }

    @Override
    public br.com.mpbruder.storage02.dto.AuthorDTO getById(long id) {
        return repository.getById(id);
    }

    @Override
    public Author getNativeById(long id) {
        return repository.getNativeById(id);
    }

    @Override
    public br.com.mpbruder.storage02.dto.AuthorDTO getDtoEagle(long id) {
        return repository.getDtoEagle(id);
    }
}
