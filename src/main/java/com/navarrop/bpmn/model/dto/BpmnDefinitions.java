package com.navarrop.bpmn.model.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.*;
import java.util.List;

@JacksonXmlRootElement(localName = "definitions")
@XmlRootElement(name = "definitions")
@Setter
@Getter
@XmlAccessorType(XmlAccessType.FIELD)
public class BpmnDefinitions {

    @XmlAttribute(name = "id")
    @JacksonXmlProperty(isAttribute = true, localName = "id")
    private String id = "id_root";

    @XmlAttribute(name = "targetNamespace")
    @JacksonXmlProperty(isAttribute = true, localName = "targetNamespace")
    private String targetNamespace = "http://flowable.org/bpmn20";

    @XmlAttribute(name = "xmlns")
    @JacksonXmlProperty(isAttribute = true, localName = "xmlns")
    private String xmlns = "http://www.omg.org/spec/BPMN/20100524/MODEL";

    @XmlAttribute(name = "xmlns:flowable")
    @JacksonXmlProperty(isAttribute = true, localName = "xmlns:flowable")
    private String xmlnsFlowable = "http://flowable.org/bpmn";

    @XmlAttribute(name = "xmlns:xsi")
    @JacksonXmlProperty(isAttribute = true, localName = "xmlns:xsi")
    private String xmlnsXsi = "http://www.w3.org/2001/XMLSchema-instance";

    @XmlAttribute(name = "xmlns:myDef")
    @JacksonXmlProperty(isAttribute = true, localName = "xmlns:myDef")
    private String xmlnsMyDef = "http://navarrop.com/bpmn";

    @XmlElement(name = "process")
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "process")
    List<BpmnProcess> processes;

}
