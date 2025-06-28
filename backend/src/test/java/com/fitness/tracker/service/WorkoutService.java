package com.fitness.tracker.service;

import com.fitness.tracker.model.User;
import com.fitness.tracker.model.Workout;
import com.fitness.tracker.repository.WorkoutRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkoutService {

    private final WorkoutRepository workoutRepository;

    public WorkoutService(WorkoutRepository workoutRepository){
        this.workoutRepository = workoutRepository;
    }

    public Workout addWorkout(Workout workout){
        return workoutRepository.save(workout);
    }

    public List<Workout> getWorkoutsByUser(User user){
        return workoutRepository.findByUser(user);
    }

    public void deleteWorkout(Long workoutId){
        workoutRepository.deleteById(workoutId);
    }

}
