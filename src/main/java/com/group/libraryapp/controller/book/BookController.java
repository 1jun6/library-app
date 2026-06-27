package com.group.libraryapp.controller.book;

import com.group.libraryapp.dto.book.request.BookCreateRequest;
import com.group.libraryapp.dto.book.request.BookLoanRequest;
import com.group.libraryapp.dto.book.request.BookReturnRequest;
import com.group.libraryapp.service.book.BookService;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;


/* saveBook() API sepcification

- HTTP Method : POST
- HTTP Path : /book
- HTTP Body (JSON) : { "name" : String // 책 이름 }
- 결과 반환 X (HTTP 상태 OK면 충분하다

 */

/* loanBook() API specification

- HTTP Method : POST
- HTTP Path : /book/loan
- HTTP Body (JSON) : { "userName" : String, "bookName" : String }
- 결과 반환 X (HTTP 상태 200 OK이면 충분하다)

 */

/* returnBook() API sepcification

- HTTP Method : PUT
- HTTP Path : /book/return
- HTTP Body (JSON) : { "userName" : String, "bookName" : String }
- 결과 반환 X (HTTP 상태 200 OK이면 충분하다)
 */


@RestController
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {

        this.bookService = bookService;
    }

    @PostMapping("/book")
    public void saveBook(@RequestBody BookCreateRequest request) {

        bookService.saveBook(request);
    }

    @PostMapping("/book/loan")
    public void loanBook(@RequestBody BookLoanRequest request) {

        bookService.loanBook(request);
    }

    @PutMapping("/book/return")
    public void returnBook(@RequestBody BookReturnRequest request) {

        bookService.returnBook(request);
    }


}
