package com.navarrop.bpmn.model.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@Setter
@JacksonXmlRootElement(localName = "boundaryEvent")
@XmlAccessorType(XmlAccessType.NONE)
public class BpmnBoundaryEvent extends BpmnNode{

    @JacksonXmlProperty(isAttribute = true, localName = "attachedToRef")
    private String attachedToRef;

    @JacksonXmlProperty(localName = "timerEventDefinition")
    private BpmnTimerEventDefinition timerEventDefinition;

    @XmlElement(name = "timerEventDefinition")
    public BpmnTimerEventDefinition getTimerEventDefinition() {
        timerEventDefinition.setId(this.getId().concat("_ted"));
        return timerEventDefinition;
    }

    @XmlAttribute(name = "attachedToRef")
    public String getAttachedToRef() {
        return this.getId().concat("_ted");
    }
}
