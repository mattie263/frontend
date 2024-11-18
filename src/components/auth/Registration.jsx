import React, { useState } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Link } from 'react-router-dom';  // Import the Link component for navigation
import {
    MDBBtn,
    MDBContainer,
    MDBRow,
    MDBCol,
    MDBCard,
    MDBCardBody,
    MDBCardImage,
    MDBInput,
    MDBIcon
} from 'mdb-react-ui-kit';

function Registration() {
    const [formData, setFormData] = useState({
        firstName: '',
        lastName: '',
        email: '',
        phoneNumber: '',
        password: '',
        children: [],  // New state for child members
    });

    const handleInputChange = (e) => {
        const { id, value } = e.target;
        setFormData({ ...formData, [id]: value });
    };

    const handleChildInputChange = (index, e) => {
        const { name, value } = e.target;
        const newChildren = [...formData.children];
        newChildren[index] = { ...newChildren[index], [name]: value };
        setFormData({ ...formData, children: newChildren });
    };

    const addChild = () => {
        setFormData({ ...formData, children: [...formData.children, { firstName: '', lastName: '' }] });
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        console.log('Form submitted:', formData);
        // Add form submission logic here (e.g., API call)
    };

    return (
        <MDBContainer fluid>
            <MDBCard className='text-black m-5' style={{ borderRadius: '25px' }}>
                <MDBCardBody>
                    <MDBRow>
                        <MDBCol md='10' lg='6' className='order-2 order-lg-1 d-flex flex-column align-items-center'>
                            <p className="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Member Registration</p>

                            <form onSubmit={handleSubmit} className="w-100">
                                <div className="d-flex flex-row align-items-center mb-1">
                                    <MDBIcon fas icon="user me-3" size='lg' />
                                    <MDBInput
                                        label='First Name'
                                        id='firstName'
                                        type='text'
                                        className='w-100'
                                        value={formData.firstName}
                                        onChange={handleInputChange}
                                    />
                                </div>

                                <div className="d-flex flex-row align-items-center mb-1">
                                    <MDBIcon fas icon="user me-3" size='lg' />
                                    <MDBInput
                                        label='Last Name'
                                        id='lastName'
                                        type='text'
                                        className='w-100'
                                        value={formData.lastName}
                                        onChange={handleInputChange}
                                    />
                                </div>

                                <div className="d-flex flex-row align-items-center mb-1">
                                    <MDBIcon fas icon="envelope me-3" size='lg' />
                                    <MDBInput
                                        label='Your Email'
                                        id='email'
                                        type='email'
                                        className='w-100'
                                        value={formData.email}
                                        onChange={handleInputChange}
                                    />
                                </div>

                                <div className="d-flex flex-row align-items-center mb-1">
                                    <MDBIcon fas icon="phone me-3" size='lg' />
                                    <MDBInput
                                        label='Phone Number'
                                        id='phoneNumber'
                                        type='tel'
                                        className='w-100'
                                        value={formData.phoneNumber}
                                        onChange={handleInputChange}
                                    />
                                </div>

                                <div className="d-flex flex-row align-items-center mb-1">
                                    <MDBIcon fas icon="lock me-3" size='lg' />
                                    <MDBInput
                                        label='Password'
                                        id='password'
                                        type='password'
                                        className='w-100'
                                        value={formData.password}
                                        onChange={handleInputChange}
                                    />
                                </div>



                                <MDBBtn type="submit" className='mb-2' size='lg'>
                                    Register
                                </MDBBtn>
                            </form>

                            {/* Login link for users who already have an account */}
                            <p className="mt-3 text-center">
                                Already registered? <Link to="/member-login">Login here</Link>
                            </p>
                        </MDBCol>

                        <MDBCol md='10' lg='6' className='order-1 order-lg-2 d-flex align-items-center'>
                            <MDBCardImage src='http://localhost:5173/src/assets/Band-Orch-scaled.jpg' fluid />
                        </MDBCol>
                    </MDBRow>
                </MDBCardBody>
            </MDBCard>
        </MDBContainer>
    );
}

export default Registration;
