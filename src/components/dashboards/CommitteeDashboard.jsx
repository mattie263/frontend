import React, { useState } from "react";
import { Tabs, Tab, Table, Button, Form, Modal } from "react-bootstrap";

const CommitteeDashboard = () => {
    const [key, setKey] = useState("inventory");
    const [showAddItemModal, setShowAddItemModal] = useState(false);

    // Example data
    const inventoryItems = [
        { id: 1, name: "Music Stand", quantity: 10, status: "Available" },
        { id: 2, name: "Guitar", quantity: 5, status: "In Use" },
    ];

    const performances = [
        { id: 1, player: "John Doe", date: "2024-11-25", location: "City Hall" },
        { id: 2, player: "Jane Doe", date: "2024-12-10", location: "Auditorium" },
    ];

    // Handle Modal Show/Hide
    const handleShowAddItemModal = () => setShowAddItemModal(true);
    const handleCloseAddItemModal = () => setShowAddItemModal(false);

    return (
        <div className="committee-dashboard">
            <h2>Committee Dashboard</h2>
            <Tabs activeKey={key} onSelect={(k) => setKey(k)} className="mb-3">
                {/* Inventory Tab */}
                <Tab eventKey="inventory" title="Inventory">
                    <h3>Manage Inventory</h3>
                    <Table striped bordered hover>
                        <thead>
                            <tr>
                                <th>#</th>
                                <th>Item Name</th>
                                <th>Quantity</th>
                                <th>Status</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            {inventoryItems.map((item) => (
                                <tr key={item.id}>
                                    <td>{item.id}</td>
                                    <td>{item.name}</td>
                                    <td>{item.quantity}</td>
                                    <td>{item.status}</td>
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
                    <Button variant="primary" onClick={handleShowAddItemModal}>
                        Add New Item
                    </Button>
                </Tab>

                {/* Performance Availability Tab */}
                <Tab eventKey="performances" title="Performance Availability">
                    <h3>Player Availability for Performances</h3>
                    <Table striped bordered hover>
                        <thead>
                            <tr>
                                <th>#</th>
                                <th>Player</th>
                                <th>Date</th>
                                <th>Location</th>
                            </tr>
                        </thead>
                        <tbody>
                            {performances.map((performance) => (
                                <tr key={performance.id}>
                                    <td>{performance.id}</td>
                                    <td>{performance.player}</td>
                                    <td>{performance.date}</td>
                                    <td>{performance.location}</td>
                                </tr>
                            ))}
                        </tbody>
                    </Table>
                </Tab>
            </Tabs>

            {/* Add Item Modal */}
            <Modal show={showAddItemModal} onHide={handleCloseAddItemModal}>
                <Modal.Header closeButton>
                    <Modal.Title>Add New Inventory Item</Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    <Form>
                        <Form.Group className="mb-3" controlId="itemName">
                            <Form.Label>Item Name</Form.Label>
                            <Form.Control type="text" placeholder="Enter item name" />
                        </Form.Group>

                        <Form.Group className="mb-3" controlId="itemQuantity">
                            <Form.Label>Quantity</Form.Label>
                            <Form.Control type="number" placeholder="Enter quantity" />
                        </Form.Group>

                        <Form.Group className="mb-3" controlId="itemStatus">
                            <Form.Label>Status</Form.Label>
                            <Form.Control as="select">
                                <option>Available</option>
                                <option>In Use</option>
                                <option>Out of Stock</option>
                            </Form.Control>
                        </Form.Group>
                    </Form>
                </Modal.Body>
                <Modal.Footer>
                    <Button variant="secondary" onClick={handleCloseAddItemModal}>
                        Close
                    </Button>
                    <Button variant="primary" onClick={handleCloseAddItemModal}>
                        Save Item
                    </Button>
                </Modal.Footer>
            </Modal>
        </div>
    );
};

export default CommitteeDashboard;
