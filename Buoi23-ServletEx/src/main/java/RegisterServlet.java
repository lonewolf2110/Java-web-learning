import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class RegisterServlet extends HttpServlet {
    private String tableRow(String name, String value) {
        return "<tr>" + "<td>" + name + "</td>" + "<td>" + value + "</td></tr>";
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String fullName = request.getParameter("fullname");
        String email = request.getParameter("email");
        String address = request.getParameter("address");

        String style = "<style>\n" +
                "       div.container {\n" +
                "            display: flex;\n" +
                "            flex-direction: column;\n" +
                "            align-items: center;\n" +
                "            justify-content: center;\n" +
                "        }" +
                "        table {\n" +
                "            border-collapse: separate;\n" +
                "        }\n" +
                "\n" +
                "        table, td, th {\n" +
                "            border: 1px solid black;\n" +
                "        }\n" +
                "    </style>";

        String head = "<head><meta charset=\"UTF-8\"><title>User information</title>" + style + "</head>";

        String body = "<body>"
                + "<div class=\"container\">"
                + "<h1>Hello, " + username + "</h1>"
                + "<p>Your information: </p>"
                + "<table>"
                + "<tr>"
                +   "<th>Name</th>"
                +   "<th>Value</th>"
                + "</tr>"
                + tableRow("pwd", password)
                + tableRow("uname", username)
                + tableRow("em", email)
                + tableRow("add", address)
                + tableRow("fname", fullName)
                + "</table></div></body>";

        String html = "<!DOCTYPE html><html lang=\"en\">" + head + body + "</html>";
        out.print(html);

        MongoClient mongoClient = MongoClients.create();
        MongoDatabase database = mongoClient.getDatabase("java-web-learning");
        MongoCollection<Document> collection = database.getCollection("buoi23");
        Document document = new Document()
                .append("uname", username)
                .append("pwd", password)
                .append("em", email)
                .append("add", address)
                .append("fname", fullName);
        collection.insertOne(document);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
