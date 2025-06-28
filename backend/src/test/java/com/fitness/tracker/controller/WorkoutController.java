package com.fitness.tracker.controller;

import com.fitness.tracker.model.User;
import com.fitness.tracker.model.Workout;
import com.fitness.tracker.service.WorkoutService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class WorkoutController {

    private final WorkoutService workoutService;

    public WorkoutController(WorkoutService workoutService){
        this.workoutService = workoutService;
    }

    @PostMapping("/users/{username}/workouts")
    public ResponseEntity<Workout> createWorkout(@PathVariable String username, @RequestBody Workout workout){
        Workout savedWorkout = workoutService.addWorkout(username, workout);
        return ResponseEntity.ok(savedWorkout);
    }

    @GetMapping("/users/{username}/workouts")
    public List<Workout> getWorkouts(@PathVariable String username){
        return workoutService.getWorkoutsByUser(username);
    }
}

