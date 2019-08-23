package interview;

import com.mysql.cj.exceptions.ExceptionInterceptor;
import interview.controller.CustomerController;
import interview.dto.CustomerDto;
import interview.exception.DbOperationException;
import interview.exception.NotFoundException;
import interview.exception.interceptor.GlobalExceptionHandler;
import interview.service.CustomerService;
import name.falgout.jeffrey.testing.junit.mockito.MockitoExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class CustomerControllerTest {

    @Mock
    private CustomerService userService;

    @InjectMocks
    private CustomerController userController;

    private MockMvc mockMvc;

    private CustomerDto customerDto;

    private final Long fakeId = 155L;
    private final DbOperationException dbOperationException = new DbOperationException("Can't create transaction");
    private final NotFoundException notFoundException = new NotFoundException("Transaction with id: " + fakeId + " not found");

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(userController)
                .setControllerAdvice(GlobalExceptionHandler.class)
                .build();
        customerDto = new CustomerDto();
        customerDto.setId(1L);
        customerDto.setLastName("some");
        customerDto.setPassword("123123");
        customerDto.setCertified(false);
        customerDto.setFirstName("User");
        customerDto.setLastName("Test");
        customerDto.setEmail("example@gmail.com");
    }

    @Test
    void findByEmail_failFlow() throws Exception {
        String fakeEmail = "";
        Mockito.when(userService.findByEmail(fakeEmail))
                .thenThrow(notFoundException);

        mockMvc.perform(get("/customers/?=email=" + fakeEmail)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("url").value("/customers/"))
                .andExpect(jsonPath("message").value(notFoundException.getLocalizedMessage()));
    }

    @Test
    void findByEmail_successFlow() throws Exception {
        Mockito.when(userService.findByEmail(customerDto.getEmail())).thenReturn(customerDto);

        mockMvc.perform(get("/customers/?=email=" + customerDto.getEmail())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").value(customerDto.getId()))
                .andExpect(jsonPath("firstName").value(customerDto.getFirstName()))
                .andExpect(jsonPath("lastName").value(customerDto.getLastName()))
                .andExpect(jsonPath("email").value(customerDto.getEmail()));
    }


}
