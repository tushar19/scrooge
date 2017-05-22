/**
 * Generated by Scrooge
 *   version: ?
 *   rev: ?
 *   built at: ?
 */
package com.twitter.scrooge.test.gold.thriftscala

import com.twitter.scrooge.ThriftEnum
import scala.collection.immutable.{Map => immutable$Map}


@javax.annotation.Generated(value = Array("com.twitter.scrooge.Compiler"))
case object RequestType {

  case object Create extends com.twitter.scrooge.test.gold.thriftscala.RequestType {
    val value: Int = 1
    val name: String = "Create"
    val originalName: String = "Create"
    val annotations: immutable$Map[String, String] = immutable$Map(
      "some.annotation" -> "true"
    )
  }

  private[this] val _SomeCreate = _root_.scala.Some(com.twitter.scrooge.test.gold.thriftscala.RequestType.Create)

  case object Read extends com.twitter.scrooge.test.gold.thriftscala.RequestType {
    val value: Int = 2
    val name: String = "Read"
    val originalName: String = "Read"
    val annotations: immutable$Map[String, String] = immutable$Map.empty
  }

  private[this] val _SomeRead = _root_.scala.Some(com.twitter.scrooge.test.gold.thriftscala.RequestType.Read)

  case class EnumUnknownRequestType(value: Int) extends com.twitter.scrooge.test.gold.thriftscala.RequestType {
    val name: String = "EnumUnknownRequestType" + value
    def originalName: String = name
  }

  /**
   * Find the enum by its integer value, as defined in the Thrift IDL.
   */
  def apply(value: Int): com.twitter.scrooge.test.gold.thriftscala.RequestType =
    value match {
      case 1 => com.twitter.scrooge.test.gold.thriftscala.RequestType.Create
      case 2 => com.twitter.scrooge.test.gold.thriftscala.RequestType.Read
      case _ => throw new NoSuchElementException(value.toString)
    }

  /**
   * Find the enum by its integer value, as defined in the Thrift IDL.
   * returns an EnumUnknownRequestType(value) if the value is not found.
   * In particular this allows ignoring new values added to an enum
   * in the IDL on the producer side when the consumer was not updated.
   */
  def getOrUnknown(value: Int): com.twitter.scrooge.test.gold.thriftscala.RequestType =
    get(value) match {
      case _root_.scala.Some(e) => e
      case _root_.scala.None => EnumUnknownRequestType(value)
    }

  /**
   * Find the enum by its integer value, as defined in the Thrift IDL.
   * Returns None if the value is not found
   */
  def get(value: Int): _root_.scala.Option[com.twitter.scrooge.test.gold.thriftscala.RequestType] =
    value match {
      case 1 => _SomeCreate
      case 2 => _SomeRead
      case _ => _root_.scala.None
    }

  def valueOf(name: String): _root_.scala.Option[com.twitter.scrooge.test.gold.thriftscala.RequestType] =
    name.toLowerCase match {
      case "create" => _SomeCreate
      case "read" => _SomeRead
      case _ => _root_.scala.None
    }

  lazy val list: List[com.twitter.scrooge.test.gold.thriftscala.RequestType] = scala.List[com.twitter.scrooge.test.gold.thriftscala.RequestType](
    com.twitter.scrooge.test.gold.thriftscala.RequestType.Create,
    com.twitter.scrooge.test.gold.thriftscala.RequestType.Read
  )
}



@javax.annotation.Generated(value = Array("com.twitter.scrooge.Compiler"))
sealed trait RequestType extends ThriftEnum with Serializable