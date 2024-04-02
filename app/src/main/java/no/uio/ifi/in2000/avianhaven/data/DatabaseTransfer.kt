package no.uio.ifi.in2000.avianhaven.data

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

class DatabaseTransfer {

    fun setUpDBConnection() {
        val password = "exp&lore4tr.ekant"
        val dbName = "bird_library"
        val host = "localhost"
        val port = 3306
        val connectionURL = "jdbc:mysql://$host:$port/$dbName?user=root&password"
        Class.forName("com.mysql.cj.jdbc.Driver")
        val connection: Connection = DriverManager.getConnection(connectionURL, "root", password)
        addBird(connection)
    }

    private fun addBird(connection: Connection) {
        val statement: PreparedStatement = connection.prepareStatement(
            "INSERT INTO names(common_name, latin_name, family_name) " +
                    "values ('house sparrow', 'passer domesticus', 'passeridae')"
        )
    }
}