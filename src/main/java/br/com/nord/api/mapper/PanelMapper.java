package br.com.nord.api.mapper;

import br.com.nord.api.mapper.request.panel.PanelPostRequest;
import br.com.nord.api.mapper.response.panel.PanelGetResponse;
import br.com.nord.api.mapper.response.panel.PanelPostResponse;
import br.com.nord.api.model.Panel;
import org.mapstruct.Mapper;

@Mapper
public interface PanelMapper {

    Panel postToPanel(PanelPostRequest panelPostRequest);

    PanelPostResponse panelToPostResponse(Panel panel);

    PanelGetResponse panelToGetResponse(Panel panel);

}
