package controllers;

import models.BookBean;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

public class ParametersParser {
    public static BookBean parseBookBean(HttpServletRequest request) {
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        BigDecimal price = new BigDecimal(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        return new BookBean(title, author, price, quantity);
    }
}
