import React, { useState } from "react";
import { Tabs, Tab, Table, Button, Modal, Form } from "react-bootstrap";

const DirectorDashboard = () => {
    const [key, setKey] = useState("committees");
    const [showAddCommitteeModal, setShowAddCommitteeModal] = useState(false);
    const [showAddBandMemberModal, setShowAddBandMemberModal] = useState(false);

    // Example data
    const committees = [
        { id: 1, name: "Performance Committee", members: 5 },
        { id: 2, name: "Inventory Committee", members: 4 },
    ];

    const bandMembers = [
        { id: 1, name: "John Doe", role: "Lead Guitarist" },
        { id: 2, name: "Jane Doe", role: "Drummer" },
    ];

    // Handle Modal Show/Hide
    const handleShowAddCommitteeModal = () => setShowAddCommitteeModal(true);
    const handleCloseAddCommitteeModal = () => setShowAddCommitteeModal(false);
    const handleShowAddBandMemberModal = () => setShowAddBandMemberModal(true);
    const handleCloseAddBandMemberModal = () => setShowAddBandMemberModal(false);

    return (
        <div className="director-dashboard">
            <h2>Director Dashboard</h2>
            <Tabs activeKey={key} onSelect={(k) => setKey(k)} className="mb-3">
                {/* Committees Tab */}
                <Tab eventKey="committees" title="Manage Committees">
                    <h3>Manage Committees</h3>
                    <Table striped bordered hover>
                        <thead>
                            <tr>
                                <th>#</th>
                                <th>Committee Name</th>
                                <th>Members</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            {committees.map((committee) => (
                                <tr key={committee.id}>
                                    <td>{committee.id}</td>
                                    <td>{committee.name}</td>
                                    <td>{committee.members}</td>
                                    <td>
                                        <Button variant="warning" size="sm" className="me-2">
                                            Edit
                                        </Button>
                                        <Button variant="danger" size="sm">
                                            Delete
                                        </Button>
                                    </td>
                                </tr>
                            ))}
                        </tbody>
                    </Table>
                    <Button variant="primary" onClick={handleShowAddCommitteeModal}>
                        Add New Committee
                    </Button>
                </Tab>

                {/* Band Members Tab */}
                <Tab eventKey="bandMembers" title="Manage Band Members">
                    <h3>Manage Band Members</h3>
                    <Table striped bordered hover>
                        <thead>
                            <tr>
                                <th>#</th>
                                <th>Member Name</th>
                                <th>Role</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            {bandMembers.map((member) => (
                                <tr key={member.id}>
                                    <td>{member.id}</td>
                                    <td>{member.name}</td>
                                    <td>{member.role}</td>
                                    <td>
                                        <Button variant="warning" size="sm" className="me-2">
                                            Edit
                                        </Button>
                                        <Button variant="danger" size="sm">
                                            Delete
                                        </Button>
                                    </td>
                                </tr>
                            ))}
                        </tbody>
                    </Table>
                    <Button variant="primary" onClick={handleShowAddBandMemberModal}>
                        Add New Band Member
                    </Button>
                </Tab>
            </Tabs>

            {/* Add Committee Modal */}
            <Modal show={showAddCommitteeModal} onHide={handleCloseAddCommitteeModal}>
                <Modal.Header closeButton>
                    <Modal.Title>Add New Committee</Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    <Form>
                        <Form.Group className="mb-3" controlId="committeeName">
                            <Form.Label>Committee Name</Form.Label>
                            <Form.Control type="text" placeholder="Enter committee name" />
                        </Form.Group>

                        <Form.Group className="mb-3" controlId="committeeMembers">
                            <Form.Label>Number of Members</Form.Label>
                            <Form.Control type="number" placeholder="Enter number of members" />
                        </Form.Group>
                    </Form>
                </Modal.Body>
                <Modal.Footer>
                    <Button variant="secondary" onClick={handleCloseAddCommitteeModal}>
                        Close
                    </Button>
                    <Button variant="primary" onClick={handleCloseAddCommitteeModal}>
                        Save Committee
                    </Button>
                </Modal.Footer>
            </Modal>

            {/* Add Band Member Modal */}
            <Modal show={showAddBandMemberModal} onHide={handleCloseAddBandMemberModal}>
                <Modal.Header closeButton>
                    <Modal.Title>Add New Band Member</Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    <Form>
                        <Form.Group className="mb-3" controlId="bandMemberName">
                            <Form.Label>Band Member Name</Form.Label>
                            <Form.Control type="text" placeholder="Enter member name" />
                        </Form.Group>

                        <Form.Group className="mb-3" controlId="bandMemberRole">
                            <Form.Label>Role</Form.Label>
                            <Form.Control type="text" placeholder="Enter role" />
                        </Form.Group>
                    </Form>
                </Modal.Body>
                <Modal.Footer>
                    <Button variant="secondary" onClick={handleCloseAddBandMemberModal}>
                        Close
                    </Button>
                    <Button variant="primary" onClick={handleCloseAddBandMemberModal}>
                        Save Band Member
                    </Button>
                </Modal.Footer>
            </Modal>
        </div>
    );
};

export default DirectorDashboard;
