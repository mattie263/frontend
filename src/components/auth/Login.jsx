import React, { useState } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import { useNavigate } from 'react-router-dom';

import {
    MDBBtn,
    MDBContainer,
    MDBRow,
    MDBCol,
    MDBCard,
    MDBCardBody,
    MDBIcon,
    MDBInput
} from 'mdb-react-ui-kit';

function Login() {
    const [formData, setFormData] = useState({
        email: '',
        password: '',
    });

    const navigate = useNavigate(); // Initialize useNavigate hook

    const handleInputChange = (e) => {
        const { id, value } = e.target;
        setFormData({ ...formData, [id]: value });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        console.log('Form submitted:', formData);

        try {
            // Simulate an API call for login
            const response = await fetch('http://127.0.0.1:8080/api/login', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(formData),
            });

            if (response.ok) {
                const data = await response.json();

                // Redirect to the member dashboard
                navigate('/member-dashboard');
            } else {
                console.error('Login failed');
                alert('Login failed. Please check your credentials.');
            }
        } catch (error) {
            console.error('Error during login:', error);
            alert('An error occurred. Please try again.');
        }
    };

    return (
        <MDBContainer fluid className="d-flex justify-content-center align-items-center" style={{ height: '100vh' }}>
            <MDBCard className="text-black m-5" style={{ borderRadius: '25px' }}>
                <MDBCardBody>
                    <MDBRow className="d-flex justify-content-center align-items-center">
                        <MDBCol md="8" lg="6" className="d-flex flex-column align-items-center">
                            <p className="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Member Login</p>

                            <form onSubmit={handleSubmit} className="w-100">
                                <div className="d-flex flex-row align-items-center mb-3">
                                    <MDBIcon fas icon="envelope me-3" size="lg" />
                                    <MDBInput
                                        label="Your Email"
                                        id="email"
                                        type="email"
                                        className="w-100"
                                        value={formData.email}
                                        onChange={handleInputChange}
                                    />
                                </div>

                                <div className="d-flex flex-row align-items-center mb-3">
                                    <MDBIcon fas icon="lock me-3" size="lg" />
                                    <MDBInput
                                        label="Password"
                                        id="password"
                                        type="password"
                                        className="w-100"
                                        value={formData.password}
                                        onChange={handleInputChange}
                                    />
                                </div>
                                <MDBBtn type="submit" className="mb-2" size="lg">
                                    Login
                                </MDBBtn>
                            </form>
                        </MDBCol>
                    </MDBRow>
                </MDBCardBody>
            </MDBCard>
        </MDBContainer>
    );
}

export default Login;
