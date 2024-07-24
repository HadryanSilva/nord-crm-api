package br.com.nord.api.mapper;

import br.com.nord.api.mapper.request.customer.CustomerPostRequest;
import br.com.nord.api.mapper.response.customer.CustomerGetResponse;
import br.com.nord.api.mapper.response.customer.CustomerPostResponse;
import br.com.nord.api.model.Customer;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {

    Customer postToCustomer(CustomerPostRequest request);

    CustomerPostResponse customerToPostResponse(Customer customer);

    CustomerGetResponse customerToGetResponse(Customer customer);

}
