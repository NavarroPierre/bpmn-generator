package com.navarrop.bpmn.model.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

@JacksonXmlRootElement(localName = "timeDuration")
public class BpmnTimeDuration {

    @JacksonXmlProperty(isAttribute = true, localName = "xsi:type")
    private String type="tFormalExpression";

    @JacksonXmlProperty(isAttribute = false)
    @JacksonXmlText()
    private String duration;

}
