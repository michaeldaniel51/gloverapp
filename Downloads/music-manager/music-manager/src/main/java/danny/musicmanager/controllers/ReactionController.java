package danny.musicmanager.controllers;


import danny.musicmanager.services.ReactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
@RequestMapping("/reaction")
public class ReactionController {

    private final ReactionService reactionService;




}
