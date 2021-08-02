package danny.musicmanager.controllers;


import danny.musicmanager.services.FeedBackService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/feedback")
public class FeedBackController {

    private final FeedBackService feedBackService;


}
