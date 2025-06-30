function WorkoutItem({ workout }) {
  return (
    <div
      style={{ border: "1px solid #ccc", padding: "10px", margin: "10px 0" }}
    >
      <h3>{workout.type}</h3>
      <p>Date: {new Date(workout.date).toLocaleDateString()}</p>
      <p>Duration: {workout.duration} minutes</p>
      <p>Feel Score: {workout.feelScore}</p>
      <p>Notes: {workout.notes}</p>
    </div>
  );
}

export default WorkoutItem;
