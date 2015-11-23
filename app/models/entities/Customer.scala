package models.entities

/**
  * Created by pnewman on 18/11/2015.
  */

case class Customer(cid: Long, username: String, email: String) {
}

object Customer{
  var customers = Set(
    Customer(1,"Alfie Allen","a.allen@nbgardens.com"),
    Customer(2,"Benny Back","b.back@nbgardens.com"),
    Customer(3,"Charlie Charles","c.charles@nbgardens.com")
  )

  def findAll: List[Customer] = {
    customers.toList.sortBy(_.cid)
  }
}
