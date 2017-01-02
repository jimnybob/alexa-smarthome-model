package com.amazon.alexa.smarthome.model

import play.api.libs.json.Json

/**
  * Created by jimbo on 02/01/17.
  */
case class Header(messageId: String, name: String, namespace: String, payloadVersion: String)

object Header {
  implicit val format = Json.format[Header]
}

case class Appliance(additionalApplianceDetails: Map[String, String], applianceId: String)

object Appliance {
  implicit val format = Json.format[Appliance]
}


case class SmartHomeControlRequest(header: Header, payload: ChangeAppliancePayload)

object SmartHomeControlRequest {

  implicit val format = Json.format[SmartHomeControlRequest]
}

case class DiscoverAppliancesRequest(header: Header, payload: ChangeAppliancePayload)

object DiscoverAppliancesRequest {
  implicit val format = Json.format[DiscoverAppliancesRequest]
}

case class DiscoverAppliancesResponse(header: Header, payload: DiscoveredAppliancesPayload)

object DiscoverAppliancesResponse {
  implicit val format = Json.format[DiscoverAppliancesResponse]
}