package controllers

import play.api._
import play.api.mvc._
import play.api.data.Forms._
import play.api.data._
/** Uncomment the following lines as needed **/
/**
import play.api.Play.current
import play.api.libs._
import play.api.libs.iteratee._
import play.api.libs.concurrent._
import java.util.concurrent._
import scala.concurrent.stm._
import akka.util.duration._
import play.api.cache._
import play.api.libs.json._
**/

object Examples extends Controller {

 def queryParam( theParam:String ) = Action {
  Ok( views.html.output("Query Parameter Result", theParam) )
 } 

}