package br.com.mpbruder.qa_bugs.controller;

import br.com.mpbruder.qa_bugs.model.TestCase;
import br.com.mpbruder.qa_bugs.service.impl.TestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/testcases")
public class TestCaseController {

    @Autowired
    private TestCaseService service;

    @PostMapping
    public ResponseEntity<TestCase> insert(@RequestBody TestCase testCase) {
        TestCase newTestCase = service.insert(testCase);
        return new ResponseEntity<>(newTestCase, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<TestCase>> getAll() {
        List<TestCase> testCaseList = service.getAll();
        return new ResponseEntity<>(testCaseList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestCase> findById(@PathVariable long id) {
        TestCase testCase = service.findById(id);
        return new ResponseEntity<>(testCase, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<TestCase> update(@RequestBody TestCase testCase) {
        TestCase updatedTestCase = service.update(testCase);
        return new ResponseEntity<>(updatedTestCase, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<TestCase>> getAfterDate(
            @RequestParam(value = "last_update")
            @DateTimeFormat(pattern = "yyyy-MM-dd")
            Date last_update) {
        List<TestCase> testCaseList = service.getAfterDate(last_update);
        return new ResponseEntity<>(testCaseList, HttpStatus.OK);
    }
}
