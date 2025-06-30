import React, { useEffect, useState } from "react";
import API from "../services/api";
import AddWorkoutForm from "../components/AddWorkoutForm";
import WorkoutList from "../components/WorkoutList";

function Dashboard({ username = "testuser" }) {
  const [workouts, setWorkouts] = useState([]);
  const fetchWorkouts = async () => {
    try {
      const res = await API.get(`/users/${username}/workouts`);
      setWorkouts(res.data);
    } catch (err) {
      console.error("Failed to load workouts:", err);
    }
  };

  useEffect(() => {
    fetchWorkouts();
  }, [fetchWorkouts]);

  const handleAddWorkout = async (newWorkout) => {
    try {
      const res = await API.post(`/users/${username}/workouts`, newWorkout);
      setWorkouts((prev) => [...prev, res.data]);
    } catch (err) {
      console.error("Failed to add workout:", err);
    }
  };

  return (
    <div>
      <h1>Your Dashboard</h1>
      <p>Welcome to your dashboard! Here you will see your past workouts</p>
      <AddWorkoutForm onAddWorkout={handleAddWorkout} />
      <WorkoutList workouts={workouts} />
    </div>
  );
}

export default Dashboard;
