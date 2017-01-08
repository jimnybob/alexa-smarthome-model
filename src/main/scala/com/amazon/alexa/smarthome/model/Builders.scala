package com.amazon.alexa.smarthome.model

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
}
