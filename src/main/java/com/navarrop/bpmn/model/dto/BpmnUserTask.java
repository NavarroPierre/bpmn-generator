package com.navarrop.bpmn.model.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

@JacksonXmlRootElement(localName = "userTask")
@Data
public class BpmnUserTask extends BpmnNode {

    public BpmnUserTask(String id, String name) {
        setId(id);
        setName(name);
    }
}
