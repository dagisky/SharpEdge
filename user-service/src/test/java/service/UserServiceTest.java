package service;

import com.sharpEdge.UserService.dao.CustomerDao;
import com.sharpEdge.UserService.dto.CustomerResponse;
import com.sharpEdge.UserService.model.Customer;
import com.sharpEdge.UserService.service.CustomerService;
import com.sharpEdge.amqp.RabbitMQMessageProducer;
import com.sharpEdge.clients.notification.NotificationClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private  ModelMapper modelMapper;
    @Mock
    private  CustomerDao customerDao;
    @Mock
    private  NotificationClient notificationClient;
    @Mock
    private  RabbitMQMessageProducer rabbitMQMessageProducer;
    @InjectMocks
    private CustomerService customerService;


    @Test
    public void getUserByUsername(){
        Customer customer = Customer.builder().username("foo").
                password("122").email("mail@miu.com").
                firstname("foo").lastname("lolo").build();
        CustomerResponse customerResponse = CustomerResponse.builder().username("foo").
                email("mail@miu.com").build();
        when(modelMapper.map(customer, CustomerResponse.class)).thenReturn(customerResponse);
    }




}
