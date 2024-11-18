import React, { useState, useEffect, useContext } from 'react';
import { Tab, initMDB } from 'mdb-ui-kit'; // Importing the necessary MDB components

// Initialize MDB
initMDB({ Tab });

const SidebarTabs = () => {
    const [activeTab, setActiveTab] = useState('v-tabs-performanceSchedule');

    const handleTabClick = (tabId) => {
        setActiveTab(tabId);
    };

    const [children, setChildren] = useState([]); // State to hold children data
    const [newChild, setNewChild] = useState({ firstName: '', lastName: '' }); // State for new child form
    const [loading, setLoading] = useState(false); // Loading state for API calls
    const [error, setError] = useState(null); // Error state for API errors

    // will implement a dynamic user id using context provider to pull current user from the context
    const parent_id = '001';
    const apiBaseUrl = `http://localhost:8080/api/child-member/${parent_id}`;

    // Fetch children data
    const fetchChildren = async () => {
        try {
            setLoading(true);
            const response = await fetch(apiBaseUrl);
            const data = await response.json();
            setChildren(data);
            setLoading(false);
        } catch (err) {
            setError('Failed to fetch children data.');
            setLoading(false);
        }
    };

    // Add a new child
    const addChild = async (e) => {
        e.preventDefault();
        try {
            setLoading(true);
            const response = await fetch(apiBaseUrl, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(newChild),
            });
            if (response.ok) {
                fetchChildren(); // Refresh the children list
                setNewChild({ firstName: '', lastName: '' }); // Reset form
            } else {
                setError('Failed to add child.');
            }
            setLoading(false);
        } catch (err) {
            setError('Failed to add child.');
            setLoading(false);
        }
    };

    // Delete a child
    const deleteChild = async (id) => {
        try {
            setLoading(true);
            const response = await fetch(`${apiBaseUrl}/${id}`, {
                method: 'DELETE',
            });
            if (response.ok) {
                fetchChildren(); // Refresh the children list
            } else {
                setError('Failed to delete child.');
            }
            setLoading(false);
        } catch (err) {
            setError('Failed to delete child.');
            setLoading(false);
        }
    };

    // Fetch children data on component mount
    useEffect(() => {
        fetchChildren();
    }, []);

    return (
        <div className="row w-100">
            <div className="col-3">
                {/* Tab navs */}
                <div
                    className="nav flex-column nav-tabs text-center"
                    id="v-tabs-tab"
                    role="tablist"
                    aria-orientation="vertical"
                >
                    <a
                        className={`nav-link ${activeTab === 'v-tabs-performanceSchedule' ? 'active' : ''}`}
                        onClick={() => handleTabClick('v-tabs-performanceSchedule')}
                        href="#v-tabs-performanceSchedule"
                        role="tab"
                        aria-controls="v-tabs-performanceSchedule"
                        aria-selected={activeTab === 'v-tabs-performanceSchedule'}
                    >
                        Performance Schedule
                    </a>
                    <a
                        className={`nav-link ${activeTab === 'v-tabs-loans' ? 'active' : ''}`}
                        onClick={() => handleTabClick('v-tabs-loans')}
                        href="#v-tabs-loans"
                        role="tab"
                        aria-controls="v-tabs-loans"
                        aria-selected={activeTab === 'v-tabs-loans'}
                    >
                        Loans
                    </a>
                    <a
                        className={`nav-link ${activeTab === 'v-tabs-music' ? 'active' : ''}`}
                        onClick={() => handleTabClick('v-tabs-music')}
                        href="#v-tabs-music"
                        role="tab"
                        aria-controls="v-tabs-music"
                        aria-selected={activeTab === 'v-tabs-music'}
                    >
                        Music
                    </a>
                    <a
                        className={`nav-link ${activeTab === 'v-tabs-children' ? 'active' : ''}`}
                        onClick={() => handleTabClick('v-tabs-children')}
                        href="#v-tabs-children"
                        role="tab"
                        aria-controls="v-tabs-children"
                        aria-selected={activeTab === 'v-tabs-children'}
                    >
                        Children
                    </a>
                </div>
                {/* Tab navs */}
            </div>

            <div className="col-9">
                {/* Tab content */}
                <div className="tab-content" id="v-tabs-tabContent">
                    {/* Performance Schedule Tab Content */}
                    <div
                        className={`tab-pane fade ${activeTab === 'v-tabs-performanceSchedule' ? 'show active' : ''}`}
                        id="v-tabs-performanceSchedule"
                        role="tabpanel"
                        aria-labelledby="v-tabs-performanceSchedule-tab"
                    >
                        <h3>Upcoming Performances</h3>
                        <table className="table">
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Date</th>
                                    <th>Location</th>
                                    <th>Availability</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>1</td>
                                    <td>2024-11-20</td>
                                    <td>Community Hall</td>
                                    <td>
                                        <input type="checkbox" />
                                    </td>
                                </tr>
                                <tr>
                                    <td>2</td>
                                    <td>2024-12-05</td>
                                    <td>City Center</td>
                                    <td>
                                        <input type="checkbox" />
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>

                    {/* Loans Tab Content */}
                    <div
                        className={`tab-pane fade ${activeTab === 'v-tabs-loans' ? 'show active' : ''}`}
                        id="v-tabs-loans"
                        role="tabpanel"
                        aria-labelledby="v-tabs-loans-tab"
                    >
                        <h3>Your Loans</h3>
                        <table className="table">
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Item</th>
                                    <th>Due Date</th>
                                    <th>Status</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>1</td>
                                    <td>Trumpet</td>
                                    <td>2024-12-01</td>
                                    <td>Pending</td>
                                </tr>
                                <tr>
                                    <td>2</td>
                                    <td>Sheet Music</td>
                                    <td>2024-12-15</td>
                                    <td>Returned</td>
                                </tr>
                            </tbody>
                        </table>
                        <button className="btn btn-primary">Request New Loan</button>
                    </div>

                    {/* Music Tab Content */}
                    <div
                        className={`tab-pane fade ${activeTab === 'v-tabs-music' ? 'show active' : ''}`}
                        id="v-tabs-music"
                        role="tabpanel"
                        aria-labelledby="v-tabs-music-tab"
                    >
                        <h3>Music Library</h3>
                        <table className="table">
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Title</th>
                                    <th>Composer</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>1</td>
                                    <td>Symphony No. 5</td>
                                    <td>Beethoven</td>
                                </tr>
                                <tr>
                                    <td>2</td>
                                    <td>Four Seasons</td>
                                    <td>Vivaldi</td>
                                </tr>
                            </tbody>
                        </table>
                        <form>
                            <div className="form-group">
                                <label htmlFor="orderMusic">Order Music</label>
                                <select className="form-control" id="orderMusic">
                                    <option>Symphony No. 5</option>
                                    <option>Four Seasons</option>
                                </select>
                            </div>
                            <button className="btn btn-primary">Order</button>
                        </form>
                    </div>

                    {/* Children Tab Content */}
                    <div
                        className={`tab-pane fade ${activeTab === 'v-tabs-children' ? 'show active' : ''}`}
                        id="v-tabs-children"
                        role="tabpanel"
                        aria-labelledby="v-tabs-children-tab"
                    >
                        <h3>Your Children</h3>
                        <table className="table">
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>First Name</th>
                                    <th>Last Name</th>
                                    <th>Action</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>1</td>
                                    <td>John</td>
                                    <td>Doe</td>
                                    <td><button className="btn btn-danger">Delete</button></td>
                                </tr>
                            </tbody>
                        </table>
                        <h4>Add New Child</h4>
                        <form>
                            <div className="form-group">
                                <label htmlFor="firstName">First Name</label>
                                <input type="text" className="form-control" id="firstName" placeholder="Enter first name" />
                            </div>
                            <div className="form-group">
                                <label htmlFor="lastName">Last Name</label>
                                <input type="text" className="form-control" id="lastName" placeholder="Enter last name" />
                            </div>
                            <button type="submit" className="btn btn-primary">Add Child</button>
                        </form>
                    </div>
                </div>
                {/* Tab content */}
            </div>
        </div>
    );
};

export default SidebarTabs;
