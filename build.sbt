name := "play-http-client"

version := "1.0.0"

scalaVersion := "2.13.6"

libraryDependencies += guice
libraryDependencies += javaWs


lazy val root = (project in file(".")).enablePlugins(PlayJava)