package br.com.nord.api.mapper;

import br.com.nord.api.mapper.request.lead.LeadPostRequest;
import br.com.nord.api.mapper.response.lead.LeadGetResponse;
import br.com.nord.api.mapper.response.lead.LeadPostResponse;
import br.com.nord.api.model.Lead;
import org.mapstruct.Mapper;

@Mapper
public interface LeadMapper {

    Lead postRequestToLead(LeadPostRequest request);

    LeadPostResponse leadToPostResponse(Lead lead);

    LeadGetResponse leadToGetResponse(Lead lead);

}
