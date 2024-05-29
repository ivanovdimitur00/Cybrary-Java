package com.project.cybrary.book;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class BookController {
    private BookRepository bookRepository;

    @Autowired
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping({"/", "/home"})
    public String home(){
        return "index";
    }

    @GetMapping("/about")
    public String about(){
        return "about";
    }

    @GetMapping("/contact")
    public String contact(){
        return "contact";
    }

    @GetMapping("/allBooks")
    public String allBooks(Model model){
        model.addAttribute("books", bookRepository.findAll());
        return "allBooks";
    }

    @GetMapping("/addBook")
    public String addBook(Book book){
        return "addBook";
    }

    @PostMapping("/addBook")
    public String addBook(@ModelAttribute("book") @Valid Book book, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            // Handle validation errors, if any
            return "addBook";
        }
        
        bookRepository.save(book);
        return "redirect:/allBooks";
    }

    @GetMapping("/searchBooks")
    public String searchBooks(@RequestParam("keyword") String keyword, Model model) {
        if (keyword.isBlank()){
            model.addAttribute("books", bookRepository.findAll());
            return "allBooks";
        }
        List<Book> books = bookRepository.findBookByAuthor(keyword);
        model.addAttribute("books", books);
        return "allBooks";
    }

    @GetMapping("updateBook/{id}")
    public String updatedBook(@PathVariable("id") long id, Model model){
        Book book = bookRepository.findById(id)
                .orElseThrow(
                        ()->new IllegalArgumentException("No Book with id: " + id)
                );
        model.addAttribute("book",book);
        return "updateBook";
    }

    @PostMapping("updateBook/{id}")
    public String updateBook(@PathVariable("id") long id, Book book, Model model){
        bookRepository.save(book);
        model.addAttribute("books", bookRepository.findAll());
        return "redirect:/allBooks";
    }

    @PostMapping("deleteBook/{id}")
    public String deleteBook(@PathVariable("id") long id, Model model){
        Book book = bookRepository.findById(id)
                .orElseThrow(
                        ()->new IllegalArgumentException("No Book with id: " + id)
                );
        bookRepository.delete(book);
        model.addAttribute("books", bookRepository.findAll());
        return "redirect:/allBooks";
    }
}
