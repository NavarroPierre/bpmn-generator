package com.navarrop.bpmn.model.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@JacksonXmlRootElement(localName = "definitions")
@Setter
@Getter
public class BpmnDefinitions {

    @JacksonXmlProperty(isAttribute = true, localName = "id")
    private String id = "id_root";

    @JacksonXmlProperty(isAttribute = true, localName = "targetNamespace")
    private String targetNamespace = "http://flowable.org/bpmn20";

    @JacksonXmlProperty(isAttribute = true, localName = "xmlns")
    private String xmlns = "http://www.omg.org/spec/BPMN/20100524/MODEL";

    @JacksonXmlProperty(isAttribute = true, localName = "xmlns:flowable")
    private String xmlnsFlowable = "http://flowable.org/bpmn";

    @JacksonXmlProperty(isAttribute = true, localName = "xmlns:xsi")
    private String xmlnsXsi = "http://www.w3.org/2001/XMLSchema-instance";

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "process")
    List<BpmnProcess> processes;

}
