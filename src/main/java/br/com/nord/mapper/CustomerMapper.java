package br.com.nord.mapper;

import br.com.nord.mapper.request.customer.CustomerPostRequest;
import br.com.nord.mapper.request.customer.CustomerPutRequest;
import br.com.nord.mapper.response.customer.CustomerGetResponse;
import br.com.nord.mapper.response.customer.CustomerPostResponse;
import br.com.nord.model.Address;
import br.com.nord.model.Customer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(uses = {Address.class}, componentModel = "spring")
public interface CustomerMapper {

    Customer postToCustomer(CustomerPostRequest request);

    Customer putToCustomer(CustomerPutRequest request);

    CustomerPostResponse customerToPostResponse(Customer customer);

    CustomerGetResponse customerToGetResponse(Customer customer);

    List<CustomerGetResponse> customerToGetResponseList(List<Customer> customers);

}
