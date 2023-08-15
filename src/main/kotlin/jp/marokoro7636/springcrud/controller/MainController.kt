package jp.marokoro7636.springcrud.controller

import jp.marokoro7636.springcrud.entity.UserEntity
import jp.marokoro7636.springcrud.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class MainController {
    @Autowired
    lateinit var userRepository: UserRepository

    @GetMapping("/")
    fun showUsers(model: Model): String {
        val users = userRepository.findAll()
        model.addAttribute("users", users)
        return "index"
    }

    @GetMapping("/add")
    fun showAddPage(): String {
        return "add"
    }

    @PostMapping("/add")
    fun addNewUser(@RequestParam name: String, @RequestParam age: Int): String {
        userRepository.save(UserEntity(0, name, age))
        return "redirect:/"
    }
}