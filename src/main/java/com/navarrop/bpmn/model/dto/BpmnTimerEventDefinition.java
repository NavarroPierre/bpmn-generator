package com.navarrop.bpmn.model.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)
@Setter
@Getter
@JacksonXmlRootElement(localName = "timerEventDefinition")
public class BpmnTimerEventDefinition extends BpmnNode{

    @XmlElement(name = "timeDuration")
    @JacksonXmlElementWrapper(useWrapping = false)
    private BpmnTimeDuration timeDuration;

}
