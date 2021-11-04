package com.navarrop.bpmn.model.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@JacksonXmlRootElement(localName = "sequenceFlow")
@Setter
@Getter
@XmlAccessorType(XmlAccessType.FIELD)
public class BpmnSequenceFlow extends BpmnNode{

    public BpmnSequenceFlow(String id, String name) {
        setId(id);
        setName(name);
    }

    @XmlAttribute(name = "sourceRef")
    @JacksonXmlProperty(isAttribute = true, localName = "sourceRef")
    private String sourceRef;

    @XmlAttribute(name = "targetRef")
    @JacksonXmlProperty(isAttribute = true, localName = "targetRef")
    private String targetRef;

    public static BpmnSequenceFlow build(final String id, final String name,
                                         final String sourceRef, final String targetRef) {
        BpmnSequenceFlow flow = new BpmnSequenceFlow(id, name);
        flow.setSourceRef(sourceRef);
        flow.setTargetRef(targetRef);
        return flow;
    }
}
