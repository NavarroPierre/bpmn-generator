package com.navarrop.bpmn.model.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.Setter;

@JacksonXmlRootElement(localName = "boundaryEvent")
@Getter
@Setter
public class BpmnBoundaryEvent extends BpmnNode{

    @JacksonXmlProperty(isAttribute = true, localName = "attachedToRef")
    private String attachedToRef;

    @JacksonXmlProperty(localName = "timerEventDefinition")
    private BpmnTimerEventDefinition timerEventDefinition;

    public BpmnTimerEventDefinition getTimerEventDefinition() {
        timerEventDefinition.setId(this.getId().concat("_ted"));
        return timerEventDefinition;
    }

    public String getAttachedToRef() {
        return this.getId().concat("_ted");
    }
}
