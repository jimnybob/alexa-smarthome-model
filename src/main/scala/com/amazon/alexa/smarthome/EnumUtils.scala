package com.amazon.alexa.smarthome

import play.api.libs.json._

import scala.util.Try

/**
  * https://gist.github.com/mikesname/5237809#file-gistfile1-scala
  *
  * Created by James on 17/09/2015.
  */
object EnumUtils {
  def enumReads[E <: Enumeration](enum: E): Reads[E#Value] = new Reads[E#Value] {
    def reads(json: JsValue): JsResult[E#Value] = json match {
      case JsString(s) => Try(JsSuccess(enum.withName(s)))
        .getOrElse(JsError(s"Enumeration expected of type: '${enum.getClass}', but it does not appear to contain the value: '$s'"))
      case _ => JsError("String value expected")
    }
  }

  def enumWrites[E <: Enumeration]: Writes[E#Value] = Writes[E#Value](v => JsString(v.toString))

  def enumFormat[E <: Enumeration](enum: E): Format[E#Value] = Format(enumReads(enum), enumWrites)
}
