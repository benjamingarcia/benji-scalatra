package org.benji

import org.scalatra.FutureSupport
import slick.jdbc.PostgresProfile.api._

class BenjiServlet(val db: Database) extends BenjiscalaappStack with FutureSupport with SlickRoutes {

  protected implicit def executor = scala.concurrent.ExecutionContext.Implicits.global

  get("/benji") {
    <html>
      <body>
        <h1>Hello, world!</h1>
        Say
        <a href="hello-scalate">hello to Scalate</a>
      </body>
    </html>
  }

}
