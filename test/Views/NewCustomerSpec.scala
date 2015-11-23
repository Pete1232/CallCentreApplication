package views

import models.entities.Customer
import org.scalatest.{Matchers, FlatSpec}
import play.api.data.Form
import play.api.data.Forms._
import play.api.test.Helpers._
import play.api.test._

/**
  * Created by pnewman on 20/11/2015.
  */
class NewCustomerSpec extends FlatSpec with Matchers{

  def testNewCustomer: Unit ={
    val testForm = Form(mapping(
      "cid" -> longNumber,
      "username" -> nonEmptyText,
      "email" -> email)(Customer.apply)(Customer.unapply)
    )
    lazy val html = views.html.newcustomer(testForm)

    "The newcustomer view" should "render an html page" in {
      running(new FakeApplication()) {
        contentType(html) should be("text/html")
      }
    }

    it should "contain a form field for customer ID" in{
      contentAsString(html) should include("cid_field")
    }

    it should "contain a form field for customer username" in{
      contentAsString(html) should include ("username_field")
    }

    it should "contain a form field for customer email" in{
      contentAsString(html) should include ("email_field")
    }
  }
  testNewCustomer
}