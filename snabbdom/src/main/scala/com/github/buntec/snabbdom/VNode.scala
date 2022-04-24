package com.github.buntec.snabbdom

import org.scalajs.dom

class VNode private (
    var sel: Option[String],
    var data: Option[VNodeData],
    var children: Option[Array[VNode]],
    var elm: Option[dom.Node],
    var text: Option[String],
    var key: Option[KeyValue],
    var listener: Option[dom.Event => Unit]
)

object VNode {

  def create(
      sel: Option[String],
      data: Option[VNodeData],
      children: Option[Array[VNode]],
      text: Option[String],
      elm: Option[dom.Node]
  ) = new VNode(sel, data, children, elm, text, data.flatMap(_.key), None)

  def text(text: String) =
    new VNode(None, None, None, None, Some(text), None, None)

  implicit def fromString(s: String): VNode = text(s)

}
