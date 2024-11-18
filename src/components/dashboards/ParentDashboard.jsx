import React, { useState } from "react";
import { Tabs, Tab, Table, Button, Form } from "react-bootstrap";

const ParentDashboard = () => {
    const [key, setKey] = useState("childAccounts");

    // Example data
    const childAccounts = [
        { id: 1, name: "John Doe", role: "Member", status: "Active" },
        { id: 2, name: "Jane Doe", role: "Member", status: "Pending" },
    ];

    const proxyPerformances = [
        { id: 1, child: "John Doe", date: "2024-11-25", location: "City Hall" },
        { id: 2, child: "Jane Doe", date: "2024-12-10", location: "Auditorium" },
    ];

    return (
        <div className="parent-dashboard">
            <h2>Parent Dashboard</h2>
            <Tabs activeKey={key} onSelect={(k) => setKey(k)} className="mb-3">
                {/* Child Accounts Tab */}
                <Tab eventKey="childAccounts" title="Child Accounts">
                    <h3>Manage Child Accounts</h3>
                    <Table striped bordered hover>
                        <thead>
                            <tr>
                                <th>#</th>
                                <th>Name</th>
                                <th>Role</th>
                                <th>Status</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            {childAccounts.map((account) => (
                                <tr key={account.id}>
                                    <td>{account.id}</td>
                                    <td>{account.name}</td>
                                    <td>{account.role}</td>
                                    <td>{account.status}</td>
                                    <td>
                                        <Button variant="warning" size="sm" className="me-2">
                                            Edit
                                        </Button>
                                        <Button variant="danger" size="sm">
                                            Remove
                                        </Button>
                                    </td>
                                </tr>
                            ))}
                        </tbody>
                    </Table>
                    <Button variant="primary">Add New Child Account</Button>
                </Tab>

                {/* Proxy Performances Tab */}
                <Tab eventKey="proxyPerformances" title="Proxy Performances">
                    <h3>Proxy Performance Schedule</h3>
                    <Table striped bordered hover>
                        <thead>
                            <tr>
                                <th>#</th>
                                <th>Child Name</th>
                                <th>Date</th>
                                <th>Location</th>
                            </tr>
                        </thead>
                        <tbody>
                            {proxyPerformances.map((performance) => (
                                <tr key={performance.id}>
                                    <td>{performance.id}</td>
                                    <td>{performance.child}</td>
                                    <td>{performance.date}</td>
                                    <td>{performance.location}</td>
                                </tr>
                            ))}
                        </tbody>
                    </Table>
                </Tab>
            </Tabs>
        </div>
    );
};

export default ParentDashboard;
