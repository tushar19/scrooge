/**
 * Generated by Scrooge
 *   version: ?
 *   rev: ?
 *   built at: ?
 */
package com.twitter.scrooge.test.gold.thriftscala

import com.twitter.finagle.SourcedException
import com.twitter.finagle.{service => ctfs}
import com.twitter.finagle.stats.{NullStatsReceiver, StatsReceiver}
import com.twitter.finagle.thrift.{Protocols,RichClientParam, ThriftClientRequest}
import com.twitter.scrooge.{TReusableBuffer, ThriftStruct, ThriftStructCodec}
import com.twitter.util.{Future, Return, Throw, Throwables}
import java.nio.ByteBuffer
import java.util.Arrays
import org.apache.thrift.protocol._
import org.apache.thrift.TApplicationException
import org.apache.thrift.transport.TMemoryInputTransport
import scala.collection.{Map, Set}
import scala.language.higherKinds


@javax.annotation.Generated(value = Array("com.twitter.scrooge.Compiler"))
class PlatinumService$FinagleClient(
    override val service: com.twitter.finagle.Service[ThriftClientRequest, Array[Byte]],
    override val clientParam: RichClientParam)
  extends GoldService$FinagleClient(service, clientParam) with PlatinumService[Future] {

  @deprecated("Use com.twitter.finagle.thrift.RichClientParam", "2017-08-16")
  def this(
    service: com.twitter.finagle.Service[ThriftClientRequest, Array[Byte]],
    protocolFactory: TProtocolFactory = Protocols.binaryFactory(),
    serviceName: String = "PlatinumService",
    stats: StatsReceiver = NullStatsReceiver,
    responseClassifier: ctfs.ResponseClassifier = ctfs.ResponseClassifier.Default
  ) = this(
    service,
    RichClientParam(
      protocolFactory,
      serviceName,
      clientStats = stats,
      responseClassifier = responseClassifier
    )
  )

  @deprecated("Use com.twitter.finagle.thrift.RichClientParam", "2017-08-16")
  def this(
    service: com.twitter.finagle.Service[ThriftClientRequest, Array[Byte]],
    protocolFactory: TProtocolFactory,
    serviceName: String,
    stats: StatsReceiver
  ) = this(service, protocolFactory, serviceName, stats, ctfs.ResponseClassifier.Default)

  import PlatinumService._

  override def serviceName: String = clientParam.serviceName
  private[this] def stats: StatsReceiver = clientParam.clientStats
  private[this] def responseClassifier: ctfs.ResponseClassifier = clientParam.responseClassifier

  private[this] val scopedStats = if (serviceName != "") stats.scope(serviceName) else stats
  private[this] object __stats_moreCoolThings {
    val RequestsCounter = scopedStats.scope("moreCoolThings").counter("requests")
    val SuccessCounter = scopedStats.scope("moreCoolThings").counter("success")
    val FailuresCounter = scopedStats.scope("moreCoolThings").counter("failures")
    val FailuresScope = scopedStats.scope("moreCoolThings").scope("failures")
  }
  val moreCoolThingsPlatinumServiceReplyDeserializer: Array[Byte] => _root_.com.twitter.util.Try[Int] = {
    response: Array[Byte] => {
      val result = decodeResponse(response, MoreCoolThings.Result)

      result.firstException() match {
        case Some(exception) => _root_.com.twitter.util.Throw(setServiceName(exception))
        case _ => result.successField match {
          case Some(success) => _root_.com.twitter.util.Return(success)
          case _ => _root_.com.twitter.util.Throw(missingResult("moreCoolThings"))
        }
      }
    }
  }

  def moreCoolThings(request: com.twitter.scrooge.test.gold.thriftscala.Request): Future[Int] = {
    __stats_moreCoolThings.RequestsCounter.incr()
    val inputArgs = MoreCoolThings.Args(request)

    val serdeCtx = new _root_.com.twitter.finagle.thrift.DeserializeCtx[Int](inputArgs, moreCoolThingsPlatinumServiceReplyDeserializer)
    _root_.com.twitter.finagle.context.Contexts.local.let(
      _root_.com.twitter.finagle.thrift.DeserializeCtx.Key,
      serdeCtx,
      _root_.com.twitter.finagle.thrift.Headers.Request.Key,
      _root_.com.twitter.finagle.thrift.Headers.Request.empty
    ) {
      val serialized = encodeRequest("moreCoolThings", inputArgs)
      this.service(serialized).flatMap { response =>
        Future.const(serdeCtx.deserialize(response))
      }.respond { response =>
        val responseClass = responseClassifier.applyOrElse(
          ctfs.ReqRep(inputArgs, response),
          ctfs.ResponseClassifier.Default)
        responseClass match {
          case ctfs.ResponseClass.Successful(_) =>
            __stats_moreCoolThings.SuccessCounter.incr()
          case ctfs.ResponseClass.Failed(_) =>
            __stats_moreCoolThings.FailuresCounter.incr()
            response match {
              case Throw(ex) =>
                setServiceName(ex)
                __stats_moreCoolThings.FailuresScope.counter(Throwables.mkString(ex): _*).incr()
              case _ =>
            }
        }
      }
    }
  }
}
