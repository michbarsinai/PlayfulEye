package controllers

import play.api._
import play.api.mvc._

import models._

object Application extends Controller {

  def index = Action {
    Ok(views.html.index("A Playful Eye for the JEE Guy", routes.Application.agenda))
  }

  def agenda = Action {
    val data = Seq(Items("Focus on what makes play interesting. Not a tutorial (but enough to get started)",
                    Text("What's Play?"),
                    Items("Importance of Play in a JEE world", Text("Comparing, not bashing.")),
                    Text("Meet the tools (there are quite a few)"),
                    Text("First Play App"),
                    Text("Template Engine"),
                    Text("Controllers"),
                    Items( "Technicalities", Text("Console"), Text("Forms"), Text("ORM") ),
                    Text( "Reactive and Background Processing" ),
                    Text("Wrap-up")
                  ))
    Ok( views.html.listItems("Agenda", data, routes.Application.whats) )
  }

  def whats = Action {
    val data = Seq(
        Items("",
            Text("Lightweight Web Framework"),
            Text("Inspired by Rails, Django and others"),
            Items("Started by Guillaume Bort (Zenexity)", Text("V0: 2007"), Text("V1: 2009"), Text("V2: 2012, adds scala, joins Typesafe Stack 2.0")),
            Text("Web first, Java second (but both very important)"),
            Text("Stateless, Async, Non-Blocking IO, Developer Oriented"),
            Text("Open Source (Apache 2)"),
            Text("Poster boys: Linkedin, GILT, TheGuardian.co.uk, KLOUT"),
            Text("Java or Scala Back-end")
          ),
        Statement("Cures the Java-at-work, PHP-at-home phenomenon")
      )
    Ok( views.html.listItems("What is Play", data, routes.Application.vsJeeJee) )
  }

  def vsJeeJee = Action {
    val data = Seq(
        Items("JEE",
          Text("Standard-based, multiple implementations"),
          Items("Servlet API-centric", Text("Making HTTP feel more like \"java\"")),
          Items("Stateful, XML, Annotation magic (sometimes breaking Java)", Text("e.g. DI to private fields")),
          Items("Well/Over architectured", Text("Depends on what your'e trying to do")),
          Text("JSF makes the web act like Swing™ - at a cost")
      )
    )

    Ok( views.html.listItemsWithImage("Play and JEE", "JEE-jsr-list", data, routes.Application.vsJeePlay) )
  }

  def vsJeePlay = Action {
      val data = Seq(
        Items("Play, on the other hand...",
          Text("Play is the only Play"),
          Items("Not opinionated about ORM", Text("Some options built in")),
          Text("\"Scripty\", lightweight feeling"),
          Text("...But allows for massive scaling"),
          Items("Web/Http centric", Text("e.g. Easy to make sensible urls")),
          Items("Best template engine evah", Text("IMHO")),
          Items("Tools are still an issue", Text("I ended up with Sublime Text 3 and the Terminal")),
          Text("Changing/Evolving rapidly")
        )
      )
      Ok( views.html.listItems("Play and JEE", data, routes.Application.worldView) )
  }

  def worldView = Action {
   val data = Seq(
        Items("Many new names",
          Term("Typesafe", "The company behind Scala and the Typesafe Stack"),
          Term("The Typesafe Stack", "Groups certain projects to create web applications"),
          Term("Activator", "Basic tool of the Typesafe stack. Use from commandline or a web browser."),
          Term("SBT","The project management/build tool. Can manage dependencies (using Ivy)."),
          Term("Akka","Actor framework. Used for background processing, parallel tasking and general heavy lifting"),
          Term("LessCSS","CSS Preprocessor. Adds some missing parts to the CSS language.")
        )

      )
      Ok( views.html.listItems("Who's Who, and What Do They Do", data, routes.Application.firstApp) ) 
  }

  def firstApp = Action {
    val data = Seq( Statement("First Application - Demo"))
    Ok( views.html.centered("First App Demo", data, routes.Application.anatomy) ) 
  }

  def anatomy = Action {
    val data = Seq(
      Items("",
        Items("app",
          Term("assets","less and coffeescript files"),
          Term("controllers","Application's control layer"),
          Term("models","Application's model objects"),
          Term("views","HTML templates")
        ),
        Items("conf",
          Term("application.conf","Configuration file, e.g. Database connection strings"),
          Term("routes","Routed HTTP calls to methods")),
        Term("public","Static resources and processed assets go here"),
        Term("test","For both unit and functional testing"),
        Term("build.sbt","Project setup (plugins, dependencies, etc.)")
      ))
    Ok( views.html.listItems("What's in the Application Folder", data, routes.Application.routesSample) ) 
  }

  def routesSample = Action {
    Ok( views.html.routesSample("Sample Routes File", routes.Application.templates))
  }

  def templates = Action {
    val data = Seq(
      Items("Templates are Scala code",
        Text("Static typing (Compiler's got your back)"),
        Items("Leverage scala's:",
          Text("Control structures"),
          Text("Collections"),
          Text("Almost all other language features")
        ),
        Text("Component reuse via function calls"),
        Text("Friendly error reporting")
      ))

    Ok( views.html.listItems("Templating Engine", data, routes.Application.elementHierarchy) ) 
  }

  def elementHierarchy = Action {
    val data = Seq(
      Img("elements"),
      Text("Element hierarchy."),
      Text("Note the recursive structure of 'Section' and 'Items'"),
      Text("How would the template look?")
      )

    Ok( views.html.centered("Templating Engine", data, routes.Application.controllerae) ) 
  }

  def controllerae = TODO
  def forms = TODO
  def orm = TODO
  def reactive = TODO
  def closing = TODO
}