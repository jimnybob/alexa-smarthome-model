package com.amazon.alexa.smarthome.model

import play.api.libs.json.Json

/**
  * Created by jimbo on 02/01/17.
  */
sealed trait TurnOnOff

case class TurnOnRequest(header: Header, payload: ChangeAppliancePayload)

object TurnOnRequest {
  implicit val format = Json.format[TurnOnRequest]
}

case class TurnOnConfirmation(header: Header)

object TurnOnConfirmation {
  implicit val format = Json.format[TurnOnConfirmation]
}

case class TurnOffRequest(header: Header, payload: ChangeAppliancePayload)

object TurnOffRequest {
  implicit val format = Json.format[TurnOffRequest]
}

case class TurnOffConfirmation(header: Header)

object TurnOffConfirmation {
  implicit val format = Json.format[TurnOffConfirmation]
}