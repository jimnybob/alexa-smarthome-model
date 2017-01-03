package com.amazon.alexa.smarthome.model

import org.scalatest.{FlatSpec, Matchers}
import play.api.libs.json.{JsError, JsSuccess, Json}

/**
  * Created by jimbo on 03/01/17.
  */
class ChangeApplianceSpec extends FlatSpec with Matchers {

  "The Turn on/off model" should "parse ON requests" in {

    val request = """{
                    |        "header": {
                    |            "messageId": "01ebf625-0b89-4c4d-b3aa-32340e894688",
                    |            "name": "TurnOnRequest",
                    |            "namespace": "Alexa.ConnectedHome.Control",
                    |            "payloadVersion": "2"
                    |        },
                    |        "payload": {
                    |            "accessToken": "[OAuth Token here]",
                    |            "appliance": {
                    |                "additionalApplianceDetails": {},
                    |                "applianceId": "[Device ID for Ceiling Fan]"
                    |            }
                    |        }
                    |    }""".stripMargin

    Json.parse(request).validate[TurnOnRequest] match {
      case JsSuccess(dar, _) => dar.header.name should be("TurnOnRequest")
      case JsError(errors) => fail("Json parsing failed: " + errors)
    }
  }

  it should "serialise ON confirmations" in {

    val confirmation = TurnOnConfirmation(
      header = Header(
        messageId = "26fa11a8-accb-4f66-a272-8b1ff7abd722",
        name = "TurnOnConfirmation",
        namespace = "Alexa.ConnectedHome.Control", payloadVersion = "2"),
      payload = EmptyPayload())

    Json.prettyPrint(Json.toJson(confirmation)) should be(expectedConfirmation("TurnOnConfirmation"))
  }

  it should "parse OFF requests" in {

    val request = """{
                    |    "header": {
                    |      "messageId": "01ebf625-0b89-4c4d-b3aa-32340e894688",
                    |      "name": "TurnOffRequest",
                    |      "namespace": "Alexa.ConnectedHome.Control",
                    |      "payloadVersion": "2"
                    |    },
                    |    "payload": {
                    |      "accessToken": "[OAuth Token here]",
                    |      "appliance": {
                    |          "additionalApplianceDetails": {},
                    |          "applianceId": "[Device ID for Ceiling Fan]"
                    |      }
                    |    }
                    |}""".stripMargin

    Json.parse(request).validate[TurnOnRequest] match {
      case JsSuccess(dar, _) => dar.header.name should be("TurnOffRequest")
      case JsError(errors) => fail("Json parsing failed: " + errors)
    }
  }

  it should "serialise OFF confirmations" in {

    val confirmation = TurnOnConfirmation(
      header = Header(
        messageId = "26fa11a8-accb-4f66-a272-8b1ff7abd722",
        name = "TurnOffConfirmation",
        namespace = "Alexa.ConnectedHome.Control", payloadVersion = "2"),
      payload = EmptyPayload())

    println(Json.prettyPrint(Json.toJson(confirmation)))
    Json.prettyPrint(Json.toJson(confirmation)) should be(expectedConfirmation("TurnOffConfirmation"))
  }

  def expectedConfirmation(headerName: String) =
    s"""|{
        |  "header" : {
        |    "messageId" : "26fa11a8-accb-4f66-a272-8b1ff7abd722",
        |    "name" : "$headerName",
        |    "namespace" : "Alexa.ConnectedHome.Control",
        |    "payloadVersion" : "2"
        |  },
        |  "payload" : { }
        |}""".stripMargin
}
