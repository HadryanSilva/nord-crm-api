package br.com.nord.mapper.response.panel;

import br.com.nord.model.Lead;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PanelGetResponse {

    private Long id;
    private String name;
    private List<Lead> users;

}
