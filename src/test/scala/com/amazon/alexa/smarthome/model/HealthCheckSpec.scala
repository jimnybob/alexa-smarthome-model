package com.amazon.alexa.smarthome.model

import org.scalatest.{FlatSpec, Matchers}
import play.api.libs.json.{JsError, JsSuccess, Json}

/**
  * Created by jimbo on 03/01/17.
  */
class HealthCheckSpec extends FlatSpec with Matchers {

  "The health check model" should "parse requests" in {

    val request =
      """{
        |        "header": {
        |            "messageId": "243550dc-5f95-4ae4-ad43-4e1e7cb037fd",
        |            "name": "HealthCheckRequest",
        |            "namespace": "Alexa.ConnectedHome.System",
        |            "payloadVersion": "2"
        |        },
        |        "payload": {
        |            "initiationTimestamp": "1435302567000"
        |        }
        |    }""".stripMargin

    Json.parse(request).validate[HealthCheckRequest] match {
      case JsSuccess(dar, _) => dar.header.name should be("HealthCheckRequest")
      case JsError(errors) => fail("Json parsing failed: " + errors)
    }
  }

  it should "serialise responses" in {

    val response = HealthCheckResponse(header = Header(
      messageId = "f9905dc8-b861-4912-bcf7-5b90f62b3a71",
      name = "HealthCheckResponse",
      namespace = "Alexa.ConnectedHome.System", payloadVersion = "2"),
      payload = HealthResponsePayload(description = "The system is currently healthy", isHealthy = true)
    )

    val expected =
      """{
         |  "header" : {
         |    "messageId" : "f9905dc8-b861-4912-bcf7-5b90f62b3a71",
         |    "name" : "HealthCheckResponse",
         |    "namespace" : "Alexa.ConnectedHome.System",
         |    "payloadVersion" : "2"
         |  },
         |  "payload" : {
         |    "description" : "The system is currently healthy",
         |    "isHealthy" : true
         |  }
         |}""".stripMargin

    Json.prettyPrint(Json.toJson(response)) should be(expected)
  }
}
