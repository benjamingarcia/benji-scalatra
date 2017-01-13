package com.benji.scalatra

import org.scalatra._

class ScalatraServlet extends BenjiscalatraStack {

  get("/") {
    <html>
      <body>
        <h1>Hello, world!</h1>
        Say <a href="hello-scalate">hello to Scalate</a>.
      </body>
    </html>
  }

}
