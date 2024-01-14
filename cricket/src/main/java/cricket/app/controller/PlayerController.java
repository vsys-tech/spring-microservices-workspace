package cricket.app.controller;

import cricket.app.services.PlayerService;
import cricket.app.web.form.PlayerForm;
import cricket.app.web.shared.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("players")
@CrossOrigin({"http://localhost:4200"})
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/")
    public ResponseEntity<Response> findAll() {
        return new ResponseEntity<>(
                new Response(this.playerService.find(), "OK"), HttpStatus.OK);
    }

    @GetMapping("/{teamId}")
    public ResponseEntity<Response> findByTeamId(@PathVariable("teamId") String teamId) {
        return new ResponseEntity<>(
                new Response(this.playerService.findByTeamId(teamId), "OK"), HttpStatus.OK);
    }

    @PostMapping("/add")
    public Mono<ResponseEntity<Response>> addOne(@RequestBody PlayerForm playerForm) {
        this.playerService.insertOne(playerForm);
        return Mono.just(new ResponseEntity<>
                (new Response("Added", "OK"), HttpStatus.OK));
    }

    @DeleteMapping("/delete")
    public Mono<ResponseEntity<Response>> deleteOne(@RequestBody PlayerForm playerForm) {
        this.playerService.deleteOne(playerForm);
        return Mono.just(new ResponseEntity<>
                (new Response("Deleted", "OK"), HttpStatus.OK));
    }


}
