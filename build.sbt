organization := "moe.mirichan"
name := "iriguchi"
version := "0.0.1-SNAPSHOT"
scalaVersion := "2.12.4"
scalacOptions += "-Ypartial-unification"

val ArgonautVersion = "6.2"
val DoobieVersion = "0.4.4"
val Http4sVersion = "0.17.6"
val LogbackVersion = "1.2.3"
val ScalazVersion = "7.2.18"
val Specs2Version = "4.0.2"

libraryDependencies ++= Seq(
  "io.argonaut"    %% "argonaut"             % ArgonautVersion,
  "io.argonaut"    %% "argonaut-scalaz"      % ArgonautVersion,
  "org.tpolecat"   %% "doobie-core"          % DoobieVersion,
  "org.http4s"     %% "http4s-argonaut"      % Http4sVersion,
  "org.http4s"     %% "http4s-blaze-server"  % Http4sVersion,
  "org.http4s"     %% "http4s-dsl"           % Http4sVersion,
  "ch.qos.logback" %  "logback-classic"      % LogbackVersion,
  "org.scalaz"     %% "scalaz-core"          % ScalazVersion,
  "org.specs2"     %% "specs2-core"          % Specs2Version % "test",
)

enablePlugins(DockerPlugin, JavaAppPackaging, DockerComposePlugin)

mainClass in Compile := Some("moe.mirichan.iriguchi.Server")
dockerExposedPorts := Seq(8080)

