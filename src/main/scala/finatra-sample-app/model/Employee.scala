package finatra_sample_app.model

case class Employee(username : String, password : String, forename : String, surname : String, role : String)

case class EmployeeDTO(forename : String, surname : String, role : String)

object Employee {
  val getInMemory = List(Employee("hsimpson", "pass123", "Homer", "Simpson", "Developer"),
    Employee("bgumble", "pass123", "Barney", "Gumble", "QA"),
    Employee("mszyslak", "pass123", "Moe", "Szyslak", "Manager"))

  def toDTO(e : Employee) = {
    EmployeeDTO(e.forename, e.surname, e.role)
  }
}