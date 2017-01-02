package com.amazon.alexa.smarthome.model

import play.api.libs.json._

/**
  * Created by jimbo on 02/01/17.
  */
class SmartHomeControlRequestSpec extends FlatSpec with Matchers {

  val mock = """{
               |  "header": {
               |    "payloadVersion": "1",
               |    "namespace": "Control",
               |    "name": "SwitchOnOffRequest"
               |  },
               |  "payload": {
               |    "switchControlAction": "TURN_ON",
               |    "appliance": {
               |      "additionalApplianceDetails": {
               |        "key2": "value2",
               |        "key1": "value1"
               |      },
               |      "applianceId": "sampleId"
               |    },
               |    "accessToken": "sampleAccessToken"
               |  }
               |}""".stripMargin


  "The smartii home model" should "work with Amazon documented" in {

    Json.parse(mock).validate[SmartHomeControlRequest] match {
      case JsSuccess(shcr, _) => shcr.header.name should be("SwitchOnOffRequest")
      case JsError(errors) => fail("Json parsing failed: " + errors)
    }
  }
}
