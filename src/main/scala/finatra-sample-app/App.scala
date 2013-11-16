package finatra_sample_app

import com.twitter.finatra._
import controllers.{EmployeeController, AuthController}

object App extends FinatraServer {

  val auth = new AuthController
  val employee = new EmployeeController
  register(auth)
  register(employee)
}
