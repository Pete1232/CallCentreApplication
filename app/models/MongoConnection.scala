package models

import reactivemongo.api.MongoDriver

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

import play.api.libs.iteratee.Iteratee

import reactivemongo.bson.BSONDocument
import reactivemongo.api.collections.bson.BSONCollection


class MongoConnection {

  def connect = {
    val driver = new MongoDriver
    val connection = driver.connection(List("localhost"))
    val db = connection("NBGardens")
    val collection = db("Customer")
    collection
  }

  def listDocs(collection: BSONCollection) = {
    val query = BSONDocument("cid" -> 2)

    val filter = BSONDocument(
      "email" -> 1,
      "username" -> 1)

    collection.
      find(query, filter).
      cursor[BSONDocument].
      enumerate().apply(Iteratee.foreach { doc =>
      println(s"found document: ${BSONDocument pretty doc}")
    })
  }
}