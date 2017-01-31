
import javax.servlet.ServletContext

import com.mchange.v2.c3p0.ComboPooledDataSource
import org.benji.BenjiServlet
import org.scalatra._
import org.slf4j.LoggerFactory
import slick.jdbc.PostgresProfile.api._

class ScalatraBootstrap extends LifeCycle {

  val logger = LoggerFactory.getLogger(getClass)

  val cpds = new ComboPooledDataSource
  logger.info("Created c3p0 connection pool")

  override def init(context: ServletContext) {
    val db = Database.forDataSource(cpds)
    context.mount(new BenjiServlet(db), "/*")
  }

  override def destroy(context: ServletContext) {
    super.destroy(context)
    closeDbConnection
  }

  private def closeDbConnection() {
    logger.info("Closing c3po connection pool")
    cpds.close
  }
}
