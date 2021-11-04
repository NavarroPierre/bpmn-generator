package com.navarrop.bpmn.model.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
@JacksonXmlRootElement(localName = "startEvent")
public class BpmnStartEvent extends BpmnNode {

    public BpmnStartEvent(String id, String name) {
        setId(id);
        setName(name);
    }
}
