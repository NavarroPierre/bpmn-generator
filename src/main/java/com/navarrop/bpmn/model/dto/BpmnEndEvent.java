package com.navarrop.bpmn.model.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@JacksonXmlRootElement(localName = "endEvent")
@Setter
@Getter
@XmlAccessorType(XmlAccessType.FIELD)
public class BpmnEndEvent extends BpmnNode {

    public BpmnEndEvent(String id, String name) {
        setId(id);
        setName(name);
    }
}
