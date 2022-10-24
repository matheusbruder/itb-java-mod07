package br.com.mpbruder.storage02.service;

import br.com.mpbruder.storage02.model.Subject;
import br.com.mpbruder.storage02.repository.SubjectRepo;
import br.com.mpbruder.storage02.service.interfaces.ISubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubjectService implements ISubjectService {

    private final SubjectRepo repository;

    @Override
    public Subject findById(long id) {
        return repository.findById(id).orElse(null);
    }
}
