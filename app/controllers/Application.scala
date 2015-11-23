package controllers

import models.MongoConnection
import models.entities.Customer
import play.api.data.Form
import play.api.data.Forms._
import play.api.mvc._

class Application extends Controller {

  val newCustomerForm = Form(mapping(
    "cid" -> longNumber,
    "username" -> nonEmptyText,
    "email" -> email)(Customer.apply)(Customer.unapply)
  )

  def createForm() = Action(
    Ok(views.html.newcustomer(newCustomerForm))
  )

  def create() = Action{implicit request =>
    newCustomerForm.bindFromRequest.fold(
      formWithErrors => BadRequest(views.html.newcustomer(formWithErrors)),
      value => Redirect(routes.Application.formSuccess(value+""))
    )
  }

  def formSuccess(value: String) = Action {
    //Ok("Customer to send: " + value )
    Ok(views.html.submitcustomer(value))
  }

  def test = Action {
    val mongo = new MongoConnection
    Ok(""+mongo.listDocs(mongo.connect))
  }

  def home = Action{
    Ok(views.html.home())
  }
}
