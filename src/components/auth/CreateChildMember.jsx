import React, { useState } from "react";

const createChildMember = async (newChild) => {
    try {
        const response = await fetch("http://localhost:8080/api/child-member", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(newChild),
        });
        if (!response.ok) {
            throw new Error("Failed to create child member");
        }
        return await response.json();
    } catch (error) {
        console.error("Error creating child member:", error);
    }
};

const CreateChildMember = () => {
    const [newChild, setNewChild] = useState({ firstName: "", lastName: "", parentId: "" });
    const [message, setMessage] = useState("");

    const handleSubmit = async (event) => {
        event.preventDefault();
        const child = await createChildMember(newChild);
        if (child) {
            setMessage("Child member created successfully!");
        }
    };

    return (
        <div>
            <h1>Create Child Member</h1>
            <form onSubmit={handleSubmit}>
                <input
                    type="text"
                    placeholder="First Name"
                    value={newChild.firstName}
                    onChange={(e) => setNewChild({ ...newChild, firstName: e.target.value })}
                />
                <input
                    type="text"
                    placeholder="Last Name"
                    value={newChild.lastName}
                    onChange={(e) => setNewChild({ ...newChild, lastName: e.target.value })}
                />
                <input
                    type="number"
                    placeholder="Parent ID"
                    value={newChild.parentId}
                    onChange={(e) => setNewChild({ ...newChild, parentId: e.target.value })}
                />
                <button type="submit">Create Child Member</button>
            </form>
            {message && <p>{message}</p>}
        </div>
    );
};

export default CreateChildMember;
