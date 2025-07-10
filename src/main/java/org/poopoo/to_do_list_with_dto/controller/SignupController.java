package org.poopoo.to_do_list_with_dto.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.poopoo.to_do_list_with_dto.dto.SignupDto;
import org.poopoo.to_do_list_with_dto.mdel.User;
import org.poopoo.to_do_list_with_dto.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class SignupController {
    private final UserRepository userRepository;

    @GetMapping("/signup")
    public String showSignup(Model model) {
        model.addAttribute("signupDto", new SignupDto());

        return "signup";
    }

    @PostMapping("/signup")
    public String doSignup(
        @Valid @ModelAttribute SignupDto signupDTO,
        BindingResult bindingResult,
        Model model
    ) {
        if (bindingResult.hasErrors()) {
            return "signup";
        }
        if (userRepository.findByUsername(signupDTO.getUsername()) != null) {
            model.addAttribute("error", "이미 사용중인 아이디입니다.");

            return "signup";
        }

        // 중복 가입 여부 체크

        User user = User.builder()
            .username(signupDTO.getUsername())
            .password(signupDTO.getPassword())
            .build();
        userRepository.save(user);

        return "redirect:/login?registered";
    }
}
