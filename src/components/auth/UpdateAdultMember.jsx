import React, { useState } from "react";

const updateAdultMember = async (id, updatedData) => {
  try {
    const response = await fetch(`http://localhost:8080/api/adult-member/${id}`, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(updatedData),
    });
    if (!response.ok) {
      throw new Error("Failed to update adult member");
    }
    return await response.json();
  } catch (error) {
    console.error("Error updating adult member:", error);
  }
};

const EditAdultMember = ({ id }) => {
  const [updatedData, setUpdatedData] = useState({
    firstName: "",
    lastName: "",
    email: "",
    phoneNumber: "",
    password: "",
  });

  const handleSubmit = async (event) => {
    event.preventDefault();
    const updatedMember = await updateAdultMember(id, updatedData);
    console.log("Updated Member:", updatedMember);
  };

  const handleChange = (e) => {
    const { name, value } = e.target;
    setUpdatedData((prevData) => ({
      ...prevData,
      [name]: value,
    }));
  };

  return (
    <form onSubmit={handleSubmit}>
      <input
        type="text"
        name="firstName"
        placeholder="First Name"
        value={updatedData.firstName}
        onChange={handleChange}
      />
      <input
        type="text"
        name="lastName"
        placeholder="Last Name"
        value={updatedData.lastName}
        onChange={handleChange}
      />
      <input
        type="email"
        name="email"
        placeholder="Email"
        value={updatedData.email}
        onChange={handleChange}
      />
      <input
        type="text"
        name="phoneNumber"
        placeholder="Phone Number"
        value={updatedData.phoneNumber}
        onChange={handleChange}
      />
      <input
        type="password"
        name="password"
        placeholder="Password"
        value={updatedData.password}
        onChange={handleChange}
      />
      <button type="submit">Update Member</button>
    </form>
  );
};

export default EditAdultMember;
