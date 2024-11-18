import React, { useEffect, useState } from "react";

const getChildMembers = async () => {
    try {
        const response = await fetch("http://localhost:8080/api/child-member");
        if (!response.ok) {
            throw new Error("Failed to fetch child members");
        }
        return await response.json();
    } catch (error) {
        console.error("Error fetching child members:", error);
        return [];
    }
};

const ChildMembers = () => {
    const [children, setChildren] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    useEffect(() => {
        const fetchChildren = async () => {
            try {
                const data = await getChildMembers();
                setChildren(data);
            } catch (err) {
                setError(err.message);
            } finally {
                setLoading(false);
            }
        };
        fetchChildren();
    }, []);

    if (loading) return <p>Loading child members...</p>;
    if (error) return <p>Error: {error}</p>;

    return (
        <div>
            <h1>Child Members</h1>
            {children.length > 0 ? (
                <ul>
                    {children.map((child) => (
                        <li key={child.id}>
                            {child.firstName} {child.lastName}
                        </li>
                    ))}
                </ul>
            ) : (
                <p>No child members found.</p>
            )}
        </div>
    );
};

export default ChildMembers;
