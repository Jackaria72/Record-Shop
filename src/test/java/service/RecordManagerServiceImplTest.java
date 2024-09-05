package service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import repository.RecordManagerRepository;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class RecordManagerServiceImplTest {

    @Mock
    private RecordManagerRepository recordManagerRepository;

    @InjectMocks
    private RecordManagerServiceImpl recordManagerServiceImpl;

    @Test
    void getAllRecords() {
    }
}