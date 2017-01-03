package com.amazon.alexa.smarthome.model

import play.api.libs.json.Json

/**
  * Created by jimbo on 02/01/17.
  */
case class Header(messageId: String, name: String, namespace: String, payloadVersion: String)

object Header {
  implicit val format = Json.format[Header]
}
