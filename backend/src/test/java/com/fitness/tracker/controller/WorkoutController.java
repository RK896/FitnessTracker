package com.fitness.tracker.controller;

import com.fitness.tracker.model.User;
import com.fitness.tracker.model.Workout;
import com.fitness.tracker.service.WorkoutService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user/workouts")
public class WorkoutController {

    private final WorkoutService workoutService;

    public WorkoutController(WorkoutService workoutService){
        this.workoutService = workoutService;
    }

    @PostMapping("/createWorkout")
    public ResponseEntity<Workout> createNewWorkout(@RequestBody User user, @RequestBody Workout workout){

    }
}
