package us.debloat.testserver.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import us.debloat.testserver.models.Jwt;
import us.debloat.testserver.models.Score;
import us.debloat.testserver.models.UserName;

import java.util.ArrayList;

@CrossOrigin("*")
@RestController
public class AuthorizationController {

	Jwt jwt = new Jwt("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9" + ".eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ" + ".SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c");
	String username = "miguel";
//	String password = "hashed";
//	String password = "U2FsdGVkX18HYydxWuCFBLslkZn2a8R51JgWX4TN2cXahyugFL74IUz5" +
//			"+0a9O8neHKxaWz7Vj9mWrSqJFxX1uLrEcI4FlTbcCfEdq9GdBNL5sXxpq" +
//			"+1BzLMwkrR+u3RktcKTLZJUaos9f3j2xVq8oA==";
String password =	"b390264a923529cdd2012d033c790ea522effb9b15d7800d3db41effe58fd346";


	@CrossOrigin("*")
	@PostMapping("/login")
	ResponseEntity<?> login(@RequestBody UserName user) {
		System.out.println("user.username = " + user.username);
		System.out.println("user.password = " + user.password);
		if ((user.username.equals(username) && user.password.equals(password))) {
			return ResponseEntity.status(HttpStatus.OK).body(jwt);
		} else {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid username or password");
		}
		// receive the username and password
		// { username: "foo", password: "barencrypted"}
		// responds with an jwt
		// 200OK OR 401 Unauthorized
		// {jwt: ezlkqwsdfjbnuilwerbnspiofg792364ol;kjhberfasdfc}
	}

	@CrossOrigin("*")
	@PostMapping("/register")
	ResponseEntity<?> register(@RequestBody UserName user) {
		// receive the username and password
		// { username: "foo", password: "barencrypted"}
		// responds with an jwt
		// 201 or 401
		// {jwt: ezlkqwsdfjbnuilwerbnspiofg792364ol;kjhberfasdfc}

		if ((null != user.username) && (null != user.password)) {
			return ResponseEntity.status(HttpStatus.CREATED).body(jwt);
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid username or password");
		}
	}

	@CrossOrigin("*")
	@PostMapping("/submit")
	void submit() {
		// request
		// Authorizartion header token
		// {username: "foo", difficulty: "easy", score: 100}
		// response 201


	}

	@CrossOrigin("*")
	@GetMapping("/scores/{username}/{level}")
	ResponseEntity<?> score(@PathVariable String username, @PathVariable String level, @RequestHeader(HttpHeaders.AUTHORIZATION) String headers) {
		// request
		// Authorization header token
		// response 200
		// {[{id: 1, score: 100, dificulty: "easy"},{}]}
		String jwtHeader = headers.split(" ")[1];
		System.out.println("jwtHeader = " + jwtHeader);
		if ((jwtHeader.equals(this.jwt.jwt)) && (username.equals(this.username))) {
			ArrayList<Score> scores = new ArrayList<>();
			Score score1 = new Score(20, level, username);
			score1.id = scores.size() + 1;
			scores.add(score1);
			Score score2 = new Score(30, level,username);
			score2.id = scores.size() + 1;
			scores.add(score2);
			Score score3 = new Score(40, level,username);
			score3.id = scores.size() + 1;
			scores.add(score3);
			Score score4 = new Score(10, level, username);
			score4.id = scores.size() + 1;
			scores.add(score4);
			Score score5 = new Score(25, level,username);
			score5.id = scores.size() + 1;
			scores.add(score5);
			Score score10 = new Score(90, level, username);
			score10.id = scores.size() + 1;
			scores.add(score10);
			Score score6 = new Score(3, level,username);
			score6.id = scores.size() + 1;
			scores.add(score6);
			Score score7 = new Score(4, level,username);
			score7.id = scores.size() + 1;
			scores.add(score7);
			Score score8 = new Score(1, level, username);
			score8.id = scores.size() + 1;
			scores.add(score8);
			Score score9 = new Score(2, level,username);
			score9.id = scores.size() + 1;
			scores.add(score9);
			return ResponseEntity.status(HttpStatus.OK).body(scores);
		} else {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Not authorized");
		}
	}


	@CrossOrigin("*")
	@GetMapping("/highscores/{level}")
	ResponseEntity<?> highscore(@PathVariable String level) {
		// nothing needed
		ArrayList<Score> scores = new ArrayList<>();
		Score score1 = new Score(20, level, username);
		score1.id = scores.size() + 1;
		scores.add(score1);
		Score score2 = new Score(30, level, "sam");
		score2.id = scores.size() + 1;
		scores.add(score2);
		Score score3 = new Score(40, level, "joel");
		score3.id = scores.size() + 1;
		scores.add(score3);
		Score score4 = new Score(10, level, username);
		score4.id = scores.size() + 1;
		scores.add(score4);
		Score score5 = new Score(25, level, "elijah");
		score5.id = scores.size() + 1;
		scores.add(score5);
		Score score10 = new Score(90, level, username);
		score10.id = scores.size() + 1;
		scores.add(score10);
		Score score6 = new Score(3, level, "sam");
		score6.id = scores.size() + 1;
		scores.add(score6);
		Score score7 = new Score(4, level, "joel");
		score7.id = scores.size() + 1;
		scores.add(score7);
		Score score8 = new Score(1, level, username);
		score8.id = scores.size() + 1;
		scores.add(score8);
		Score score9 = new Score(2, level, "elijah");
		score9.id = scores.size() + 1;
		scores.add(score9);
		return ResponseEntity.status(HttpStatus.OK).body(scores);
	}

	@CrossOrigin("*")
	@PostMapping("/score")
	ResponseEntity<?> submitScore(@RequestBody Score score, @RequestHeader(HttpHeaders.AUTHORIZATION) String headers) {
		String jwtHeader = headers.split(" ")[1];
		System.out.println("jwtHeader = " + jwtHeader);
		if ((jwtHeader.equals(this.jwt.jwt)) && (username.equals(this.username))) {
			System.out.println("score = " + score.difficulty);
			if (null != score) {
				return ResponseEntity.status(HttpStatus.CREATED).body(score);
			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad Request");
			}
		} else {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Not Authorized");
		}
	}
}
