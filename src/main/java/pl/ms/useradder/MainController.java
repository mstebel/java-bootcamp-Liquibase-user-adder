package pl.ms.useradder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
class MainController {
    private AppUserRepository appUserRepository;

    MainController(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("user", new AppUser());
        return "home";
    }

    @PostMapping("/addUser")
    public String addUser(AppUser user) {
        appUserRepository.save(user);
        return "redirect:/success/" + user.getId();
    }

    @GetMapping("/success/{id}")
    public String successMessage(@PathVariable Long id, Model model) {
        Optional<AppUser> byId = appUserRepository.findById(id);
        AppUser user = byId.orElseThrow(IllegalArgumentException::new);
        model.addAttribute("userData", user);
        return "success";
    }

    @GetMapping("/users")
    public String showUsers(Model model) {
        List<AppUser> allUsers = appUserRepository.findAll();
        model.addAttribute("users", allUsers);
        return "users";
    }
}
