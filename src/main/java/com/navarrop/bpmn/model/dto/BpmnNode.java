package com.navarrop.bpmn.model.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.*;
import java.util.List;

@Setter
@Getter
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class BpmnNode {

    @XmlAttribute(name = "id")
    @JacksonXmlProperty(isAttribute = true, localName = "id")
    private String id;

    @XmlAttribute(name = "name")
    @JacksonXmlProperty(isAttribute = true, localName = "name")
    private String name;

    @XmlElementWrapper(name = "extensionElements")
    @XmlElement(name = "myDef:parameter")
    @JacksonXmlElementWrapper(localName = "extensionElements")
    @JacksonXmlProperty(localName = "myDef:parameter")
    private List<BpmnParameter> parameters;
}


