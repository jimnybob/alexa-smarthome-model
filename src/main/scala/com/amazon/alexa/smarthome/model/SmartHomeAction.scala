package com.amazon.alexa.smarthome.model

/**
  * Created by jimbo on 08/01/17.
  */
object SmartHomeAction extends Enumeration {
  val setTargetTemperature, incrementTargetTemperature, decrementTargetTemperature, setPercentage, incrementPercentage, decrementPercentage, turnOff, turnOn = Value
}
