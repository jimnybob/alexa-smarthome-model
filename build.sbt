name := "alexa-smarthome-model"

organization := "uk.co.smartii.alexa"

version := "1.0.0-SNAPSHOT"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "com.typesafe.play"  %% "play-ws" % "2.5.10",
  "ai.x"               %% "play-json-extensions" % "0.8.0",
  "org.scalatest"      %% "scalatest" % "3.0.1" % Test
)

libraryDependencies ~= { _ map {
  case m => m.exclude("commons-logging", "commons-logging")
}}