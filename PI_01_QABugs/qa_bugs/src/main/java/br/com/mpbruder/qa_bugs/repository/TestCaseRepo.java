package br.com.mpbruder.qa_bugs.repository;

import br.com.mpbruder.qa_bugs.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface TestCaseRepo extends JpaRepository<TestCase, Long> {

    @Query("select t from TestCase t where t.last_update >= :last_update")
    List<TestCase> findTestCaseEqualOrGreaterThanLastUpdate(@Param("last_update") Date last_update);

}
