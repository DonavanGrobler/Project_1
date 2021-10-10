package za.ac.nwu.as.logic.flow.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

class FetchAccountTypeFlowImplTest {

    private FetchAccountTypeFlowImpl classToTest;

    @BeforeEach
    void setUp() {
        classToTest = new FetchAccountTypeFlowImpl(null);
    }

    @AfterEach
    void tearDown() {
        classToTest = null;
    }

    @Test
    void methodTest() {
        assertTrue(classToTest.methodTest());
    }
}