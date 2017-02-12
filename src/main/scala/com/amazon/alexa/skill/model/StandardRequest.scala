package com.amazon.alexa.skill.model

/**
  * https://developer.amazon.com/public/solutions/alexa/alexa-skills-kit/docs/custom-standard-request-types-reference
  *
  * Created by jimbo on 25/01/17.
  */
sealed trait StandardRequest

case class LaunchRequest(`type`: String, requestId: String, timestamp: String, locale: String) extends StandardRequest

sealed  trait Intent

case class SlotObject(name: String, value: String) extends Intent

case class IntentObject(name: String, slots: Map[String, SlotObject]) extends Intent

case class IntentRequest(`type`: String, requestId: String, timestamp: String, intent: Intent, locale: String) extends StandardRequest
