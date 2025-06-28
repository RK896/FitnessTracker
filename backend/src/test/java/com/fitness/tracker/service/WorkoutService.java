package com.fitness.tracker.service;

import com.fitness.tracker.model.User;
import com.fitness.tracker.model.Workout;
import com.fitness.tracker.repository.UserRepository;
import com.fitness.tracker.repository.WorkoutRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkoutService {

    private final WorkoutRepository workoutRepository;
    private final UserRepository userRepository;

    public WorkoutService(WorkoutRepository workoutRepository, UserRepository userRepository){
        this.workoutRepository = workoutRepository;
        this.userRepository = userRepository;
    }

    public Workout addWorkout(String username, Workout workout){
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
        workout.setUser(user);
        return workoutRepository.save(workout);
    }

    public List<Workout> getWorkoutsByUser(String username){
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return workoutRepository.findByUser(user);
    }

    public void deleteWorkout(Long workoutId){
        workoutRepository.deleteById(workoutId);
    }

}
