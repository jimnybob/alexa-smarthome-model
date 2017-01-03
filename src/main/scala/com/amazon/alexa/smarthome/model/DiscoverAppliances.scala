package com.amazon.alexa.smarthome.model

import play.api.libs.json.Json

/**
  * Created by jimbo on 03/01/17.
  */
trait DiscoverAppliances

case class DiscoverAppliancesRequest(header: Header, payload: AccessTokenPayload)

object DiscoverAppliancesRequest {
  implicit val format = Json.format[DiscoverAppliancesRequest]
}

case class DiscoverAppliancesResponse(header: Header, payload: DiscoveredAppliancesPayload)

object DiscoverAppliancesResponse {
  implicit val format = Json.format[DiscoverAppliancesResponse]
}
