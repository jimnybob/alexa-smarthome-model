package com.amazon.alexa.smarthome.model

import play.api.libs.json.Json

/**
  * Created by jimbo on 03/01/17.
  */
case class Appliance(additionalApplianceDetails: Map[String, String], applianceId: String)

object Appliance {
  implicit val format = Json.format[Appliance]
}
