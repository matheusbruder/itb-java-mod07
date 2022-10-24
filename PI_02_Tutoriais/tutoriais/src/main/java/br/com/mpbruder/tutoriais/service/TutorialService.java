package br.com.mpbruder.tutoriais.service;

import br.com.mpbruder.tutoriais.model.Tutorial;
import br.com.mpbruder.tutoriais.repository.TutorialRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TutorialService implements ITutorialService {

    private final TutorialRepo repo;

    @Override
    public Tutorial insert(Tutorial tutorial) {
        return repo.save(tutorial);
    }

    @Override
    public List<Tutorial> findAll() {
        return repo.findAll();
    }

    @Override
    public Tutorial findById(long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Tutorial updateById(Tutorial tutorial, long id) {
        Tutorial updatedTutorial = repo.findById(id).orElse(null);
        if (updatedTutorial != null) {
            updatedTutorial = tutorial;
            return repo.save(updatedTutorial);
        }
        return null;
    }

    @Override
    public void deleteAll() {
        repo.deleteAll();
    }

    @Override
    public void deleteById(long id) {
        repo.findById(id).ifPresent(tutorial -> repo.deleteById(id));
    }

    @Override
    public List<Tutorial> getPublishedTutorials() {
        List<Tutorial> publishedTutorials = repo.getPublishedTutorials();
        if (!publishedTutorials.isEmpty()) {
            return publishedTutorials;
        } else {
            return null;
        }
    }

    @Override
    public List<Tutorial> getTutorialByTitle(String title) {
        List<Tutorial> tutorials = repo.getTutorialByTitle(title);
        if (!tutorials.isEmpty()) {
            return tutorials;
        } else {
            return null;
        }
    }


}
