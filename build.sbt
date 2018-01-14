organization := "moe.mirichan"
name := "iriguchi"
version := "0.0.1-SNAPSHOT"
scalaVersion := "2.12.4"
scalacOptions += "-Ypartial-unification"

val ScalazVersion = "7.2.18"
val ArgonautVersion = "6.2"
val Http4sVersion = "0.17.6"
val Specs2Version = "4.0.2"
val LogbackVersion = "1.2.3"
val DoobieVersion = "0.4.4"

libraryDependencies ++= Seq(
  "org.scalaz"     %% "scalaz-core"          % ScalazVersion,
  "org.http4s"     %% "http4s-blaze-server"  % Http4sVersion,
  "org.http4s"     %% "http4s-argonaut"      % Http4sVersion,
  "org.http4s"     %% "http4s-dsl"           % Http4sVersion,
  "io.argonaut"    %% "argonaut"             % ArgonautVersion,
  "io.argonaut"    %% "argonaut-scalaz"      % ArgonautVersion,
  "org.tpolecat"   %% "doobie-core"          % DoobieVersion,
  "org.specs2"     %% "specs2-core"          % Specs2Version % "test",
  "ch.qos.logback" %  "logback-classic"      % LogbackVersion
)

enablePlugins(sbtdocker.DockerPlugin, JavaAppPackaging)

dockerfile in docker := {
  val appDir: File = stage.value
  val targetDir = "/app"

  new Dockerfile {
    from("java")
    entryPoint(s"$targetDir/bin/${executableScriptName.value}")
    copy(appDir, targetDir, chown = "daemon:daemon")
  }
}
