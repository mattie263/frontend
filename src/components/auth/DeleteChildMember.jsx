import React from "react";

const deleteChildMember = async (id) => {
    try {
        const response = await fetch(`http://localhost:8080/api/child-member/${id}`, {
            method: "DELETE",
        });
        if (!response.ok) {
            throw new Error("Failed to delete child member");
        }
        return await response.json();
    } catch (error) {
        console.error("Error deleting child member:", error);
    }
};

const DeleteChildMember = ({ id }) => {
    const handleDelete = async () => {
        const deletedChild = await deleteChildMember(id);
        if (deletedChild) {
            console.log("Child member deleted:", deletedChild);
        }
    };

    return <button onClick={handleDelete}>Delete Child Member</button>;
};

export default DeleteChildMember;
