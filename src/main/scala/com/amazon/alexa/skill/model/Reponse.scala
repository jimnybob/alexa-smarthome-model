package com.amazon.alexa.skill.model

/**
  * Created by jimbo on 25/01/17.
  */
case class Response(version: String, sessionAttributes: Option[Map[String, String]])

trait StandardResponse

object SpeechType extends Enumeration {
  val PlainText, SSML = Value
}

case class OutputSpeechObject(`type`: SpeechType.Value, text: Option[String], ssml: Option[String])

object CardType extends Enumeration{
  val Simple, Standard, LinkAccount = Value
}

class Image(smallImageUrl: String, largeImageUrl: String)

case class CardObject(`type`: CardType.Value, title: Option[String], content: Option[String], text: Option[String], image: Option[Image])

case class ResponseObject(card: Option[CardObject], outputSpeech: Option[OutputSpeechObject])