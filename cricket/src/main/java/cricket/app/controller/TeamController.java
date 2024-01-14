package cricket.app.controller;

import cricket.app.services.TeamService;
import cricket.app.web.form.TeamForm;
import cricket.app.web.shared.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/cricket")
@CrossOrigin("*")
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("/")
    public ResponseEntity<Response> findAll() {
        return new ResponseEntity<>(
                new Response(this
                        .teamService
                        .find()
                        , "OK"), HttpStatus.OK);
    }

    @PostMapping("/add")
    public Mono<ResponseEntity<Response>> addOne(@RequestBody TeamForm teamForm) {
        this.teamService.insertOne(teamForm);
        return Mono.just(new ResponseEntity<>
                (new Response("Added", "OK"), HttpStatus.OK));
    }

    @DeleteMapping("/delete")
    public Mono<ResponseEntity<Response>> deleteOne(@RequestBody TeamForm teamForm) {
        this.teamService.deleteOne(teamForm);
        return Mono.just(new ResponseEntity<>
                (new Response("Added", "OK"), HttpStatus.OK));
    }


}
