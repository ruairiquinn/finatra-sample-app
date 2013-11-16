package finatra_sample_app.controllers

import com.twitter.finatra.Controller
import finatra_sample_app.model.{EmployeeDTO, Employee}

class EmployeeController extends Controller  {

  /**
   * Query params
   * curl http://localhost:7070/show?u=foo
   */
  get("/show") { request =>
    (request.params.get("u")) match {
      case (Some(u)) => render.json(getEmployee(u)).toFuture
      case _ => render.nothing.status(500).toFuture
    }
  }

  def getEmployee(username : String) : EmployeeDTO = {
    Employee.getInMemory.filter(e => e.username == username)
                        .map(e => Employee.toDTO(e))
                        .head
  }
}
