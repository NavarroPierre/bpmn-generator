package com.navarrop.bpmn.model.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@JacksonXmlRootElement(localName = "userTask")
@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class BpmnUserTask extends BpmnNode {

    public BpmnUserTask(String id, String name) {
        setId(id);
        setName(name);
    }
}
