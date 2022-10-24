package br.com.mpbruder.qa_bugs.service.impl;

import br.com.mpbruder.qa_bugs.model.TestCase;
import br.com.mpbruder.qa_bugs.repository.TestCaseRepo;
import br.com.mpbruder.qa_bugs.service.ITestCaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TestCaseService implements ITestCaseService {

    private final TestCaseRepo repo;

    @Override
    public TestCase insert(TestCase testCase) {
        return repo.save(testCase);
    }

    @Override
    public List<TestCase> getAll() {
        return repo.findAll();
    }

    @Override
    public TestCase findById(long id) {
        return repo.findById(id).orElseThrow();
    }

    @Override
    public TestCase update(TestCase testCase) {
        return repo.save(testCase);
    }

    @Override
    public void delete(long id) {
        repo.findById(id).orElseThrow();
        repo.deleteById(id);
    }

    @Override
    public List<TestCase> getAfterDate(Date last_update) {
        return repo.findTestCaseEqualOrGreaterThanLastUpdate(last_update);
    }
}
