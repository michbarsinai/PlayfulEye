name := """presentation"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.1"

LessKeys.compress in Assets := true

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  ws
)
