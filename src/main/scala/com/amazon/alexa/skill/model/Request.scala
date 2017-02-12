package com.amazon.alexa.skill.model

/**
  * Created by jimbo on 25/01/17.
  */
case class ApplicationId(applicationId: String)

case class User(userId: String, accessToken: String)

case class SessionObject(`new`: Boolean, sessionId: String, attributes: Map[String, String], application: ApplicationId, user: User)


case class Device(supportedInterfaces: List[String])

case class SystemObject(application: ApplicationId, user: User, device: Device)

object PlayerActivity extends Enumeration {
  val IDLE, PAUSED, PLAYING, BUFFER_UNDERRUN, FINISHED, STOPEED = Value
}

case class AudioPlayer(token: String, offsetInMilliseconds: Long, playerActivity: PlayerActivity.Value)

case class ContextObject(System: SystemObject, AudioPlayer: AudioPlayer)

case class Request(version: String, session: SessionObject, context: ContextObject)



