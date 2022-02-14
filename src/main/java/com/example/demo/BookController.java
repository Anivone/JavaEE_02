package com.example.demo;

import com.example.demo.models.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {

    List<Book> books = new ArrayList<>();

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String displayForm() {
        return "form";
    }

    @RequestMapping(value = "/add-book", method = RequestMethod.POST)
    public String addNewBook(@ModelAttribute Book book) {
        books.add(book);
        return "redirect:/books";
    }

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public String getBooks(Model model) {
        model.addAttribute("books", books);
        return "books";
    }

}
