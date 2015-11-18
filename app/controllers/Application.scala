package controllers

import entities.Customer
import play.api._
import play.api.mvc._

class Application extends Controller {

  def index = Action {
    Ok("Hello, World!")
  }

  def home = Action {
    val customers = Customer.findAll
    Ok(views.html.index(customers))
  }
}
