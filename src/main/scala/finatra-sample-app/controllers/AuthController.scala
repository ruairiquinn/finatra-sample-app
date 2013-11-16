package finatra_sample_app.controllers

import com.twitter.finatra.Controller
import finatra_sample_app.model.Employee

class AuthController extends Controller {

  /**
   * Query params
   * curl http://localhost:7070/auth?u=foo&p=pass1234
   */
  get("/auth") { request =>
    val username = request.params.get("u")
    val password = request.params.get("p")

    (username, password) match {
      case (Some(u), Some(p)) if (authenticate(u, p)) => render.nothing.status(200).toFuture
      case _ => render.nothing.status(401).toFuture
    }
  }

  def authenticate(username : String, password : String) = {
    log.info("Authenticating...")
    Employee.getInMemory.exists(e => e.username == username && e.password == password)
  }
}