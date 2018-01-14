package moe.mirichan.iriguchi

import fs2.Task

import scala.util.Properties.envOrNone
import org.http4s.server.blaze.BlazeBuilder
import org.http4s.util.StreamApp

object Server extends StreamApp {
  val port: Int = envOrNone("HTTP_PORT").fold(8080)(_.toInt)
  val addr: String = envOrNone("HTTP_ADDR").getOrElse("0.0.0.0")

  def stream(args: List[String]): fs2.Stream[Task, Nothing] = BlazeBuilder.bindHttp(port, addr)
    .mountService(Echo.service, "/echo")
    .serve
}
