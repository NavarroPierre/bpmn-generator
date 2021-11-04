package com.navarrop.bpmn.model.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)
@JacksonXmlRootElement(localName = "timeDuration")
public class BpmnTimeDuration {

    @XmlAttribute(name = "xsi:type")
    @JacksonXmlProperty(isAttribute = true, localName = "xsi:type")
    private String type="tFormalExpression";

    @XmlValue
    @JacksonXmlProperty(isAttribute = false)
    @JacksonXmlText()
    private String duration;

}
