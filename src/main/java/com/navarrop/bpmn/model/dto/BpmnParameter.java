package com.navarrop.bpmn.model.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.navarrop.bpmn.model.adapter.AdapterCDATA;
import com.sun.xml.txw2.annotation.XmlCDATA;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class BpmnParameter {

    @XmlAttribute(name = "id")
    @JacksonXmlProperty(isAttribute = true, localName = "id")
    private String id;

    @XmlAttribute(name = "name")
    @JacksonXmlProperty(isAttribute = true, localName = "name")
    private String name;

    @XmlElement(name = "myDef:value")
    @XmlJavaTypeAdapter(AdapterCDATA.class)
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(isAttribute = false, localName = "myDef:value")
    @JacksonXmlCData()
    private List<String> value;

}
