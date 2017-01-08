package com.amazon.alexa.smarthome.model

import play.api.libs.json.Json

/**
  * Created by jimbo on 08/01/17.
  */
case class Error(header: Header, payload: EmptyPayload)

object Error {
  implicit val format = Json.format[Error]
}
