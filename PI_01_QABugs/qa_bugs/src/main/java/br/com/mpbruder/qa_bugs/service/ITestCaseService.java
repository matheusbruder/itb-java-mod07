package br.com.mpbruder.qa_bugs.service;

import br.com.mpbruder.qa_bugs.model.TestCase;

import java.util.Date;
import java.util.List;

public interface ITestCaseService {

    TestCase insert(TestCase testCase);
    List<TestCase> getAll();
    TestCase findById(long id);
    TestCase update(TestCase testCase);
    void delete(long id);
    List<TestCase> getAfterDate(Date last_update);
}
