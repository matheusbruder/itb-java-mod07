package br.com.mpbruder.storage02.service.interfaces;

import br.com.mpbruder.storage02.model.Author;

public interface IAuthorService {

    Author insert (Author author);

    Author findById(long id);

}
