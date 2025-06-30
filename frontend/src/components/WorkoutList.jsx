import WorkoutItem from "./WorkoutItem";

function WorkoutList({ workouts }) {
  if (!workouts) {
    return <div>No workouts found.</div>;
  }

  return (
    <div>
      {workouts.map((workout) => (
        <WorkoutItem key={workout.id} workout={workout} />
      ))}
    </div>
  );
}

export default WorkoutList;
