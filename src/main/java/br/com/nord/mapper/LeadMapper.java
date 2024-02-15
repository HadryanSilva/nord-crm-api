package br.com.nord.mapper;

import br.com.nord.mapper.request.lead.LeadPostRequest;
import br.com.nord.mapper.request.lead.LeadPutRequest;
import br.com.nord.mapper.response.lead.LeadCompleteDataResponse;
import br.com.nord.mapper.response.lead.LeadGetResponse;
import br.com.nord.mapper.response.lead.LeadPostResponse;
import br.com.nord.model.Lead;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface LeadMapper {

    Lead postToLead(LeadPostRequest leadPostRequest);

    Lead putToLead(LeadPutRequest leadPutRequest);

    LeadPostResponse leadToPostResponse(Lead lead);

    LeadGetResponse leadToGetResponse(Lead lead);

    List<LeadGetResponse> leadToGetResponseList(List<Lead> leads);

    LeadCompleteDataResponse leadToCompleteDataResponse(Lead lead);

}
