package br.com.mpbruder.tutoriais.service;

import br.com.mpbruder.tutoriais.exception.InvalidParamException;
import br.com.mpbruder.tutoriais.exception.NotFoundException;
import br.com.mpbruder.tutoriais.model.Status;
import br.com.mpbruder.tutoriais.model.Tutorial;
import br.com.mpbruder.tutoriais.repository.TutorialRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TutorialService implements ITutorialService {

    private final TutorialRepo repo;

    private Tutorial getTutorial(long id) {
        Optional<Tutorial> optionalTutorial = repo.findById(id);
        if (optionalTutorial.isEmpty()) {
            throw new NotFoundException("Id not found");
        }
        return optionalTutorial.get();
    }

    @Override
    public Tutorial insert(Tutorial tutorial) {
        if (tutorial == null) {
            throw new InvalidParamException("Tutorial cannot be null");
        }
        if (tutorial.getId() != null) {
            throw new InvalidParamException("Tutorial cannot have an id");
        }
        tutorial.setStatus(Status.DRAFT);
        return repo.save(tutorial);
    }

    @Override
    public List<Tutorial> findAll() {
        List<Tutorial> tutorials = repo.findAll();
        if (tutorials.isEmpty()) {
            throw new NotFoundException("No tutorial available");
        }
        return tutorials;
    }

    @Override
    public Tutorial findById(long id) {
        return getTutorial(id);
    }

    @Override
    public Tutorial updateById(Tutorial tutorial, long id) {
        if (tutorial == null) {
            throw new InvalidParamException("Tutorial cannot be null");
        }
        if (tutorial.getId() == null) {
            throw new InvalidParamException("Tutorial must have an id");
        }
        return repo.save(tutorial);
    }

    @Override
    public void deleteAll() {
        repo.deleteAll();
    }

    @Override
    public void deleteById(long id) {
        Tutorial tutorial = getTutorial(id);
        repo.deleteById(tutorial.getId());
    }

    @Override
    public List<Tutorial> findByStatusIsPublished() {
        List<Tutorial> publishedTutorials = repo.findByStatusIs(Status.PUBLISHED);
        if (publishedTutorials.isEmpty()) {
            throw new NotFoundException("No published tutorials available");
        }
        return publishedTutorials;
    }

    @Override
    public List<Tutorial> findByTitleContaining(String title) {
        List<Tutorial> tutorials = repo.findByTitleContaining(title);
        if (tutorials.isEmpty()) {
            throw new NotFoundException("No tutorial available with title [%" + title + "%]");
        }
        return tutorials;
    }

}
