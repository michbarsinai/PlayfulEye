package models

class Element() {
  def boxed = {
    val s = toString;
    val edge = "+" + "-"*(s.length+2) + "+"

    edge + "\n" + "| " + s + " |" + "\n" + edge
  }
}

case class Section( title: String, subs:Element* ) extends Element
case class Text( text:String ) extends Element
case class Items( title: String, subs:Element* ) extends Element
case class Statement( text:String ) extends Element
case class SideBySide( l:Element, r:Element ) extends Element
case class Term( text:String, info:String ) extends Element
case class Img( name: String ) extends Element
