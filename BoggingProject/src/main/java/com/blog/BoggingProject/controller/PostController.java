package com.blog.BoggingProject.controller;


import com.blog.BoggingProject.model.Post;
import com.blog.BoggingProject.repository.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {


    @Autowired
    PostRepo repo;
    @GetMapping("/")
public String viewHomePost(Model model){
  model.addAttribute("Listposts",repo.findAll());
  return "index";
}

@GetMapping("/new")
public  String newPost(Model model){
  model.addAttribute("post",new Post());
  return "new_Post";
}

@PostMapping("/save")
public String savePost(@ModelAttribute("post") Post post){
  repo.save(post);
  return "redirect:/";
}

    @GetMapping("/edit/{id}")
    public String editPost(@PathVariable int id, Model model){
        model.addAttribute("post",repo.findById(id));
        return "edit_Post";
    }

    @PostMapping("/update")
    public String updatePost(@ModelAttribute("post") Post post) {
      repo.save(post);
      return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public   String deletePost(@PathVariable int id){
      repo.deleteById(id);
      return "redirect:/";
    }

}
