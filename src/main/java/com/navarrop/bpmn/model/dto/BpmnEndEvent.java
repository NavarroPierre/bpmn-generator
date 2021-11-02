package com.navarrop.bpmn.model.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.Setter;

@JacksonXmlRootElement(localName = "endEvent")
@Setter
@Getter
public class BpmnEndEvent extends BpmnNode {

    public BpmnEndEvent(String id, String name) {
        setId(id);
        setName(name);
    }
}
