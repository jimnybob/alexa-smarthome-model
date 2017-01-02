package com.amazon.alexa.smarthome.model

import play.api.libs.json.Json

/**
  * Created by jimbo on 02/01/17.
  */
sealed trait Payload

case class DiscoveredAppliancesPayload(actions: Seq[String],
                                       additionalApplianceDetails: Map[String, String],
                                       applianceId: String,
                                       friendlyDescription: String) extends Payload

object DiscoveredAppliancesPayload {

  implicit val format = Json.format[DiscoveredAppliancesPayload]
}

case class ChangeAppliancePayload(appliance: Appliance, accessToken: String)

object ChangeAppliancePayload {

  implicit val format = Json.format[ChangeAppliancePayload]
}