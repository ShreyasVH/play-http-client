name := "play-http-client"

version := "1.0.0"

scalaVersion := "3.8.2"

libraryDependencies += guice
libraryDependencies += javaWs


lazy val root = (project in file(".")).enablePlugins(PlayJava)