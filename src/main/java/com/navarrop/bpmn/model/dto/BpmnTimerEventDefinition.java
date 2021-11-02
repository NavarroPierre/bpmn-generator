package com.navarrop.bpmn.model.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JacksonXmlRootElement(localName = "timerEventDefinition")
public class BpmnTimerEventDefinition extends BpmnNode{

    @JacksonXmlElementWrapper(useWrapping = false)
    private BpmnTimeDuration timeDuration;

}
