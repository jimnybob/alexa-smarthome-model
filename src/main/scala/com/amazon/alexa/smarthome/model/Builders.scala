package com.amazon.alexa.smarthome.model

import java.util.UUID

import com.amazon.alexa.smarthome.model.Builders.header

/**
  * Created by jimbo on 08/01/17.
  */
object Builders {

  def discoveredAppliance(actions: Seq[SmartHomeAction.Value], additionalApplianceDetails: Map[String, String] = Map.empty,
                          applianceId: String, friendlyDescription: String = "", friendlyName: String = "",
                          isReachable: Boolean = true, manufacturerName: String = "", modelName: String = "",
                          version: String = "") = {
    DiscoveredAppliance(actions = actions,
      additionalApplianceDetails: Map[String, String],
      applianceId = applianceId,
      friendlyDescription = friendlyDescription,
      friendlyName = friendlyName,
      isReachable: Boolean,
      manufacturerName: String,
      modelName: String,
      version: String)
  }

  def header(messageId: String = UUID.randomUUID().toString, name: String, namespace: String, payloadVersion: String = "2"): Header = {
    Header(messageId = messageId,
      name = name,
      namespace = namespace,
      payloadVersion = payloadVersion)
  }

  def turnOnConfirmation() = {
    TurnOnConfirmation(header = header(name = "TurnOnConfirmation", namespace = "Alexa.ConnectedHome.Control"),  payload = EmptyPayload())
  }

  def turnOffConfirmation() = {
    TurnOnConfirmation(header = header(name = "TurnOffConfirmation", namespace = "Alexa.ConnectedHome.Control"),  payload = EmptyPayload())
  }

  def error(name: String) = {
    Error(header = header(name = name, namespace = "Alexa.ConnectedHome.Control"),  payload = EmptyPayload())
  }

  def healthCheck(description: String, isHealthy: Boolean) = HealthCheckResponse(header = header(
    name = "HealthCheckResponse",
    namespace = "Alexa.ConnectedHome.System"),
    payload = HealthResponsePayload(description = description, isHealthy = isHealthy))
}
