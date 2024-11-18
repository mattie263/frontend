import React from "react";

const deleteAdultMember = async (id) => {
  try {
    const response = await fetch(`http://localhost:8080/api/adult-member/${id}`, {
      method: "DELETE",
    });
    if (!response.ok) {
      throw new Error("Failed to delete adult member");
    }
    return await response.json();
  } catch (error) {
    console.error("Error deleting adult member:", error);
  }
};

const DeleteAdultMember = ({ id }) => {
  const handleDelete = async () => {
    if (window.confirm("Are you sure you want to delete this member?")) {
      const deletedMember = await deleteAdultMember(id);
      if (deletedMember) {
        console.log("Deleted Member:", deletedMember);
        alert("Member deleted successfully!");
      }
    }
  };

  return <button onClick={handleDelete}>Delete Member</button>;
};

export default DeleteAdultMember;
