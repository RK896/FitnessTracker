import React, { useState } from "react";
import API from "../services/api";

function Register() {
  const [formData, setFormData] = useState({
    email: "",
    username: "",
    password: "",
    confirmPassword: "",
  });

  const [message, setMessage] = useState("");

  const handleChange = (e) => {
    setFormData((prev) => ({
      ...prev,
      [e.target.name]: e.target.value,
    }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    if (formData.password !== formData.confirmPassword) {
      setMessage("Passwords do not match.");
      return;
    }
    try {
      await API.post("users/register", formData);
      setMessage("Registered successfully! Please log in.");
      setFormData({
        email: "",
        username: "",
        password: "",
        confirmPassword: "",
      });
    } catch (error) {
      console.error("Error registering:", error);
      if (error.response) {
        console.error("Response data:", error.response.data);
        setMessage(
          error.response.data.message ||
            "Registration failed. Please try again."
        );
      } else {
        setMessage("Registration failed. Please try again.");
      }
    }
  };

  return (
    <div>
      <h1>Register</h1>
      {message && <p>{message}</p>}
      <form onSubmit={handleSubmit}>
        <input
          name="username"
          type="text"
          placeholder="Username"
          value={formData.username}
          onChange={handleChange}
          required
        />
        <br />
        <input
          name="email"
          type="email"
          placeholder="Email"
          value={formData.email}
          onChange={handleChange}
          required
        />
        <br />
        <input
          name="password"
          type="password"
          placeholder="Password"
          value={formData.password}
          onChange={handleChange}
          required
        />
        <br />
        <input
          name="confirmPassword"
          type="password"
          placeholder="Confirm Password"
          value={formData.confirmPassword}
          onChange={handleChange}
          required
        />
        <br />
        <button type="submit">Register</button>
      </form>
    </div>
  );
}

export default Register;
