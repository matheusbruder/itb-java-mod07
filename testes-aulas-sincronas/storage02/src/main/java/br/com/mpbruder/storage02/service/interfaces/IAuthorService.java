package br.com.mpbruder.storage02.service.interfaces;

import br.com.mpbruder.storage02.model.Author;

public interface IAuthorService {

    Author insert (Author author);

    Author findById(long id);

    void delete(long id);

    br.com.mpbruder.storage02.dto.AuthorDTO getById(long id);

    Author getNativeById(long id);

    br.com.mpbruder.storage02.dto.AuthorDTO getDtoEagle(long id);

}
