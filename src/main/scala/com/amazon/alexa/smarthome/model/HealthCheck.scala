package com.amazon.alexa.smarthome.model

import play.api.libs.json.Json

/**
  * Created by jimbo on 03/01/17.
  */
trait HealthCheck

case class HealthCheckRequest(header: Header, payload: InitiationPayload)

object HealthCheckRequest {
  implicit val format = Json.format[HealthCheckRequest]
}

case class HealthCheckResponse(header: Header, payload: HealthResponsePayload)

object HealthCheckResponse {
  implicit val format = Json.format[HealthCheckResponse]
}