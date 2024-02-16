package br.com.nord.mapper;

import br.com.nord.mapper.request.panel.PanelPostRequest;
import br.com.nord.mapper.request.panel.PanelPutRequest;
import br.com.nord.mapper.response.panel.PanelGetResponse;
import br.com.nord.mapper.response.panel.PanelPostResponse;
import br.com.nord.model.Panel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PanelMapper {

    Panel postToPanel(PanelPostRequest panelPostRequest);

    PanelPostResponse panelToPostResponse(Panel panel);

    PanelGetResponse panelToGetResponse(Panel panel);

    Panel putToPanel(PanelPutRequest panelPutRequest);

    List<PanelGetResponse> panelListToGetResponseList(List<Panel> panelList);

}
