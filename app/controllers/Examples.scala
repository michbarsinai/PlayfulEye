package controllers

import play.api._
import play.api.mvc._
import play.api.data.Forms._
import play.api.data._
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import play.api.Routes

import scala.concurrent._

import java.util.Date
import java.text.SimpleDateFormat


object Examples extends Controller {

 def queryParam( theParam:String ) = Action {
  Ok( views.html.output("Query Parameter Result", theParam) )
 } 

 def syncEcho( message:String ) = Action {
  val result = longOperation(message)
  Ok( result )
 }

 def asyncEcho( message:String ) = Action.async {
  val fResult:Future[String] = Future( longOperation(message) )
  fResult.map( result => Ok(result) )
 }

 def asyncPage = Action {
  Ok( views.html.async() )
 }
def javascriptRoutes = Action { implicit request =>
    Ok(
      Routes.javascriptRouter("jsRoutes")(
        routes.javascript.Examples.syncEcho,
        routes.javascript.Examples.asyncEcho
      )
    ).as("text/javascript")
  }

 def longOperation( message:String ) = {
  val start = new Date
  Thread.sleep( 1000 )
  val end = new Date
  val fmt = new SimpleDateFormat("hh:mm:ss")
  "%s | %s -> %s".format(message, fmt.format(start), fmt.format(end))
 }
}