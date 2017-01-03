package com.amazon.alexa.smarthome.model

import org.scalatest.{FlatSpec, Matchers}
import play.api.libs.json.{JsError, JsSuccess, Json}

/**
  * Created by jimbo on 03/01/17.
  */
class DiscoverAppliancesSpec extends FlatSpec with Matchers {

  "The DiscoverAppliances model" should "parse requests" in {

    val request = """{
                    |    "header": {
                    |        "messageId": "6d6d6e14-8aee-473e-8c24-0d31ff9c17a2",
                    |        "name": "DiscoverAppliancesRequest",
                    |        "namespace": "Alexa.ConnectedHome.Discovery",
                    |        "payloadVersion": "2"
                    |    },
                    |    "payload": {
                    |        "accessToken": "*OAuth Token here*"
                    |    }
                    |}""".stripMargin

    Json.parse(request).validate[DiscoverAppliancesRequest] match {
      case JsSuccess(dar, _) => dar.header.name should be("DiscoverAppliancesRequest")
      case JsError(errors) => fail("Json parsing failed: " + errors)
    }
  }

  it should "parse responses" in {

    val response = """{
                     |    "header": {
                     |        "messageId": "ff746d98-ab02-4c9e-9d0d-b44711658414",
                     |        "name": "DiscoverAppliancesResponse",
                     |        "namespace": "Alexa.ConnectedHome.Discovery",
                     |        "payloadVersion": "2"
                     |    },
                     |    "payload": {
                     |        "discoveredAppliances": [
                     |            {
                     |                "actions": [
                     |                    "incrementTargetTemperature",
                     |                    "decrementTargetTemperature",
                     |                    "setTargetTemperature"
                     |                ],
                     |                "additionalApplianceDetails": {
                     |                    "extraDetail1": "optionalDetailForSkillAdapterToReferenceThisDevice",
                     |                    "extraDetail2": "There can be multiple entries",
                     |                    "extraDetail3": "but they should only be used for reference purposes.",
                     |                    "extraDetail4": "This is not a suitable place to maintain current device state"
                     |                },
                     |                "applianceId": "uniqueThermostatDeviceId",
                     |                "friendlyDescription": "descriptionThatIsShownToCustomer",
                     |                "friendlyName": " Bedroom Thermostat",
                     |                "isReachable": true,
                     |                "manufacturerName": "yourManufacturerName",
                     |                "modelName": "fancyThermostat",
                     |                "version": "your software version number here."
                     |            },
                     |            {
                     |                "actions": [
                     |                    "incrementPercentage",
                     |                    "decrementPercentage",
                     |                    "setPercentage",
                     |                    "turnOn",
                     |                    "turnOff"
                     |                ],
                     |                "additionalApplianceDetails": {},
                     |                "applianceId": "uniqueLightDeviceId",
                     |                "friendlyDescription": "descriptionThatIsShownToCustomer",
                     |                "friendlyName": "Living Room",
                     |                "isReachable": true,
                     |                "manufacturerName": "yourManufacturerName",
                     |                "modelName": "fancyLight",
                     |                "version": "your software version number here."
                     |            }
                     |        ]
                     |    }
                     |}""".stripMargin

    Json.parse(response).validate[DiscoverAppliancesResponse] match {
      case JsSuccess(dar, _) => dar.header.name should be("DiscoverAppliancesResponse")
      case JsError(errors) => fail("Json parsing failed: " + errors)
    }
  }
}
