package ImageHoster.controller;


import ImageHoster.model.Image;
import ImageHoster.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import javax.servlet.http.HttpSession;
import java.util.Date;
import org.springframework.web.bind.annotation.RequestParam;




import ImageHoster.model.Comment;

import ImageHoster.service.ImageService;

import ImageHoster.service.CommentService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private ImageService imageService;


    @RequestMapping(value = "/images/{imageId}/{imageTitle}/comments", method = RequestMethod.POST)

    public String addComment(@RequestParam("comment") String commentString,@PathVariable("imageTitle") String imageTitle, @PathVariable("imageId") Integer imageId,Model model, HttpSession session) {
        Image image = imageService.getImage(imageId);



        Comment comment = new Comment();
        comment.setImage(image);
        comment.setUser((User) session.getAttribute("userID"));

        comment.setText(commentString);
        comment.setCreatedDate(new Date());
        commentService.newComment(comment);

        return "redirect:/images/" + image.getId() +"/"+ image.getTitle();

    }



}
