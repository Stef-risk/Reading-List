package com.stefan.readinglist.controller;

import com.stefan.readinglist.entity.Book;
import com.stefan.readinglist.repository.ReadingListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/")
@ConfigurationProperties(prefix = "amazon")
public class ReadingListController {

    private String associateId;

    @Autowired
    private ReadingListRepository readingListRepository;

    @RequestMapping(value="/{reader}",method = RequestMethod.GET)
    public String readerBooks (
            @PathVariable("reader") String reader,
            Model model
    ) {
        List<Book> readingList= readingListRepository.findByReader(reader);

        if(readingList!=null) {
            model.addAttribute("books",readingList);
            model.addAttribute("amazonId",associateId);
            model.addAttribute("reader",reader);
        }

        System.out.println(associateId);
        return "readingList";
    }

    @RequestMapping(value = "/{reader}",method = RequestMethod.POST)
    public String addToReadingList (
            @PathVariable("reader") String reader,
            Book book
    ) {
        book.setReader(reader);
        readingListRepository.save(book);
        return "redirect:/{reader}";
    }

    public String getAssociateId() {
        return associateId;
    }

    public void setAssociateId(String associateId) {
        this.associateId = associateId;
    }
}
