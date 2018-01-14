package moe.mirichan.iriguchi

import argonaut._
import Argonaut._

import org.http4s._
import org.http4s.server._
import org.http4s.dsl._
import org.http4s.argonaut._

object Echo {
  case class EchoResponse(name: String) {
    val message: String = s"This is $name"
  }

  object EchoResponse {
    implicit val greetingJsonEncoder: EncodeJson[EchoResponse] = EncodeJson[EchoResponse](g => Json("message" -> g.message.asJson))
    implicit val greetingEntityEncoder: EntityEncoder[EchoResponse] = jsonEncoderOf[EchoResponse]
  }

  val service = HttpService {
    case GET -> Root / resource =>
      Ok(EchoResponse(resource))
  }
}
