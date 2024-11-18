import React, { useEffect, useState } from "react";

// Service to fetch members
const getAdultMembers = async () => {
    try {
        const response = await fetch("http://192.168.100.48:8080/api/adult-member");
        if (!response.ok) {
            throw new Error("Failed to fetch adult members");
        }
        return await response.json();
    } catch (error) {
        console.error("Error fetching adult members:", error);
        return [];
    }
};

const AdultMembers = () => {
    const [members, setMembers] = useState([

    ]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    useEffect(() => {
        const fetchMembers = async () => {
            try {
                const data = await getAdultMembers();
                setMembers(data);
            } catch (err) {
                setError(err.message);
            } finally {
                setLoading(false);
            }
        };
        fetchMembers();
    }, []);

    if (loading) return <p className="text-center mt-4">Loading members...</p>;
    if (error)
        return (
            <div className="text-center mt-4">
                <p className="text-danger">Error: {error}</p>
                <button className="btn btn-primary" onClick={() => window.location.reload()}>
                    Retry
                </button>
            </div>
        );

    if (members.length === 0)
        return <p className="text-center mt-4">No adult members found.</p>;

    return (
        <table className="table align-middle mb-0 bg-white">
            <thead className="bg-light">
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th>Phone</th>
                    <th>Password</th>
                </tr>
            </thead>
            <tbody>
                {members.map((member) => (
                    <tr key={member.id}>
                        <td>
                            <p className="fw-normal mb-1">{member.FirstName}</p>
                        </td>
                        <td>
                            <p className="fw-normal mb-1">{member.LastName}</p>
                        </td>
                        <td>{member.email}</td>
                        <td>{member.Phone}</td>
                        <td>
                            <button type="button" className="btn btn-link btn-sm btn-rounded">
                                Edit
                            </button>
                        </td>
                    </tr>
                ))}
            </tbody>
        </table>
    );
};


export default AdultMembers;
