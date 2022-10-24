package br.com.mpbruder.tutoriais.service;

import br.com.mpbruder.tutoriais.model.Tutorial;

import java.util.List;

public interface ITutorialService {
    Tutorial insert(Tutorial tutorial);
    List<Tutorial> findAll();
    Tutorial findById(long id);
    Tutorial updateById(Tutorial tutorial, long id);
    void deleteAll();
    void deleteById(long id);
    List<Tutorial> getPublishedTutorials();
    List<Tutorial> getTutorialByTitle(String title);
}
