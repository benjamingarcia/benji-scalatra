package org.benji

import org.scalatra.{FutureSupport, ScalatraBase}
import slick.jdbc.PostgresProfile.api._

/**
  * Created by benjamin on 30/01/2017.
  */
trait SlickRoutes extends ScalatraBase with FutureSupport {

  def db: Database

  get("/db/create-tables") {
    db.run(Tables.createSchemaAction)
  }

  get("/db/load-data") {
    db.run(Tables.insertSupplierAndCoffeeData)
  }

  get("/db/drop-tables") {
    db.run(Tables.dropSchemaAction)
  }

  get("/coffees") {
    // run the action and map the result to something more readable
    db.run(Tables.findCoffeesWithSuppliers.result) map { xs =>
      contentType = "text/plain"
      xs map { case (s1, s2) => f"  $s1 supplied by $s2" } mkString "\n"
    }
  }
}
