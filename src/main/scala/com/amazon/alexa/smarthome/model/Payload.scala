package com.amazon.alexa.smarthome.model

import play.api.libs.json.Json
import ai.x.play.json.Jsonx
import com.amazon.alexa.smarthome.EnumUtils

/**
  * Created by jimbo on 02/01/17.
  */
sealed trait Payload

case class AccessTokenPayload(accessToken: String) extends Payload

object AccessTokenPayload {
  implicit val format = Json.format[AccessTokenPayload]
}

case class EmptyPayload(dummyval: Option[String] = None) extends Payload

object EmptyPayload {

  implicit val format = Json.format[EmptyPayload]
}

case class DiscoveredAppliance(actions: Seq[SmartHomeAction.Value],
                               additionalApplianceDetails: Map[String, String],
                               applianceId: String,
                               friendlyDescription: String,
                               friendlyName: String,
                               isReachable: Boolean,
                               manufacturerName: String,
                               modelName: String,
                               version: String)

object DiscoveredAppliance {

  implicit val formatAction = EnumUtils.enumFormat(SmartHomeAction)
  implicit val format = Json.format[DiscoveredAppliance]
}

case class DiscoveredAppliancesPayload(discoveredAppliances: Seq[DiscoveredAppliance]) extends Payload

object DiscoveredAppliancesPayload {

  implicit val format = Json.format[DiscoveredAppliancesPayload]
}

case class ChangeAppliancePayload(appliance: Appliance, accessToken: String) extends Payload

object ChangeAppliancePayload {

  implicit val format = Json.format[ChangeAppliancePayload]
}

case class InitiationPayload(initiationTimestamp: String) extends Payload

object InitiationPayload {

  implicit val format = Json.format[InitiationPayload]
}

case class HealthResponsePayload(description: String, isHealthy: Boolean) extends Payload

object HealthResponsePayload {

  implicit val format = Json.format[HealthResponsePayload]
}